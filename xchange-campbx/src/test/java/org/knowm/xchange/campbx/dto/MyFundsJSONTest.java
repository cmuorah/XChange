package org.knowm.xchange.campbx.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.Test;
import org.knowm.xchange.campbx.dto.account.MyFunds;

/** Test BitStamp Full Depth JSON parsing */
public class MyFundsJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    MyFunds myFunds =
        new ObjectMapper()
            .readValue(
                MyFundsJSONTest.class.getResourceAsStream(
                    "/org/knowm/xchange/campbx/account/myfunds.json"),
                MyFunds.class);

    // Verify that the example data was unmarshalled correctly
    assertThat(myFunds.getLiquidUSD()).isEqualTo(new Double("0.00"));
    assertThat(myFunds.getTotalBTC()).isEqualTo(new Double("0.10000000"));
  }
}
