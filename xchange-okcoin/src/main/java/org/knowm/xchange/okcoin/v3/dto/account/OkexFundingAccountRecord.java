package org.knowm.xchange.okcoin.v3.dto.account;

import lombok.Data;

@Data
public class OkexFundingAccountRecord {
  private Double balance;
  private Double available;
  private String currency;
  private Double hold;
}
