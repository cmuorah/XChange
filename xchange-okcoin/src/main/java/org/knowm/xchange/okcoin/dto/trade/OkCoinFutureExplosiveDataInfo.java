package org.knowm.xchange.okcoin.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OkCoinFutureExplosiveDataInfo {
  private final Integer amount;
  private final String createDate;
  private final Double loss;
  private final Double price;
  private final Integer type;

  public OkCoinFutureExplosiveDataInfo(
      @JsonProperty("amount") final Integer amount,
      @JsonProperty("create_date") final String createDate,
      @JsonProperty("loss") final Double loss,
      @JsonProperty("price") final Double price,
      @JsonProperty("type") final Integer type) {
    this.amount = amount;
    this.createDate = createDate;
    this.loss = loss;
    this.price = price;
    this.type = type;
  }

  public Integer getAmount() {
    return amount;
  }

  public String getCreateDate() {
    return createDate;
  }

  public Double getLoss() {
    return loss;
  }

  public Double getPrice() {
    return price;
  }

  public Integer getType() {
    return type;
  }

  @Override
  public String toString() {
    return "OkCoinFutureExplosiveDataInfo{"
        + "amount="
        + amount
        + ", createDate='"
        + createDate
        + '\''
        + ", loss="
        + loss
        + ", price="
        + price
        + ", type="
        + type
        + '}';
  }
}
