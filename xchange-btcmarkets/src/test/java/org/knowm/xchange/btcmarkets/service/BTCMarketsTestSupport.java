package org.knowm.xchange.btcmarkets.service;

import org.knowm.xchange.btcmarkets.dto.BTCMarketsDtoTestSupport;
import org.knowm.xchange.btcmarkets.dto.account.BTCMarketsBalance;
import org.knowm.xchange.btcmarkets.dto.account.BTCMarketsFundtransfer;
import org.knowm.xchange.btcmarkets.dto.account.BTCMarketsFundtransferHistoryResponse;
import org.knowm.xchange.btcmarkets.dto.marketdata.BTCMarketsTicker;
import org.knowm.xchange.btcmarkets.dto.trade.BTCMarketsOrder;
import org.knowm.xchange.btcmarkets.dto.trade.BTCMarketsUserTrade;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.UserTrade;
import org.powermock.reflect.Whitebox;

import java.util.*;

/**
 * Test utilities for btnmarkets tests.
 */
public class BTCMarketsTestSupport extends BTCMarketsDtoTestSupport {

    protected static final String SPECIFICATION_USERNAME = "admin";
    protected static final String SPECIFICATION_API_KEY =
            Base64.getEncoder().encodeToString("publicKey".getBytes());
    protected static final String SPECIFICATION_SECRET_KEY =
            Base64.getEncoder().encodeToString("secretKey".getBytes());

    protected static final Balance EXPECTED_BALANCE =
            new Balance(Currency.BTC, new Double("3.0E-7"), new Double("2.0E-7"));
    protected static final Ticker EXPECTED_TICKER =
            new Ticker.Builder()
                    .bid(new Double("137.00"))
                    .ask(new Double("140.00"))
                    .last(new Double("140.00"))
                    .currencyPair(CurrencyPair.BTC_AUD)
                    .timestamp(new Date(1378878117000L))
                    .build();
    protected static final BTCMarketsTicker EXPECTED_BTC_MARKETS_TICKER =
            new BTCMarketsTicker(
                    new Double("137.00"),
                    new Double("140.00"),
                    new Double("140.00"),
                    "AUD",
                    "BTC",
                    new Date(1378878117000L));

    protected static LimitOrder[] expectedAsks() {
        return new LimitOrder[]{
                new LimitOrder(
                        Order.OrderType.ASK,
                        new Double("1.004594"),
                        CurrencyPair.BTC_AUD,
                        null,
                        null,
                        new Double("329.31")),
                new LimitOrder(
                        Order.OrderType.ASK,
                        new Double("22.265709"),
                        CurrencyPair.BTC_AUD,
                        null,
                        null,
                        new Double("329.38")),
                new LimitOrder(
                        Order.OrderType.ASK,
                        new Double("10.0"),
                        CurrencyPair.BTC_AUD,
                        null,
                        null,
                        new Double("329.41"))
        };
    }

    protected static LimitOrder[] expectedBids() {
        return new LimitOrder[]{
                new LimitOrder(
                        Order.OrderType.BID,
                        new Double("1.3593495"),
                        CurrencyPair.BTC_AUD,
                        null,
                        null,
                        new Double("328.98")),
                new LimitOrder(
                        Order.OrderType.BID,
                        new Double("0.21273699"),
                        CurrencyPair.BTC_AUD,
                        null,
                        null,
                        new Double("327.6"))
        };
    }

    protected static LimitOrder[] expectedOrders() {
        return new LimitOrder[]{
                new LimitOrder(
                        Order.OrderType.ASK,
                        new Double("10.00000000"),
                        CurrencyPair.BTC_AUD,
                        "1",
                        null,
                        new Double("20.00000000")),
                new LimitOrder(
                        Order.OrderType.BID,
                        new Double("30.00000000"),
                        CurrencyPair.BTC_AUD,
                        "2",
                        null,
                        new Double("40.00000000"))
        };
    }

    protected static UserTrade[] expectedUserTrades() {
        return new UserTrade[]{
                new UserTrade(
                        Order.OrderType.ASK,
                        new Double("20.00000000"),
                        CurrencyPair.BTC_AUD,
                        new Double("10.00000000"),
                        new Date(111111111L),
                        "1",
                        "null",
                        new Double("1"),
                        Currency.AUD),
                new UserTrade(
                        Order.OrderType.ASK,
                        new Double("40.00000000"),
                        CurrencyPair.BTC_AUD,
                        new Double("30.00000000"),
                        new Date(222222222L),
                        "2",
                        "null",
                        new Double("2"),
                        Currency.AUD),
                new UserTrade(
                        Order.OrderType.BID,
                        new Double("60.00000000"),
                        CurrencyPair.BTC_AUD,
                        new Double("50.00000000"),
                        new Date(333333333L),
                        "3",
                        "null",
                        new Double("3"),
                        Currency.AUD),
                new UserTrade(
                        Order.OrderType.BID,
                        new Double("80.00000000"),
                        CurrencyPair.BTC_AUD,
                        new Double("70.00000000"),
                        new Date(444444444L),
                        "4",
                        "null",
                        new Double("4"),
                        Currency.AUD),
                new UserTrade(
                        Order.OrderType.BID,
                        new Double("0"),
                        CurrencyPair.BTC_AUD,
                        new Double("90.00000000"),
                        new Date(555555555L),
                        "5",
                        "null",
                        new Double("5"),
                        Currency.AUD)
        };
    }

    protected static List<BTCMarketsUserTrade> expectedBtcMarketsUserTrades() {
        return Collections.unmodifiableList(
                Arrays.asList(
                        createBTCMarketsUserTrade(
                                1L,
                                "trade 1",
                                new Double("10.00000000"),
                                new Double("20.00000000"),
                                new Double("1"),
                                new Date(111111111L),
                                BTCMarketsOrder.Side.Ask),
                        createBTCMarketsUserTrade(
                                2L,
                                "trade 2",
                                new Double("30.00000000"),
                                new Double("40.00000000"),
                                new Double("2"),
                                new Date(222222222L),
                                BTCMarketsOrder.Side.Ask),
                        createBTCMarketsUserTrade(
                                3L,
                                "trade 3",
                                new Double("50.00000000"),
                                new Double("60.00000000"),
                                new Double("3"),
                                new Date(333333333L),
                                BTCMarketsOrder.Side.Bid),
                        createBTCMarketsUserTrade(
                                4L,
                                "trade 4",
                                new Double("70.00000000"),
                                new Double("80.00000000"),
                                new Double("4"),
                                new Date(444444444L),
                                BTCMarketsOrder.Side.Bid),
                        createBTCMarketsUserTrade(
                                5L,
                                "trade 5",
                                new Double("90.00000000"),
                                0d,
                                new Double("5"),
                                new Date(555555555L),
                                BTCMarketsOrder.Side.Bid)));
    }

    protected static List<BTCMarketsUserTrade> expectedParsedBtcMarketsUserTrades() {
        return Collections.unmodifiableList(
                Arrays.asList(
                        createBTCMarketsUserTrade(
                                45118157L,
                                null,
                                new Double("330.00000000"),
                                new Double("0.00100000"),
                                new Double("0.00280499"),
                                new Date(1442994673684L),
                                BTCMarketsOrder.Side.Bid),
                        createBTCMarketsUserTrade(
                                45118095L,
                                null,
                                new Double("328.33000000"),
                                new Double("0.00100000"),
                                new Double("0.00279080"),
                                new Date(1442994664114L),
                                BTCMarketsOrder.Side.Ask),
                        createBTCMarketsUserTrade(
                                45117892L,
                                null,
                                new Double("328.65000000"),
                                new Double("0.00100000"),
                                new Double("0.00279352"),
                                new Date(1442994245419L),
                                BTCMarketsOrder.Side.Ask)));
    }

    protected static BTCMarketsOrder[] expectedBtcMarketsOrders() {
        return new BTCMarketsOrder[]{
                createBTCMarketsOrder(
                        1L,
                        new Double("10.00000000"),
                        new Double("20.00000000"),
                        "AUD",
                        "BTC",
                        BTCMarketsOrder.Side.Ask,
                        BTCMarketsOrder.Type.Market,
                        "11111",
                        null,
                        null,
                        null,
                        null,
                        null),
                createBTCMarketsOrder(
                        2L,
                        new Double("30.00000000"),
                        new Double("40.00000000"),
                        "AUD",
                        "BTC",
                        BTCMarketsOrder.Side.Bid,
                        BTCMarketsOrder.Type.Limit,
                        "22222",
                        null,
                        null,
                        null,
                        null,
                        null)
        };
    }

    protected static BTCMarketsOrder[] expectedParsedBtcMarketsOrders() {
        return new BTCMarketsOrder[]{
                createBTCMarketsOrder(
                        1003245675L,
                        new Double("0.10000000"),
                        new Double("130.00000000"),
                        "AUD",
                        "BTC",
                        BTCMarketsOrder.Side.Bid,
                        BTCMarketsOrder.Type.Limit,
                        null,
                        new Date(1378862733366L),
                        "Placed",
                        null,
                        new Double("0.10000000"),
                        new ArrayList<BTCMarketsUserTrade>()),
                createBTCMarketsOrder(
                        4345675L,
                        new Double("0.10000000"),
                        new Double("130.00000000"),
                        "AUD",
                        "BTC",
                        BTCMarketsOrder.Side.Ask,
                        BTCMarketsOrder.Type.Limit,
                        null,
                        new Date(1378636912705L),
                        "Fully Matched",
                        null,
                        new Double("0E-8"),
                        Arrays.asList(
                                createBTCMarketsUserTrade(
                                        5345677L,
                                        null,
                                        new Double("130.00000000"),
                                        new Double("0.10000000"),
                                        new Double("0.00100000"),
                                        new Date(1378636913151L),
                                        null))),
        };
    }

    protected static BTCMarketsBalance[] expectedBtcMarketsBalances() {
        return new BTCMarketsBalance[]{
                createBTCMarketsBalance(new Double("10.00000000"), null, "AUD"),
                createBTCMarketsBalance(null, new Double("10.00000000"), "BTC"),
                createBTCMarketsBalance(null, null, "LTC")
        };
    }

    protected static BTCMarketsUserTrade createBTCMarketsUserTrade(
            Long id,
            String description,
            Double price,
            Double volume,
            Double fee,
            Date creationTime,
            BTCMarketsOrder.Side side) {

        BTCMarketsUserTrade marketsUserTrade = new BTCMarketsUserTrade();
        Whitebox.setInternalState(marketsUserTrade, "id", id);
        Whitebox.setInternalState(marketsUserTrade, "description", description);
        Whitebox.setInternalState(marketsUserTrade, "price", price);
        Whitebox.setInternalState(marketsUserTrade, "volume", volume);
        Whitebox.setInternalState(marketsUserTrade, "fee", fee);
        Whitebox.setInternalState(marketsUserTrade, "creationTime", creationTime);
        Whitebox.setInternalState(marketsUserTrade, "side", side);

        return marketsUserTrade;
    }

    protected static BTCMarketsOrder createBTCMarketsOrder(
            Long id,
            Double volume,
            Double price,
            String currency,
            String instrument,
            BTCMarketsOrder.Side orderSide,
            BTCMarketsOrder.Type ordertype,
            String clientRequestId,
            Date creationTime,
            String status,
            String errorMessage,
            Double openVolume,
            List<BTCMarketsUserTrade> trades) {
        BTCMarketsOrder order =
                new BTCMarketsOrder(
                        volume, price, currency, instrument, orderSide, ordertype, clientRequestId);

        Whitebox.setInternalState(order, "id", id);
        Whitebox.setInternalState(order, "creationTime", creationTime);
        Whitebox.setInternalState(order, "status", status);
        Whitebox.setInternalState(order, "errorMessage", errorMessage);
        Whitebox.setInternalState(order, "openVolume", openVolume);
        Whitebox.setInternalState(order, "trades", trades);

        return order;
    }

    protected static BTCMarketsBalance createBTCMarketsBalance(
            Double pendingFunds, Double balance, String currency) {

        BTCMarketsBalance marketsBalance = new BTCMarketsBalance();
        Whitebox.setInternalState(marketsBalance, "pendingFunds", pendingFunds);
        Whitebox.setInternalState(marketsBalance, "balance", balance);
        Whitebox.setInternalState(marketsBalance, "currency", currency);

        return marketsBalance;
    }

    protected static BTCMarketsFundtransferHistoryResponse
    expectedParsedBTCMarketsFundtransferHistoryResponse() {
        return new BTCMarketsFundtransferHistoryResponse(
                true,
                null,
                null,
                Collections.singletonList(
                        new BTCMarketsFundtransfer(
                                "Complete",
                                new Date(1530533761866L),
                                0d,
                                "Ethereum Deposit, S 15",
                                null,
                                new Date(1530533761866L),
                                7485764826L,
                                new BTCMarketsFundtransfer.CryptoPaymentDetail(
                                        "0x1234abcdef1234abcdef1234abcdef1234abcdef1234abcdef1234abcdef", null),
                                "ETH",
                                15.04872041,
                                "DEPOSIT")),
                new BTCMarketsFundtransferHistoryResponse.Paging(
                        "/fundtransfer/history?since=1957653133&indexForward=true",
                        "/fundtransfer/history?since=373346299&indexForward=false"));
    }
}
