package org.knowm.xchange.kuna.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.knowm.xchange.kuna.dto.enums.KunaSide;
import org.knowm.xchange.kuna.util.KunaUtils;

/** @author Dat Bui */
public class KunaTrade {

  public static final String CREATED_AT = "created_at";

  private int id;
  private Double price;
  private Double volume;
  private Double funds;
  private String market;
  private Date createdAt;
  private KunaSide side;

  /** Hide default constructor. */
  private KunaTrade() {}

  /**
   * Creates new builder.
   *
   * @return builder
   */
  public static Builder builder() {
    return new Builder();
  }

  public int getId() {
    return id;
  }

  public Double getPrice() {
    return price;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getFunds() {
    return funds;
  }

  public String getMarket() {
    return market;
  }

  @JsonProperty(CREATED_AT)
  public Date getCreatedAt() {
    return createdAt;
  }

  public KunaSide getSide() {
    return side;
  }

  public static class Builder {

    private KunaTrade target = new KunaTrade();

    public Builder withId(int id) {
      target.id = id;
      return this;
    }

    public Builder withSide(String side) {
      target.side = KunaSide.valueOfIgnoreCase(side);
      return this;
    }

    public Builder withPrice(Double price) {
      target.price = price;
      return this;
    }

    public Builder withFunds(Double funds) {
      target.funds = funds;
      return this;
    }

    public Builder withMarket(String market) {
      target.market = market;
      return this;
    }

    @JsonProperty(CREATED_AT)
    public Builder withCreatedAt(String createdAt) {
      if (createdAt == null || createdAt.isEmpty()) {
        target.createdAt = null;
      } else {
        target.createdAt = KunaUtils.toDate(createdAt);
      }
      return this;
    }

    public Builder withVolume(Double volume) {
      target.volume = volume;
      return this;
    }

    public KunaTrade build() {
      return this.target;
    }
  }
}
