package com.binance.client.model.event;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 最新标记价格
 *
 * @author xingyu
 */
public class MarkPriceEvent {

    /**
     * 事件类型
     */
    private String eventType;
    /**
     * 事件时间
     */
    private Long eventTime;
    /**
     * 交易对
     */
    private String symbol;
    /**
     * 标记价格
     */
    private BigDecimal markPrice;
    /**
     * 资金费率
     */
    private BigDecimal fundingRate;
    /**
     * 下次资金时间
     */
    private Long nextFundingTime;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Long getEventTime() {
        return eventTime;
    }

    public void setEventTime(Long eventTime) {
        this.eventTime = eventTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(BigDecimal markPrice) {
        this.markPrice = markPrice;
    }

    public BigDecimal getFundingRate() {
        return fundingRate;
    }

    public void setFundingRate(BigDecimal fundingRate) {
        this.fundingRate = fundingRate;
    }

    public Long getNextFundingTime() {
        return nextFundingTime;
    }

    public void setNextFundingTime(Long nextFundingTime) {
        this.nextFundingTime = nextFundingTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("eventType", eventType)
                .append("eventTime", eventTime).append("symbol", symbol).append("markPrice", markPrice)
                .append("fundingRate", fundingRate).append("nextFundingTime", nextFundingTime).toString();
    }
}
