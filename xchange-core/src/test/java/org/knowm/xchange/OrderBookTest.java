package org.knowm.xchange;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.OrderBookUpdate;
import org.knowm.xchange.dto.trade.LimitOrder;

public class OrderBookTest {

  private OrderBook orderBook;

  @Before
  public void setUp() {
    LimitOrder askOrder =
        new LimitOrder(OrderType.ASK, 1d, CurrencyPair.BTC_USD, "", null, 10d + (1d));
    LimitOrder bidOrder = new LimitOrder(OrderType.BID, 1d, CurrencyPair.BTC_USD, "", null, 10d);

    List<LimitOrder> asks = new ArrayList<>(Collections.singletonList(askOrder));
    List<LimitOrder> bids = new ArrayList<>(Collections.singletonList(bidOrder));
    Date timeStamp = new Date(0);
    orderBook = new OrderBook(timeStamp, asks, bids);
  }

  @Test
  public void testUpdateAddOrder() {
    Date timeStamp = new Date(0);
    OrderBookUpdate lowerBidUpdate =
        new OrderBookUpdate(OrderType.BID, 1d, CurrencyPair.BTC_USD, 10d - (1d), timeStamp, 1d);
    orderBook.update(lowerBidUpdate);
    assertThat(orderBook.getBids().size()).isEqualTo(2);
  }

  @Test
  public void testUpdateRemoveOrder() {
    Date timeStamp = new Date(0);
    OrderBookUpdate lowerBidUpdate =
        new OrderBookUpdate(OrderType.BID, 1d, CurrencyPair.BTC_USD, 10d, timeStamp, 0d);
    orderBook.update(lowerBidUpdate);
    assertThat(orderBook.getBids().size()).isEqualTo(0);
  }

  @Test
  public void testUpdateAddVolume() {

    Date timeStamp = new Date(0);
    OrderBookUpdate lowerBidUpdate =
        new OrderBookUpdate(OrderType.BID, 1d, CurrencyPair.BTC_USD, 10d, timeStamp, 10d);
    orderBook.update(lowerBidUpdate);
    assertThat(orderBook.getBids().size()).isEqualTo(1);
    assertThat(orderBook.getBids().get(0).getOriginalAmount()).isEqualTo(10d);
  }

  @Test
  public void testDateSame() {

    Date timeStamp = new Date(0);
    OrderBookUpdate lowerBidUpdate =
        new OrderBookUpdate(OrderType.BID, 1d, CurrencyPair.BTC_USD, 10d, timeStamp, 10d);
    Date oldDate = orderBook.getTimeStamp();
    orderBook.update(lowerBidUpdate);
    assertThat(orderBook.getTimeStamp()).isEqualTo(oldDate);
  }

  @Test
  public void testDateOther() {

    Date timeStamp = new Date(10);
    OrderBookUpdate lowerBidUpdate =
        new OrderBookUpdate(OrderType.BID, 1d, CurrencyPair.BTC_USD, 10d, timeStamp, 10d);
    Date oldDate = orderBook.getTimeStamp();
    orderBook.update(lowerBidUpdate);
    assertThat(orderBook.getTimeStamp()).isAfter(oldDate);
    assertThat(orderBook.getTimeStamp()).isEqualTo(timeStamp);
  }
}
