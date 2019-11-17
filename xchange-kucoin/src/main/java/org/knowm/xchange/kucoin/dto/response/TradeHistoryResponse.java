/** Copyright 2019 Mek Global Limited. */
package org.knowm.xchange.kucoin.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/** Created by chenshiwei on 2019/1/18. */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeHistoryResponse {

  private String sequence;

  private Double price;

  private Double size;

  private String side;

  private long time;
}
