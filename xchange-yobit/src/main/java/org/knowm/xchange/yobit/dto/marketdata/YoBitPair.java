package org.knowm.xchange.yobit.dto.marketdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;
import org.knowm.xchange.yobit.dto.marketdata.YoBitPair.YoBitPairDeserializer;

@JsonDeserialize(using = YoBitPairDeserializer.class)
public class YoBitPair {
  private Integer decimal_places;
  private Double min_price;
  private Double max_price;
  private Double min_amount;
  private Double min_total;
  private Integer hidden;
  private Double fee;
  private Double fee_buyer;
  private Double fee_seller;

  public YoBitPair(
      Integer decimal_places,
      Double min_price,
      Double max_price,
      Double min_amount,
      Double min_total,
      Integer hidden,
      Double fee,
      Double fee_buyer,
      Double fee_seller) {
    super();
    this.decimal_places = decimal_places;
    this.min_price = min_price;
    this.max_price = max_price;
    this.min_amount = min_amount;
    this.min_total = min_total;
    this.hidden = hidden;
    this.fee = fee;
    this.fee_buyer = fee_buyer;
    this.fee_seller = fee_seller;
  }

  public Integer getDecimal_places() {
    return decimal_places;
  }

  public Double getMin_price() {
    return min_price;
  }

  public Double getMax_price() {
    return max_price;
  }

  public Double getMin_amount() {
    return min_amount;
  }

  public Double getMin_total() {
    return min_total;
  }

  public Integer getHidden() {
    return hidden;
  }

  public Double getFee() {
    return fee;
  }

  public Double getFee_buyer() {
    return fee_buyer;
  }

  public Double getFee_seller() {
    return fee_seller;
  }

  @Override
  public String toString() {
    return "YoBitPair [decimal_places="
        + decimal_places
        + ", min_price="
        + min_price
        + ", max_price="
        + max_price
        + ", min_amount="
        + min_amount
        + ", min_total="
        + min_total
        + ", hidden="
        + hidden
        + ", fee="
        + fee
        + ", fee_buyer="
        + fee_buyer
        + ", fee_seller="
        + fee_seller
        + "]";
  }

  static class YoBitPairDeserializer extends JsonDeserializer<YoBitPair> {

    private static Double getNumberIfPresent(JsonNode numberNode) {

      final String numberString = numberNode.asText();
      return numberString.isEmpty() ? null : new Double(numberString);
    }

    public static YoBitPair deserializeFromNode(JsonNode tickerNode) {

      final Integer decimal_places = tickerNode.path("decimal_places").asInt();
      final Double min_price = getNumberIfPresent(tickerNode.path("min_price"));
      final Double max_price = getNumberIfPresent(tickerNode.path("max_price"));
      final Double min_amount = getNumberIfPresent(tickerNode.path("min_amount"));
      final Double min_total = getNumberIfPresent(tickerNode.path("min_total"));
      final Integer hidden = tickerNode.path("hidden").asInt();
      final Double fee = getNumberIfPresent(tickerNode.path("fee"));
      final Double fee_buyer = getNumberIfPresent(tickerNode.path("fee_buyer"));
      final Double fee_seller = getNumberIfPresent(tickerNode.path("fee_seller"));

      return new YoBitPair(
          decimal_places,
          min_price,
          max_price,
          min_amount,
          min_total,
          hidden,
          fee,
          fee_buyer,
          fee_seller);
    }

    @Override
    public YoBitPair deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {

      final ObjectCodec oc = jp.getCodec();
      final JsonNode tickerNode = oc.readTree(jp);

      return deserializeFromNode(tickerNode);
    }
  }
}
