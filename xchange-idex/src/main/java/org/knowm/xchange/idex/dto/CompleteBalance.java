package org.knowm.xchange.idex.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.knowm.xchange.idex.annotations.ApiModelProperty;

public class CompleteBalance {

  private Double available;
  private Double onOrders;

  /** */
  public CompleteBalance available(Double available) {
    this.available = available;
    return this;
  }

  @ApiModelProperty("")
  @JsonProperty("available")
  public Double getAvailable() {
    return available;
  }

  public void setAvailable(Double available) {
    this.available = available;
  }

  /** */
  public CompleteBalance onOrders(Double onOrders) {
    this.onOrders = onOrders;
    return this;
  }

  @ApiModelProperty("")
  @JsonProperty("onOrders")
  public Double getOnOrders() {
    return onOrders;
  }

  public void setOnOrders(Double onOrders) {
    this.onOrders = onOrders;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompleteBalance completeBalance = (CompleteBalance) o;
    return Objects.equals(available, completeBalance.available)
        && Objects.equals(onOrders, completeBalance.onOrders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(available, onOrders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompleteBalance {\n");

    sb.append("    available: ").append(toIndentedString(available)).append("\n");
    sb.append("    onOrders: ").append(toIndentedString(onOrders)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
