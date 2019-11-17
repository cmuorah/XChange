package org.knowm.xchange.luno.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

public class LunoBalance {

  private final Balance[] balance;

  public LunoBalance(@JsonProperty(value = "balance", required = true) Balance[] balance) {
    this.balance = balance != null ? balance : new Balance[0];
  }

  @Override
  public String toString() {
    return "LunoBalance [balance(" + balance.length + ")=" + Arrays.toString(balance) + "]";
  }

  public Balance[] getBalance() {
    Balance[] copy = new Balance[balance.length];
    System.arraycopy(balance, 0, copy, 0, balance.length);
    return copy;
  }

  public static class Balance {
    public final String accountId;
    public final String asset;
    public final Double balance;
    public final Double reserved;
    public final Double unconfirmed;
    public final String name;

    public Balance(
        @JsonProperty(value = "account_id", required = true) String accountId,
        @JsonProperty(value = "asset", required = true) String asset,
        @JsonProperty(value = "balance", required = true) Double balance,
        @JsonProperty(value = "reserved", required = true) Double reserved,
        @JsonProperty(value = "unconfirmed", required = true) Double unconfirmed,
        @JsonProperty(value = "name") String name) {
      super();
      this.accountId = accountId;
      this.asset = asset;
      this.balance = balance;
      this.reserved = reserved;
      this.unconfirmed = unconfirmed;
      this.name = name;
    }

    @Override
    public String toString() {
      return "Balance [accountId="
          + accountId
          + ", asset="
          + asset
          + ", balance="
          + balance
          + ", reserved="
          + reserved
          + ", unconfirmed="
          + unconfirmed
          + ", name="
          + name
          + "]";
    }
  }
}
