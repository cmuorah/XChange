package org.knowm.xchange.bithumb.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.knowm.xchange.bithumb.dto.BithumbResponse;

public class BithumbTradeResponse extends BithumbResponse<List<BithumbTradeResponse.BithumbTrade>> {

  private final String orderId;

  public BithumbTradeResponse(
      @JsonProperty("status") String status,
      @JsonProperty("message") String message,
      @JsonProperty("data") List<BithumbTrade> data,
      @JsonProperty("order_id") String orderId) {
    super(status, message, data);
    this.orderId = orderId;
  }

  public String getOrderId() {
    return orderId;
  }

  public static class BithumbTrade {
    private final String contId;
    private final Double units;
    private final Double price;
    private final Double total;
    private final Double fee;

    public BithumbTrade(
        @JsonProperty("cont_id") String contId,
        @JsonProperty("units") Double units,
        @JsonProperty("price") Double price,
        @JsonProperty("total") Double total,
        @JsonProperty("fee") Double fee) {
      this.contId = contId;
      this.units = units;
      this.price = price;
      this.total = total;
      this.fee = fee;
    }

    public String getContId() {
      return contId;
    }

    public Double getUnits() {
      return units;
    }

    public Double getPrice() {
      return price;
    }

    public Double getTotal() {
      return total;
    }

    public Double getFee() {
      return fee;
    }

    @Override
    public String toString() {
      return "BithumbTrade{"
          + "contId='"
          + contId
          + '\''
          + ", units="
          + units
          + ", price="
          + price
          + ", total="
          + total
          + ", fee="
          + fee
          + '}';
    }
  }
}
