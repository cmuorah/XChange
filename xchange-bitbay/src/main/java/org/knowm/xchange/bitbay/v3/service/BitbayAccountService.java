package org.knowm.xchange.bitbay.v3.service;

import java.io.IOException;
import java.util.*;
import org.knowm.xchange.bitbay.v3.BitbayExchange;
import org.knowm.xchange.bitbay.v3.dto.BitbayBalances;
import org.knowm.xchange.bitbay.v3.dto.trade.BitbayBalancesHistoryQuery;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.service.account.AccountService;
import org.knowm.xchange.service.trade.params.TradeHistoryParamLimit;
import org.knowm.xchange.service.trade.params.TradeHistoryParamOffset;
import org.knowm.xchange.service.trade.params.TradeHistoryParams;
import org.knowm.xchange.utils.DateUtils;

public class BitbayAccountService extends BitbayAccountServiceRaw implements AccountService {
  public BitbayAccountService(BitbayExchange bitbayExchange) {
    super(bitbayExchange);
  }

  @Override
  public AccountInfo getAccountInfo() throws IOException {
    List<Wallet> wallets = new ArrayList<>();

    for (BitbayBalances.BitbayBalance balance : balances()) {
      Wallet wallet =
          Wallet.Builder.from(
                  Collections.singletonList(
                      new Balance(
                          Currency.getInstance(balance.getCurrency()),
                          balance.getTotalFunds(),
                          balance.getAvailableFunds(),
                          balance.getLockedFunds())))
              .id(balance.getId())
              .build();
      wallets.add(wallet);
    }

    return new AccountInfo(wallets);
  }

  @Override
  public List<FundingRecord> getFundingHistory(TradeHistoryParams params) throws IOException {

    Integer limit = 200;
    Long offset = 0L;

    if (params instanceof TradeHistoryParamLimit) {
      limit = ((TradeHistoryParamLimit) params).getLimit();
    }

    if (params instanceof TradeHistoryParamOffset) {
      offset = ((TradeHistoryParamOffset) params).getOffset();
    }

    BitbayBalancesHistoryQuery query = new BitbayBalancesHistoryQuery();

    List<String> types = new ArrayList<>();
    types.add("WITHDRAWAL_SUBTRACT_FUNDS");
    types.add("ADD_FUNDS");
    query.setTypes(types);
    query.setLimit(String.valueOf(limit));
    query.setOffset(String.valueOf(offset));

    Map map = balanceHistory(query);

    List<FundingRecord> fundingRecords = new ArrayList<>();

    for (Map item : (List<Map>) map.get("items")) {
      fundingRecords.add(adaptFundingRecord(item));
    }

    return fundingRecords;
  }

  private static FundingRecord adaptFundingRecord(Map item) {
    FundingRecord.Type type =
        item.get("type").toString().equalsIgnoreCase("WITHDRAWAL_SUBTRACT_FUNDS")
            ? FundingRecord.Type.WITHDRAWAL
            : FundingRecord.Type.DEPOSIT;

    return new FundingRecord.Builder()
        .setType(type)
        .setBlockchainTransactionHash(null) // not available in the API yet
        .setAddress(null) // not available in the API yet
        .setAmount(Math.abs(Double.parseDouble(item.get("value").toString())))
        .setCurrency(Currency.getInstance(((Map) item.get("balance")).get("currency").toString()))
        .setDate(DateUtils.fromMillisUtc(Long.parseLong(item.get("time").toString())))
        .setInternalId(item.get("historyId").toString()) // could be detailId maybe?
        .setFee(null) // not available in the API yet
        .setStatus(FundingRecord.Status.COMPLETE)
        .setBalance(new Double(((Map) item.get("fundsAfter")).get("total").toString()))
        .build();
  }
}
