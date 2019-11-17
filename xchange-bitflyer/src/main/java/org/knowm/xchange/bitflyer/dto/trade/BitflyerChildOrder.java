package org.knowm.xchange.bitflyer.dto.trade;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.bitflyer.BitflyerUtils;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BitflyerChildOrder {
  private static final int CURRENCY_SCALE = 2;
  private static final int SIZE_SCALE = 8;

  private String productCode;
  private BitflyerChildOrderType childOrderType;
  private BitflyerSide side;
  private Double price;
  private Double size;
  private Long minuteToExpire;
  private BitflyerTimeInForce timeInForce;

  public BitflyerChildOrder(
      String productCode,
      BitflyerChildOrderType childOrderType,
      BitflyerSide side,
      Double price,
      Double size,
      Long minuteToExpire,
      BitflyerTimeInForce timeInForce) {

    this.productCode = productCode;
    this.childOrderType = childOrderType;
    this.side = side;
    this.price = price;
    this.size = size;
    this.minuteToExpire = minuteToExpire;
    this.timeInForce = timeInForce;
  }

  public static BitflyerChildOrderBuilder getOrderBuilder() {
    return new BitflyerChildOrderBuilder();
  }

  @JsonProperty("product_code")
  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  @JsonProperty("child_order_type")
  public BitflyerChildOrderType getChildOrderType() {
    return childOrderType;
  }

  public void setChildOrderType(BitflyerChildOrderType childOrderType) {
    this.childOrderType = childOrderType;
  }

  @JsonProperty("side")
  public BitflyerSide getSide() {
    return side;
  }

  public void setSide(BitflyerSide side) {
    this.side = side;
  }

  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @JsonProperty("size")
  public Double getSize() {
    return size;
  }

  public void setSize(Double size) {
    this.size = size;
  }

  @JsonProperty("minute_to_expire")
  public Long getMinuteToExpire() {
    return minuteToExpire;
  }

  public void setMinuteToExpire(Long minuteToExpire) {
    this.minuteToExpire = minuteToExpire;
  }

  @JsonProperty("time_in_force")
  public BitflyerTimeInForce getTimeInForce() {
    return timeInForce;
  }

  public void setTimeInForce(BitflyerTimeInForce timeInForce) {
    this.timeInForce = timeInForce;
  }

  @Override
  public String toString() {
    return "BitflyerChildOrder{"
        + "productCode='"
        + productCode
        + '\''
        + ", childOrderType="
        + childOrderType
        + ", side="
        + side
        + ", price="
        + price
        + ", size="
        + size
        + ", minuteToExpire="
        + minuteToExpire
        + ", timeInForce="
        + timeInForce
        + '}';
  }

  public static class BitflyerChildOrderBuilder {
    private CurrencyPair currencyPair;
    private BitflyerChildOrderType childOrderType;
    private BitflyerSide side;
    private Double price;
    private Double size;
    private Long minuteToExpire = null;
    private BitflyerTimeInForce timeInForce = BitflyerTimeInForce.GTC;

    public BitflyerChildOrderBuilder withProductCode(CurrencyPair currencyPair) {
      this.currencyPair = currencyPair;

      return this;
    }

    public BitflyerChildOrderBuilder withChildOrderType(BitflyerChildOrderType childOrderType) {
      this.childOrderType = childOrderType;

      return this;
    }

    public BitflyerChildOrderBuilder withSide(Order.OrderType orderType) {
      this.side = BitflyerSide.fromOrderType(orderType);

      return this;
    }

    public BitflyerChildOrderBuilder withPrice(Double price) {
      this.price = price;

      return this;
    }

    public BitflyerChildOrderBuilder withSize(Double size) {
      this.size = size;

      return this;
    }

    public BitflyerChildOrderBuilder withMinuteToExpire(Long minuteToExpire) {
      this.minuteToExpire = minuteToExpire;

      return this;
    }

    public BitflyerChildOrderBuilder withTimeInForce(BitflyerTimeInForce timeInForce) {
      this.timeInForce = timeInForce;

      return this;
    }

    public BitflyerChildOrder buildOrder() {
      return new BitflyerChildOrder(
          BitflyerUtils.bitflyerProductCode(currencyPair),
          childOrderType,
          side,
          price,
          size,
          minuteToExpire,
          timeInForce);
    }
  }
}
