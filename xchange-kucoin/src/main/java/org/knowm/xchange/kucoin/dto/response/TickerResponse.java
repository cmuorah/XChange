/** Copyright 2019 Mek Global Limited. */
package org.knowm.xchange.kucoin.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/** Created by chenshiwei on 2019/1/10. */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerResponse {

  private String sequence;

  private Double bestAsk;

  private Double bestBid;

  private Double size;

  private Double price;

  private Double bestAskSize;

  private Double bestBidSize;

  private long time;
}
