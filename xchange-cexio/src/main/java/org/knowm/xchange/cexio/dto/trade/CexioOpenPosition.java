package org.knowm.xchange.cexio.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object is returned when a position is opened
 *
 * @author Andrea Fossi.
 */
public class CexioOpenPosition {

  private final String id; // 	position id
  private final Long otime; // 	timestamp the position was opened at
  private final String psymbol; // 	currency, in which the position was opened (product)
  private final String
      msymbol; //	currency, in which user is going to gain profit, can be one of the currencies,
  // presented in the pair
  private final String
      lsymbol; //	currency of borrowed funds, can be one of the currencies, presented in the pair
  private final CexioPositionPair pair; // 	trading pair as a string like "XXX:XXX"

  private final Double pamount; // total position amount, presented in "psymbol"
  private final Double
      omamount; //	string	("open money amount') user's amount used in the position, presented in
  // 'msymbol"
  private final Double lamount; // 	amount of borrowed funds in the position, presented in "lsymbol"
  private final Double
      oprice; //	price the position was opened at, calculated as average of underlying executed
  // orders
  private final CexioPositionType
      ptype; //	position type. long - buying product, profitable if product price grows; short -
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

  public CexioOpenPosition(
      @JsonProperty("id") String id,
      @JsonProperty("otime") Long otime,
      @JsonProperty("psymbol") String psymbol,
      @JsonProperty("msymbol") String msymbol,
      @JsonProperty("lsymbol") String lsymbol,
      @JsonProperty("pair") CexioPositionPair pair,
      @JsonProperty("pamount") Double pamount,
      @JsonProperty("omamount") Double omamount,
      @JsonProperty("lamount") Double lamount,
      @JsonProperty("oprice") Double oprice,
      @JsonProperty("ptype") CexioPositionType ptype,
      @JsonProperty("stopLossPrice") Double stopLossPrice,
      @JsonProperty("pfee") Double pfee,
      @JsonProperty("cfee") Double cfee,
      @JsonProperty("tfeeAmount") Double tfeeAmount) {
    this.id = id;
    this.otime = otime;
    this.psymbol = psymbol;
    this.msymbol = msymbol;
    this.lsymbol = lsymbol;
    this.pair = pair;
    this.pamount = pamount;
    this.omamount = omamount;
    this.lamount = lamount;
    this.oprice = oprice;
    this.ptype = ptype;
    this.stopLossPrice = stopLossPrice;
    this.pfee = pfee;
    this.cfee = cfee;
    this.tfeeAmount = tfeeAmount;
  }

  public String getId() {
    return id;
  }

  public Long getOtime() {
    return otime;
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

  public CexioPositionPair getPair() {
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

  public Double getOprice() {
    return oprice;
  }

  public CexioPositionType getPtype() {
    return ptype;
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
}
