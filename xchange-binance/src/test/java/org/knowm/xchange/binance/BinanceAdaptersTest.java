package org.knowm.xchange.binance;

import org.junit.Test;
import org.knowm.xchange.binance.dto.trade.BinanceOrder;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.trade.MarketOrder;
import org.knowm.xchange.utils.ObjectMapperHelper;

import static org.assertj.core.api.Assertions.assertThat;

public class BinanceAdaptersTest {

    @Test
    public void testFilledMarketOrder() throws Exception {
        BinanceOrder binanceOrder = ObjectMapperHelper.readValue(BinanceAdaptersTest.class.getResource("/filled-market-order.json"), BinanceOrder.class);
        Order order = BinanceAdapters.adaptOrder(binanceOrder);
        assertThat(order).isInstanceOf(MarketOrder.class);
        MarketOrder marketOrder = (MarketOrder) order;
        assertThat(marketOrder.getStatus()).isEqualByComparingTo(Order.OrderStatus.FILLED);
        assertThat(marketOrder.getOriginalAmount()).isEqualByComparingTo(new Double("0.10700000"));
        assertThat(marketOrder.getCumulativeAmount()).isEqualByComparingTo(new Double("0.10700000"));
        assertThat(marketOrder.getRemainingAmount()).isEqualByComparingTo(0d);
        assertThat(marketOrder.getAveragePrice()).isEqualByComparingTo(new Double("0.018583831775700936"));
    }
}
