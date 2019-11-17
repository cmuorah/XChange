package org.knowm.xchange.bithumb.dto.account;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class BithumbBalance {

  private static final String PREFIX_TOTAL = "total_";
  private static final String PREFIX_FROZEN = "in_use_";
  private static final String PREFIX_AVAILABLE = "available_";

  private final Double totalKrw;
  private final Double inUseKrw;
  private final Double availableKrw;
  private final Map<String, String> additionalProperties = new HashMap<>();

  public BithumbBalance(
      @JsonProperty("total_krw") Double totalKrw,
      @JsonProperty("in_use_krw") Double inUseKrw,
      @JsonProperty("available_krw") Double availableKrw) {
    this.totalKrw = totalKrw;
    this.inUseKrw = inUseKrw;
    this.availableKrw = availableKrw;
  }

  public Double getTotalKrw() {
    return totalKrw;
  }

  public Double getInUseKrw() {
    return inUseKrw;
  }

  public Double getAvailableKrw() {
    return availableKrw;
  }

  public Map<String, String> getAdditionalProperties() {
    return additionalProperties;
  }

  public Set<String> getCurrencies() {
    return additionalProperties.keySet().stream()
        .filter(key -> key.startsWith(PREFIX_TOTAL))
        .map(key -> StringUtils.remove(key, PREFIX_TOTAL))
        .collect(Collectors.toSet());
  }

  public Double getAvailable(String currency) {
    return Optional.ofNullable(additionalProperties.get(PREFIX_AVAILABLE + currency))
        .map(Double::new)
        .orElse(0d);
  }

  public Double getFrozen(String currency) {
    return Optional.ofNullable(additionalProperties.get(PREFIX_FROZEN + currency))
        .map(Double::new)
        .orElse(0d);
  }

  public Double getTotal(String currency) {
    return Optional.ofNullable(additionalProperties.get(PREFIX_TOTAL + currency))
        .map(Double::new)
        .orElse(0d);
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, String value) {
    this.additionalProperties.put(name, value);
  }

  @Override
  public String toString() {
    return "BithumbBalance{"
        + "totalKrw="
        + totalKrw
        + ", inUseKrw="
        + inUseKrw
        + ", availableKrw="
        + availableKrw
        + ", additionalProperties="
        + additionalProperties
        + '}';
  }
}
