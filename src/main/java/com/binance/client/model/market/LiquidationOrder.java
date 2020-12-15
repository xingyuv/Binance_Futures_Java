package com.binance.client.model.market;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 市场强平订单
 *
 * @author xingyu
 */
public class LiquidationOrder {

    /**
     * 交易对
     */
    private String symbol;
    /**
     * 订单价格
     */
    private BigDecimal price;
    /**
     * 订单数量
     */
    private BigDecimal origQty;
    /**
     * 成交量
     */
    private BigDecimal executedQty;
    /**
     * 成交均价
     */
    private BigDecimal averagePrice;
    /**
     * 订单状态
     */
    private String status;
    /**
     * 有效方式
     */
    private String timeInForce;
    /**
     * 订单类型
     */
    private String type;
    /**
     * 订单方向
     */
    private String side;
    /**
     * 撮合引擎时间
     */
    private Long time;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOrigQty() {
        return origQty;
    }

    public void setOrigQty(BigDecimal origQty) {
        this.origQty = origQty;
    }

    public BigDecimal getExecutedQty() {
        return executedQty;
    }

    public void setExecutedQty(BigDecimal executedQty) {
        this.executedQty = executedQty;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
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
                .append("price", price).append("origQty", origQty).append("executedQty", executedQty)
                .append("averagePrice", averagePrice).append("status", status)
                .append("timeInForce", timeInForce).append("type", type)
                .append("side", side).append("time", time).toString();
    }
}
