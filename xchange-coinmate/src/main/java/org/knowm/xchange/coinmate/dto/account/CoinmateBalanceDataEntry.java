/*
 * The MIT License
 *
 * Copyright 2015 Coinmate.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.knowm.xchange.coinmate.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author Martin Stachon */
public class CoinmateBalanceDataEntry {

  private final String currency;
  private final Double balance;
  private final Double reserved;
  private final Double available;

  public CoinmateBalanceDataEntry(
      @JsonProperty("currency") String currency,
      @JsonProperty("balance") Double balance,
      @JsonProperty("reserved") Double reserved,
      @JsonProperty("available") Double available) {

    this.currency = currency;
    this.balance = balance;
    this.reserved = reserved;
    this.available = available;
  }

  /** @return the currency */
  public String getCurrency() {
    return currency;
  }

  /** @return the balance */
  public Double getBalance() {
    return balance;
  }

  /** @return the reserved */
  public Double getReserved() {
    return reserved;
  }

  /** @return the available */
  public Double getAvailable() {
    return available;
  }
}
