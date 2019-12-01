package org.knowm.xchange.okcoin.service.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.okcoin.OkCoinAdapters;
import org.knowm.xchange.okcoin.dto.account.OkCoinAccountRecords;
import org.knowm.xchange.okcoin.dto.marketdata.OkCoinDepth;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class OkCoinAdaptersTest {

    @Test
    public void testAdaptFundingHistory() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        InputStream is =
                OkCoinAdaptersTest.class.getResourceAsStream(
                        "/org/knowm/xchange/okcoin/dto/account/example-accountrecords-deposit-data.json");
        OkCoinAccountRecords okCoinAccountDepositRecords =
                mapper.readValue(is, OkCoinAccountRecords.class);

        is =
                OkCoinAdaptersTest.class.getResourceAsStream(
                        "/org/knowm/xchange/okcoin/dto/account/example-accountrecords-withdrawal-data.json");
        OkCoinAccountRecords okCoinAccountWithdrawalRecords =
                mapper.readValue(is, OkCoinAccountRecords.class);

        List<FundingRecord> records =
                OkCoinAdapters.adaptFundingHistory(okCoinAccountDepositRecords, FundingRecord.Type.DEPOSIT);

        assertThat(records.size()).isEqualTo(2);
        FundingRecord depositRecord = records.get(1);
        assertThat(depositRecord).isInstanceOf(FundingRecord.class);
        assertThat(depositRecord.getType()).isEqualTo(FundingRecord.Type.DEPOSIT);
        assertThat(depositRecord.getStatus()).isEqualTo(FundingRecord.Status.COMPLETE);
        assertThat(depositRecord.getAmount()).isEqualTo(new Double("50"));
        assertThat(depositRecord.getFee().doubleValue()).isEqualTo(Double.parseDouble("0.07"));
        assertThat(depositRecord.getAddress()).isEqualTo("1lEWjmlkmlhTqcYj3l33sg980slkjtdqd");

        records =
                OkCoinAdapters.adaptFundingHistory(
                        okCoinAccountDepositRecords, FundingRecord.Type.WITHDRAWAL);
        FundingRecord withdrawalRecord = records.get(1);
        assertThat(withdrawalRecord).isInstanceOf(FundingRecord.class);
        assertThat(withdrawalRecord.getType()).isEqualTo(FundingRecord.Type.WITHDRAWAL);
        assertThat(withdrawalRecord.getStatus()).isEqualTo(FundingRecord.Status.PROCESSING);
        assertThat(withdrawalRecord.getAmount()).isEqualTo(new Double("50"));
        assertThat(withdrawalRecord.getFee().doubleValue()).isEqualTo(Double.parseDouble("0.07"));
        assertThat(withdrawalRecord.getAddress()).isEqualTo("1lEWjmlkmlhTqcYj3l33sg980slkjtdqd");
    }

    @Test
    public void testAdaptOrderBook() {
        Double ask1Price = new Double("8");
        Double ask1Amount = new Double("28");
        Double ask2Price = new Double("5");
        Double ask2Amount = new Double("20");
        Double ask3Price = new Double("7");
        Double ask3Amount = new Double("24");

        Double bid1Price = new Double("4");
        Double bid1Amount = new Double("35");
        Double bid2Price = new Double("2");
        Double bid2Amount = new Double("45");

        Double[][] asks = {{ask1Price, ask1Amount}, {ask2Price, ask2Amount}, {ask3Price, ask3Amount}};
        Double[][] bids = {{bid1Price, bid1Amount}, {bid2Price, bid2Amount}};
        Date date = new Date();
        OkCoinDepth depth = new OkCoinDepth(asks, bids, date);

        OrderBook orderBook = OkCoinAdapters.adaptOrderBook(depth, CurrencyPair.ETH_BTC);

        Assert.assertEquals(orderBook.getAsks().size(), asks.length);
        Assert.assertTrue(
                orderBook
                        .getAsks()
                        .contains(
                                new LimitOrder(
                                        Order.OrderType.ASK, ask1Amount, CurrencyPair.ETH_BTC, null, date.getTime(), ask1Price)));
        Assert.assertTrue(
                orderBook
                        .getAsks()
                        .contains(
                                new LimitOrder(
                                        Order.OrderType.ASK, ask2Amount, CurrencyPair.ETH_BTC, null, date.getTime(), ask2Price)));
        Assert.assertTrue(
                orderBook
                        .getAsks()
                        .contains(
                                new LimitOrder(
                                        Order.OrderType.ASK, ask3Amount, CurrencyPair.ETH_BTC, null, date.getTime(), ask3Price)));
        Assert.assertEquals(orderBook.getAsks().stream()
                .sorted()
                .collect(Collectors.toList()), orderBook.getAsks());

        Assert.assertEquals(orderBook.getBids().size(), bids.length);
        Assert.assertTrue(
                orderBook
                        .getBids()
                        .contains(
                                new LimitOrder(
                                        Order.OrderType.BID, bid1Amount, CurrencyPair.ETH_BTC, null, date.getTime(), bid1Price)));
        Assert.assertTrue(
                orderBook
                        .getBids()
                        .contains(
                                new LimitOrder(
                                        Order.OrderType.BID, bid2Amount, CurrencyPair.ETH_BTC, null, date.getTime(), bid2Price)));
        Assert.assertEquals(orderBook.getBids().stream()
                .sorted()
                .collect(Collectors.toList()), orderBook.getBids());
    }
}
