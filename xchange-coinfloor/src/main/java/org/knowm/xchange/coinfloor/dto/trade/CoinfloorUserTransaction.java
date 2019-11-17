package org.knowm.xchange.coinfloor.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.Objects;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;

public class CoinfloorUserTransaction {
  public String datetime = "";

  public long id = 0;

  @JsonProperty("order_id")
  public long orderId = 0;

  public TransactionType type = TransactionType.UNKNOWN;

  public Double fee = 0d;

  // amounts: for TRADE transactions, negative -> BID, positive -> ASK
  // for other transactions, negative -> WITHDRAWAL, positive -> DEPOSIT
  @JsonProperty("xbt")
  public Double btc = 0d;

  public Double gbp = 0d;

  public Double usd = 0d;

  public Double eur = 0d;

  public Double eth = 0d;

  public Double ltc = 0d;

  public Double bch = 0d;

  public Double xrp = 0d;

  // prices
  @JsonProperty("xbt_gbp")
  public Double btc_gbp = 0d;

  @JsonProperty("xbt_usd")
  public Double btc_usd = 0d;

  @JsonProperty("xbt_eur")
  public Double btc_eur = 0d;

  @JsonProperty("bch_gbp")
  public Double bch_gbp = 0d;

  @JsonProperty("eth_gbp")
  public Double eth_gbp = 0d;

  @JsonProperty("xrp_gbp")
  public Double xrp_gbp = 0d;

  @JsonProperty("ltc_gbp")
  public Double ltc_gbp = 0d;

  public CurrencyPair getCurrencyPair() {
    if (isTrade()) {
      if (!Objects.equals(btc_gbp, 0d)) {
        return CurrencyPair.BTC_GBP;
      } else if (!Objects.equals(btc_usd, 0d)) {
        return CurrencyPair.BTC_USD;
      } else if (!Objects.equals(btc_eur, 0d)) {
        return CurrencyPair.BTC_EUR;
      } else if (!Objects.equals(bch_gbp, 0d)) {
        return CurrencyPair.BCH_GBP;
      } else if (!Objects.equals(eth_gbp, 0d)) {
        return CurrencyPair.ETH_GBP;
      } else if (!Objects.equals(xrp_gbp, 0d)) {
        return CurrencyPair.XRP_GBP;
      } else if (!Objects.equals(ltc_gbp, 0d)) {
        return CurrencyPair.LTC_GBP;
      }
    }
    return null; // not a trade or an unsupported currency pair
  }

  public Double getPrice() {
    if (isTrade()) {
      if (!Objects.equals(btc_gbp, 0d)) {
        return btc_gbp;
      } else if (!Objects.equals(btc_usd, 0d)) {
        return btc_usd;
      } else if (!Objects.equals(btc_eur, 0d)) {
        return btc_eur;
      } else if (!Objects.equals(bch_gbp, 0d)) {
        return bch_gbp;
      } else if (!Objects.equals(eth_gbp, 0d)) {
        return eth_gbp;
      } else if (!Objects.equals(xrp_gbp, 0d)) {
        return xrp_gbp;
      } else if (!Objects.equals(ltc_gbp, 0d)) {
        return ltc_gbp;
      }
    }
    return 0d; // not a trade or an unsupported currency pair
  }

  public Currency getCurrency() {
    if (isTrade()) {
      return null;
    } else if (btc != 0.0) {
      return Currency.BTC;
    } else if (gbp != 0.0) {
      return Currency.GBP;
    } else if (usd != 0.0) {
      return Currency.USD;
    } else if (eur != 0.0) {
      return Currency.EUR;
    } else if (ltc != 0.0) {
      return Currency.LTC;
    } else if (eth != 0.0) {
      return Currency.ETH;
    } else if (bch != 0.0) {
      return Currency.BCH;
    } else if (xrp != 0.0) {
      return Currency.XRP;
    } else {
      return null;
    }
  }

  public Double getAmount() {
    if (isTrade()) {
      if (getCurrencyPair().base == Currency.BTC) {
        return btc;
      } else if (getCurrencyPair().base == Currency.XRP) {
        return xrp;
      } else if (getCurrencyPair().base == Currency.LTC) {
        return ltc;
      } else if (getCurrencyPair().base == Currency.ETH) {
        return eth;
      } else if (getCurrencyPair().base == Currency.BCH) {
        return bch;
      } else {
        return 0d;
      }
    } else if (btc != 0.0) {
      return btc;
    } else if (bch != 0.0) {
      return bch;
    } else if (xrp != 0.0) {
      return xrp;
    } else if (ltc != 0.0) {
      return ltc;
    } else if (eth != 0.0) {
      return eth;
    } else if (gbp != 0.0) {
      return gbp;
    } else if (usd != 0.0) {
      return usd;
    } else if (eur != 0.0) {
      return eur;
    } else {
      return 0d; // an unsupported currency
    }
  }

  public OrderType getSide() {
    if (isTrade()) {
      switch ((int) Math.signum(getAmount())) {
        case 0:
        default:
          return null; // deposit or withdrawal
        case 1:
          return OrderType.BID;
        case -1:
          return OrderType.ASK;
      }
    } else {
      return null;
    }
  }

  public boolean isDeposit() {
    return type == TransactionType.DEPOSIT;
  }

  public boolean isWithdrawal() {
    return type == TransactionType.WITHDRAWAL;
  }

  public boolean isTrade() {
    return type == TransactionType.TRADE;
  }

  public TransactionType getType() {
    return type;
  }

  public String getDateTime() {
    return datetime;
  }

  public long getId() {
    return id;
  }

  public long getOrderId() {
    return orderId;
  }

  public Double getFee() {
    return fee;
  }

  @Override
  public String toString() {
    if (isTrade()) {
      return String.format(
          "CoinfloorUserTransaction{datetime=%s, id=%d, orderId=%d, type=%s, currencyPair=%s side=%s amount=%s price=%s fee=%s}",
          datetime, id, orderId, type, getCurrencyPair(), getSide(), getAmount(), getPrice(), fee);
    } else {
      return String.format(
          "CoinfloorUserTransaction{datetime=%s, id=%d, type=%s, currency=%s amount=%s }",
          datetime, id, type, getCurrency(), getAmount());
    }
  }

  public enum TransactionType {
    DEPOSIT,
    WITHDRAWAL,
    TRADE,
    UNKNOWN
  }

  public static class CoinfloorTransactionTypeDeserializer
      extends JsonDeserializer<TransactionType> {

    @Override
    public TransactionType deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      switch (jp.getValueAsInt()) {
        case 0:
          return TransactionType.DEPOSIT;
        case 1:
          return TransactionType.WITHDRAWAL;
        case 2:
          return TransactionType.TRADE;
        default:
          return TransactionType.UNKNOWN;
      }
    }
  }
}
