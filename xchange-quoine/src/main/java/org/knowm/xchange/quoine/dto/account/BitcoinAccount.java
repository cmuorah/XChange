package org.knowm.xchange.quoine.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author timmolter */
public final class BitcoinAccount {

  private final Integer id;
  private final Double balance;
  private final String address;
  private final String currency;
  private final String currencySymbol;
  private final String pusherChannel;
  private final Double btcMinimumWithdraw;
  private final Double lowestOfferInterestRate;
  private final Double highestOfferInterestRate;
  private final Double freeBalance;

  /**
   * Constructor
   *
   * @param id
   * @param balance
   * @param address
   * @param currency
   * @param currencySymbol
   * @param pusherChannel
   * @param btcMinimumWithdraw
   * @param lowestOfferInterestRate
   * @param highestOfferInterestRate
   * @param freeBalance
   */
  public BitcoinAccount(
      @JsonProperty("id") Integer id,
      @JsonProperty("balance") Double balance,
      @JsonProperty("address") String address,
      @JsonProperty("currency") String currency,
      @JsonProperty("currency_symbol") String currencySymbol,
      @JsonProperty("pusher_channel") String pusherChannel,
      @JsonProperty("btc_minimum_withdraw") Double btcMinimumWithdraw,
      @JsonProperty("lowest_offer_interest_rate") Double lowestOfferInterestRate,
      @JsonProperty("highest_offer_interest_rate") Double highestOfferInterestRate,
      @JsonProperty("free_balance") Double freeBalance) {
    this.id = id;
    this.balance = balance;
    this.address = address;
    this.currency = currency;
    this.currencySymbol = currencySymbol;
    this.pusherChannel = pusherChannel;
    this.btcMinimumWithdraw = btcMinimumWithdraw;
    this.lowestOfferInterestRate = lowestOfferInterestRate;
    this.highestOfferInterestRate = highestOfferInterestRate;
    this.freeBalance = freeBalance;
  }

  public Integer getId() {
    return id;
  }

  public Double getBalance() {
    return balance;
  }

  public String getAddress() {
    return address;
  }

  public String getCurrency() {
    return currency;
  }

  public String getCurrencySymbol() {
    return currencySymbol;
  }

  public String getPusherChannel() {
    return pusherChannel;
  }

  public Double getBtcMinimumWithdraw() {
    return btcMinimumWithdraw;
  }

  public Double getLowestOfferInterestRate() {
    return lowestOfferInterestRate;
  }

  public Double getHighestOfferInterestRate() {
    return highestOfferInterestRate;
  }

  public Double getFreeBalance() {
    return freeBalance;
  }

  @Override
  public String toString() {
    return "BitcoinAccount [id="
        + id
        + ", balance="
        + balance
        + ", address="
        + address
        + ", currency="
        + currency
        + ", currencySymbol="
        + currencySymbol
        + ", pusherChannel="
        + pusherChannel
        + ", btcMinimumWithdraw="
        + btcMinimumWithdraw
        + ", lowestOfferInterestRate="
        + lowestOfferInterestRate
        + ", highestOfferInterestRate="
        + highestOfferInterestRate
        + ", freeBalance="
        + freeBalance
        + "]";
  }
}
