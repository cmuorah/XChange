package org.knowm.xchange.cexio.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object contains position data
 *
 * @author Andrea Fossi.
 */
public class CexioPosition {

  private final String id; // 	position id
  private final Long timestamp; // 	timestamp the position was opened at
  private final String psymbol; // 	currency, in which the position was opened (product)
  private final String
      msymbol; //	currency, in which user is going to gain profit, can be one of the currencies,
  // presented in the pair
  private final String
      lsymbol; //	currency of borrowed funds, can be one of the currencies, presented in the pair
  private final String pair; // 	trading pair as a string like "XXX:XXX"
  private final Double pamount; // total position amount, presented in "psymbol"
  private final Double
      omamount; //	string	("open money amount') user's amount used in the position, presented in
  // 'msymbol"
  private final Double lamount; // 	amount of borrowed funds in the position, presented in "lsymbol"
  private final Double
      openPrice; //	price the position was opened at, calculated as average of underlying executed
  // orders
  private final CexioPositionType
      type; //	position type. long - buying product, profitable if product price grows; short -
  // selling product, profitable if product price falls;
  private final Double
      stopLossPrice; //	price, near which your position will be closed automatically in case of
  // unfavorable market conditions
  private final Double
      pfee; //	estimated fee (in %) from user's amount, that will be charged for position rollover
  // for the next 4 hours
  private final Double
      cfee; //	fee (in %) from user's amount, that will be charged for position closing
  private final Double
      tfeeAmount; //	total fees paid by user, it is equal to opening fee amount, when position has
  // been just opened
  private final String user; // 	User ID
  private final Double amount; // 	total amount of "product" in the position
  private final String symbol; // 	total amount of product in the position
  private final Double
      slamount; //	(stop-loss amount) amount that will be returned, including user`s and borrowed
  // funds
  private final Integer leverage; // 	leverage, with which the position was opened
  private final String dfl; // 	(TECH) desired fast liquidation price
  private final String flPrice; // 	(TECH) estimated price of total loss
  private final String
      ofee; //	fee (in %) from user's amount, that was charged for position opening
  private final String rinterval; // 	rollover interval in miliseconds
  private final String okind; // 	how the position was opened
  //  private final String  a:BTC:c	;//	(TECH) credit in psymbol
  //  private final String  a:BTC:s	;//	(TECH) saldo in psymbol
  private final String oorder; // 	underlying order id for position opening
  private final String lremains; // 	(TECH) amount of borrowed funds to be returned by user
  private final String slremains; // 	(TECH) remains of slamount to return
  private final String status; // 	position's current status (e.g. a for active)
  //  public final String  a:USD:cds	;//	(TECH) equation c==d, s==0

  public CexioPosition(
      @JsonProperty("id") String id,
      @JsonProperty("otime") Long timestamp,
      @JsonProperty("psymbol") String psymbol,
      @JsonProperty("msymbol") String msymbol,
      @JsonProperty("lsymbol") String lsymbol,
      @JsonProperty("pair") String pair,
      @JsonProperty("pamount") Double pamount,
      @JsonProperty("omamount") Double omamount,
      @JsonProperty("lamount") Double lamount,
      @JsonProperty("oprice") Double openPrice,
      @JsonProperty("ptype") CexioPositionType type,
      @JsonProperty("stopLossPrice") Double stopLossPrice,
      @JsonProperty("pfee") Double pfee,
      @JsonProperty("cfee") Double cfee,
      @JsonProperty("tfeeAmount") Double tfeeAmount,
      @JsonProperty("user") String user,
      @JsonProperty("amount") Double amount,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("slamount") Double slamount,
      @JsonProperty("leverage") Integer leverage,
      @JsonProperty("dfl") String dfl,
      @JsonProperty("flPrice") String flPrice,
      @JsonProperty("ofee") String ofee,
      @JsonProperty("rinterval") String rinterval,
      @JsonProperty("okind") String okind,
      @JsonProperty("oorder") String oorder,
      @JsonProperty("lremains") String lremains,
      @JsonProperty("slremains") String slremains,
      @JsonProperty("status") String status) {
    this.id = id;
    this.timestamp = timestamp;
    this.psymbol = psymbol;
    this.msymbol = msymbol;
    this.lsymbol = lsymbol;
    this.pair = pair;
    this.pamount = pamount;
    this.omamount = omamount;
    this.lamount = lamount;
    this.openPrice = openPrice;
    this.type = type;
    this.stopLossPrice = stopLossPrice;
    this.pfee = pfee;
    this.cfee = cfee;
    this.tfeeAmount = tfeeAmount;
    this.user = user;
    this.amount = amount;
    this.symbol = symbol;
    this.slamount = slamount;
    this.leverage = leverage;
    this.dfl = dfl;
    this.flPrice = flPrice;
    this.ofee = ofee;
    this.rinterval = rinterval;
    this.okind = okind;
    this.oorder = oorder;
    this.lremains = lremains;
    this.slremains = slremains;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public String getPsymbol() {
    return psymbol;
  }

  public String getMsymbol() {
    return msymbol;
  }

  public String getLsymbol() {
    return lsymbol;
  }

  public String getPair() {
    return pair;
  }

  public Double getPamount() {
    return pamount;
  }

  public Double getOmamount() {
    return omamount;
  }

  public Double getLamount() {
    return lamount;
  }

  public Double getOpenPrice() {
    return openPrice;
  }

  public CexioPositionType getType() {
    return type;
  }

  public Double getStopLossPrice() {
    return stopLossPrice;
  }

  public Double getPfee() {
    return pfee;
  }

  public Double getCfee() {
    return cfee;
  }

  public Double getTfeeAmount() {
    return tfeeAmount;
  }

  public String getUser() {
    return user;
  }

  public Double getAmount() {
    return amount;
  }

  public String getSymbol() {
    return symbol;
  }

  public Double getSlamount() {
    return slamount;
  }

  public Integer getLeverage() {
    return leverage;
  }

  public String getDfl() {
    return dfl;
  }

  public String getFlPrice() {
    return flPrice;
  }

  public String getOfee() {
    return ofee;
  }

  public String getRinterval() {
    return rinterval;
  }

  public String getOkind() {
    return okind;
  }

  public String getOorder() {
    return oorder;
  }

  public String getLremains() {
    return lremains;
  }

  public String getSlremains() {
    return slremains;
  }

  public String getStatus() {
    return status;
  }
}
