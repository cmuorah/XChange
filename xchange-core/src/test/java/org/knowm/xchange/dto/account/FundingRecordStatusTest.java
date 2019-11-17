package org.knowm.xchange.dto.account;

import static org.assertj.core.api.Assertions.assertThat;
import static org.knowm.xchange.currency.Currency.BTC;
import static org.knowm.xchange.dto.account.FundingRecord.Type.DEPOSIT;

import org.junit.Test;

public class FundingRecordStatusTest {

  @Test
  public void shouldProcessStatusDescriptionNormal() throws Exception {
    testStatusDesc("PROCESSING", "foo", FundingRecord.Status.PROCESSING, "foo");
  }

  @Test
  public void shouldProcessStatusToUpercase() throws Exception {
    testStatusDesc("Complete", "bar", FundingRecord.Status.COMPLETE, "bar");
  }

  @Test
  public void shouldProcessNullDescription() throws Exception {
    testStatusDesc("COMPLETE", null, FundingRecord.Status.COMPLETE, null);
  }

  @Test
  public void shouldProcessStatusAsDescriptionWhenDescInputNull() throws Exception {
    testStatusDesc("Unknown", null, null, "Unknown");
  }

  @Test
  public void shouldPrependUnrecognizedStatusStringToDescription() throws Exception {
    testStatusDesc(
        "AdminCancelled",
        "The administrator has cancelled the transfers.",
        null,
        "AdminCancelled: The administrator has cancelled the transfers.");
  }

  private void testStatusDesc(
      String statusInput,
      String descriptionInput,
      FundingRecord.Status expectedStatus,
      String expectedDescription) {
    final FundingRecord fundingRecord =
        new FundingRecord(
            "", null, BTC, 1d, "", "", DEPOSIT, statusInput, 1d, 1d, descriptionInput);
    assertThat(fundingRecord.getStatus()).isEqualTo(expectedStatus);
    assertThat(fundingRecord.getDescription()).isEqualTo(expectedDescription);
  }
}
