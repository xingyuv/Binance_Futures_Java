package com.binance.client.model.event;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 归集交易
 *
 * @author xingyu
 */
public class AggregateTradeEvent {
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
     * 交易ID
     */
    private Long id;
    /**
     * 成交价格
     */
    private BigDecimal price;
    /**
     * 成交笔数
     */
    private BigDecimal qty;
    /**
     * 被归集的首个交易ID
     */
    private Long firstId;
    /**
     * 被归集的末次交易ID
     */
    private Long lastId;
    /**
     * 成交时间
     */
    private Long time;
    /**
     * 买方是否是做市方。如true，则此次成交是一个主动卖出单，否则是一个主动买入单。
     */
    private Boolean isBuyerMaker;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public Long getFirstId() {
        return firstId;
    }

    public void setFirstId(Long firstId) {
        this.firstId = firstId;
    }

    public Long getLastId() {
        return lastId;
    }

    public void setLastId(Long lastId) {
        this.lastId = lastId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Boolean getIsBuyerMaker() {
        return isBuyerMaker;
    }

    public void setIsBuyerMaker(Boolean isBuyerMaker) {
        this.isBuyerMaker = isBuyerMaker;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("eventType", eventType)
                .append("eventTime", eventTime).append("symbol", symbol).append("id", id).append("price", price)
                .append("qty", qty).append("firstId", firstId).append("lastId", lastId).append("time", time)
                .append("isBuyerMaker", isBuyerMaker).toString();
    }
}
