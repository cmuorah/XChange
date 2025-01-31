package org.knowm.xchange.cryptonit2.dto.trade;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.knowm.xchange.cryptonit2.CryptonitUtils;
import org.knowm.xchange.currency.Currency;

/** @author Matija Mazi */
public final class CryptonitUserTransaction {

  private final Date datetime;
  private final long id;
  private final long order_id;
  private final TransactionType type;
  private final Double fee;
  private final Map<String, Double> amounts = new HashMap<>();
  // possible pairs at the moment: btcusd, btceur, eurusd, xrpusd, xrpeur, xrpbtc
  private String base; // btc, eur, xrp
  private String counter; // usd, eur, btc
  private Double price;

  /**
   * Constructor
   *
   * @param datetime
   * @param id
   * @param order_id
   * @param type
   * @param fee
   */
  public CryptonitUserTransaction(
      @JsonProperty("datetime") String datetime,
      @JsonProperty("id") long id,
      @JsonProperty("order_id") long order_id,
      @JsonProperty("type") TransactionType type,
      @JsonProperty("fee") Double fee) {

    this.datetime = CryptonitUtils.parseDate(datetime);
    this.id = id;
    this.order_id = order_id;
    this.type = type;
    this.fee = fee; // fee currency is the counter currency
  }

  @JsonAnySetter
  public void setDynamicProperty(String name, Object value) {
    // here we handle dynamically the amounts of base and counter curency plus the rate (price),
    // which contains the underscore, ie "btc_usd
    final Set<String> ccyCodeList = Currency.getAvailableCurrencyCodes();
    String[] nameArr = name.toUpperCase().split("_");
    String name1 = nameArr[0];
    if (nameArr.length == 2) {
      String name2 = nameArr[1];
      if (ccyCodeList.contains(name1) && ccyCodeList.contains(name2)) {
        base = name1;
        counter = name2;
        price = new Double(value.toString());
      }
    } else if (nameArr.length == 1) {
      if (ccyCodeList.contains(name1)) {
        amounts.put(name1, new Double(value.toString()));
      }
    }
  }

  public Date getDatetime() {
    return datetime;
  }

  public long getId() {
    return id;
  }

  public long getOrderId() {
    return order_id;
  }

  public TransactionType getType() {
    return type;
  }

  public boolean isDeposit() {
    return type == TransactionType.deposit;
  }

  public boolean isWithdrawal() {
    return type == TransactionType.withdrawal;
  }

  public boolean isMarketTrade() {
    return type == TransactionType.trade;
  }

  public Double getCounterAmount() {
    return amounts.get(counter);
  }

  public Double getBaseAmount() {
    return amounts.get(base);
  }

  public Double getPrice() {
    return price;
  }

  public String getCounterCurrency() {
    return counter;
  }

  public String getBaseCurrency() {
    return base;
  }

  public Double getFee() {
    return fee;
  }

  public String getFeeCurrency() {
    return counter;
  }

  public Map<String, Double> getAmounts() {
    return amounts;
  }

  @Override
  public String toString() {
    return "CryptonitUserTransaction [datetime="
        + datetime
        + ", id="
        + id
        + ", order_id="
        + order_id
        + ", type="
        + type
        + ", fee="
        + fee
        + ", base="
        + base
        + ", counter="
        + counter
        + ", amounts="
        + amounts
        + ", price="
        + price
        + "]";
  }

  public enum TransactionType {
    deposit,
    withdrawal,
    trade,
    rippleWithdrawal,
    rippleDeposit,
    subAccountTransfer;

    @JsonCreator
    public static TransactionType fromString(int type) {
      switch (type) {
        case 0:
          return deposit;
        case 1:
          return withdrawal;
        case 2:
          return trade;
        case 3:
          return rippleWithdrawal;
        case 4:
          return rippleDeposit;
        case 14:
          return subAccountTransfer;
        default:
          throw new IllegalArgumentException(type + " has no corresponding value");
      }
    }
  }
}
