package org.knowm.xchange.therock.dto.trade;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.knowm.xchange.therock.TheRock;

/**
 * @author Matija Mazi
 * @author Pnk
 */
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class TheRockOrder {

  private Long id;
  private TheRock.Pair fundId;
  private Side side;
  private Type type;
  private String status;
  private Double amount;
  private Double amountUnfilled;
  private Double price;
  private String conditionalType;
  private Double conditionalPrice;
  private String date;
  private String closeOn;
  private boolean dark;
  private Double leverage;
  private long positionId;

  protected TheRockOrder() {}

  public TheRockOrder(TheRock.Pair fundId, Side side, Type type, Double amount, Double price) {
    this.fundId = fundId;
    this.side = side;
    this.type = type;
    this.amount = amount;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public TheRock.Pair getFundId() {
    return fundId;
  }

  public Side getSide() {
    return side;
  }

  public Type getType() {
    return type;
  }

  public String getStatus() {
    return status;
  }

  public Double getAmount() {
    return amount;
  }

  public Double getAmountUnfilled() {
    return amountUnfilled;
  }

  public Double getPrice() {
    return price;
  }

  public String getConditionalType() {
    return conditionalType;
  }

  public Double getConditionalPrice() {
    return conditionalPrice;
  }

  public String getDate() {
    return date;
  }

  public String getCloseOn() {
    return closeOn;
  }

  public boolean isDark() {
    return dark;
  }

  public Double getLeverage() {
    return leverage;
  }

  public long getPositionId() {
    return positionId;
  }

  @Override
  public String toString() {
    return String.format(
        "TheRockOrder{id=%d, side=%s, type=%s, amount=%s, amountUnfilled=%s, price=%s, fundId=%s, status='%s'}",
        id, side, type, amount, amountUnfilled, price, fundId, status);
  }

  public enum Side {
    buy,
    sell
  }

  public enum Type {
    market,
    limit
  }
}
