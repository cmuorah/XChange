/** Copyright 2019 Mek Global Limited. */
package org.knowm.xchange.kucoin.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponse {

  private String id;

  private String symbol;

  private String opType;

  private String type;

  public String getType() {
    return this.type == null ? null : this.type.toLowerCase();
  }

  private String side;

  public String getSide() {
    return this.side == null ? null : this.side.toLowerCase();
  }

  private Double price;

  private Double size;

  private Double funds;

  private Double dealFunds;

  private Double dealSize;

  private Double fee;

  private String feeCurrency;

  private String stp;

  private String stop;

  public String getStop() {
    return this.stop == null ? null : this.stop.toLowerCase();
  }

  private Boolean stopTriggered;

  private Double stopPrice;

  private String timeInForce;

  private boolean postOnly;

  private boolean hidden;

  private boolean iceberg;

  private Double visibleSize;

  private Long cancelAfter;

  private String channel;

  private String clientOid;

  private String remark;

  private String tags;

  @JsonProperty("isActive")
  private boolean isActive;

  private boolean cancelExist;

  private Date createdAt;
}
