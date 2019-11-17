package org.knowm.xchange.wex.v3.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.MessageFormat;
import java.util.Map;

/** @author Ondřej Novotný */
public class WexWithdrawInfo {

  private final Map<String, Double> funds;
  private final int tId;

  private final Double amountSent;

  /**
   * Constructor
   *
   * @param tId
   * @param amountSent
   * @param funds The funds
   */
  public WexWithdrawInfo(
      @JsonProperty("tId") int tId,
      @JsonProperty("amountSent") Double amountSent,
      @JsonProperty("funds") Map<String, Double> funds) {
    this.funds = funds;
    this.tId = tId;
    this.amountSent = amountSent;
  }

  public int gettId() {
    return tId;
  }

  public Double getAmountSent() {
    return amountSent;
  }

  public Map<String, Double> getFunds() {

    return funds;
  }

  @Override
  public String toString() {

    return MessageFormat.format(
        "WexAccountInfo[tId={0}, amountSent={1}, funds=''{2}''']", tId, amountSent, funds);
  }
}
