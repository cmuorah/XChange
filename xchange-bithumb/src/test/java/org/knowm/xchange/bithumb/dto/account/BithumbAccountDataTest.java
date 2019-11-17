package org.knowm.xchange.bithumb.dto.account;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;
import org.knowm.xchange.bithumb.BithumbAdapters;

public class BithumbAccountDataTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  public void testUnmarshallBalance() throws IOException {

    final InputStream is =
        BithumbAccountDataTest.class.getResourceAsStream(
            "/org/knowm/xchange/bithumb/dto/account/example-balance.json");
    final BithumbBalance bithumbBalance = mapper.readValue(is, BithumbBalance.class);

    assertThat(bithumbBalance.getTotalKrw()).isEqualTo(Double.valueOf(1));
    assertThat(bithumbBalance.getInUseKrw()).isEqualTo(Double.valueOf(0));
    assertThat(bithumbBalance.getAvailableKrw()).isEqualTo(Double.valueOf(1));
  }

  @Test
  public void testUnmarshallOrder() throws IOException {

    final InputStream is =
        BithumbAccountDataTest.class.getResourceAsStream(
            "/org/knowm/xchange/bithumb/dto/account/example-order.json");
    final BithumbOrder bithumbOrder = mapper.readValue(is, BithumbOrder.class);

    assertThat(bithumbOrder.getOrderId()).isEqualTo(1546705688665840L);
    assertThat(bithumbOrder.getOrderDate()).isEqualTo(1546705688665840L);
    assertThat(bithumbOrder.getOrderCurrency()).isEqualTo("XRP");
    assertThat(bithumbOrder.getPaymentCurrency()).isEqualTo("KRW");
    assertThat(bithumbOrder.getType()).isEqualTo(BithumbAdapters.OrderType.ask);
    assertThat(bithumbOrder.getStatus()).isEqualTo("placed");
    assertThat(bithumbOrder.getUnits()).isEqualTo(Double.valueOf(1.0));
    assertThat(bithumbOrder.getUnitsRemaining()).isEqualTo(Double.valueOf(1.0));
    assertThat(bithumbOrder.getPrice()).isEqualTo(Double.valueOf(700));
    assertThat(bithumbOrder.getFee()).isNull();
    assertThat(bithumbOrder.getTotal()).isNull();
    assertThat(bithumbOrder.getDateCompleted()).isEqualTo(0L);
  }

  @Test
  public void testUnmarshallOrderDetail() throws IOException {

    final InputStream is =
        BithumbAccountDataTest.class.getResourceAsStream(
            "/org/knowm/xchange/bithumb/dto/account/example-order-detail.json");
    final BithumbOrderDetail bithumbOrderDetail = mapper.readValue(is, BithumbOrderDetail.class);

    assertThat(bithumbOrderDetail.getTransactionDate()).isEqualTo(1428024598967L);
    assertThat(bithumbOrderDetail.getType()).isEqualTo("ask");
    assertThat(bithumbOrderDetail.getOrderCurrency()).isEqualTo("BTC");
    assertThat(bithumbOrderDetail.getPaymentCurrency()).isEqualTo("KRW");
    assertThat(bithumbOrderDetail.getUnitsTraded()).isEqualTo(Double.valueOf(0.0017D));
    assertThat(bithumbOrderDetail.getPrice()).isEqualTo(Double.valueOf(264000L));
    assertThat(bithumbOrderDetail.getFee()).isEqualTo(Double.valueOf(0.0000017D));
    assertThat(bithumbOrderDetail.getTotal()).isEqualTo(Double.valueOf(449L));
  }

  @Test
  public void testUnmarshallTransaction() throws IOException {

    final InputStream is =
        BithumbAccountDataTest.class.getResourceAsStream(
            "/org/knowm/xchange/bithumb/dto/account/example-transaction.json");
    final BithumbTransaction bithumbTransaction = mapper.readValue(is, BithumbTransaction.class);

    assertThat(bithumbTransaction.getSearch()).isEqualTo("2");
    assertThat(bithumbTransaction.getTransferDate()).isEqualTo(1417138805912L);
    assertThat(bithumbTransaction.getUnits()).isEqualTo("- 0.1");
    assertThat(bithumbTransaction.getPrice()).isEqualTo(Double.valueOf(51600));
    assertThat(bithumbTransaction.getFee()).isEqualTo(Double.valueOf(0.24));
    assertThat(bithumbTransaction.getKrwRemain()).isEqualTo(Double.valueOf(305455680));
  }

  @Test
  public void testUnmarshallAccount() throws IOException {

    final InputStream is =
        BithumbAccountDataTest.class.getResourceAsStream(
            "/org/knowm/xchange/bithumb/dto/account/example-account.json");
    final BithumbAccount bithumbTransaction = mapper.readValue(is, BithumbAccount.class);

    assertThat(bithumbTransaction.getCreated()).isEqualTo(1489545326000L);
    assertThat(bithumbTransaction.getAccountId()).isEqualTo("ABCDE");
    assertThat(bithumbTransaction.getTradeFee()).isEqualTo(Double.valueOf(0.0015));
    assertThat(bithumbTransaction.getBalance()).isEqualTo(Double.valueOf(0.00001971));
  }

  @Test
  public void testUnmarshallWalletAddress() throws IOException {

    final InputStream is =
        BithumbAccountDataTest.class.getResourceAsStream(
            "/org/knowm/xchange/bithumb/dto/account/example-wallet-address.json");
    final BithumbWalletAddress bithumbWalletAddress =
        mapper.readValue(is, BithumbWalletAddress.class);

    assertThat(bithumbWalletAddress.getCurrency()).isEqualTo("BTC");
    assertThat(bithumbWalletAddress.getWalletAddress())
        .isEqualTo("1H7WL8Lb8mxCTwpL1RN8yckL2gcPLgqtqD");
  }
}
