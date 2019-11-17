/** Copyright 2019 Mek Global Limited. */
package org.knowm.xchange.kucoin.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeResponse {

  private String symbol;

  private String tradeId;

  private String orderId;

  private String counterOrderId;

  private String side;

  public String getSide() {
    return this.side == null ? null : this.side.toLowerCase();
  }

  private String liquidity;

  public String getLiquidity() {
    return this.liquidity == null ? null : this.liquidity.toLowerCase();
  }

  private boolean forceTaker;

  private Double price;

  private Double size;

  private Double funds;

  private Double fee;

  private Double feeRate;

  private String feeCurrency;

  private String domainId;

  @JsonProperty("type")
  private String orderType;

  private String stop;

  @JsonProperty("createdAt")
  private Date tradeCreatedAt;

  private String displayType;
}
