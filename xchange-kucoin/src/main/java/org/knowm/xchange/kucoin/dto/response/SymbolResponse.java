/** Copyright 2019 Mek Global Limited. */
package org.knowm.xchange.kucoin.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/** Created by devin@kucoin.com on 2018-12-27. */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SymbolResponse {

  private String symbol;

  private String name;

  private String market;

  private String baseCurrency;

  private String quoteCurrency;

  private Double baseMinSize;

  private Double quoteMinSize;

  private Double baseMaxSize;

  private Double quoteMaxSize;

  private Double baseIncrement;

  private Double quoteIncrement;

  private Double priceIncrement;

  private boolean enableTrading;
}
