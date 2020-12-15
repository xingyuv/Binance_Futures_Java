package com.binance.client.model.market;

import java.math.BigDecimal;

/**
 * 合约主动买卖量
 *
 * @author xingyu
 */
public class TakerLongShortStat {
    /**
     * 买卖比
     */
    private BigDecimal buySellRatio;
    /**
     * 主动买入量
     */
    private BigDecimal sellVol;
    /**
     * 主动卖出量
     */
    private BigDecimal buyVol;
    /**
     * 撮合引擎时间
     */
    private Long timestamp;

    public BigDecimal getBuySellRatio() {
        return buySellRatio;
    }

    public void setBuySellRatio(BigDecimal buySellRatio) {
        this.buySellRatio = buySellRatio;
    }

    public BigDecimal getSellVol() {
        return sellVol;
    }

    public void setSellVol(BigDecimal sellVol) {
        this.sellVol = sellVol;
    }

    public BigDecimal getBuyVol() {
        return buyVol;
    }

    public void setBuyVol(BigDecimal buyVol) {
        this.buyVol = buyVol;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "TakerLongShortStat{" +
                "buySellRatio=" + buySellRatio +
                ", sellVol=" + sellVol +
                ", buyVol=" + buyVol +
                ", timestamp=" + timestamp +
                '}';
    }
}
