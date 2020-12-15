package com.binance.client.model.trade;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 逐仓保证金变动历史
 *
 * @author xingyu
 */
public class WalletDeltaLog {
    /**
     * 交易对
     */
    private String symbol;
    /**
     * 调整方向
     */
    private int type;
    /**
     * 数量
     */
    private String amount;
    /**
     * 资产
     */
    private String asset;
    /**
     * 时间
     */
    private Long time;
    /**
     * 持仓方向
     */
    private String positionSide;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getPositionSide() {
        return positionSide;
    }

    public void setPositionSide(String positionSide) {
        this.positionSide = positionSide;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("symbol", symbol).append("type", type).append("amount", amount)
                .append("asset", asset).append("time", time)
                .append("positionSide", positionSide).toString();
    }
}
