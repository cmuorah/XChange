package org.knowm.xchange.cryptofacilities.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import java.util.Date;
import org.knowm.xchange.cryptofacilities.Util;
import org.knowm.xchange.cryptofacilities.dto.CryptoFacilitiesResult;

/** @author Neil Panchen */
public class CryptoFacilitiesInstrument extends CryptoFacilitiesResult {

  private final boolean tradeable;
  private final Date lastTradingTime;
  private final String symbol;
  private final String underlying;
  private final Double contractSize;
  private final String type;
  private final Double tickSize;

  public CryptoFacilitiesInstrument(
      @JsonProperty("result") String result,
      @JsonProperty("error") String error,
      @JsonProperty("tradeable") String strTradeable,
      @JsonProperty("lastTradingTime") String strLastTradingTime,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("underlying") String underlying,
      @JsonProperty("contractSize") Double contractSize,
      @JsonProperty("type") String type,
      @JsonProperty("tickSize") Double tickSize)
      throws ParseException {

    super(result, error);

    this.tradeable = strTradeable.equalsIgnoreCase("true");
    this.lastTradingTime = Util.parseDate(strLastTradingTime);
    this.symbol = symbol;
    this.underlying = underlying;
    this.contractSize = contractSize;
    this.type = type;
    this.tickSize = tickSize;
  }

  public Boolean getTradeable() {
    return tradeable;
  }

  public Date getLastTradingTime() {
    return lastTradingTime;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getUnderlying() {
    return underlying;
  }

  public Double getContractSize() {
    return contractSize;
  }

  public String getType() {
    return type;
  }

  public Double getTickSize() {
    return tickSize;
  }

  @Override
  public String toString() {
    return "CryptoFacilitiesInstrument [tradeable="
        + tradeable
        + ", lastTradingTime="
        + lastTradingTime
        + ", symbol="
        + symbol
        + ", underlying="
        + underlying
        + ", contractSize="
        + contractSize
        + ", type="
        + type
        + ", tickSize="
        + tickSize
        + " ]";
  }
}
