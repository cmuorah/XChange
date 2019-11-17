package org.knowm.xchange.bitfinex.v1.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties({"maker_fees", "taker_fees"})
public class BitfinexTradingFeeResponse {
    private final BitfinexTradingFeeResponseRow[] tradingFeeResponseRows;

    /**
     * Constructor
     *
     * @param type
     * @param currency
     * @param amount
     * @param available
     */
    public BitfinexTradingFeeResponse(
            @JsonProperty("fees") BitfinexTradingFeeResponseRow[] tradingFeeResponseRows) {
        this.tradingFeeResponseRows = tradingFeeResponseRows;
    }

    public BitfinexTradingFeeResponseRow[] getTradingFees() {
        return tradingFeeResponseRows;
    }

    @Override
    public String toString() {
        return "BitfinexTradingFeeResponseRow [tradingFeeResponseRows="
                + Arrays.toString(tradingFeeResponseRows)
                + "]";
    }

    public static class BitfinexTradingFeeResponseRow {
        private final String currency;
        private final Double makerFee;
        private final Double takerFee;

        public BitfinexTradingFeeResponseRow(
                @JsonProperty("pairs") String pairs,
                @JsonProperty("maker_fees") Double makerFees,
                @JsonProperty("taker_fees") Double takerFees) {
            this.currency = pairs;
            this.makerFee = makerFees;
            this.takerFee = takerFees;
        }

        public String getCurrency() {
            return currency;
        }

        public Double getMakerFee() {
            return makerFee;
        }

        public Double getTakerFee() {
            return takerFee;
        }
    }
}
