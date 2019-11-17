package org.knowm.xchange.bitz.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitZUserAssetsInfo {
  private final String name;
  private final Double num;
  private final Double over;
  private final Double lock;
  private final Double btc;
  private final Double usd;
  private final Double cny;

  public BitZUserAssetsInfo(
      @JsonProperty("name") String name,
      @JsonProperty("num") Double num,
      @JsonProperty("over") Double over,
      @JsonProperty("lock") Double lock,
      @JsonProperty("btc") Double btc,
      @JsonProperty("usd") Double usd,
      @JsonProperty("cny") Double cny) {
    this.name = name;
    this.num = num;
    this.over = over;
    this.lock = lock;
    this.btc = btc;
    this.usd = usd;
    this.cny = cny;
  }

  public String getName() {
    return name;
  }

  public Double getNum() {
    return num;
  }

  public Double getOver() {
    return over;
  }

  public Double getLock() {
    return lock;
  }

  public Double getBtc() {
    return btc;
  }

  public Double getUsd() {
    return usd;
  }

  public Double getCny() {
    return cny;
  }

  @Override
  public String toString() {
    return "BitZUserAssetsInfo{"
        + "name='"
        + name
        + '\''
        + ", num="
        + num
        + ", over="
        + over
        + ", lock="
        + lock
        + ", btc="
        + btc
        + ", usd="
        + usd
        + ", cny="
        + cny
        + '}';
  }
}
