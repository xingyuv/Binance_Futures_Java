package com.binance.client.model.trade;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 下单
 *
 * @author xingyu
 */
public class Order {

    /**
     * 用户自定义的订单号
     */
    private String clientOrderId;

    /**
     * 量
     */
    private String cumQty;
    /**
     * 成交金额
     */
    private BigDecimal cumQuote;
    /**
     * 成交量
     */
    private BigDecimal executedQty;
    /**
     * 系统订单号
     */
    private Long orderId;
    /**
     * 平均成交价
     */
    private BigDecimal avgPrice;
    /**
     * 原始委托数量
     */
    private BigDecimal origQty;
    /**
     * 委托价格
     */
    private BigDecimal price;
    /**
     * 仅减仓
     */
    private Boolean reduceOnly;
    /**
     * 买卖方向
     */
    private String side;
    /**
     * 持仓方向
     */
    private String positionSide;
    /**
     * 订单状态
     */
    private String status;
    /**
     * 触发价，对`TRAILING_STOP_MARKET`无效
     */
    private BigDecimal stopPrice;

    /**
     * 是否条件全平仓
     */
    private Boolean closePosition;
    /**
     * 交易对
     */
    private String symbol;
    /**
     * 有效方法
     */
    private String timeInForce;
    /**
     * 订单类型
     */
    private String type;

    /**
     * 触发前订单类型
     */
    private String origType;

    /**
     * 跟踪止损激活价格, 仅`TRAILING_STOP_MARKET` 订单返回此字段
     */
    private String activatePrice;
    /**
     * 跟踪止损回调比例, 仅`TRAILING_STOP_MARKET` 订单返回此字段
     */
    private String priceRate;

    /**
     * 更新时间
     */
    private Long updateTime;
    /**
     * 条件价格触发类型
     */
    private String workingType;

    /**
     * 是否开启条件单触发保护
     */
    private Boolean priceProtect;

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public BigDecimal getCumQuote() {
        return cumQuote;
    }

    public void setCumQuote(BigDecimal cumQuote) {
        this.cumQuote = cumQuote;
    }

    public BigDecimal getExecutedQty() {
        return executedQty;
    }

    public void setExecutedQty(BigDecimal executedQty) {
        this.executedQty = executedQty;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getOrigQty() {
        return origQty;
    }

    public void setOrigQty(BigDecimal origQty) {
        this.origQty = origQty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getReduceOnly() {
        return reduceOnly;
    }

    public void setReduceOnly(Boolean reduceOnly) {
        this.reduceOnly = reduceOnly;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getPositionSide() {
        return positionSide;
    }

    public void setPositionSide(String positionSide) {
        this.positionSide = positionSide;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(BigDecimal stopPrice) {
        this.stopPrice = stopPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getWorkingType() {
        return workingType;
    }

    public void setWorkingType(String workingType) {
        this.workingType = workingType;
    }

    public String getCumQty() {
        return cumQty;
    }

    public void setCumQty(String cumQty) {
        this.cumQty = cumQty;
    }

    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(BigDecimal avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Boolean getClosePosition() {
        return closePosition;
    }

    public void setClosePosition(Boolean closePosition) {
        this.closePosition = closePosition;
    }

    public String getOrigType() {
        return origType;
    }

    public void setOrigType(String origType) {
        this.origType = origType;
    }

    public String getActivatePrice() {
        return activatePrice;
    }

    public void setActivatePrice(String activatePrice) {
        this.activatePrice = activatePrice;
    }

    public String getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(String priceRate) {
        this.priceRate = priceRate;
    }

    public Boolean getPriceProtect() {
        return priceProtect;
    }

    public void setPriceProtect(Boolean priceProtect) {
        this.priceProtect = priceProtect;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("clientOrderId", clientOrderId).append("cumQuote", cumQuote).append("executedQty", executedQty)
                .append("orderId", orderId).append("origQty", origQty).append("price", price)
                .append("reduceOnly", reduceOnly).append("side", side).append("positionSide", positionSide).append("status", status)
                .append("stopPrice", stopPrice).append("symbol", symbol).append("timeInForce", timeInForce)
                .append("type", type).append("updateTime", updateTime).append("workingType", workingType).toString();
    }
}
