package org.knowm.xchange.exmo.dto.trade;

import java.util.List;
import org.knowm.xchange.dto.trade.UserTrade;

public class ExmoUserTrades {
  private final Double originalAmount;
  private final List<UserTrade> userTrades;

  public ExmoUserTrades(Double originalAmount, List<UserTrade> userTrades) {
    this.originalAmount = originalAmount;
    this.userTrades = userTrades;
  }

  public Double getOriginalAmount() {
    return originalAmount;
  }

  public List<UserTrade> getUserTrades() {
    return userTrades;
  }
}
