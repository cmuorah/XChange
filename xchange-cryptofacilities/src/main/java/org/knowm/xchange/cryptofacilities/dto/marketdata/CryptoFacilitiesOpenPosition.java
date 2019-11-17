package org.knowm.xchange.cryptofacilities.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import java.util.Date;
import org.knowm.xchange.cryptofacilities.Util;
import org.knowm.xchange.cryptofacilities.dto.CryptoFacilitiesResult;

/** @author Panchen */
public class CryptoFacilitiesOpenPosition extends CryptoFacilitiesResult {

  private final Date fillTime;
  private final String symbol;
  private final String side;
  private final Double size;
  private final Double price;

  public CryptoFacilitiesOpenPosition(
      @JsonProperty("result") String result,
      @JsonProperty("error") String error,
      @JsonProperty("fillTime") String strfillTime,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("side") String side,
      @JsonProperty("size") Double size,
      @JsonProperty("price") Double price)
      throws ParseException {

    super(result, error);

    this.fillTime = Util.parseDate(strfillTime);
    this.symbol = symbol;
    this.side = side;
    this.size = size;
    this.price = price;
  }

  public String getSymbol() {
    return symbol;
  }

  public Date getFillTime() {
    return fillTime;
  }

  public String getSide() {
    return side;
  }

  public Double getSize() {
    return size;
  }

  public Double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "CryptoFacilitiesOpenPosition [fillTime="
        + fillTime
        + ", symbol="
        + symbol
        + ", side="
        + side
        + ", size="
        + size
        + ", price="
        + price
        + " ]";
  }
}
