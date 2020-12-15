package com.binance.client.model.market;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 资金费率历史
 *
 * @author xingyu
 */
public class FundingRate {

    /**
     * [
     * {
     * "symbol": "BTCUSDT",            // 交易对
     * "fundingRate": "-0.03750000",   // 资金费率
     * "fundingTime": 1570608000000,   // 资金费时间
     * },
     * {
     * "symbol": "BTCUSDT",
     * "fundingRate": "0.00010000",
     * "fundingTime": 1570636800000,
     * }
     * ]
     */

    private String symbol;

    private BigDecimal fundingRate;

    private Long fundingTime;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getFundingRate() {
        return fundingRate;
    }

    public void setFundingRate(BigDecimal fundingRate) {
        this.fundingRate = fundingRate;
    }

    public Long getFundingTime() {
        return fundingTime;
    }

    public void setFundingTime(Long fundingTime) {
        this.fundingTime = fundingTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("symbol", symbol)
                .append("fundingRate", fundingRate).append("fundingTime", fundingTime).toString();
    }
}
