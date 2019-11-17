package org.knowm.xchange.simulated;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.FundsExceededException;
import org.knowm.xchange.exceptions.NotAvailableFromExchangeException;

class Account {

  private final ConcurrentMap<Currency, AtomicReference<Balance>> balances =
      new ConcurrentHashMap<>();

  void initialize(Iterable<Currency> currencies) {
    currencies.forEach(
        currency -> balances.put(currency, new AtomicReference<>(new Balance(currency, 0d))));
  }

  public Collection<Balance> balances() {
    return balances.values().stream().map(AtomicReference::get).collect(Collectors.toList());
  }

  public void checkBalance(LimitOrder order) {
    checkBalance(order, order.getOriginalAmount() * (order.getLimitPrice()));
  }

  public void checkBalance(Order order, Double bidAmount) {
    switch (order.getType()) {
      case ASK:
        Double askAmount = order.getRemainingAmount();
        Balance askBalance =
            balances.computeIfAbsent(order.getCurrencyPair().base, this::defaultBalance).get();
        checkBalance(order, askAmount, askBalance);
        break;
      case BID:
        Balance bidBalance =
            balances.computeIfAbsent(order.getCurrencyPair().counter, this::defaultBalance).get();
        checkBalance(order, bidAmount, bidBalance);
        break;
      default:
        throw new NotAvailableFromExchangeException(
            "Order type " + order.getType() + " not supported");
    }
  }

  private void checkBalance(Order order, Double amount, Balance balance) {
    if (balance.getAvailable().compareTo(amount) < 0) {
      throw new FundsExceededException(
          "Insufficient balance: "
              + amount.toString()
              + order.getCurrencyPair().base
              + " required but only "
              + balance.getAvailable()
              + " available");
    }
  }

  public void reserve(LimitOrder order) {
    reserve(order, false);
  }

  public void release(LimitOrder order) {
    reserve(order, true);
  }

  private AtomicReference<Balance> defaultBalance(Currency currency) {
    return new AtomicReference<>(new Balance(currency, 0d));
  }

  private void reserve(LimitOrder order, boolean negate) {
    switch (order.getType()) {
      case ASK:
        Double askAmount = negate ? -order.getRemainingAmount() : order.getRemainingAmount();
        balance(order.getCurrencyPair().base)
            .updateAndGet(
                b -> {
                  if (b.getAvailable().compareTo(askAmount) < 0) {
                    throw new ExchangeException(
                        "Insufficient balance: "
                            + askAmount.toString()
                            + order.getCurrencyPair().base
                            + " required but only "
                            + b.getAvailable()
                            + " available");
                  }
                  return Balance.Builder.from(b)
                      .available(b.getAvailable() - (askAmount))
                      .frozen(b.getFrozen() + (askAmount))
                      .build();
                });
        break;
      case BID:
        double bid = order.getRemainingAmount() * (order.getLimitPrice());
        Double bidAmount = negate ? -bid : bid;
        balance(order.getCurrencyPair().counter)
            .updateAndGet(
                b -> {
                  if (b.getAvailable().compareTo(bidAmount) < 0) {
                    throw new ExchangeException(
                        "Insufficient balance: "
                            + bidAmount.toString()
                            + order.getCurrencyPair().counter
                            + " required but only "
                            + b.getAvailable()
                            + " available");
                  }
                  return Balance.Builder.from(b)
                      .available(b.getAvailable() - (bidAmount))
                      .frozen(b.getFrozen() + (bidAmount))
                      .build();
                });
        break;
      default:
        throw new NotAvailableFromExchangeException(
            "Order type " + order.getType() + " not supported");
    }
  }

  public void fill(UserTrade userTrade, boolean reserved) {
    Double counterAmount = userTrade.getOriginalAmount() * (userTrade.getPrice());
    switch (userTrade.getType()) {
      case ASK:
        balance(userTrade.getCurrencyPair().base)
            .updateAndGet(
                b ->
                    Balance.Builder.from(b)
                        .available(
                            reserved
                                ? b.getAvailable()
                                : b.getAvailable() - (userTrade.getOriginalAmount()))
                        .frozen(
                            reserved
                                ? b.getFrozen() - (userTrade.getOriginalAmount())
                                : b.getFrozen())
                        .total(b.getTotal() - (userTrade.getOriginalAmount()))
                        .build());
        balance(userTrade.getCurrencyPair().counter)
            .updateAndGet(
                b ->
                    Balance.Builder.from(b)
                        .total(b.getTotal() + (counterAmount))
                        .available(b.getAvailable() + (counterAmount))
                        .build());
        break;
      case BID:
        balance(userTrade.getCurrencyPair().base)
            .updateAndGet(
                b ->
                    Balance.Builder.from(b)
                        .total(b.getTotal() + (userTrade.getOriginalAmount()))
                        .available(b.getAvailable() + (userTrade.getOriginalAmount()))
                        .build());
        balance(userTrade.getCurrencyPair().counter)
            .updateAndGet(
                b ->
                    Balance.Builder.from(b)
                        .available(reserved ? b.getAvailable() : b.getAvailable() - (counterAmount))
                        .frozen(reserved ? b.getFrozen() - (counterAmount) : b.getFrozen())
                        .total(b.getTotal() - (counterAmount))
                        .build());
        break;
      default:
        throw new NotAvailableFromExchangeException(
            "Order type " + userTrade.getType() + " not supported");
    }
  }

  private AtomicReference<Balance> balance(Currency currency) {
    return balances.computeIfAbsent(currency, this::defaultBalance);
  }

  public void deposit(Currency currency, Double amount) {
    balance(currency)
        .updateAndGet(
            b ->
                Balance.Builder.from(b)
                    .total(b.getTotal() + (amount))
                    .available(b.getAvailable() + (amount))
                    .build());
  }
}
