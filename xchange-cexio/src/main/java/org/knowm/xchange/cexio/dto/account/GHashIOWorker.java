package org.knowm.xchange.cexio.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Author: veken0m */
public class GHashIOWorker {

  private final Double last5m;
  private final Double last15m;
  private final Double last1h;
  private final Double last1d;
  private final Double prev5m;
  private final Double prev15m;
  private final Double prev1h;
  private final Double prev1d;
  private final GHashIORejected rejected;

  /**
   * @param last5m
   * @param last15m
   * @param last1h
   * @param last1d
   * @param prev5m
   * @param prev15m
   * @param prev1h
   * @param prev1d
   * @param rejected
   */
  public GHashIOWorker(
      @JsonProperty("last5m") Double last5m,
      @JsonProperty("last15m") Double last15m,
      @JsonProperty("last1h") Double last1h,
      @JsonProperty("last1d") Double last1d,
      @JsonProperty("prev5m") Double prev5m,
      @JsonProperty("prev15m") Double prev15m,
      @JsonProperty("prev1h") Double prev1h,
      @JsonProperty("prev1d") Double prev1d,
      @JsonProperty("rejected") GHashIORejected rejected) {

    this.last5m = last5m;
    this.last15m = last15m;
    this.last1h = last1h;
    this.last1d = last1d;
    this.prev5m = prev5m;
    this.prev15m = prev15m;
    this.prev1h = prev1h;
    this.prev1d = prev1d;
    this.rejected = rejected;
  }

  public Double getLast5m() {

    return last5m;
  }

  public Double getLast15m() {

    return last15m;
  }

  public Double getLast1h() {

    return last1h;
  }

  public Double getLast1d() {

    return last1d;
  }

  public Double getPrev5m() {

    return prev5m;
  }

  public Double getPrev15m() {

    return prev15m;
  }

  public Double getPrev1h() {

    return prev1h;
  }

  public Double getPrev1d() {

    return prev1d;
  }

  public GHashIORejected getRejected() {

    return rejected;
  }
}
