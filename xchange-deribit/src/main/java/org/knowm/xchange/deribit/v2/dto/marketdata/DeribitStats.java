package org.knowm.xchange.deribit.v2.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DeribitStats {

  /** volume during last 24h in base currency */
  @JsonProperty("volume")
  private Double volume;

  /** lowest price during 24h */
  @JsonProperty("low")
  private Double low;

  /** highest price during 24h */
  @JsonProperty("high")
  private Double high;
}
