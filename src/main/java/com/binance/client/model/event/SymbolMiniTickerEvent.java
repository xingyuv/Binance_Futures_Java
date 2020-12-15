package com.binance.client.model.event;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 按Symbol的精简Ticker
 *
 * @author xingyu
 */
public class SymbolMiniTickerEvent {
    /**
     * 事件类型
     */
    private String eventType;
    /**
     * 事件时间(毫秒)
     */
    private Long eventTime;
    /**
     * 交易对
     */
    private String symbol;

    /**
     * 最新成交价格
     */
    private BigDecimal close;
    /**
     * 24小时前开始第一笔成交价格
     */
    private BigDecimal open;

    /**
     * 24小时内最高成交价
     */
    private BigDecimal high;
    /**
     * 24小时内最低成交价
     */
    private BigDecimal low;
    /**
     * 成交量
     */
    private BigDecimal totalTradedBaseAssetVolume;
    /**
     * 成交额
     */
    private BigDecimal totalTradedQuoteAssetVolume;

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

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getTotalTradedBaseAssetVolume() {
        return totalTradedBaseAssetVolume;
    }

    public void setTotalTradedBaseAssetVolume(BigDecimal totalTradedBaseAssetVolume) {
        this.totalTradedBaseAssetVolume = totalTradedBaseAssetVolume;
    }

    public BigDecimal getTotalTradedQuoteAssetVolume() {
        return totalTradedQuoteAssetVolume;
    }

    public void setTotalTradedQuoteAssetVolume(BigDecimal totalTradedQuoteAssetVolume) {
        this.totalTradedQuoteAssetVolume = totalTradedQuoteAssetVolume;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("eventType", eventType)
                .append("eventTime", eventTime).append("symbol", symbol).append("open", open).append("close", close)
                .append("high", high).append("low", low)
                .append("totalTradedBaseAssetVolume", totalTradedBaseAssetVolume)
                .append("totalTradedQuoteAssetVolume", totalTradedQuoteAssetVolume).toString();
    }
}
