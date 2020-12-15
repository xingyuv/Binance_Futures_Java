package com.binance.client.model.event;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * K线
 *
 * @author xingyu
 */
public class CandlestickEvent {
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
     * 这根K线的起始时间
     */
    private Long startTime;
    /**
     * 这根K线的结束时间
     */
    private Long closeTime;
    /**
     * K线间隔
     */
    private String interval;
    /**
     * 这根K线期间第一笔成交ID
     */
    private Long firstTradeId;
    /**
     * 这根K线期间末一笔成交ID
     */
    private Long lastTradeId;
    /**
     * 这根K线期间第一笔成交价
     */
    private BigDecimal open;
    /**
     * 这根K线期间末一笔成交价
     */
    private BigDecimal close;
    /**
     * 这根K线期间最高成交价
     */
    private BigDecimal high;
    /**
     * 这根K线期间最低成交价
     */
    private BigDecimal low;
    /**
     * 这根K线期间成交量
     */
    private BigDecimal volume;
    /**
     * 这根K线期间成交笔数
     */
    private Long numTrades;
    /**
     * 这根K线是否完结(是否已经开始下一根K线)
     */
    private Boolean isClosed;
    /**
     * 这根K线期间成交额
     */
    private BigDecimal quoteAssetVolume;
    /**
     * 主动买入的成交量
     */
    private BigDecimal takerBuyBaseAssetVolume;
    /**
     * 主动买入的成交额
     */
    private BigDecimal takerBuyQuoteAssetVolume;
    /**
     * 忽略此参数
     */
    private Long ignore;

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

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public Long getFirstTradeId() {
        return firstTradeId;
    }

    public void setFirstTradeId(Long firstTradeId) {
        this.firstTradeId = firstTradeId;
    }

    public Long getLastTradeId() {
        return lastTradeId;
    }

    public void setLastTradeId(Long lastTradeId) {
        this.lastTradeId = lastTradeId;
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

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public Long getNumTrades() {
        return numTrades;
    }

    public void setNumTrades(Long numTrades) {
        this.numTrades = numTrades;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public BigDecimal getQuoteAssetVolume() {
        return quoteAssetVolume;
    }

    public void setQuoteAssetVolume(BigDecimal quoteAssetVolume) {
        this.quoteAssetVolume = quoteAssetVolume;
    }

    public BigDecimal getTakerBuyBaseAssetVolume() {
        return takerBuyBaseAssetVolume;
    }

    public void setTakerBuyBaseAssetVolume(BigDecimal takerBuyBaseAssetVolume) {
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
    }

    public BigDecimal getTakerBuyQuoteAssetVolume() {
        return takerBuyQuoteAssetVolume;
    }

    public void setTakerBuyQuoteAssetVolume(BigDecimal takerBuyQuoteAssetVolume) {
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
    }

    public Long getIgnore() {
        return ignore;
    }

    public void setIgnore(Long ignore) {
        this.ignore = ignore;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("eventType", eventType)
                .append("eventTime", eventTime).append("symbol", symbol).append("startTime", startTime)
                .append("closeTime", closeTime).append("symbol", symbol).append("interval", interval)
                .append("firstTradeId", firstTradeId).append("lastTradeId", lastTradeId).append("open", open)
                .append("close", close).append("high", high).append("low", low).append("volume", volume)
                .append("numTrades", numTrades).append("isClosed", isClosed)
                .append("quoteAssetVolume", quoteAssetVolume).append("takerBuyBaseAssetVolume", takerBuyBaseAssetVolume)
                .append("takerBuyQuoteAssetVolume", takerBuyQuoteAssetVolume).append("ignore", ignore).toString();
    }

}
