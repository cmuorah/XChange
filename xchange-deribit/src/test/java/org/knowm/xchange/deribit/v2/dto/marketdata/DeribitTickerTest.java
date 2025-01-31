package org.knowm.xchange.deribit.v2.dto.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import org.junit.Test;

public class DeribitTickerTest {

  @Test
  public void deserializeTradeTest() throws Exception {

    // given
    InputStream is =
        DeribitTrade.class.getResourceAsStream(
            "/org/knowm/xchange/deribit/v2/dto/marketdata/example-ticker.json");

    // when
    ObjectMapper mapper = new ObjectMapper();
    DeribitTicker ticker = mapper.readValue(is, DeribitTicker.class);

    // then
    assertThat(ticker).isNotNull();

    assertThat(ticker.getUnderlyingPrice()).isEqualTo(new Double("5433.06"));
    assertThat(ticker.getUnderlyingIndex()).isEqualTo("SYN.BTC-3MAY19");
    assertThat(ticker.getTimestamp().getTime()).isEqualTo(1556125162701L);
    assertThat(ticker.getStats()).isNotNull();
    assertThat(ticker.getState()).isEqualTo("open");
    assertThat(ticker.getSettlementPrice()).isEqualTo(new Double("0.01"));
    assertThat(ticker.getOpenInterest()).isEqualTo(new Double("0.5"));
    assertThat(ticker.getMinPrice()).isEqualTo(new Double("0.0005"));
    assertThat(ticker.getMaxPrice()).isEqualTo(new Double("0.0625"));
    assertThat(ticker.getMarkPrice()).isEqualTo(new Double("0.01236567"));
    assertThat(ticker.getMarkIv()).isEqualTo(new Double("68.48"));
    assertThat(ticker.getLastPrice()).isEqualTo(new Double("0.0075"));
    assertThat(ticker.getInterestRate()).isEqualTo(new Double("0"));
    assertThat(ticker.getInstrumentName()).isEqualTo("BTC-3MAY19-5000-P");
    assertThat(ticker.getIndexPrice()).isEqualTo(new Double("5438.82"));
    assertThat(ticker.getGreeks()).isNotNull();
    assertThat(ticker.getBidIv()).isEqualTo(new Double("62.83"));
    assertThat(ticker.getBestBidPrice()).isEqualTo(new Double("0.01"));
    assertThat(ticker.getBestBidAmount()).isEqualTo(new Double("5"));
    assertThat(ticker.getBestAskPrice()).isEqualTo(new Double("0.0135"));
    assertThat(ticker.getBestAskAmount()).isEqualTo(new Double("5"));
    assertThat(ticker.getAskIv()).isEqualTo(new Double("71.09"));
  }
}
