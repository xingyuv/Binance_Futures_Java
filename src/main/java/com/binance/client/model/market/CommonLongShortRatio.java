package com.binance.client.model.market;

import java.math.BigDecimal;

/**
 * 大户账户数多空比
 *
 * @author xingyu
 */
public class CommonLongShortRatio {
    /**
     * 交易对
     */
    private String symbol;
    /**
     * 大户多空账户数比值
     */
    private BigDecimal longAccount;
    /**
     * 大户多仓账户数比例
     */
    private BigDecimal longShortRatio;
    /**
     * 大户空仓账户数比例
     */
    private BigDecimal shortAccount;
    /**
     * 时间
     */
    private Long timestamp;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getLongAccount() {
        return longAccount;
    }

    public void setLongAccount(BigDecimal longAccount) {
        this.longAccount = longAccount;
    }

    public BigDecimal getLongShortRatio() {
        return longShortRatio;
    }

    public void setLongShortRatio(BigDecimal longShortRatio) {
        this.longShortRatio = longShortRatio;
    }

    public BigDecimal getShortAccount() {
        return shortAccount;
    }

    public void setShortAccount(BigDecimal shortAccount) {
        this.shortAccount = shortAccount;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CommonLongShortRatio{" +
                "symbol='" + symbol + '\'' +
                ", longAccount=" + longAccount +
                ", longShortRatio=" + longShortRatio +
                ", shortAccount=" + shortAccount +
                ", timestamp=" + timestamp +
                '}';
    }
}
