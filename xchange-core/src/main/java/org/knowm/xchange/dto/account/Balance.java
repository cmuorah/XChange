package org.knowm.xchange.dto.account;

import java.io.Serializable;

import net.openhft.chronicle.wire.AbstractMarshallable;
import org.knowm.xchange.currency.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DTO representing a balance in a currency
 *
 * <p>This is simply defined by an amount of money in a given currency, contained in the cash
 * object.
 *
 * <p>This class is immutable.
 */
public final class Balance extends AbstractMarshallable implements Comparable<Balance>, Serializable {

  private static final long serialVersionUID = -1460694403597268635L;
  private static final Logger LOG = LoggerFactory.getLogger(Balance.class);

  private final Currency currency;

  // Invariant:
  // total = available + frozen - borrowed + loaned + withdrawing + depositing;
  private final Double total;
  private final Double available;
  private final Double frozen;
  private final Double loaned;
  private final Double borrowed;
  private final Double withdrawing;
  private final Double depositing;

  /**
   * Constructs a balance, the {@link #available} will be the same as the <code>total</code>, and
   * the {@link #frozen} is zero. The <code>borrowed</code> and <code>loaned</code> will be zero.
   *
   * @param currency The underlying currency
   * @param total The total
   */
  public Balance(Currency currency, Double total) {

    this(currency, total, total, 0d, 0d, 0d, 0d, 0d);
  }

  /**
   * Constructs a balance, the {@link #frozen} will be assigned as <code>total</code> - <code>
   * available</code>. The <code>borrowed</code> and <code>loaned</code> will be zero.
   *
   * @param currency the underlying currency of this balance.
   * @param total the total amount of the <code>currency</code> in this balance.
   * @param available the amount of the <code>currency</code> in this balance that is available to
   *     trade.
   */
  public Balance(Currency currency, Double total, Double available) {
    this(currency, total, available, total - available, 0d, 0d, 0d, 0d);
  }

  /**
   * Constructs a balance. The <code>borrowed</code> and <code>loaned</code> will be zero.
   *
   * @param currency the underlying currency of this balance.
   * @param total the total amount of the <code>currency</code> in this balance, including the
   *     <code>available</code> and <code>frozen</code>.
   * @param available the amount of the <code>currency</code> in this balance that is available to
   *     trade.
   * @param frozen the frozen amount of the <code>currency</code> in this balance that is locked in
   *     trading.
   */
  public Balance(Currency currency, Double total, Double available, Double frozen) {
    this(currency, total, available, frozen, 0d, 0d, 0d, 0d);
  }

  /**
   * Constructs a balance.
   *
   * @param currency the underlying currency of this balance.
   * @param total the total amount of the <code>currency</code> in this balance, equal to <code>
   *                    available + frozen - borrowed + loaned</code>.
   * @param available the amount of the <code>currency</code> in this balance that is available to
   *     trade, including the <code>borrowed</code>.
   * @param frozen the frozen amount of the <code>currency</code> in this balance that is locked in
   *     trading.
   * @param borrowed the borrowed amount of the available <code>currency</code> in this balance that
   *     must be repaid.
   * @param loaned the loaned amount of the total <code>currency</code> in this balance that will be
   *     returned.
   * @param withdrawing the amount of the <code>currency</code> in this balance that is scheduled
   *     for withdrawal.
   * @param depositing the amount of the <code>currency</code> in this balance that is being
   *     deposited but not available yet.
   */
  public Balance(
      Currency currency,
      Double total,
      Double available,
      Double frozen,
      Double borrowed,
      Double loaned,
      Double withdrawing,
      Double depositing) {
    if (total != null && available != null) {
      Double sum = (available + frozen) - (borrowed) + (loaned) + (withdrawing) + (depositing);
      if (0 != total.compareTo(sum)) {
        LOG.warn(
            "{} = total != available + frozen - borrowed + loaned + withdrawing + depositing = {}",
            total,
            sum);
      }
    }
    this.currency = currency;
    this.total = total;
    this.available = available;
    this.frozen = frozen;
    this.borrowed = borrowed;
    this.loaned = loaned;
    this.withdrawing = withdrawing;
    this.depositing = depositing;
  }

  /**
   * Returns a zero balance.
   *
   * @param currency the balance currency.
   * @return a zero balance.
   */
  public static Balance zero(Currency currency) {

    return new Balance(currency, 0d, 0d, 0d, 0d, 0d, 0d, 0d);
  }

  public Currency getCurrency() {

    return currency;
  }

  /**
   * Returns the total amount of the <code>currency</code> in this balance.
   *
   * @return the total amount.
   */
  public Double getTotal() {
    if (total == null) {
      return available + (frozen) - (borrowed) + (loaned) + (withdrawing) - (depositing);
    } else {
      return total;
    }
  }

  /**
   * Returns the amount of the <code>currency</code> in this balance that is available to trade.
   *
   * @return the amount that is available to trade.
   */
  public Double getAvailable() {
    if (available == null) {
      return total - (frozen) - (loaned) + (borrowed) - (withdrawing) - (depositing);
    } else {
      return available;
    }
  }

  /**
   * Returns the amount of the <code>currency</code> in this balance that may be withdrawn. Equal to
   * <code>available - borrowed</code>.
   *
   * @return the amount that is available to withdraw.
   */
  public Double getAvailableForWithdrawal() {
    return getAvailable() - (getBorrowed());
  }

  /**
   * Returns the frozen amount of the <code>currency</code> in this balance that is locked in
   * trading.
   *
   * @return the amount that is locked in open orders.
   */
  public Double getFrozen() {

    if (frozen == null) {
      return total - (available);
    }
    return frozen;
  }

  /**
   * Returns the borrowed amount of the available <code>currency</code> in this balance that must be
   * repaid.
   *
   * @return the amount that must be repaid.
   */
  public Double getBorrowed() {
    return borrowed;
  }

  /**
   * Returns the loaned amount of the total <code>currency</code> in this balance that will be
   * returned.
   *
   * @return that amount that is loaned out.
   */
  public Double getLoaned() {
    return loaned;
  }

  /**
   * Returns the amount of the <code>currency</code> in this balance that is locked in withdrawal
   *
   * @return the amount in withdrawal.
   */
  public Double getWithdrawing() {
    return withdrawing;
  }

  /**
   * Returns the amount of the <code>currency</code> in this balance that is locked in deposit
   *
   * @return the amount in deposit.
   */
  public Double getDepositing() {
    return depositing;
  }

  @Override
  public String toString() {
    return "Balance [currency="
        + currency
        + ", total="
        + total
        + ", available="
        + available
        + ", frozen="
        + frozen
        + ", borrowed="
        + borrowed
        + ", loaned="
        + loaned
        + ", withdrawing="
        + withdrawing
        + ", depositing="
        + depositing
        + "]";
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = 1;
    result = prime * result + ((total == null) ? 0 : total.hashCode());
    result = prime * result + ((currency == null) ? 0 : currency.hashCode());
    result = prime * result + ((available == null) ? 0 : available.hashCode());
    result = prime * result + ((frozen == null) ? 0 : frozen.hashCode());
    result = prime * result + ((borrowed == null) ? 0 : borrowed.hashCode());
    result = prime * result + ((loaned == null) ? 0 : loaned.hashCode());
    result = prime * result + ((withdrawing == null) ? 0 : withdrawing.hashCode());
    result = prime * result + ((depositing == null) ? 0 : depositing.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Balance other = (Balance) obj;
    if (total == null) {
      if (other.total != null) {
        return false;
      }
    } else if (!total.equals(other.total)) {
      return false;
    }
    if (available == null) {
      if (other.available != null) {
        return false;
      }
    } else if (!available.equals(other.available)) {
      return false;
    }
    if (frozen == null) {
      if (other.frozen != null) {
        return false;
      }
    } else if (!frozen.equals(other.frozen)) {
      return false;
    }
    if (currency == null) {
      if (other.currency != null) {
        return false;
      }
    } else if (!currency.equals(other.currency)) {
      return false;
    }
    if (borrowed == null) {
      if (other.borrowed != null) {
        return false;
      }
    } else if (!borrowed.equals(other.borrowed)) {
      return false;
    }
    if (loaned == null) {
      if (other.loaned != null) {
        return false;
      }
    } else if (!loaned.equals(other.loaned)) {
      return false;
    }
    if (withdrawing == null) {
      if (other.withdrawing != null) {
        return false;
      }
    } else if (!withdrawing.equals(other.withdrawing)) {
      return false;
    }
    if (depositing == null) {
      return other.depositing == null;
    } else return depositing.equals(other.depositing);
  }

  @Override
  public int compareTo(Balance other) {

    int comparison = currency.compareTo(other.currency);
    if (comparison != 0) return comparison;
    comparison = total.compareTo(other.total);
    if (comparison != 0) return comparison;
    comparison = available.compareTo(other.available);
    if (comparison != 0) return comparison;
    comparison = frozen.compareTo(other.frozen);
    if (comparison != 0) return comparison;
    comparison = borrowed.compareTo(other.borrowed);
    if (comparison != 0) return comparison;
    comparison = loaned.compareTo(other.loaned);
    if (comparison != 0) return comparison;
    comparison = withdrawing.compareTo(other.withdrawing);
    if (comparison != 0) return comparison;
    comparison = depositing.compareTo(other.depositing);
    return comparison;
  }

  public static class Builder {
    private Currency currency;
    private Double total;
    private Double available;
    private Double frozen;
    private Double borrowed = 0d;
    private Double loaned = 0d;
    private Double withdrawing = 0d;
    private Double depositing = 0d;

    public static Builder from(Balance balance) {
      return new Builder()
          .currency(balance.getCurrency())
          .total(balance.getTotal())
          .available(balance.getAvailable())
          .frozen(balance.getFrozen())
          .borrowed(balance.getBorrowed())
          .loaned(balance.getLoaned())
          .withdrawing(balance.getWithdrawing())
          .depositing(balance.getDepositing());
    }

    public Builder currency(Currency currency) {
      this.currency = currency;
      return this;
    }

    public Builder total(Double total) {
      this.total = total;
      return this;
    }

    public Builder available(Double available) {
      this.available = available;
      return this;
    }

    public Builder frozen(Double frozen) {
      this.frozen = frozen;
      return this;
    }

    public Builder borrowed(Double borrowed) {
      this.borrowed = borrowed;
      return this;
    }

    public Builder loaned(Double loaned) {
      this.loaned = loaned;
      return this;
    }

    public Builder withdrawing(Double withdrawing) {
      this.withdrawing = withdrawing;
      return this;
    }

    public Builder depositing(Double depositing) {
      this.depositing = depositing;
      return this;
    }

    public Balance build() {
      if (frozen == null) {
        if (total == null || available == null) {
          frozen = 0d;
        }
      }
      return new Balance(
          currency, total, available, frozen, borrowed, loaned, withdrawing, depositing);
    }
  }
}
