package org.knowm.xchange.therock.dto.marketdata;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.Date;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.utils.jackson.CurrencyPairDeserializer;

/** @author Matija Mazi */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TheRockTicker {

  @JsonDeserialize(using = CurrencyPairDeserializer.class)
  private CurrencyPair fundId;

  private Date date;

  private Double bid, ask, last, volume, volumeTraded, open, high, low, close;

  public CurrencyPair getFundId() {
    return fundId;
  }

  public Date getDate() {
    return date;
  }

  public Double getBid() {
    return bid;
  }

  public Double getAsk() {
    return ask;
  }

  public Double getLast() {
    return last;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getVolumeTraded() {
    return volumeTraded;
  }

  public Double getOpen() {
    return open;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLow() {
    return low;
  }

  public Double getClose() {
    return close;
  }

  @Override
  public String toString() {
    return String.format(
        "TheRockTicker{currencyPair=%s, date=%s, bid=%s, ask=%s, last=%s, volume=%s, volumeTraed=%s, open=%s, high=%s, low=%s, close=%s}",
        fundId, date, bid, ask, last, volume, volumeTraded, open, high, low, close);
  }
}
