package com.binance.client.model.user;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 持仓信息
 *
 * @author xingyu
 */
public class PositionUpdate {
    /**
     * 交易对
     */
    private String symbol;
    /**
     * 仓位
     */
    private BigDecimal amount;
    /**
     * 入仓价格
     */
    private BigDecimal entryPrice;
    /**
     * (费前)累计实现损益
     */
    private BigDecimal preFee;
    /**
     * 持仓未实现盈亏
     */
    private BigDecimal unrealizedPnl;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(BigDecimal entryPrice) {
        this.entryPrice = entryPrice;
    }

    public BigDecimal getPreFee() {
        return preFee;
    }

    public void setPreFee(BigDecimal preFee) {
        this.preFee = preFee;
    }

    public BigDecimal getUnrealizedPnl() {
        return unrealizedPnl;
    }

    public void setUnrealizedPnl(BigDecimal unrealizedPnl) {
        this.unrealizedPnl = unrealizedPnl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("symbol", symbol)
                .append("amount", amount).append("entryPrice", entryPrice).append("preFee", preFee)
                .append("unrealizedPnl", unrealizedPnl).toString();
    }
}
