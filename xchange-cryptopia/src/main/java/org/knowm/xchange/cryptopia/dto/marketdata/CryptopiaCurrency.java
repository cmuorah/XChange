package org.knowm.xchange.cryptopia.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class CryptopiaCurrency {

  private final long id;
  private final String name;
  private final String symbol;
  private final String algorithm;
  private final Double withdrawFee;
  private final Double minWithdraw;
  private final Double maxWithdraw;
  private final Double minBaseTrade;
  private final boolean isTipEnabled;
  private final Double minTip;
  private final long depositConfirmations;
  private final String status;
  private final String statusMessage;
  private final String listingStatus;

  public CryptopiaCurrency(
      @JsonProperty("Id") long id,
      @JsonProperty("Name") String name,
      @JsonProperty("Symbol") String symbol,
      @JsonProperty("Algorithm") String algorithm,
      @JsonProperty("WithdrawFee") Double withdrawFee,
      @JsonProperty("MinWithdraw") Double minWithdraw,
      @JsonProperty("MaxWithdraw") Double maxWithdraw,
      @JsonProperty("MinBaseTrade") Double minBaseTrade,
      @JsonProperty("IsTipEnabled") boolean isTipEnabled,
      @JsonProperty("MinTip") Double minTip,
      @JsonProperty("DepositConfirmations") long depositConfirmations,
      @JsonProperty("Status") String status,
      @JsonProperty("StatusMessage") String statusMessage,
      @JsonProperty("ListingStatus") String listingStatus) {
    this.id = id;
    this.name = name;
    this.symbol = symbol;
    this.algorithm = algorithm;
    this.withdrawFee = withdrawFee;
    this.minWithdraw = minWithdraw;
    this.maxWithdraw = maxWithdraw;
    this.minBaseTrade = minBaseTrade;
    this.isTipEnabled = isTipEnabled;
    this.minTip = minTip;
    this.depositConfirmations = depositConfirmations;
    this.status = status;
    this.statusMessage = statusMessage;
    this.listingStatus = listingStatus;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getAlgorithm() {
    return algorithm;
  }

  public Double getWithdrawFee() {
    return withdrawFee;
  }

  public Double getMinWithdraw() {
    return minWithdraw;
  }

  public Double getMaxWithdraw() {
    return maxWithdraw;
  }

  public Double getMinBaseTrade() {
    return minBaseTrade;
  }

  public boolean isTipEnabled() {
    return isTipEnabled;
  }

  public Double getMinTip() {
    return minTip;
  }

  public long getDepositConfirmations() {
    return depositConfirmations;
  }

  public String getStatus() {
    return status;
  }

  public String getStatusMessage() {
    return statusMessage;
  }

  public String getListingStatus() {
    return listingStatus;
  }

  @Override
  public String toString() {
    return "CryptopiaCurrency{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", symbol='"
        + symbol
        + '\''
        + ", algorithm='"
        + algorithm
        + '\''
        + ", withdrawFee="
        + withdrawFee
        + ", minWithdraw="
        + minWithdraw
        + ", maxWithdraw="
        + maxWithdraw
        + ", minBaseTrade="
        + minBaseTrade
        + ", isTipEnabled="
        + isTipEnabled
        + ", minTip="
        + minTip
        + ", depositConfirmations="
        + depositConfirmations
        + ", status='"
        + status
        + '\''
        + ", statusMessage='"
        + statusMessage
        + '\''
        + ", listingStatus='"
        + listingStatus
        + '\''
        + '}';
  }
}
