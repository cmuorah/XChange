package org.knowm.xchange.blockchain;

/** A central place for shared Blockchain Utils */
public final class BlockchainUtils {

  private static final int AMOUNT_INT_2_DECIMAL_FACTOR = 100000000;

  /** private Constructor */
  private BlockchainUtils() {}

  /**
   * Converts long amount into a BigMoney amount
   *
   * @param price
   * @return
   */
  public static Double getAmount(long price) {
    return (double) price / ((double) BlockchainUtils.AMOUNT_INT_2_DECIMAL_FACTOR);
  }
}
