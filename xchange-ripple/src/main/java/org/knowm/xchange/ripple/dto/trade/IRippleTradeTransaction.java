package org.knowm.xchange.ripple.dto.trade;

import java.util.Date;
import java.util.List;
import org.knowm.xchange.ripple.dto.RippleAmount;

public interface IRippleTradeTransaction {
  List<RippleAmount> getBalanceChanges();

  Double getFee();

  long getOrderId();

  String getHash();

  Date getTimestamp();
}
