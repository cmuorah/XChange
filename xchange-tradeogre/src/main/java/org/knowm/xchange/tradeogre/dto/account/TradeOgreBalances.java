package org.knowm.xchange.tradeogre.dto.account;


import java.util.Map;
import lombok.Data;

@Data
public class TradeOgreBalances {
  private Map<String, Double> balances;
}
