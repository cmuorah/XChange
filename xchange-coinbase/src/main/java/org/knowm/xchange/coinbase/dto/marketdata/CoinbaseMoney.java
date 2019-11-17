package org.knowm.xchange.coinbase.dto.marketdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.knowm.xchange.coinbase.dto.serialization.CoinbaseMoneyDeserializer;

/** @author jamespedwards42 */
@JsonDeserialize(using = CoinbaseMoneyDeserializer.class)
public class CoinbaseMoney {

  private final String currency;
  private final Double amount;

  public CoinbaseMoney(String currency, final Double amount) {

    this.currency = currency;
    this.amount = amount;
  }

  public String getCurrency() {

    return currency;
  }

  public Double getAmount() {

    return amount;
  }

  @Override
  public String toString() {

    return "CoinbaseMoney [currency=" + currency + ", amount=" + amount + "]";
  }
}
