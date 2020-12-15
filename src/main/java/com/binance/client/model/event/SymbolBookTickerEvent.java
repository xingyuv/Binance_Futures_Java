package com.binance.client.model.event;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 交易对最优挂单信息
 *
 * @author xingyu
 */
public class SymbolBookTickerEvent {
    /**
     * 事件类型
     */
    private String eventType;
    /**
     * 更新ID
     */
    private Long orderBookUpdateId;
    /**
     * 事件时间
     */
    private Long eventTime;
    /**
     * 撮合引擎时间
     */
    private Long time;

    /**
     * 交易对
     */
    private String symbol;
    /**
     * 买单最优挂单价格
     */
    private BigDecimal bestBidPrice;
    /**
     * 买单最优挂单数量
     */
    private BigDecimal bestBidQty;
    /**
     * 卖单最优挂单价格
     */
    private BigDecimal bestAskPrice;
    /**
     * 卖单最优挂单数量
     */
    private BigDecimal bestAskQty;

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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getOrderBookUpdateId() {
        return orderBookUpdateId;
    }

    public void setOrderBookUpdateId(Long orderBookUpdateId) {
        this.orderBookUpdateId = orderBookUpdateId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getBestBidPrice() {
        return bestBidPrice;
    }

    public void setBestBidPrice(BigDecimal bestBidPrice) {
        this.bestBidPrice = bestBidPrice;
    }

    public BigDecimal getBestBidQty() {
        return bestBidQty;
    }

    public void setBestBidQty(BigDecimal bestBidQty) {
        this.bestBidQty = bestBidQty;
    }

    public BigDecimal getBestAskPrice() {
        return bestAskPrice;
    }

    public void setBestAskPrice(BigDecimal bestAskPrice) {
        this.bestAskPrice = bestAskPrice;
    }

    public BigDecimal getBestAskQty() {
        return bestAskQty;
    }

    public void setBestAskQty(BigDecimal bestAskQty) {
        this.bestAskQty = bestAskQty;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("orderBookUpdateId", orderBookUpdateId).append("symbol", symbol)
                .append("bestBidPrice", bestBidPrice).append("bestBidQty", bestBidQty)
                .append("bestAskPrice", bestAskPrice).append("bestAskQty", bestAskQty).toString();
    }
}
