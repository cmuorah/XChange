package org.knowm.xchange.deribit.v2.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DeribitGreeks {

  /** The vega value for the option */
  @JsonProperty("vega")
  private Double vega;

  /** The theta value for the option */
  @JsonProperty("theta")
  private Double theta;

  /** The rho value for the option */
  @JsonProperty("rho")
  private Double rho;

  /** The gamma value for the option */
  @JsonProperty("gamma")
  private Double gamma;

  /** The delta value for the option */
  @JsonProperty("delta")
  private Double delta;
}
