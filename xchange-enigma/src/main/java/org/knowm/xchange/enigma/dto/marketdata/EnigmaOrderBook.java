package org.knowm.xchange.enigma.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.knowm.xchange.enigma.dto.BaseResponse;

@Setter
@Getter
public class EnigmaOrderBook extends BaseResponse {

  @JsonProperty("timestamp")
  private Date timestamp;

  @JsonProperty("bids")
  private List<List<Double>> bids;

  @JsonProperty("asks")
  private List<List<Double>> asks;
}
