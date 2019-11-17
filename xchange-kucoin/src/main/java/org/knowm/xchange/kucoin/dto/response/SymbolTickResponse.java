/** Copyright 2019 Mek Global Limited. */
package org.knowm.xchange.kucoin.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author yi.yang
 * @since 2018/12/26.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SymbolTickResponse {

  private String symbol;

  private Double changeRate;

  private Double changePrice;

  private Double open;

  private Double close;

  private Double high;

  private Double low;

  private Double vol;

  private Double volValue;

  private Double last;

  private Double buy;

  private Double sell;

  private long time;
}
