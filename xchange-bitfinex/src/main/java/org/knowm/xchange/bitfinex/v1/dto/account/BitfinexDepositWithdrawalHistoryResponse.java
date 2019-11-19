package org.knowm.xchange.bitfinex.v1.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.knowm.xchange.dto.account.FundingRecord;

public class BitfinexDepositWithdrawalHistoryResponse {

  @JsonProperty("id")
  private long id;

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("method")
  private String method;

  @JsonProperty("type")
  private FundingRecord.Type type;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("description")
  private String description;

  @JsonProperty("address")
  private String address;

  @JsonProperty("status")
  private String status;

  @JsonProperty("timestamp")
  private Double timestamp;

  @JsonProperty("txid")
  private String txid;

  @JsonProperty("timestamp_created")
  private Double timestampCreated;

  @JsonProperty("fee")
  private Double fee;

  public BitfinexDepositWithdrawalHistoryResponse(
      @JsonProperty("id") Long id,
      @JsonProperty("currency") String currency,
      @JsonProperty("method") String method,
      @JsonProperty("type") FundingRecord.Type type,
      @JsonProperty("amount") Double amount,
      @JsonProperty("description") String description,
      @JsonProperty("address") String address,
      @JsonProperty("status") String status,
      @JsonProperty("timestamp") Double timestamp,
      @JsonProperty("txid") String txid,
      @JsonProperty("timestamp_created") Double timestampCreated,
      @JsonProperty("fee") Double fee) {
    this.id = id;
    this.currency = currency;
    this.method = method;
    this.type = type;
    this.amount = amount;
    this.description = description;
    this.address = address;
    this.status = status;
    this.timestamp = timestamp;
    this.txid = txid;
    this.timestampCreated = timestampCreated;
    this.fee = fee;
  }

  @Override
  public String toString() {
    return "BitfinexDepositWithdrawalHistoryResponse [id="
        + id
        + ", currency="
        + currency
        + ", method="
        + method
        + ", type="
        + type
        + ", amount="
        + amount
        + ", description="
        + description
        + ", address="
        + address
        + ", status="
        + status
        + ", timestamp="
        + getTimestamp()
        + ", txid="
        + txid
        + ", timestampCreated="
        + getTimestampCreated()
        + ", fee="
        + fee
        + "]";
  }

  public long getId() {
    return id;
  }

  public String getCurrency() {
    return currency;
  }

  public String getMethod() {
    return method;
  }

  public FundingRecord.Type getType() {
    return type;
  }

  public Double getAmount() {
    return amount;
  }

  public String getDescription() {
    return description;
  }

  public String getAddress() {
    return address;
  }

  public String getStatus() {
    return status;
  }

  public Date getTimestamp() {
    return new Date((long)(timestamp * 1e3));
  }

  public String getTxid() {
    return txid;
  }

  public Date getTimestampCreated() {
    return new Date((long)(timestampCreated * 1e3));
  }

  public Double getFee() {
    return fee;
  }
}
