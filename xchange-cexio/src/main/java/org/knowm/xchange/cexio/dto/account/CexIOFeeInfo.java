package org.knowm.xchange.cexio.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Map;
import org.knowm.xchange.cexio.dto.CexIOApiResponse;
import org.knowm.xchange.currency.CurrencyPair;

/** @author ujjwal on 14/02/18. */
public class CexIOFeeInfo extends CexIOApiResponse<Map<CurrencyPair, CexIOFeeInfo.FeeDetails>> {

  public CexIOFeeInfo(
      @JsonProperty("e") String e,
      @JsonProperty("data") @JsonDeserialize(keyUsing = CurrencyPairKeyDeserializer.class)
          Map<CurrencyPair, FeeDetails> data,
      @JsonProperty("ok") String ok,
      @JsonProperty("error") String error) {
    super(e, data, ok, error);
  }

  public static class CurrencyPairKeyDeserializer extends KeyDeserializer {
    @Override
    public CurrencyPair deserializeKey(
        String value, DeserializationContext deserializationContext) {
      String[] currencies = value.split(":");
      return new CurrencyPair(currencies[0], currencies[1]);
    }
  }

  public static class FeeDetails {
    private final Double sell;
    private final Double sellMaker;
    private final Double buy;
    private final Double buyMaker;

    public FeeDetails(
        @JsonProperty("sell") Double sell,
        @JsonProperty("sellMaker") Double sellMaker,
        @JsonProperty("buy") Double buy,
        @JsonProperty("buyMaker") Double buyMaker) {
      this.sell = sell;
      this.sellMaker = sellMaker;
      this.buy = buy;
      this.buyMaker = buyMaker;
    }

    public Double getSell() {
      return sell;
    }

    public Double getSellMaker() {
      return sellMaker;
    }

    public Double getBuy() {
      return buy;
    }

    public Double getBuyMaker() {
      return buyMaker;
    }
  }
}
