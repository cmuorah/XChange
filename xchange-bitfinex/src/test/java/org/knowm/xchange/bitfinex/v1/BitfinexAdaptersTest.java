package org.knowm.xchange.bitfinex.v1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.knowm.xchange.bitfinex.service.BitfinexAdapters;
import org.knowm.xchange.bitfinex.v1.dto.account.*;
import org.knowm.xchange.bitfinex.v1.dto.marketdata.BitfinexLevel;
import org.knowm.xchange.bitfinex.v1.dto.trade.BitfinexOrderStatusResponse;
import org.knowm.xchange.bitfinex.v1.dto.trade.BitfinexTradeResponse;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Fee;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.OpenOrders;

public class BitfinexAdaptersTest {

  private static final String MARKET = "bitfinex";
  private static final String SYMBOL = "BTCUSD";

  @Test
  public void shouldAdaptDynamicTradingFees() throws IOException {
    InputStream is =
        BitfinexFeesJSONTest.class.getResourceAsStream(
            "/v1/account/example-account-info-fees.json");
    ObjectMapper mapper = new ObjectMapper();
    BitfinexTradingFeeResponse[] readValues =
        mapper.readValue(is, BitfinexTradingFeeResponse[].class);
    assertEquals(2, readValues.length);
    List<CurrencyPair> currencyPairs =
        new ArrayList<>(
            Arrays.asList(
                CurrencyPair.BTC_LTC,
                CurrencyPair.LTC_AUD,
                CurrencyPair.ETH_BTC,
                CurrencyPair.DGC_BTC,
                CurrencyPair.BTC_USD));
    Map<CurrencyPair, Fee> feesPerPair =
        BitfinexAdapters.adaptDynamicTradingFees(readValues, currencyPairs);
    assertEquals(currencyPairs.size(), feesPerPair.size());

    Double point001 = 0.001;
    Double point002 = point001 * (2d);
    Double point00025 = 0.00025;
    Double point0001 = 0.0001;

    Fee btcLTCFee = feesPerPair.get(CurrencyPair.BTC_LTC);
    Fee btcExpectedFee = new Fee(point001, point002);
    assertEquals(btcExpectedFee, btcLTCFee);
    Fee btcUSDFee = feesPerPair.get(CurrencyPair.BTC_USD);
    assertEquals(btcExpectedFee, btcUSDFee);
    Fee ltcFee = feesPerPair.get(CurrencyPair.LTC_AUD);
    assertEquals(new Fee(point001, point002), ltcFee);
    Fee ethFee = feesPerPair.get(CurrencyPair.ETH_BTC);
    assertEquals(new Fee(point001, point002), ethFee);
    Fee dgcFee = feesPerPair.get(CurrencyPair.DGC_BTC);
    assertEquals(new Fee(point00025, point0001), dgcFee);
  }

  @Test
  public void shouldAdaptBalances() throws IOException {
    // Read in the JSON from the example resources
    InputStream is =
        BitfinexWalletJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/bitfinex/v1/dto/account/example-account-info-balance.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    BitfinexBalancesResponse[] response = mapper.readValue(is, BitfinexBalancesResponse[].class);

    List<Wallet> wallets = BitfinexAdapters.adaptWallets(response);

    Wallet exchangeWallet =
        wallets.stream()
            .filter(wallet -> "exchange".equals(wallet.getId()))
            .findFirst()
            .orElse(null);
    assertNotNull("Exchange wallet is missing", exchangeWallet);
    Wallet tradingWallet =
        wallets.stream()
            .filter(wallet -> "trading".equals(wallet.getId()))
            .findFirst()
            .orElse(null);
    assertNotNull("Trading wallet is missing", tradingWallet);
    Wallet depositWallet =
        wallets.stream()
            .filter(wallet -> "deposit".equals(wallet.getId()))
            .findFirst()
            .orElse(null);
    assertNotNull("Deposit wallet is missing", depositWallet);

    Balance tradingUsdBalance = tradingWallet.getBalance(Currency.USD);
    assertNotNull(tradingUsdBalance);
    assertEquals(new Double("100"), tradingUsdBalance.getTotal());
    assertEquals(new Double("50"), tradingUsdBalance.getAvailable());

    Balance tradingBtcBalance = tradingWallet.getBalance(Currency.BTC);
    assertNotNull(tradingBtcBalance);
    assertEquals(0d, tradingBtcBalance.getTotal(), 1e-8);
    assertEquals(0d, tradingBtcBalance.getAvailable(), 1e-8);

    Balance exchangeUsdBalance = exchangeWallet.getBalance(Currency.USD);
    assertNotNull(exchangeUsdBalance);
    assertEquals(new Double("5.5"), exchangeUsdBalance.getTotal());
    assertEquals(new Double("5.5"), exchangeUsdBalance.getAvailable());

    Balance exchangeBtcBalance = exchangeWallet.getBalance(Currency.BTC);
    assertNotNull(exchangeBtcBalance);
    assertEquals(0d, exchangeBtcBalance.getTotal(), 1e-8);
    assertEquals(0d, exchangeBtcBalance.getAvailable(), 1e-8);

    Balance depositUsdBalance = depositWallet.getBalance(Currency.USD);
    assertNotNull(depositUsdBalance);
    assertEquals(new Double("69"), depositUsdBalance.getTotal());
    assertEquals(new Double("42"), depositUsdBalance.getAvailable());

    Balance depositBtcBalance = depositWallet.getBalance(Currency.BTC);
    assertNotNull(depositBtcBalance);
    assertEquals(new Double("50"), depositBtcBalance.getTotal());
    assertEquals(new Double("30"), depositBtcBalance.getAvailable());
  }

  @Test
  public void testAdaptOrdersToOrdersContainer() {

    BitfinexLevel[] levels = initLevels();
    BitfinexAdapters.OrdersContainer container =
        BitfinexAdapters.adaptOrders(levels, CurrencyPair.BTC_USD, OrderType.BID);

    BitfinexLevel lastLevel = levels[levels.length - 1];
    assertEquals(
        lastLevel.getTimestamp() * (new Double(1000L)).longValue(), container.getTimestamp(), 1e-8);
    assertEquals(container.getLimitOrders().size(), levels.length);

    for (int i = 0; i < levels.length; i++) {
      LimitOrder order = container.getLimitOrders().get(i);
      long expectedTimestampMillis = Math.round(levels[i].getTimestamp() * (1000d));

      assertEquals(levels[i].getAmount(), order.getOriginalAmount());
      assertEquals(expectedTimestampMillis, order.getTimestamp().longValue());
      assertEquals(levels[i].getPrice(), order.getLimitPrice());
    }
  }

  /**
   * Create 60 {@link BitfinexLevel}s. The values increase as the array index does. The timestamps
   * increase by 1 second + 1 minute + 1 hour + 1 day in order to test the correct handling of the
   * given timestamp.
   *
   * @return The generated responses.
   */
  private BitfinexLevel[] initLevels() {

    BitfinexLevel[] responses = new BitfinexLevel[60];

    for (int i = 0; i < responses.length; i++) {
      Double price = (double) (350L + i);
      Double timestamp =
          new Double("1414669893.823615468") + ((double) (i * (1 + 60 + 60 * 60 + 60 * 60 * 24)));
      Double amount = (double) (1L + i);
      responses[i] = new BitfinexLevel(price, amount, timestamp);
    }

    return responses;
  }

  @Test
  public void testAdaptOrdersToOpenOrders() {

    BitfinexOrderStatusResponse[] responses = initOrderStatusResponses();
    OpenOrders orders = BitfinexAdapters.adaptOrders(responses);
    assertEquals(orders.getOpenOrders().size(), responses.length);

    for (int i = 0; i < responses.length; i++) {
      LimitOrder order = orders.getOpenOrders().get(i);
      long expectedTimestampMillis = (long) (responses[i].getTimestamp() * 1000d);
      Order.OrderType expectedOrderType =
          responses[i].getSide().equalsIgnoreCase("buy")
              ? Order.OrderType.BID
              : Order.OrderType.ASK;

      assertEquals(String.valueOf(responses[i].getId()), order.getId());
      assertEquals(responses[i].getOriginalAmount(), order.getOriginalAmount());
      assertEquals(BitfinexAdapters.adaptCurrencyPair(SYMBOL), order.getCurrencyPair());
      assertEquals(expectedOrderType, order.getType());
      assertEquals(expectedTimestampMillis, order.getTimestamp().longValue());
      assertEquals(responses[i].getPrice(), order.getLimitPrice());
    }
  }

  /**
   * Create 60 {@link BitfinexOrderStatusResponse}s. The values increase as array index does. The
   * timestamps increase by 1 second + 1 minute + 1 hour + 1 day in order to test the correct
   * handling of the given timestamp.
   *
   * @return The generated responses.
   */
  private BitfinexOrderStatusResponse[] initOrderStatusResponses() {

    BitfinexOrderStatusResponse[] responses = new BitfinexOrderStatusResponse[60];

    for (int i = 0; i < responses.length; i++) {
      Double price = (double) (350L + i);
      Double avgExecutionPrice = price + (0.25 * i);
      String side = i % 2 == 0 ? "buy" : "sell";
      String type = "limit";
      Double timestamp =
          new Double("1414658239.41373654") + ((double) (i * (1 + 60 + 60 * 60 + 60 * 60 * 24)));
      boolean isLive = false;
      boolean isCancelled = false;
      boolean wasForced = false;
      Double originalAmount = new Double("70");
      Double remainingAmount = originalAmount - ((double) (i));
      Double executedAmount = originalAmount - (remainingAmount);
      responses[i] =
          new BitfinexOrderStatusResponse(
              i,
              SYMBOL,
              price,
              avgExecutionPrice,
              side,
              type,
              timestamp,
              isLive,
              isCancelled,
              wasForced,
              originalAmount,
              remainingAmount,
              executedAmount);
    }

    return responses;
  }

  @Test
  public void testAdaptTradeHistory() {

    BitfinexTradeResponse[] responses = initTradeResponses();
    Trades trades = BitfinexAdapters.adaptTradeHistory(responses, SYMBOL);
    assertEquals(trades.getTrades().size(), responses.length);

    for (int i = 0; i < responses.length; i++) {
      Trade trade = trades.getTrades().get(i);
      long expectedTimestampMillis = (long)(responses[i].getTimestamp() * (1000d));
      Order.OrderType expectedOrderType =
          responses[i].getType().equalsIgnoreCase("buy") ? OrderType.BID : OrderType.ASK;

      assertEquals(responses[i].getPrice(), trade.getPrice());
      assertEquals(responses[i].getAmount(), trade.getOriginalAmount());
      assertEquals(BitfinexAdapters.adaptCurrencyPair(SYMBOL), trade.getCurrencyPair());
      assertEquals(expectedTimestampMillis, trade.getTimestamp().longValue());
      assertEquals(expectedOrderType, trade.getType());
      assertEquals(responses[i].getTradeId(), trade.getId());
    }
  }

  /**
   * Create 60 {@link BitfinexTradeResponse}s. The values increase as array index does. The
   * timestamps increase by 1 second + 1 minute + 1 hour + 1 day in order to test the correct
   * handling of the given timestamp.
   *
   * @return The generated responses.
   */
  private BitfinexTradeResponse[] initTradeResponses() {

    BitfinexTradeResponse[] responses = new BitfinexTradeResponse[60];
    int tradeId = 2000;
    int orderId = 1000;

    for (int i = 0; i < responses.length; i++) {
      Double price = (double) (350L + i);
      Double amount = (double) (1L + i);
      Double timestamp =
          new Double("1414658239.41373654") + ((double) (i * (1 + 60 + 60 * 60 + 60 * 60 * 24)));
      String type = i % 2 == 0 ? "buy" : "sell";
      String tradeIdString = String.valueOf(tradeId++);
      String orderIdString = String.valueOf(orderId++);
      Double feeAmount = (double) 0L;
      String feeCurrency = "USD";
      responses[i] =
          new BitfinexTradeResponse(
              price,
              amount,
              timestamp,
              MARKET,
              type,
              tradeIdString,
              orderIdString,
              feeAmount,
              feeCurrency);
    }

    return responses;
  }

  @Test
  public void testAdaptFundingHistory() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        BitfinexAdaptersTest.class.getResourceAsStream(
            "/org/knowm/xchange/bitfinex/v1/dto/account/example-deposit-withdrawal-info-data.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    BitfinexDepositWithdrawalHistoryResponse[] response =
        mapper.readValue(is, BitfinexDepositWithdrawalHistoryResponse[].class);

    List<FundingRecord> fundingRecords = BitfinexAdapters.adaptFundingHistory(response);

    for (FundingRecord record : fundingRecords) {
      if (record.getType().name().equalsIgnoreCase(FundingRecord.Type.DEPOSIT.name())) {
        assertThat(record.getStatus()).isEqualTo(FundingRecord.Status.PROCESSING);
        assertEquals(new Double("0.01"), record.getAmount());
        assertEquals("jlsd98087sdfkjldsflj432kjlsdf8", record.getAddress());
        assertNull(record.getBlockchainTransactionHash());
        assertEquals(Currency.BTC, record.getCurrency());
      } else {
        assertThat(record.getStatus()).isEqualTo(FundingRecord.Status.COMPLETE);
        assertEquals(new Double("0.07"), record.getAmount());
        assertEquals("3QXYWgRGX2BPYBpUDBssGbeWEa5zq6snBZ", record.getAddress());
        assertEquals(
            "3QXYWgRGX2BPYBpUDBssGbeWEa5zq6snBZ, txid: offchain transfer", record.getDescription());
        assertNull(record.getBlockchainTransactionHash());
        assertEquals(
            "3QXYWgRGX2BPYBpUDBssGbeWEa5zq6snBZ, txid: offchain transfer", record.getDescription());
        assertEquals(Currency.BTC, record.getCurrency());
      }
    }
  }
}
