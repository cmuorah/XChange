package org.knowm.xchange.bleutrade.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
  "MarketName",
  "PrevDay",
  "High",
  "Low",
  "Last",
  "Average",
  "Volume",
  "BaseVolume",
  "TimeStamp",
  "Bid",
  "Ask",
  "IsActive"
})
public class BleutradeTicker {

  @JsonProperty("MarketName")
  private String MarketName;

  @JsonProperty("PrevDay")
  private Double PrevDay;

  @JsonProperty("High")
  private Double High;

  @JsonProperty("Low")
  private Double Low;

  @JsonProperty("Last")
  private Double Last;

  @JsonProperty("Average")
  private Double Average;

  @JsonProperty("Volume")
  private Double Volume;

  @JsonProperty("BaseVolume")
  private Double BaseVolume;

  @JsonProperty("TimeStamp")
  private String TimeStamp;

  @JsonProperty("Bid")
  private Double Bid;

  @JsonProperty("Ask")
  private Double Ask;

  @JsonProperty("IsActive")
  private Boolean IsActive;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /** @return The MarketName */
  @JsonProperty("MarketName")
  public String getMarketName() {

    return MarketName;
  }

  /** @param MarketName The MarketName */
  @JsonProperty("MarketName")
  public void setMarketName(String MarketName) {

    this.MarketName = MarketName;
  }

  /** @return The PrevDay */
  @JsonProperty("PrevDay")
  public Double getPrevDay() {

    return PrevDay;
  }

  /** @param PrevDay The PrevDay */
  @JsonProperty("PrevDay")
  public void setPrevDay(Double PrevDay) {

    this.PrevDay = PrevDay;
  }

  /** @return The High */
  @JsonProperty("High")
  public Double getHigh() {

    return High;
  }

  /** @param High The High */
  @JsonProperty("High")
  public void setHigh(Double High) {

    this.High = High;
  }

  /** @return The Low */
  @JsonProperty("Low")
  public Double getLow() {

    return Low;
  }

  /** @param Low The Low */
  @JsonProperty("Low")
  public void setLow(Double Low) {

    this.Low = Low;
  }

  /** @return The Last */
  @JsonProperty("Last")
  public Double getLast() {

    return Last;
  }

  /** @param Last The Last */
  @JsonProperty("Last")
  public void setLast(Double Last) {

    this.Last = Last;
  }

  /** @return The Average */
  @JsonProperty("Average")
  public Double getAverage() {

    return Average;
  }

  /** @param Average The Average */
  @JsonProperty("Average")
  public void setAverage(Double Average) {

    this.Average = Average;
  }

  /** @return The Volume */
  @JsonProperty("Volume")
  public Double getVolume() {

    return Volume;
  }

  /** @param Volume The Volume */
  @JsonProperty("Volume")
  public void setVolume(Double Volume) {

    this.Volume = Volume;
  }

  /** @return The BaseVolume */
  @JsonProperty("BaseVolume")
  public Double getBaseVolume() {

    return BaseVolume;
  }

  /** @param BaseVolume The BaseVolume */
  @JsonProperty("BaseVolume")
  public void setBaseVolume(Double BaseVolume) {

    this.BaseVolume = BaseVolume;
  }

  /** @return The TimeStamp */
  @JsonProperty("TimeStamp")
  public String getTimeStamp() {

    return TimeStamp;
  }

  /** @param TimeStamp The TimeStamp */
  @JsonProperty("TimeStamp")
  public void setTimeStamp(String TimeStamp) {

    this.TimeStamp = TimeStamp;
  }

  /** @return The Bid */
  @JsonProperty("Bid")
  public Double getBid() {

    return Bid;
  }

  /** @param Bid The Bid */
  @JsonProperty("Bid")
  public void setBid(Double Bid) {

    this.Bid = Bid;
  }

  /** @return The Ask */
  @JsonProperty("Ask")
  public Double getAsk() {

    return Ask;
  }

  /** @param Ask The Ask */
  @JsonProperty("Ask")
  public void setAsk(Double Ask) {

    this.Ask = Ask;
  }

  /** @return The IsActive */
  @JsonProperty("IsActive")
  public Boolean getIsActive() {

    return IsActive;
  }

  /** @param IsActive The IsActive */
  @JsonProperty("IsActive")
  public void setIsActive(Boolean IsActive) {

    this.IsActive = IsActive;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {

    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {

    this.additionalProperties.put(name, value);
  }

  @Override
  public String toString() {

    return "BleutradeTicker [MarketName="
        + MarketName
        + ", PrevDay="
        + PrevDay
        + ", High="
        + High
        + ", Low="
        + Low
        + ", Last="
        + Last
        + ", Average="
        + Average
        + ", Volume="
        + Volume
        + ", BaseVolume="
        + BaseVolume
        + ", TimeStamp="
        + TimeStamp
        + ", Bid="
        + Bid
        + ", Ask="
        + Ask
        + ", IsActive="
        + IsActive
        + ", additionalProperties="
        + additionalProperties
        + "]";
  }
}
