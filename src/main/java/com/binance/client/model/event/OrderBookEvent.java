package com.binance.client.model.event;

import com.binance.client.constant.BinanceApiConstants;
import com.binance.client.model.market.OrderBookEntry;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * 深度信息
 *
 * @author xingyu
 */
public class OrderBookEvent {

    /**
     * 事件类型
     */
    private String eventType;
    /**
     * 事件时间
     */
    private Long eventTime;
    /**
     * 交易时间
     */
    private Long transactionTime;
    /**
     * 交易对
     */
    private String symbol;
    /**
     * 从上次推送至今新增的第一个 update Id
     */
    private Long firstUpdateId;
    /**
     * 从上次推送至今新增的最后一个 update Id
     */
    private Long lastUpdateId;
    /**
     * 事件时间
     */
    private Long lastUpdateIdInlastStream;
    /**
     * 买方
     */
    private List<OrderBookEntry> bids;
    /**
     * 卖方
     */
    private List<OrderBookEntry> asks;

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

    public Long getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Long transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getFirstUpdateId() {
        return firstUpdateId;
    }

    public void setFirstUpdateId(Long firstUpdateId) {
        this.firstUpdateId = firstUpdateId;
    }

    public Long getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(Long lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public Long getLastUpdateIdInlastStream() {
        return lastUpdateIdInlastStream;
    }

    public void setLastUpdateIdInlastStream(Long lastUpdateIdInlastStream) {
        this.lastUpdateIdInlastStream = lastUpdateIdInlastStream;
    }

    public List<OrderBookEntry> getBids() {
        return bids;
    }

    public void setBids(List<OrderBookEntry> bids) {
        this.bids = bids;
    }

    public List<OrderBookEntry> getAsks() {
        return asks;
    }

    public void setAsks(List<OrderBookEntry> asks) {
        this.asks = asks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("eventType", eventType)
                .append("eventTime", eventTime).append("transactionTime", transactionTime).append("symbol", symbol)
                .append("firstUpdateId", firstUpdateId).append("lastUpdateId", lastUpdateId)
                .append("lastUpdateIdInlastStream", lastUpdateIdInlastStream).append("bids", bids).append("asks", asks)
                .toString();
    }
}
