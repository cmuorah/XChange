package org.knowm.xchange.paymium.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymiumBalance {

  @JsonProperty("locked_btc")
  private Double lockedBtc;

  @JsonProperty("locked_eur")
  private Double lockedEur;

  @JsonProperty("balance_btc")
  private Double balanceBtc;

  @JsonProperty("balance_eur")
  private Double balanceEur;

  @JsonProperty("meta_state")
  private String metaState;

  @JsonProperty("name")
  private String name;

  @JsonProperty("locale")
  private String locale;

  @JsonProperty("channel_d")
  private String channelId;

  @JsonProperty("email")
  private String email;

  public Double getLockedBtc() {
    return lockedBtc;
  }

  public void setLockedBtc(Double lockedBtc) {
    this.lockedBtc = lockedBtc;
  }

  public Double getLockedEur() {
    return lockedEur;
  }

  public void setLockedEur(Double lockedEur) {
    this.lockedEur = lockedEur;
  }

  public Double getBalanceBtc() {
    return balanceBtc;
  }

  public void setBalanceBtc(Double balanceBtc) {
    this.balanceBtc = balanceBtc;
  }

  public Double getBalanceEur() {
    return balanceEur;
  }

  public void setBalanceEur(Double balanceEur) {
    this.balanceEur = balanceEur;
  }

  public String getMetaState() {
    return metaState;
  }

  public void setMetaState(String metaState) {
    this.metaState = metaState;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public String getChannelId() {
    return channelId;
  }

  public void setChannelId(String channelId) {
    this.channelId = channelId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {

    return "PaymiumBalance [lockedBtc="
        + lockedBtc
        + ", lockedEur="
        + lockedEur
        + ", balanceBtc="
        + balanceBtc
        + ", balanceEur="
        + balanceEur
        + ", metaState="
        + metaState
        + ", name="
        + name
        + ", locale="
        + locale
        + ", channelId="
        + channelId
        + ", email="
        + email
        + "]";
  }
}
