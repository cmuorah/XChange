package org.knowm.xchange.bibox.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.knowm.xchange.currency.Currency;

public class BiboxAsset {

  @JsonProperty("coin_symbol")
  @Getter
  private Currency coin_symbol;

  @JsonProperty("BTCValue")
  @Getter
  private Double BTCValue;

  @JsonProperty("CNYValue")
  @Getter
  private Double CNYValue;

  @JsonProperty("USDValue")
  @Getter
  private Double USDValue;

  @JsonProperty("balance")
  @Getter
  private Double balance;

  @JsonProperty("freeze")
  @Getter
  private Double freeze;
}
