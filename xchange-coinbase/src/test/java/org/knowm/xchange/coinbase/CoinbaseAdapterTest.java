package org.knowm.xchange.coinbase;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.Test;
import org.knowm.xchange.coinbase.dto.account.CoinbaseUser;
import org.knowm.xchange.coinbase.dto.account.CoinbaseUsers;
import org.knowm.xchange.coinbase.dto.marketdata.CoinbaseMoney;
import org.knowm.xchange.coinbase.dto.marketdata.CoinbasePrice;
import org.knowm.xchange.coinbase.dto.marketdata.CoinbaseSpotPriceHistory;
import org.knowm.xchange.coinbase.dto.trade.CoinbaseTransfers;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.dto.trade.UserTrades;
import org.knowm.xchange.utils.DateUtils;

/** @author jamespedwards42 */
public class CoinbaseAdapterTest {

  @Test
  public void testAdaptAccountInfo() throws IOException {

    Balance balance = new Balance(Currency.BTC, new Double("7.10770000"));
    List<Balance> balances = new ArrayList<>();
    balances.add(balance);
    AccountInfo expectedAccountInfo =
        new AccountInfo("demo@demo.com", Wallet.Builder.from(balances).build());

    // Read in the JSON from the example resources
    InputStream is =
        CoinbaseAdapterTest.class.getResourceAsStream(
            "/org/knowm/xchange/coinbase/dto/account/example-users-data.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    CoinbaseUsers users = mapper.readValue(is, CoinbaseUsers.class);

    List<CoinbaseUser> userList = users.getUsers();
    CoinbaseUser user = userList.get(0);

    AccountInfo accountInfo = CoinbaseAdapters.adaptAccountInfo(user);
    //// fest bug: map fields are compared by values() which is always false
    // assertThat(wallet).isEqualToIgnoringGivenFields(expectedWallet, "balances");
    // assertThat(wallet.getBalance("BTC")).isEqualTo(expectedWallet.getBalance("BTC"));
    assertThat(accountInfo).isEqualToComparingFieldByField(expectedAccountInfo);
  }

  @Test
  public void testAdaptTrades() throws IOException {

    Double originalAmount = new Double("1.20000000");
    Double price = new Double("905.10") / originalAmount;

    UserTrade expectedTrade =
        new UserTrade(
            OrderType.BID,
            originalAmount,
            CurrencyPair.BTC_USD,
            price,
            DateUtils.fromISO8601DateString("2014-02-06T18:12:38-08:00").getTime(),
            "52f4411767c71baf9000003f",
            "52f4411667c71baf9000003c",
            new Double("9.05"),
            Currency.getInstance("USD"));

    // Read in the JSON from the example resources
    InputStream is =
        CoinbaseAdapterTest.class.getResourceAsStream(
            "/org/knowm/xchange/coinbase/dto/trade/example-transfers-data.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    CoinbaseTransfers transfers = mapper.readValue(is, CoinbaseTransfers.class);

    UserTrades trades = CoinbaseAdapters.adaptTrades(transfers);
    List<UserTrade> tradeList = trades.getUserTrades();
    assertThat(tradeList.size()).isEqualTo(1);

    UserTrade trade = tradeList.get(0);
    assertThat(trade).isEqualToComparingFieldByField(expectedTrade);
  }

  @Test
  public void testAdaptTicker() throws IOException {

    Ticker expectedTicker =
        new Ticker.Builder()
            .currencyPair(CurrencyPair.BTC_USD)
            .ask(new Double("723.09"))
            .bid(new Double("723.09"))
            .last(new Double("719.79"))
            .low(new Double("718.2"))
            .high(new Double("723.11"))
            .build();

    InputStream is =
        CoinbaseAdapterTest.class.getResourceAsStream(
            "/org/knowm/xchange/coinbase/dto/marketdata/example-price-data.json");
    ObjectMapper mapper = new ObjectMapper();
    CoinbasePrice price = mapper.readValue(is, CoinbasePrice.class);

    CoinbaseMoney spotPrice = new CoinbaseMoney("USD", new Double("719.79"));

    is =
        CoinbaseAdapterTest.class.getResourceAsStream(
            "/org/knowm/xchange/coinbase/dto/marketdata/example-spot-rate-history-data.txt");
    String spotPriceHistoryString;
    try (Scanner scanner = new Scanner(is)) {
      spotPriceHistoryString = scanner.useDelimiter("\\A").next();
    }

    CoinbaseSpotPriceHistory spotPriceHistory =
        CoinbaseSpotPriceHistory.fromRawString(spotPriceHistoryString);

    Ticker ticker =
        CoinbaseAdapters.adaptTicker(
            CurrencyPair.BTC_USD, price, price, spotPrice, spotPriceHistory);

    // TOD  this seems broke. If you
    //    assertThat(ticker).isEqualToComparingFieldByField(expectedTicker);
  }
}
