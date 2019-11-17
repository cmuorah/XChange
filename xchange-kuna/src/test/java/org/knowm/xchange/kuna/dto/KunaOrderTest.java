package org.knowm.xchange.kuna.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.knowm.xchange.kuna.util.KunaUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.knowm.xchange.kuna.dto.enums.KunaOrderType.LIMIT;
import static org.knowm.xchange.kuna.dto.enums.KunaOrderType.MARKET;
import static org.knowm.xchange.kuna.dto.enums.KunaSide.BUY;
import static org.knowm.xchange.kuna.dto.enums.KunaSide.SELL;

public class KunaOrderTest {

    //  private static KunaOrder order;

    //  @BeforeClass/**/
    public KunaOrder order() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream file =
                     getClass().getClassLoader().getResourceAsStream("org/knowm/xchange/kuna/dto/order.json")) {

            return mapper.readValue(file, mapper.constructType(KunaOrder.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_id() throws IOException {
        assertEquals(0, KunaOrder.builder().withId(0).build().getId());
        assertEquals(MIN_VALUE, KunaOrder.builder().withId(MIN_VALUE).build().getId());
        assertEquals(MAX_VALUE, KunaOrder.builder().withId(MAX_VALUE).build().getId());

        assertThat(order().getId()).isEqualTo(2052694);
    }

    @Test
    public void test_side() {
        assertThat(KunaOrder.builder().withSide(null).build().getSide()).isNull();
        assertThat(KunaOrder.builder().withSide(BUY.name().toUpperCase()).build().getSide())
                .isEqualByComparingTo(BUY);
        assertThat(KunaOrder.builder().withSide(SELL.name().toUpperCase()).build().getSide())
                .isEqualByComparingTo(SELL);
        assertThat(KunaOrder.builder().withSide(BUY.name().toLowerCase()).build().getSide())
                .isEqualByComparingTo(BUY);
        assertThat(KunaOrder.builder().withSide(SELL.name().toLowerCase()).build().getSide())
                .isEqualByComparingTo(SELL);

        assertThat(order().getSide()).isEqualByComparingTo(SELL);
    }

    @Test
    public void test_order_type() {
        assertThat(KunaOrder.builder().withOrderType(null).build().getOrderType()).isNull();
        assertThat(KunaOrder.builder().withOrderType(LIMIT.name().toUpperCase()).build().getOrderType())
                .isEqualByComparingTo(LIMIT);
        assertThat(
                KunaOrder.builder().withOrderType(MARKET.name().toUpperCase()).build().getOrderType())
                .isEqualByComparingTo(MARKET);
        assertThat(KunaOrder.builder().withOrderType(LIMIT.name().toLowerCase()).build().getOrderType())
                .isEqualByComparingTo(LIMIT);
        assertThat(
                KunaOrder.builder().withOrderType(MARKET.name().toLowerCase()).build().getOrderType())
                .isEqualByComparingTo(MARKET);

        assertThat(order().getOrderType()).isEqualByComparingTo(LIMIT);
    }

    @Test
    public void test_price() {
        assertEquals(0d, KunaOrder.builder().withPrice(0d).build().getPrice(), 1e-8);
        assertEquals(1d, KunaOrder.builder().withPrice(0d).build().getPrice(), 1e-8);
        assertEquals(10d, KunaOrder.builder().withPrice(10d).build().getPrice(), 1e-8);

        assertThat(order().getPrice()).isEqualByComparingTo(new Double("359995.0"));
    }

    @Test
    public void test_average_price() {
        assertEquals(0d, KunaOrder.builder().withAveragePrice(0d).build().getAveragePrice(), 1e-8);
        assertEquals(1d, KunaOrder.builder().withAveragePrice(1d).build().getAveragePrice(), 1e-8);
        assertEquals(10d, KunaOrder.builder().withAveragePrice(10d).build().getAveragePrice(), 1e-8);

        assertThat(order().getAveragePrice()).isEqualByComparingTo(Double.parseDouble("359995.0"));
    }

    @Test
    public void test_state() {
        assertThat(KunaOrder.builder().withState(null).build().getState()).isNull();
        assertThat(KunaOrder.builder().withState("").build().getState()).isEmpty();

        assertThat(order().getState()).isEqualTo("wait");
    }

    @Test
    public void test_market() {
        assertThat(KunaOrder.builder().withMarket(null).build().getMarket()).isNull();
        assertThat(KunaOrder.builder().withMarket("").build().getMarket()).isEmpty();

        assertThat(order().getMarket()).isEqualTo("btcuah");
    }

    @Test
    public void test_createdAt() {
        assertThat(KunaOrder.builder().withCreatedAt(null).build().getCreatedAt()).isNull();
        assertThat(
                KunaOrder.builder().withCreatedAt(KunaUtils.format(new Date())).build().getCreatedAt())
                .isEqualToIgnoringSeconds(new Date());
        // belongs in the adapter
        //    assertThat(order().getCreatedAt()).isEqualTo("2018-01-16T09:28:05Z");
        // TODO fix this. somehow the local time zone is causing this to fail by a one-hour difference.
        //    assertThat(order.getCreatedAt()).isEqualTo("2018-01-16T09:28:05Z");
    }

    @Test
    public void test_volume() {
        assertEquals(0d, KunaOrder.builder().withVolume(0d).build().getVolume(), 1e-8);
        assertEquals(1d, KunaOrder.builder().withVolume(1d).build().getVolume(), 1e-8);
        assertEquals(10d, KunaOrder.builder().withVolume(10d).build().getVolume(), 1e-8);

        assertThat(order().getVolume()).isEqualByComparingTo(Double.parseDouble("0.021"));
    }

    @Test
    public void test_remaining_volume() {
        assertEquals(0d, KunaOrder.builder().withRemainingVolume(0d).build().getRemainingVolume(), 1e-8);
        assertEquals(1d, KunaOrder.builder().withRemainingVolume(1d).build().getRemainingVolume(), 1e-8);
        assertEquals(10d, KunaOrder.builder().withRemainingVolume(10d).build().getRemainingVolume(), 1e-8);

        assertThat(order().getRemainingVolume()).isEqualByComparingTo(Double.parseDouble("0.014437"));
    }

    @Test
    public void test_executed_volume() {
        assertEquals(0d, KunaOrder.builder().withExecutedVolume(0d).build().getExecutedVolume(), 1e-8);
        assertEquals(1d, KunaOrder.builder().withExecutedVolume(1d).build().getExecutedVolume(), 1e-8);
        assertEquals(10d, KunaOrder.builder().withExecutedVolume(10d).build().getExecutedVolume(), 1e-8);

        assertThat(order().getExecutedVolume()).isEqualByComparingTo(Double.parseDouble("0.006563"));
    }

    @Test
    public void test_trades_count() {
        assertEquals(0, KunaOrder.builder().withTradesCount(0).build().getTradesCount());
        assertEquals(
                MIN_VALUE, KunaOrder.builder().withTradesCount(MIN_VALUE).build().getTradesCount());
        assertEquals(
                MAX_VALUE, KunaOrder.builder().withTradesCount(MAX_VALUE).build().getTradesCount());

        assertThat(order().getTradesCount()).isEqualTo(1);
    }
}
