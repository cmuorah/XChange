package org.knowm.xchange.coinfloor.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.Balance;

public class CoinfloorBalance {
  @JsonProperty("gbp_balance")
  public Double gbpBalance = 0d;

  @JsonProperty("usd_balance")
  public Double usdBalance = 0d;

  @JsonProperty("eur_balance")
  public Double eurBalance = 0d;

  @JsonProperty("xbt_balance")
  public Double btcBalance = 0d;

  @JsonProperty("bch_balance")
  public Double bchBalance = 0d;

  @JsonProperty("eth_balance")
  public Double ethBalance = 0d;

  @JsonProperty("ltc_balance")
  public Double ltcBalance = 0d;

  @JsonProperty("xrp_balance")
  public Double xrpBalance = 0d;

  @JsonProperty("gbp_reserved")
  public Double gbpReserved = 0d;

  @JsonProperty("usd_reserved")
  public Double usdReserved = 0d;

  @JsonProperty("eur_reserved")
  public Double eurReserved = 0d;

  @JsonProperty("xbt_reserved")
  public Double btcReserved = 0d;

  @JsonProperty("bch_reserved")
  public Double bchReserved = 0d;

  @JsonProperty("eth_reserved")
  public Double ethReserved = 0d;

  @JsonProperty("ltc_reserved")
  public Double ltcReserved = 0d;

  @JsonProperty("xrp_reserved")
  public Double xrpReserved = 0d;

  @JsonProperty("gbp_available")
  public Double gbpAvailable = 0d;

  @JsonProperty("usd_available")
  public Double usdAvailable = 0d;

  @JsonProperty("eur_available")
  public Double eurAvailable = 0d;

  @JsonProperty("xbt_available")
  public Double btcAvailable = 0d;

  @JsonProperty("bch_available")
  public Double bchAvailable = 0d;

  @JsonProperty("eth_available")
  public Double ethAvailable = 0d;

  @JsonProperty("ltc_available")
  public Double ltcAvailable = 0d;

  @JsonProperty("xrp_available")
  public Double xrpAvailable = 0d;

  public boolean hasCurrency(Currency currency) {
    if (currency.equals(Currency.BTC)) {
      return !Objects.equals(btcBalance, 0d);
    } else if (currency.equals(Currency.GBP)) {
      return !Objects.equals(gbpBalance, 0d);
    } else if (currency.equals(Currency.EUR)) {
      return !Objects.equals(eurBalance, 0d);
    } else if (currency.equals(Currency.USD)) {
      return !Objects.equals(usdBalance, 0d);
    } else if (currency.equals(Currency.BCH)) {
      return !Objects.equals(bchBalance, 0d);
    } else if (currency.equals(Currency.XRP)) {
      return !Objects.equals(xrpBalance, 0d);
    } else if (currency.equals(Currency.LTC)) {
      return !Objects.equals(ltcBalance, 0d);
    } else if (currency.equals(Currency.ETH)) {
      return !Objects.equals(ethBalance, 0d);
    } else {
      return false;
    }
  }

  public Balance getBalance(Currency currency) {
    if (currency.equals(Currency.XBT)) {
      return new Balance(currency, btcBalance, btcAvailable, btcReserved);
    } else if (currency.equals(Currency.GBP)) {
      return new Balance(currency, gbpBalance, gbpAvailable, gbpReserved);
    } else if (currency.equals(Currency.EUR)) {
      return new Balance(currency, eurBalance, eurAvailable, eurReserved);
    } else if (currency.equals(Currency.USD)) {
      return new Balance(currency, usdBalance, usdAvailable, usdReserved);
    } else if (currency.equals(Currency.BCH)) {
      return new Balance(currency, bchBalance, bchAvailable, bchReserved);
    } else if (currency.equals(Currency.XRP)) {
      return new Balance(currency, xrpBalance, xrpAvailable, xrpReserved);
    } else if (currency.equals(Currency.LTC)) {
      return new Balance(currency, ltcBalance, ltcAvailable, ltcReserved);
    } else if (currency.equals(Currency.ETH)) {
      return new Balance(currency, ethBalance, ethAvailable, ethReserved);
    } else {
      throw new IllegalArgumentException("Unsupported currency: " + currency);
    }
  }
}
