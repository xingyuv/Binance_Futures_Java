package com.binance.client.model.user;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 订单/交易 更新推送
 *
 * @author xingyu
 */
public class OrderUpdate {
    /**
     * 交易对
     */
    private String symbol;
    /**
     * 客户端自定订单ID
     * 特殊的自定义订单ID:
     * "autoclose-"开头的字符串: 系统强平订单
     * "adl_autoclose": ADL自动减仓订单
     */
    private String clientOrderId;
    /**
     * 订单方向
     */
    private String side;
    /**
     * 订单类型
     * MARKET 市价单
     * LIMIT 限价单
     * STOP 止损单
     * TAKE_PROFIT 止盈单
     * LIQUIDATION 强平单
     */
    private String type;
    /**
     * 有效方式
     * GTC
     * IOC
     * FOK
     * GTX
     */
    private String timeInForce;
    /**
     * 订单原始数量
     */
    private BigDecimal origQty;
    /**
     * 订单原始价格
     */
    private BigDecimal price;
    /**
     * 订单平均价格
     */
    private BigDecimal avgPrice;
    /**
     * 条件订单触发价格，对追踪止损单无效
     */
    private BigDecimal stopPrice;
    /**
     * 本次事件的具体执行类型
     * NEW
     * PARTIAL_FILL 部分成交
     * FILL 成交
     * CANCELED 已撤
     * CALCULATED
     * EXPIRED 订单失效
     * TRADE 交易
     */
    private String executionType;
    /**
     * 订单的当前状态
     * NEW
     * PARTIALLY_FILLED
     * FILLED
     * CANCELED
     * EXPIRED
     * NEW_INSURANCE 风险保障基金(强平)
     * NEW_ADL 自动减仓序列(强平)
     */
    private String orderStatus;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 订单末次成交量
     */
    private BigDecimal lastFilledQty;
    /**
     * 订单累计已成交量
     */
    private BigDecimal cumulativeFilledQty;
    /**
     * 订单末次成交价格
     */
    private BigDecimal lastFilledPrice;
    /**
     * 手续费资产类型
     */
    private String commissionAsset;
    /**
     * 手续费数量
     */
    private BigDecimal commissionAmount;
    /**
     * 成交时间
     */
    private Long orderTradeTime;
    /**
     * 成交ID
     */
    private Long tradeID;
    /**
     * 买单净值
     */
    private BigDecimal bidsNotional;
    /**
     * 卖单净值
     */
    private BigDecimal asksNotional;
    /**
     * 该成交是作为挂单成交吗？
     */
    private Boolean isMarkerSide;
    /**
     * 是否是只减仓单
     */
    private Boolean isReduceOnly;
    /**
     * 触发价类型
     */
    private String workingType;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
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

    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(BigDecimal avgPrice) {
        this.avgPrice = avgPrice;
    }

    public BigDecimal getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(BigDecimal stopPrice) {
        this.stopPrice = stopPrice;
    }

    public String getExecutionType() {
        return executionType;
    }

    public void setExecutionType(String executionType) {
        this.executionType = executionType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getLastFilledQty() {
        return lastFilledQty;
    }

    public void setLastFilledQty(BigDecimal lastFilledQty) {
        this.lastFilledQty = lastFilledQty;
    }

    public BigDecimal getCumulativeFilledQty() {
        return cumulativeFilledQty;
    }

    public void setCumulativeFilledQty(BigDecimal cumulativeFilledQty) {
        this.cumulativeFilledQty = cumulativeFilledQty;
    }

    public BigDecimal getLastFilledPrice() {
        return lastFilledPrice;
    }

    public void setLastFilledPrice(BigDecimal lastFilledPrice) {
        this.lastFilledPrice = lastFilledPrice;
    }

    public String getCommissionAsset() {
        return commissionAsset;
    }

    public void setCommissionAsset(String commissionAsset) {
        this.commissionAsset = commissionAsset;
    }

    public BigDecimal getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(BigDecimal commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public Long getOrderTradeTime() {
        return orderTradeTime;
    }

    public void setOrderTradeTime(Long orderTradeTime) {
        this.orderTradeTime = orderTradeTime;
    }

    public Long getTradeID() {
        return tradeID;
    }

    public void setTradeID(Long tradeID) {
        this.tradeID = tradeID;
    }

    public BigDecimal getBidsNotional() {
        return bidsNotional;
    }

    public void setBidsNotional(BigDecimal bidsNotional) {
        this.bidsNotional = bidsNotional;
    }

    public BigDecimal getAsksNotional() {
        return asksNotional;
    }

    public void setAsksNotional(BigDecimal asksNotional) {
        this.asksNotional = asksNotional;
    }

    public Boolean getIsMarkerSide() {
        return isMarkerSide;
    }

    public void setIsMarkerSide(Boolean isMarkerSide) {
        this.isMarkerSide = isMarkerSide;
    }

    public Boolean getIsReduceOnly() {
        return isReduceOnly;
    }

    public void setIsReduceOnly(Boolean isReduceOnly) {
        this.isReduceOnly = isReduceOnly;
    }

    public String getWorkingType() {
        return workingType;
    }

    public void setWorkingType(String workingType) {
        this.workingType = workingType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("symbol", symbol)
                .append("clientOrderId", clientOrderId).append("side", side).append("type", type)
                .append("timeInForce", timeInForce).append("origQty", origQty).append("price", price)
                .append("avgPrice", avgPrice).append("stopPrice", stopPrice).append("executionType", executionType)
                .append("orderStatus", orderStatus).append("orderId", orderId).append("lastFilledQty", lastFilledQty)
                .append("cumulativeFilledQty", cumulativeFilledQty).append("lastFilledPrice", lastFilledPrice)
                .append("commissionAsset", commissionAsset).append("commissionAmount", commissionAmount)
                .append("orderTradeTime", orderTradeTime).append("tradeID", tradeID)
                .append("bidsNotional", bidsNotional).append("asksNotional", asksNotional)
                .append("isMarkerSide", isMarkerSide).append("isReduceOnly", isReduceOnly)
                .append("workingType", workingType).toString();
    }
}
