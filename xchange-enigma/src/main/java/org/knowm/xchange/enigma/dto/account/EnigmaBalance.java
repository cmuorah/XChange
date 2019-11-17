package org.knowm.xchange.enigma.dto.account;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EnigmaBalance {

  private Map<String, Double> balances;
}
