package org.knowm.xchange.quoine.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author timmolter */
public final class Execution {

  private final Double quantity;
  private final Double price;
  private final String makerSide;
  private final Double createdAt;
  private final Double sellerFee;
  private final Double buyerFee;
  private final Double buyFxRate;
  private final Double sellFxRate;

  /**
   * Constructor
   *
   * @param quantity
   * @param price
   * @param makerSide
   * @param createdAt
   * @param sellerFee
   * @param buyerFee
   * @param buyFxRate
   * @param sellFxRate
   */
  public Execution(
      @JsonProperty("quantity") Double quantity,
      @JsonProperty("price") Double price,
      @JsonProperty("maker_side") String makerSide,
      @JsonProperty("created_at") Double createdAt,
      @JsonProperty("seller_fee") Double sellerFee,
      @JsonProperty("buyer_fee") Double buyerFee,
      @JsonProperty("buy_fx_rate") Double buyFxRate,
      @JsonProperty("sell_fx_rate") Double sellFxRate) {
    this.quantity = quantity;
    this.price = price;
    this.makerSide = makerSide;
    this.createdAt = createdAt;
    this.sellerFee = sellerFee;
    this.buyerFee = buyerFee;
    this.buyFxRate = buyFxRate;
    this.sellFxRate = sellFxRate;
  }

  public Double getQuantity() {
    return quantity;
  }

  public Double getPrice() {
    return price;
  }

  public String getMakerSide() {
    return makerSide;
  }

  public Double getCreatedAt() {
    return createdAt;
  }

  public Double getSellerFee() {
    return sellerFee;
  }

  public Double getBuyerFee() {
    return buyerFee;
  }

  public Double getBuyFxRate() {
    return buyFxRate;
  }

  public Double getSellFxRate() {
    return sellFxRate;
  }

  @Override
  public String toString() {
    return "Execution [quantity="
        + quantity
        + ", price="
        + price
        + ", makerSide="
        + makerSide
        + ", createdAt="
        + createdAt
        + ", sellerFee="
        + sellerFee
        + ", buyerFee="
        + buyerFee
        + ", buyFxRate="
        + buyFxRate
        + ", sellFxRate="
        + sellFxRate
        + "]";
  }
}
