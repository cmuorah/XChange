package org.knowm.xchange.bitfinex.v1.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.stream.Collectors;
import org.knowm.xchange.bitfinex.service.BitfinexAdapters;
import org.knowm.xchange.currency.Currency;

/** @author ujjwal on 23/02/18. */
public class BitfinexAccountFeesResponse {
  private final Map<Currency, Double> withdraw;

  public BitfinexAccountFeesResponse(@JsonProperty("withdraw") final Map<String, Double> withdraw) {
    this.withdraw =
        withdraw.entrySet().stream() // Sting needs to be adapted (i.e., DSH -> DASH)
            .collect(
                Collectors.toMap(
                    entry -> new Currency(BitfinexAdapters.adaptBitfinexCurrency(entry.getKey())),
                    entry -> entry.getValue()));
  }

  public Map<Currency, Double> getWithdraw() {
    return withdraw;
  }
}
