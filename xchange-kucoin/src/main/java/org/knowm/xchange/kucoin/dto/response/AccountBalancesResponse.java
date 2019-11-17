/** Copyright 2019 Mek Global Limited. */
package org.knowm.xchange.kucoin.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/** Created by tao.mao on 2018/11/15. */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountBalancesResponse {

  private String id;

  private String currency;

  private String type;

  private Double balance;

  private Double available;

  private Double holds;
}
