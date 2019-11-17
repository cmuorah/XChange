package org.knowm.xchange.bitz.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitZAssetsInfo {
  private final long uid;
  private final Double bzOver;
  private final Double bzLock;
  private final long created;
  private final long updated;

  public BitZAssetsInfo(
      @JsonProperty("uid") long uid,
      @JsonProperty("bz_over") Double bzOver,
      @JsonProperty("bz_lock") Double bzLock,
      @JsonProperty("created") long created,
      @JsonProperty("updated") long updated) {
    this.uid = uid;
    this.bzOver = bzOver;
    this.bzLock = bzLock;
    this.created = created;
    this.updated = updated;
  }

  public long getUid() {
    return uid;
  }

  public Double getBzOver() {
    return bzOver;
  }

  public Double getBzLock() {
    return bzLock;
  }

  public long getCreated() {
    return created;
  }

  public long getUpdated() {
    return updated;
  }

  @Override
  public String toString() {
    return "BitZAssetsInfo{"
        + "uid="
        + uid
        + ", bzOver="
        + bzOver
        + ", bzLock="
        + bzLock
        + ", created="
        + created
        + ", updated="
        + updated
        + '}';
  }
}
