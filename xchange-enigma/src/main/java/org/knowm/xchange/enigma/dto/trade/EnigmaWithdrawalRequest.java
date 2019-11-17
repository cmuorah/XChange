package org.knowm.xchange.enigma.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnigmaWithdrawalRequest {

  @JsonProperty("withdrawal_type_id")
  private int withdrawalTypeId;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("infra")
  private String infra;
}
