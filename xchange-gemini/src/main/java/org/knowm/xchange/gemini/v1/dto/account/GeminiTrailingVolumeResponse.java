package org.knowm.xchange.gemini.v1.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;
import java.util.Date;

public class GeminiTrailingVolumeResponse {
  @JsonProperty("web_maker_fee_bps")
  public Double webMakerFeeBps;

  @JsonProperty("web_taker_fee_bps")
  public Double webTakerFeeBps;

  @JsonProperty("web_auction_fee_bps")
  public Double webAuctionFeeBps;

  @JsonProperty("api_maker_fee_bps")
  public Double apiMakerFeeBPS;

  @JsonProperty("api_taker_fee_bps")
  public Double apiTakerFeeBPS;

  @JsonProperty("api_auction_fee_bps")
  public Double apiAuctionFeeBPS;

  @JsonProperty("fix_maker_fee_bps")
  public Double fixMakerFeeBps;

  @JsonProperty("fix_taker_fee_bps")
  public Double fixTakerFeeBps;

  @JsonProperty("fix_auction_fee_bps")
  public Double fixAuctionFeeBps;

  @JsonProperty("block_maker_fee_bps")
  public Double blockMakerFeeBps;

  @JsonProperty("block_taker_fee_bps")
  public Double blockTakerFeeBps;

  @JsonProperty("notional_30d_volume")
  public Double Notional30DayVolume;

  @JsonProperty("last_updated_ms")
  public BigInteger LastUpdatedMS;

  @JsonProperty("account_id")
  public long AccountID;

  @JsonProperty("date")
  public Date Date;

  public static class NotionalOneDayVolume {
    @JsonProperty("date")
    public Date Date;

    @JsonProperty("notional_volume")
    public Double NotionalVolume;
  }

  @JsonProperty("notional_1d_volume")
  public NotionalOneDayVolume[] VolumesPerDay;
}
