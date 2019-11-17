package org.knowm.xchange.binance;

import org.junit.BeforeClass;
import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.ExchangeMetaData;

import static org.assertj.core.api.Assertions.assertThat;

public class ExchangeMetaDataIntegration {

    private static ExchangeMetaData metaData;

    @BeforeClass
    public static void fetchMetaData() throws Exception {
        Exchange binance = ExchangeFactory.INSTANCE.createExchange(BinanceExchange.class);
        metaData = binance.getExchangeMetaData();
    }

    @Test
    public void testEthBtcPairMetaData() {
        CurrencyPairMetaData pairMetaData = metaData.getCurrencyPairs().get(CurrencyPair.ETH_BTC);
        assertThat(pairMetaData.getPriceScale()).isEqualByComparingTo(8);
        assertThat(pairMetaData.getMinimumAmount()).isEqualByComparingTo(new Double("0.001"));
        assertThat(pairMetaData.getMaximumAmount()).isEqualByComparingTo(new Double("100000"));
        assertThat(pairMetaData.getAmountStepSize()).isEqualByComparingTo(new Double("0.001"));
    }

    @Test
    public void testGntBtcPairMetaData() {
        CurrencyPairMetaData pairMetaData =
                metaData.getCurrencyPairs().get(new CurrencyPair("GNT/BTC"));
        assertThat(pairMetaData.getPriceScale()).isEqualByComparingTo(8);
        assertThat(pairMetaData.getMinimumAmount()).isEqualByComparingTo(new Double("1"));
        assertThat(pairMetaData.getMaximumAmount()).isEqualByComparingTo(new Double("90000000"));
        assertThat(pairMetaData.getAmountStepSize()).isEqualByComparingTo(new Double("1"));
    }
}
