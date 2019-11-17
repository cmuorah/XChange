package org.knowm.xchange.bitmex.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.knowm.xchange.bitmex.AbstractHttpResponseAware;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "account",
  "currency",
  "prevDeposited",
  "prevWithdrawn",
  "prevTransferIn",
  "prevTransferOut",
  "prevAmount",
  "prevTimestamp",
  "deltaDeposited",
  "deltaWithdrawn",
  "deltaTransferIn",
  "deltaTransferOut",
  "deltaAmount",
  "deposited",
  "withdrawn",
  "transferIn",
  "transferOut",
  "amount",
  "pendingCredit",
  "pendingDebit",
  "confirmedDebit",
  "timestamp",
  "addr",
  "script",
  "withdrawalLock"
})
public final class BitmexWallet extends AbstractHttpResponseAware {

  @JsonProperty("account")
  private Integer account;

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("prevDeposited")
  private Double prevDeposited;

  @JsonProperty("prevWithdrawn")
  private Double prevWithdrawn;

  @JsonProperty("prevTransferIn")
  private Double prevTransferIn;

  @JsonProperty("prevTransferOut")
  private Double prevTransferOut;

  @JsonProperty("prevAmount")
  private Double prevAmount;

  @JsonProperty("prevTimestamp")
  private String prevTimestamp;

  @JsonProperty("deltaDeposited")
  private Double deltaDeposited;

  @JsonProperty("deltaWithdrawn")
  private Double deltaWithdrawn;

  @JsonProperty("deltaTransferIn")
  private Double deltaTransferIn;

  @JsonProperty("deltaTransferOut")
  private Double deltaTransferOut;

  @JsonProperty("deltaAmount")
  private Double deltaAmount;

  @JsonProperty("deposited")
  private Double deposited;

  @JsonProperty("withdrawn")
  private Double withdrawn;

  @JsonProperty("transferIn")
  private Double transferIn;

  @JsonProperty("transferOut")
  private Double transferOut;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("pendingCredit")
  private Double pendingCredit;

  @JsonProperty("pendingDebit")
  private Double pendingDebit;

  @JsonProperty("confirmedDebit")
  private Double confirmedDebit;

  @JsonProperty("timestamp")
  private String timestamp;

  @JsonProperty("addr")
  private String addr;

  @JsonProperty("script")
  private String script;

  @JsonProperty("withdrawalLock")
  private List<String> withdrawalLock = null;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<>();

  public Integer getAccount() {
    return account;
  }

  public String getCurrency() {
    return currency;
  }

  public Double getPrevDeposited() {
    return prevDeposited;
  }

  public Double getPrevWithdrawn() {
    return prevWithdrawn;
  }

  public Double getPrevTransferIn() {
    return prevTransferIn;
  }

  public Double getPrevTransferOut() {
    return prevTransferOut;
  }

  public Double getPrevAmount() {
    return prevAmount;
  }

  public String getPrevTimestamp() {
    return prevTimestamp;
  }

  public Double getDeltaDeposited() {
    return deltaDeposited;
  }

  public Double getDeltaWithdrawn() {
    return deltaWithdrawn;
  }

  public Double getDeltaTransferIn() {
    return deltaTransferIn;
  }

  public Double getDeltaTransferOut() {
    return deltaTransferOut;
  }

  public Double getDeltaAmount() {
    return deltaAmount;
  }

  public Double getDeposited() {
    return deposited;
  }

  public Double getWithdrawn() {
    return withdrawn;
  }

  public Double getTransferIn() {
    return transferIn;
  }

  public Double getTransferOut() {
    return transferOut;
  }

  public Double getAmount() {
    return amount;
  }

  public Double getPendingCredit() {
    return pendingCredit;
  }

  public Double getPendingDebit() {
    return pendingDebit;
  }

  public Double getConfirmedDebit() {
    return confirmedDebit;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public String getAddr() {
    return addr;
  }

  public String getScript() {
    return script;
  }

  public List<String> getWithdrawalLock() {
    return withdrawalLock;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  @Override
  public String toString() {
    return "BitmexWallet{"
        + "account="
        + account
        + ", currency='"
        + currency
        + '\''
        + ", prevDeposited="
        + prevDeposited
        + ", prevWithdrawn="
        + prevWithdrawn
        + ", prevTransferIn="
        + prevTransferIn
        + ", prevTransferOut="
        + prevTransferOut
        + ", prevAmount="
        + prevAmount
        + ", prevTimestamp='"
        + prevTimestamp
        + '\''
        + ", deltaDeposited="
        + deltaDeposited
        + ", deltaWithdrawn="
        + deltaWithdrawn
        + ", deltaTransferIn="
        + deltaTransferIn
        + ", deltaTransferOut="
        + deltaTransferOut
        + ", deltaAmount="
        + deltaAmount
        + ", deposited="
        + deposited
        + ", withdrawn="
        + withdrawn
        + ", transferIn="
        + transferIn
        + ", transferOut="
        + transferOut
        + ", amount="
        + amount
        + ", pendingCredit="
        + pendingCredit
        + ", pendingDebit="
        + pendingDebit
        + ", confirmedDebit="
        + confirmedDebit
        + ", timestamp='"
        + timestamp
        + '\''
        + ", addr='"
        + addr
        + '\''
        + ", script='"
        + script
        + '\''
        + ", withdrawalLock="
        + withdrawalLock
        + ", additionalProperties="
        + additionalProperties
        + '}';
  }
}
