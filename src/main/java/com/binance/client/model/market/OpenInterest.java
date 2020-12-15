package com.binance.client.model.market;

/**
 * 未平仓合约数量
 *
 * @author xingyu
 */
public class OpenInterest {
    /**
     * 未平仓合约数量
     */
    private String openInterest;
    /**
     * 交易对
     */
    private String symbol;
    /**
     * 撮合引擎时间
     */
    private Long time;

    public String getOpenInterest() {
        return openInterest;
    }

    public void setOpenInterest(String openInterest) {
        this.openInterest = openInterest;
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
        return "OpenInterestStat{" +
                "symbol='" + symbol + '\'' +
                ", openInterest=" + openInterest +
                ", time=" + time +
                '}';
    }
}
