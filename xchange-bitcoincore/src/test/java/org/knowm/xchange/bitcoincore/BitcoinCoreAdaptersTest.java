package org.knowm.xchange.bitcoincore;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;
import org.knowm.xchange.bitcoincore.dto.account.BitcoinCoreBalanceResponse;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Balance;

public class BitcoinCoreAdaptersTest {

  @Test
  public void adaptAccountInfoTest() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();

    // available balance
    InputStream getBalance = getClass().getResourceAsStream("/account/example-getbalance.json");
    BitcoinCoreBalanceResponse available =
        mapper.readValue(getBalance, BitcoinCoreBalanceResponse.class);

    // unconfirmed balance
    InputStream getUnconfirmedBalance =
        getClass().getResourceAsStream("/account/example-getunconfirmedbalance.json");
    BitcoinCoreBalanceResponse unconfirmed =
        mapper.readValue(getUnconfirmedBalance, BitcoinCoreBalanceResponse.class);

    AccountInfo account = BitcoinCoreAdapters.adaptAccountInfo(available, unconfirmed);
    Balance btc = account.getWallet().getBalance(Currency.BTC);

    assertThat(btc.getAvailable()).isEqualTo(new Double("68480.47579046"));
    assertThat(btc.getFrozen()).isEqualTo(new Double("10.00000001"));
    assertThat(btc.getTotal()).isEqualTo(new Double("68490.47579047"));
  }
}
