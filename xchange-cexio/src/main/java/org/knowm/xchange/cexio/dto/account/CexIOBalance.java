package org.knowm.xchange.cexio.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.MessageFormat;

/** Author: brox Since: 2/7/14 */
public class CexIOBalance {

  private final Double available;
  private final Double orders;
  private final Double bonus;

  /**
   * Constructor
   *
   * @param available Available balance
   * @param orders Balance in pending orders
   * @param bonus Referral program bonus
   */
  public CexIOBalance(
      @JsonProperty("available") Double available,
      @JsonProperty("orders") Double orders,
      @JsonProperty("bonus") Double bonus) {

    this.available = available;
    this.orders = orders;
    this.bonus = bonus;
  }

  public Double getAvailable() {

    return available;
  }

  public Double getOrders() {

    return orders;
  }

  public Double getBonus() {

    return bonus;
  }

  @Override
  public String toString() {

    return MessageFormat.format(
        "CexIOBalance[available={0}, orders={1}, bonus={2}]", available, orders, bonus);
  }
}
