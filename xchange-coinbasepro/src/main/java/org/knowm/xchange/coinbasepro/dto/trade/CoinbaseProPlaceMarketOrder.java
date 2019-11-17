package org.knowm.xchange.coinbasepro.dto.trade;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * MARKET ORDER PARAMETERS
 *
 * <table>
 * <tr><th>Param</th><th>Description</th></tr>
 * <tr><td>size</td><td>[optional] Desired amount in BTC</td></tr>
 * <tr><td>funds</td><td>[optional] Desired amount of quote currency to use</td></tr>
 * </table>
 *
 * <em>One of size or funds is required.</em>
 *
 * @author bryant_harris
 */
public class CoinbaseProPlaceMarketOrder extends CoinbaseProPlaceOrder {
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  @JsonProperty("size")
  Double size;

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  @JsonProperty("funds")
  Double funds;

  public CoinbaseProPlaceMarketOrder(
      String clientOld,
      Type type,
      Side side,
      String productId,
      SelfTradePrevention stp,
      Stop stop,
      Double stopPrice,
      Double size,
      Double funds) {
    super(clientOld, type, side, productId, stp, stop, stopPrice);
    this.size = size;
    this.funds = funds;

    if ((size != null && funds != null) || (size == null && funds == null))
      throw new IllegalArgumentException("One of size or funds is required.");
  }

  public Double getSize() {
    return size;
  }

  public Double getFunds() {
    return funds;
  }

  @Override
  public String toString() {
    return "CoinbaseProPlaceMarketOrder [size="
        + size
        + ", funds="
        + funds
        + ", clientOid="
        + clientOid
        + ", type="
        + type
        + ", side="
        + side
        + ", productId="
        + productId
        + ", stp="
        + stp
        + ", stop="
        + stop
        + ", stopPrice="
        + stopPrice
        + "]";
  }

  public static class Builder
      extends CoinbaseProPlaceOrder.Builder<CoinbaseProPlaceMarketOrder, Builder> {
    Double size;
    Double funds;

    public Builder size(Double size) {
      this.size = size;
      return this;
    }

    public Builder funds(Double funds) {
      this.funds = funds;
      return this;
    }

    @Override
    public CoinbaseProPlaceMarketOrder build() {
      return new CoinbaseProPlaceMarketOrder(
          clientOid, type, side, productId, stp, stop, stopPrice, size, funds);
    }
  }
}
