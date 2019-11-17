package org.knowm.xchange.dragonex.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Balance {

  public final String code;
  public final long coinId;
  public final Double frozen;
  public final Double volume;

  public Balance(
      @JsonProperty("code") String code,
      @JsonProperty("coin_id") long coinId,
      @JsonProperty("frozen") Double frozen,
      @JsonProperty("volume") Double volume) {
    this.code = code;
    this.coinId = coinId;
    this.frozen = frozen;
    this.volume = volume;
  }

  @Override
  public String toString() {
    return "Balance ["
        + (code != null ? "code=" + code + ", " : "")
        + "coinId="
        + coinId
        + ", "
        + (frozen != null ? "frozen=" + frozen + ", " : "")
        + (volume != null ? "volume=" + volume : "")
        + "]";
  }
}
