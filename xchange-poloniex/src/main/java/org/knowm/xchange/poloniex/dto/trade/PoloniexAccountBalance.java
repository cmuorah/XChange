package org.knowm.xchange.poloniex.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.Map;

public class PoloniexAccountBalance {

  private final Map<String, Double> exchange;
  private final Map<String, Double> margin;
  private final Map<String, Double> lending;

  public PoloniexAccountBalance(
      @JsonProperty("exchange") Map<String, Double> exchange,
      @JsonProperty("margin") Map<String, Double> margin,
      @JsonProperty("lending") Map<String, Double> lending) {
    this.exchange = exchange;
    this.margin = margin;
    this.lending = lending;
  }

  public Map<String, Double> getExchangeBalance() {
    return exchange != null ? Collections.unmodifiableMap(exchange) : Collections.emptyMap();
  }

  public Map<String, Double> getMarginBalance() {
    return margin != null ? Collections.unmodifiableMap(margin) : Collections.emptyMap();
  }

  public Map<String, Double> getLendingBalance() {
    return lending != null ? Collections.unmodifiableMap(lending) : Collections.emptyMap();
  }

  @Override
  public String toString() {
    return "PoloniexAvailableAccountBalance{"
        + "exchange="
        + exchange
        + ", margin="
        + margin
        + ", lending="
        + lending
        + '}';
  }

  public enum ACCOUNT {
    EXCHANGE("exchange"),
    MARGIN("margin"),
    LENDING("lending");

    private String name;

    ACCOUNT(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return name;
    }
  }
}
