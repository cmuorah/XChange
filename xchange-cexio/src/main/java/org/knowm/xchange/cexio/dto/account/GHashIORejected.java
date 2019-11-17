package org.knowm.xchange.cexio.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Author: veken0m */
public class GHashIORejected {

  private final Double stale;
  private final Double duplicate;
  private final Double lowdiff;

  /**
   * @param stale
   * @param duplicate
   * @param lowdiff
   */
  public GHashIORejected(
      @JsonProperty("stale") Double stale,
      @JsonProperty("duplicate") Double duplicate,
      @JsonProperty("lowdiff") Double lowdiff) {

    this.stale = stale;
    this.duplicate = duplicate;
    this.lowdiff = lowdiff;
  }

  public Double getStale() {

    return stale;
  }

  public Double getDuplicate() {

    return duplicate;
  }

  public Double getLowdiff() {

    return lowdiff;
  }
}
