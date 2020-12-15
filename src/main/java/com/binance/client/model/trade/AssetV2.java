package com.binance.client.model.trade;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 资产
 *
 * @author xingyu
 */
public class AssetV2 {

    /**
     * 资产
     */
    private String asset;

    /**
     * 余额
     */
    private BigDecimal walletBalance;

    /**
     * 未实现盈亏
     */
    private BigDecimal unrealizedProfit;

    /**
     * 保证金余额
     */
    private BigDecimal marginBalance;

    /**
     * 维持保证金
     */
    private BigDecimal maintMargin;

    /**
     * 当前所需起始保证金
     */
    private BigDecimal initialMargin;

    /**
     * 持仓所需起始保证金(基于最新标记价格)
     */
    private BigDecimal positionInitialMargin;

    /**
     * 当前挂单所需起始保证金(基于最新标记价格)
     */
    private BigDecimal openOrderInitialMargin;

    /**
     * 全仓账户余额
     */
    private BigDecimal crossWalletBalance;


    /**
     * 全仓持仓未实现盈亏
     */
    private BigDecimal crossUnPnl;

    /**
     * 可用余额
     */
    private BigDecimal availableBalance;

    /**
     * 最大可转出余额
     */
    private BigDecimal maxWithdrawAmount;

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public BigDecimal getInitialMargin() {
        return initialMargin;
    }

    public void setInitialMargin(BigDecimal initialMargin) {
        this.initialMargin = initialMargin;
    }

    public BigDecimal getMaintMargin() {
        return maintMargin;
    }

    public void setMaintMargin(BigDecimal maintMargin) {
        this.maintMargin = maintMargin;
    }

    public BigDecimal getMarginBalance() {
        return marginBalance;
    }

    public void setMarginBalance(BigDecimal marginBalance) {
        this.marginBalance = marginBalance;
    }

    public BigDecimal getMaxWithdrawAmount() {
        return maxWithdrawAmount;
    }

    public void setMaxWithdrawAmount(BigDecimal maxWithdrawAmount) {
        this.maxWithdrawAmount = maxWithdrawAmount;
    }

    public BigDecimal getOpenOrderInitialMargin() {
        return openOrderInitialMargin;
    }

    public void setOpenOrderInitialMargin(BigDecimal openOrderInitialMargin) {
        this.openOrderInitialMargin = openOrderInitialMargin;
    }

    public BigDecimal getPositionInitialMargin() {
        return positionInitialMargin;
    }

    public void setPositionInitialMargin(BigDecimal positionInitialMargin) {
        this.positionInitialMargin = positionInitialMargin;
    }

    public BigDecimal getUnrealizedProfit() {
        return unrealizedProfit;
    }

    public void setUnrealizedProfit(BigDecimal unrealizedProfit) {
        this.unrealizedProfit = unrealizedProfit;
    }

    public BigDecimal getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(BigDecimal walletBalance) {
        this.walletBalance = walletBalance;
    }

    public BigDecimal getCrossWalletBalance() {
        return crossWalletBalance;
    }

    public void setCrossWalletBalance(BigDecimal crossWalletBalance) {
        this.crossWalletBalance = crossWalletBalance;
    }

    public BigDecimal getCrossUnPnl() {
        return crossUnPnl;
    }

    public void setCrossUnPnl(BigDecimal crossUnPnl) {
        this.crossUnPnl = crossUnPnl;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("asset", asset)
                .append("initialMargin", initialMargin).append("maintMargin", maintMargin)
                .append("marginBalance", marginBalance).append("maxWithdrawAmount", maxWithdrawAmount)
                .append("openOrderInitialMargin", openOrderInitialMargin)
                .append("positionInitialMargin", positionInitialMargin).append("unrealizedProfit", unrealizedProfit)
                .append("walletBalance", walletBalance)
                .append("crossWalletBalance", crossWalletBalance)
                .append("crossUnPnl", crossUnPnl)
                .append("availableBalance", availableBalance)
                .toString();
    }
}
