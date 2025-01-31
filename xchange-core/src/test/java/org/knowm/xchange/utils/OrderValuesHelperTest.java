package org.knowm.xchange.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.math.RoundingMode;
import org.junit.Before;
import org.junit.Test;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;

public class OrderValuesHelperTest {

  private CurrencyPairMetaData pairMetaData;
  private OrderValuesHelper adjuster;

  @Before
  public void setup() {
    pairMetaData = mock(CurrencyPairMetaData.class);
    adjuster = new OrderValuesHelper(pairMetaData);
  }

  @Test
  public void shouldAdjustAmountToStepSize() {
    // given
    given(pairMetaData.getAmountStepSize()).willReturn(new Double("0.001"));
    given(pairMetaData.getBaseScale()).willReturn(null);

    // when
    Double result = adjuster.adjustAmount(new Double("0.93851732"));

    // then
    assertThat(result).isEqualByComparingTo(0.939);
  }

  @Test
  public void shouldAdjustAmountToScale() {
    // given
    given(pairMetaData.getAmountStepSize()).willReturn(null);
    given(pairMetaData.getBaseScale()).willReturn(5);

    // when
    Double result = adjuster.adjustAmount(new Double("10.123456789"));

    // then
    assertThat(result).isEqualByComparingTo(new Double("10.12346"));
  }

  @Test
  public void shouldAdjustAmountToMaximal() {
    // given
    Double minimal = new Double("100");
    given(pairMetaData.getMaximumAmount()).willReturn(minimal);
    given(pairMetaData.getBaseScale()).willReturn(null);

    // when
    Double result = adjuster.adjustAmount(new Double("128.32432"));

    // then
    assertThat(result).isEqualByComparingTo(minimal);
  }

  @Test
  public void shouldAdjustPriceToScale() {
    // given
    given(pairMetaData.getPriceScale()).willReturn(2);

    // when
    Double result = adjuster.adjustPrice(new Double("36010.123456789"), RoundingMode.FLOOR);

    // then
    assertThat(result).isEqualByComparingTo(new Double("36010.12"));
  }
}
