package org.knowm.xchange.ripple.dto.account.trade;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ripple.RippleExchange;
import org.knowm.xchange.ripple.service.RippleTradeService;

public class RippleTransactioFeeIntegration {

  @Test
  public void getTransactionFeeTest() {
    final Exchange exchange =
        ExchangeFactory.INSTANCE.createExchange(RippleExchange.class.getName());
    final RippleTradeService tradeService = (RippleTradeService) exchange.getTradeService();

    final Double transactionFee = tradeService.getTransactionFee();
    assertThat(transactionFee).isGreaterThan(0d);

    System.out.println(
        String.format("Ripple network transaction fee is currently %s XRP", transactionFee));
  }
}
