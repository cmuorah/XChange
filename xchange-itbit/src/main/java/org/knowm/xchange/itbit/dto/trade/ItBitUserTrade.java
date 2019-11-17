package org.knowm.xchange.itbit.dto.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;
import org.knowm.xchange.itbit.ItBitDateDeserializer;

public class ItBitUserTrade {
  private String orderId;

  @JsonDeserialize(using = ItBitDateDeserializer.class)
  private Date timestamp;

  private String instrument;
  private Direction direction;
  private String currency1;
  private Double currency1Amount;
  private String currency2;
  private Double currency2Amount;
  private Double rate;
  private Double commissionPaid;
  private String commissionCurrency;
  private Double rebatesApplied;
  private String rebateCurrency;

  public String getOrderId() {
    return orderId;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public String getInstrument() {
    return instrument;
  }

  public Direction getDirection() {
    return direction;
  }

  public String getCurrency1() {
    return currency1;
  }

  public Double getCurrency1Amount() {
    return currency1Amount;
  }

  public String getCurrency2() {
    return currency2;
  }

  public Double getCurrency2Amount() {
    return currency2Amount;
  }

  public Double getRate() {
    return rate;
  }

  public Double getCommissionPaid() {
    return commissionPaid;
  }

  public String getCommissionCurrency() {
    return commissionCurrency;
  }

  public Double getRebatesApplied() {
    return rebatesApplied;
  }

  public String getRebateCurrency() {
    return rebateCurrency;
  }

  public enum Direction {
    buy,
    sell
  }
}
