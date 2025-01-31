package org.knowm.xchange.bitz.dto.marketdata.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import org.knowm.xchange.bitz.dto.BitZResult;
import org.knowm.xchange.currency.Currency;

public class BitZCurrencyCoinRateResult extends BitZResult<Map<Currency, Map<Currency, Double>>> {
  public BitZCurrencyCoinRateResult(
      @JsonProperty("status") int status,
      @JsonProperty("msg") String message,
      @JsonProperty("data") Map<Currency, Map<Currency, Double>> data,
      @JsonProperty("time") String time,
      @JsonProperty("microtime") String microtime,
      @JsonProperty("source") String source) {
    super(status, message, data);
  }
}
