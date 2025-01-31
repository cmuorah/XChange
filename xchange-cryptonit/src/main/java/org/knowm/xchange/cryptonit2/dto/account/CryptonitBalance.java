package org.knowm.xchange.cryptonit2.dto.account;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/** @author Matija Mazi */
public final class CryptonitBalance {

  private final Double fee;
  private final String error;

  /** map with currency -> Balance */
  private final Map<String, Balance> balances = new HashMap<>();
  /** map with pair -> fee */
  private final Map<String, Double> fees = new HashMap<>();

  /**
   * Constructor
   *
   * @param fee
   */
  public CryptonitBalance(@JsonProperty("fee") Double fee, @JsonProperty("error") String error) {
    this.fee = fee;
    this.error = error;
  }

  @JsonAnySetter
  public void setDynamicProperty(String name, Double value) {
    int idx = name.indexOf('_');
    if (idx < 0) {
      // ignore it, we expect s.th. like xxx_xxx
    }
    String pre = name.substring(0, idx);
    String post = name.substring(idx + 1);
    switch (post) {
      case "fee":
        fees.put(pre, value);
        break;
      case "balance":
        getBalance(pre).balance = value;
        break;
      case "available":
        getBalance(pre).available = value;
        break;
      case "reserved":
        getBalance(pre).reserved = value;
        break;
      default:
        break;
    }
  }

  private Balance getBalance(String currency) {
    Balance b = balances.get(currency);
    if (b == null) {
      b = new Balance(currency);
      balances.put(currency, b);
    }
    return b;
  }

  public Double getFee() {
    return fee;
  }

  public Double getFee(String pair) {
    return fees.get(pair);
  }

  public String getError() {
    return error;
  }

  public Collection<Balance> getBalances() {
    return balances.values();
  }

  public static final class Balance {
    private final String currency;
    private Double balance;
    private Double reserved;
    private Double available;

    public Balance(String currency) {
      this.currency = currency;
    }

    public String getCurrency() {
      return currency;
    }

    public Double getBalance() {
      return balance;
    }

    public Double getReserved() {
      return reserved;
    }

    public Double getAvailable() {
      return available;
    }
  }
}
