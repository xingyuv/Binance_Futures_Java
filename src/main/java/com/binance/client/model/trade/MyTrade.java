package com.binance.client.model.trade;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 账户成交历史
 *
 * @author xingyu
 */
public class MyTrade {

    /**
     * 是否是买方
     */
    private Boolean isBuyer;
    /**
     * 手续费
     */
    private BigDecimal commission;
    /**
     * 手续费计价单位
     */
    private String commissionAsset;
    /**
     * 是否是挂单方
     */
    private Boolean isMaker;
    /**
     * 交易ID
     */
    private Long id;

    /**
     * 订单编号
     */
    private Long orderId;
    /**
     * 成交价
     */
    private BigDecimal price;
    /**
     * 成交量
     */
    private BigDecimal qty;
    /**
     * 成交额
     */
    private BigDecimal quoteQty;
    /**
     * 是否是买方
     */
    private Long counterPartyId;

    /**
     * 实现盈亏
     */
    private BigDecimal realizedPnl;
    /**
     * 买卖方向
     */
    private String side;
    /**
     * 持仓方向
     */
    private String positionSide;
    /**
     * 交易对
     */
    private String symbol;
    /**
     * 时间
     */
    private Long time;

    public Boolean getBuyer() {
        return isBuyer;
    }

    public void setBuyer(Boolean buyer) {
        isBuyer = buyer;
    }

    public Boolean getMaker() {
        return isMaker;
    }

    public void setMaker(Boolean maker) {
        isMaker = maker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsBuyer() {
        return isBuyer;
    }

    public void setIsBuyer(Boolean isBuyer) {
        this.isBuyer = isBuyer;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public String getCommissionAsset() {
        return commissionAsset;
    }

    public void setCommissionAsset(String commissionAsset) {
        this.commissionAsset = commissionAsset;
    }

    public Long getCounterPartyId() {
        return counterPartyId;
    }

    public void setCounterPartyId(Long counterPartyId) {
        this.counterPartyId = counterPartyId;
    }

    public Boolean getIsMaker() {
        return isMaker;
    }

    public void setIsMaker(Boolean isMaker) {
        this.isMaker = isMaker;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getQuoteQty() {
        return quoteQty;
    }

    public void setQuoteQty(BigDecimal quoteQty) {
        this.quoteQty = quoteQty;
    }

    public BigDecimal getRealizedPnl() {
        return realizedPnl;
    }

    public void setRealizedPnl(BigDecimal realizedPnl) {
        this.realizedPnl = realizedPnl;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getPositionSide() {
        return positionSide;
    }

    public void setPositionSide(String positionSide) {
        this.positionSide = positionSide;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("isBuyer", isBuyer)
                .append("commission", commission).append("commissionAsset", commissionAsset)
                .append("counterPartyId", counterPartyId).append("isMaker", isMaker)
                .append("orderId", orderId).append("price", price).append("qty", qty).append("quoteQty", quoteQty)
                .append("realizedPnl", realizedPnl).append("side", side).append("positionSide", positionSide)
                .append("symbol", symbol).append("time", time).toString();
    }
}
