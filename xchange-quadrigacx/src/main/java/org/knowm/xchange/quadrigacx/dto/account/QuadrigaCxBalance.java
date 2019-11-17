package org.knowm.xchange.quadrigacx.dto.account;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.knowm.xchange.currency.Currency;

public final class QuadrigaCxBalance {

  private final Double fee;
  private final String error;
  private Map<Currency, Double> currencyReserved = new HashMap<>();
  private Map<Currency, Double> currencyAvailable = new HashMap<>();
  private Map<Currency, Double> currencyBalance = new HashMap<>();
  private List<Currency> currencies = new ArrayList<>();

  public QuadrigaCxBalance(
      @JsonProperty("fee") Double fee,
      @JsonProperty("error") String error,
      @JsonProperty("fees") Object fees) {

    this.fee = fee;
    this.error = error;
  }

  @JsonAnySetter
  public void setCurrencyAmount(String currencyBalance, Double amount) {

    String[] parts = currencyBalance.split("_");
    Currency currency = Currency.getInstance(parts[0].toUpperCase());

    if (parts.length > 1) {
      switch (parts[1]) {
        case "reserved":
          this.currencyReserved.put(currency, amount);
          break;
        case "available":
          this.currencyAvailable.put(currency, amount);
          break;
        case "balance":
          this.currencyBalance.put(currency, amount);
          break;
      }

      if (!currencies.contains(currency)) currencies.add(currency);
    }
  }

  public Double getCurrencyBalance(Currency currency) {
    return this.currencyBalance.get(currency);
  }

  public Double getCurrencyReserved(Currency currency) {
    return this.currencyReserved.get(currency);
  }

  public Double getCurrencyAvailable(Currency currency) {
    return this.currencyAvailable.get(currency);
  }

  public List<Currency> getCurrencyList() {
    return this.currencies;
  }

  public Double getFee() {

    return fee;
  }

  public String getError() {

    return error;
  }

  @Override
  public String toString() {
    return "QuadrigaCxBalance{"
        + "currencyReserved="
        + currencyReserved
        + ", currencyAvailable="
        + currencyAvailable
        + ", currencyBalance="
        + currencyBalance
        + ", fee="
        + fee
        + ", error='"
        + error
        + '\''
        + '}';
  }
}
