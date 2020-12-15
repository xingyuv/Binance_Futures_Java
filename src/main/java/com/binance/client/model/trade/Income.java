package com.binance.client.model.trade;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 账户损益资金流水
 *
 * @author xingyu
 */
public class Income {

    /**
     * 交易对，仅针对涉及交易对的资金流
     */
    private String symbol;
    /**
     * 资金流类型
     */
    private String incomeType;
    /**
     * 资金流数量，正数代表流入，负数代表流出
     */
    private BigDecimal income;
    /**
     * 资产内容
     */
    private String asset;
    /**
     * 备注信息，取决于流水类型
     */
    private String info;
    /**
     * 时间
     */
    private Long time;

    /**
     * 划转ID
     */
    private String tranId;

    /**
     * 引起流水产生的原始交易ID
     */
    private String tradeId;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTranId() {
        return tranId;
    }

    public void setTranId(String tranId) {
        this.tranId = tranId;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("symbol", symbol)
                .append("incomeType", incomeType).append("income", income).append("asset", asset).append("time", time)
                .toString();
    }
}
