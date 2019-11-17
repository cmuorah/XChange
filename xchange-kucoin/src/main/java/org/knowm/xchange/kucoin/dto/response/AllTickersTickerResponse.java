package org.knowm.xchange.kucoin.dto.response;

import lombok.Data;

@Data
public class AllTickersTickerResponse {
  private String symbol;
  private Double high;
  private Double vol;
  private Double last;
  private Double low;
  private Double buy;
  private Double sell;
  private Double changePrice;
  private Double changeRate;
  private Double volValue;
}
