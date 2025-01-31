package org.knowm.xchange.dto.account;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import net.openhft.chronicle.wire.AbstractMarshallable;
import org.knowm.xchange.currency.Currency;

/**
 * DTO representing funding information
 *
 * <p>Funding information contains the detail of deposit/withdrawal transaction for a specific
 * currency
 */
public final class FundingRecord extends AbstractMarshallable implements Serializable {

  private static final long serialVersionUID = 3788398035845873448L;

  /** Crypto currency address for deposit/withdrawal */
  private final String address;

  /** Crypto currency destination tag for deposit/withdrawal */
  private final String destinationTag;

  /** Long/Time of transaction */
  private final Long date;

  /** The transaction currency */
  private final Currency currency;

  /** Amount deposited/withdrawn in given transaction currency (always positive) */
  private final Double amount;

  /** Internal transaction identifier, specific to the Exchange. */
  private final String internalId;

  /**
   * External Transaction id that identifies the transaction within the public ledger, eg.
   * blockchain transaction hash.
   */
  private final String blockchainTransactionHash;
  /** Transaction Type */
  private final Type type;
  /**
   * Status of the transaction whenever available (e.g. Open, Completed or any descriptive status of
   * transaction)
   */
  private final Status status;
  /** Balance of the associated account after the transaction is performed */
  private final Double balance;
  /** Transaction Fee Amount in given transaction currency (always positive) */
  private final Double fee;
  /** Description of the transaction */
  private String description;

  /**
   * Constructs a {@link FundingRecord}.
   *
   * @param address Crypto currency address for deposit/withdrawal
   * @param date Long/Time of transaction
   * @param currency The transaction currency
   * @param amount Amount deposited/withdrawn (always positive)
   * @param internalId Internal transaction identifier, specific to the Exchange
   * @param blockchainTransactionHash Transaction hash/id that identifies the transaction within the
   *     public ledger
   * @param type Transaction Type {@link Type}
   * @param status Status of the transaction whenever available (e.g. Pending, Completed or any
   *     descriptive status of transaction). Will be naively converted to Status enum if possible,
   *     or else be prefixed to description.
   * @param balance Balance of the associated account after the transaction is performed
   * @param fee Transaction Fee Amount (always positive)
   * @param description Description of the transaction. It is a good idea to put here any extra info
   *     sent back from the exchange that doesn't fit elsewhere so users can still access it.
   * @deprecated Use the constructor with enum status parameter.
   */
  @Deprecated
  public FundingRecord(
      final String address,
      final Long date,
      final Currency currency,
      final Double amount,
      final String internalId,
      final String blockchainTransactionHash,
      final Type type,
      final String status,
      final Double balance,
      final Double fee,
      final String description) {
    this(
        address,
        date,
        currency,
        amount,
        internalId,
        blockchainTransactionHash,
        type,
        Status.resolveStatus(status),
        balance,
        fee,
        description);
    if (this.status == null && status != null) {
      this.description =
          this.description == null || this.description.isEmpty()
              ? status
              : status + ": " + this.description;
    }
  }

  /**
   * Constructs a {@link FundingRecord}.
   *
   * @param address Crypto currency address for deposit/withdrawal
   * @param destinationTag Crypto address destination tag for deposit/withdrawal
   * @param date Long/Time of transaction
   * @param currency The transaction currency
   * @param amount Amount deposited/withdrawn (always positive)
   * @param internalId Internal transaction identifier, specific to the Exchange
   * @param blockchainTransactionHash Transaction hash/id that identifies the transaction within the
   *     public ledger
   * @param type Transaction Type {@link Type}
   * @param status Status of the transaction whenever available
   * @param balance Balance of the associated account after the transaction is performed
   * @param fee Transaction Fee Amount (always positive)
   * @param description Description of the transaction. It is a good idea to put here any extra info
   *     sent back from the exchange that doesn't fit elsewhere so users can still access it.
   */
  public FundingRecord(
      final String address,
      final String destinationTag,
      final Long date,
      final Currency currency,
      final Double amount,
      final String internalId,
      final String blockchainTransactionHash,
      final Type type,
      final Status status,
      final Double balance,
      final Double fee,
      final String description) {
    this.address = address;
    this.destinationTag = destinationTag;
    this.date = date;
    this.currency = currency;
    this.amount = amount == null ? null : Math.abs(amount);
    this.internalId = internalId;
    this.blockchainTransactionHash = blockchainTransactionHash;
    this.type = type;
    this.status = status;
    this.balance = balance;
    this.fee = fee == null ? null : Math.abs(fee);
    this.description = description;
  }

  /**
   * Constructs a {@link FundingRecord}.
   *
   * @param address Crypto currency address for deposit/withdrawal
   * @param date Long/Time of transaction
   * @param currency The transaction currency
   * @param amount Amount deposited/withdrawn (always positive)
   * @param internalId Internal transaction identifier, specific to the Exchange
   * @param blockchainTransactionHash Transaction hash/id that identifies the transaction within the
   *     public ledger
   * @param type Transaction Type {@link Type}
   * @param status Status of the transaction whenever available
   * @param balance Balance of the associated account after the transaction is performed
   * @param fee Transaction Fee Amount (always positive)
   * @param description Description of the transaction. It is a good idea to put here any extra info
   *     sent back from the exchange that doesn't fit elsewhere so users can still access it.
   */
  public FundingRecord(
      final String address,
      final Long date,
      final Currency currency,
      final Double amount,
      final String internalId,
      final String blockchainTransactionHash,
      final Type type,
      final Status status,
      final Double balance,
      final Double fee,
      final String description) {
    this(
        address,
        null,
        date,
        currency,
        amount,
        internalId,
        blockchainTransactionHash,
        type,
        status,
        balance,
        fee,
        description);
  }

  /** @return Crypto currency address */
  public String getAddress() {
    return address;
  }

  public String getDestinationTag() {
    return destinationTag;
  }

  /** @return Long/Time of transaction */
  public Long getDate() {
    return date;
  }

  /** @return The transaction currency */
  public Currency getCurrency() {
    return currency;
  }

  /** @return Amount deposited/withdrawn in given transaction currency (always positive) */
  public Double getAmount() {
    return amount;
  }

  /** @return Internal transaction identifier, specific to the Exchange. */
  public String getInternalId() {
    return internalId;
  }

  @Deprecated // for backward compatibility.  Will be removed
  public String getExternalId() {
    return blockchainTransactionHash;
  }

  /**
   * @return External Transaction id that identifies the transaction within the public ledger, eg.
   *     blockchain transaction hash.
   */
  public String getBlockchainTransactionHash() {
    return blockchainTransactionHash;
  }

  /** @return Transaction Type {@link Type} */
  public Type getType() {
    return type;
  }

  /**
   * @return Status of the transaction whenever available (e.g. Open, Completed or any descriptive
   *     status of transaction)
   */
  public Status getStatus() {
    return status;
  }

  /** @return Balance of the associated account after the transaction is performed */
  public Double getBalance() {
    return balance;
  }

  /** @return Transaction Fee Amount in given transaction currency (always positive) */
  public Double getFee() {
    return fee;
  }

  /** @return Description of the transaction */
  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return String.format(
        "FundingRecord{address='%s', date=%s, currency=%s, amount=%s, internalId=%s, blockchainTransactionHash=%s, description='%s', type=%s, status=%s, balance=%s, fee=%s}",
        address,
        date,
        currency,
        amount,
        internalId,
        blockchainTransactionHash,
        description,
        type,
        status,
        balance,
        fee);
  }

  /** Enum representing funding transaction type */
  public enum Type {
    WITHDRAWAL,
    DEPOSIT;

    private static final Map<String, Type> fromString = new HashMap<>();

    static {
      for (Type type : values()) fromString.put(type.toString(), type);
    }

    public static Type fromString(String ledgerTypeString) {
      return fromString.get(ledgerTypeString.toUpperCase());
    }
  }

  public enum Status {
    /**
     * The user has requested the withdrawal or deposit, or the exchange has detected an initiated
     * deposit, but the exchange still has to fully process the funding. The funds are not available
     * to the user. The funding request may possibly still be cancelled though.
     */
    PROCESSING(
        "WAIT CONFIRMATION",
        "EMAIL CONFIRMATION",
        "EMAIL SENT",
        "AWAITING APPROVAL",
        "VERIFYING",
        "PENDING_APPROVAL",
        "PENDING"),

    /**
     * The exchange has processed the transfer fully and successfully. The funding typically cannot
     * be cancelled any more. For withdrawals, the funds are gone from the exchange, though they may
     * have not reached their destination yet. For deposits, the funds are available to the user.
     */
    COMPLETE("COMPLETED"),

    /** The transfer was cancelled either by the user or by the exchange. */
    CANCELLED("REVOKED", "CANCEL", "REFUND"),

    /**
     * The transfer has failed for any reason other than user cancellation after it was initiated
     * and before it was successfully processed. For withdrawals, the funds are available to the
     * user again.
     */
    FAILED("FAILURE"),
    ;

    private static final Map<String, Status> fromString = new HashMap<>();

    static {
      for (final Status status : values()) {
        final String[] statusArray = status.statusArray;
        if (statusArray != null) {
          for (final String statusStr : statusArray) {
            fromString.put(statusStr, status);
          }
        }
        fromString.put(status.toString(), status);
      }
    }

    private String[] statusArray;

    Status(String... statusArray) {
      this.statusArray = statusArray;
    }

    public static Status resolveStatus(String str) {
      if (str == null) {
        return null;
      }
      return fromString.get(str.toUpperCase());
    }
  }

  public static final class Builder {

    private String address;
    private Long date;
    private Currency currency;
    private Double amount;
    private String internalId;
    private String blockchainTransactionHash;
    private String description;
    private Type type;
    private Status status;
    private Double balance;
    private Double fee;

    public static Builder from(FundingRecord record) {
      return new Builder()
          .setAddress(record.address)
          .setDate(record.date)
          .setCurrency(record.currency)
          .setAmount(record.amount)
          .setInternalId(record.internalId)
          .setDescription(record.description)
          .setType(record.type)
          .setStatus(record.status)
          .setBalance(record.balance)
          .setFee(record.fee);
    }

    public Builder setAddress(String address) {
      this.address = address;
      return this;
    }

    public Builder setDate(Long date) {
      this.date = date;
      return this;
    }

    public Builder setCurrency(Currency currency) {
      this.currency = currency;
      return this;
    }

    public Builder setAmount(Double amount) {
      this.amount = amount;
      return this;
    }

    public Builder setInternalId(String internalId) {
      this.internalId = internalId;
      return this;
    }

    public Builder setBlockchainTransactionHash(String blockchainTransactionHash) {
      this.blockchainTransactionHash = blockchainTransactionHash;
      return this;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public Builder setType(Type type) {
      this.type = type;
      return this;
    }

    public Builder setStatus(Status status) {
      this.status = status;
      return this;
    }

    public Builder setBalance(Double balance) {
      this.balance = balance;
      return this;
    }

    public Builder setFee(Double fee) {
      this.fee = fee;
      return this;
    }

    public FundingRecord build() {
      return new FundingRecord(
          address,
          date,
          currency,
          amount,
          internalId,
          blockchainTransactionHash,
          type,
          status,
          balance,
          fee,
          description);
    }
  }
}
