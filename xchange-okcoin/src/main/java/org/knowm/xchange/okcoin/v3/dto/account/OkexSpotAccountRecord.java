package org.knowm.xchange.okcoin.v3.dto.account;

import lombok.Data;

@Data
public class OkexSpotAccountRecord {
  private Double frozen;
  /** amount on hold(not available) */
  private Double hold;
  /** account ID */
  private String id;

  private String currency;
  private Double balance;
  /** available amount */
  private Double available;

  private Double holds;
}
