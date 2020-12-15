package com.binance.client.model.market;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 交易规则和交易对
 *
 * @author xingyu
 */
public class ExchangeInfoEntry {

    /**
     * 交易对
     */
    private String symbol;

    /**
     * 标的交易对
     */
    private String pair;

    /**
     * 交割日期
     */
    private Long deliveryDate;

    /**
     * 上线日期
     */
    private Long onboardDate;

    /**
     * 交易对状态 "TRADING"
     */
    private String status;

    private BigDecimal maintMarginPercent;

    private BigDecimal requiredMarginPercent;

    /**
     * 标的资产 "BTC"
     */
    private String baseAsset;

    /**
     * 报价资产 "USDT"
     */
    private String quoteAsset;

    /**
     * 价格小数点位数
     */
    private Long pricePrecision;

    /**
     * 数量小数点位数
     */
    private Long quantityPrecision;

    /**
     * 标的资产精度
     */
    private Long baseAssetPrecision;

    /**
     * 报价资产精度
     */
    private Long quotePrecision;

    /**
     * 订单类型
     * "LIMIT",  // 限价单
     * "MARKET",  // 市价单
     * "STOP", // 止损单
     * "STOP_MARKET", // 止损市价单
     * "TAKE_PROFIT", // 止盈单
     * "TAKE_PROFIT_MARKET", // 止盈暑市价单
     * "TRAILING_STOP_MARKET" // 跟踪止损市价单
     */
    private List<String> orderTypes;
    /**
     * 有效方式
     * "GTC", // 成交为止, 一直有效
     * "IOC", // 无法立即成交(吃单)的部分就撤销
     * "FOK", // 无法全部立即成交就撤销
     * "GTX" // 无法成为挂单方就撤销
     */
    private List<String> timeInForce;

    /**
     * {
     * "filterType": "PRICE_FILTER", // 价格限制
     * "maxPrice": "300", // 价格上限, 最大价格
     * "minPrice": "0.0001", // 价格下限, 最小价格
     * "tickSize": "0.0001" // 步进间隔
     * },
     * {
     * "filterType": "LOT_SIZE", // 数量限制
     * "maxQty": "10000000", // 数量上限, 最大数量
     * "minQty": "1", // 数量下限, 最小数量
     * "stepSize": "1" // 允许的步进值
     * },
     * {
     * "filterType": "MARKET_LOT_SIZE", // 市价订单数量限制
     * "maxQty": "590119", // 数量上限, 最大数量
     * "minQty": "1", // 数量下限, 最小数量
     * "stepSize": "1" // 允许的步进值
     * },
     * {
     * "filterType": "MAX_NUM_ORDERS", // 最多订单数限制
     * "limit": 200
     * },
     * {
     * "filterType": "MAX_NUM_ALGO_ORDERS", // 最多条件订单数限制
     * "limit": 100
     * },
     * {
     * "filterType": "PERCENT_PRICE", // 价格比限制
     * "multiplierUp": "1.1500", // 价格上限百分比
     * "multiplierDown": "0.8500", // 价格下限百分比
     * "multiplierDecimal": 4
     * }
     */
    private List<List<Map<String, String>>> filters;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getMaintMarginPercent() {
        return maintMarginPercent;
    }

    public void setMaintMarginPercent(BigDecimal maintMarginPercent) {
        this.maintMarginPercent = maintMarginPercent;
    }

    public BigDecimal getRequiredMarginPercent() {
        return requiredMarginPercent;
    }

    public void setRequiredMarginPercent(BigDecimal requiredMarginPercent) {
        this.requiredMarginPercent = requiredMarginPercent;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public Long getPricePrecision() {
        return pricePrecision;
    }

    public void setPricePrecision(Long pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    public Long getQuantityPrecision() {
        return quantityPrecision;
    }

    public void setQuantityPrecision(Long quantityPrecision) {
        this.quantityPrecision = quantityPrecision;
    }

    public Long getBaseAssetPrecision() {
        return baseAssetPrecision;
    }

    public void setBaseAssetPrecision(Long baseAssetPrecision) {
        this.baseAssetPrecision = baseAssetPrecision;
    }

    public Long getQuotePrecision() {
        return quotePrecision;
    }

    public void setQuotePrecision(Long quotePrecision) {
        this.quotePrecision = quotePrecision;
    }

    public List<String> getOrderTypes() {
        return orderTypes;
    }

    public void setOrderTypes(List<String> orderTypes) {
        this.orderTypes = orderTypes;
    }

    public List<String> getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(List<String> timeInForce) {
        this.timeInForce = timeInForce;
    }

    public List<List<Map<String, String>>> getFilters() {
        return filters;
    }

    public void setFilters(List<List<Map<String, String>>> filters) {
        this.filters = filters;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public Long getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Long deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getOnboardDate() {
        return onboardDate;
    }

    public void setOnboardDate(Long onboardDate) {
        this.onboardDate = onboardDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("symbol", symbol)
                .append("status", status).append("maintMarginPercent", maintMarginPercent)
                .append("requiredMarginPercent", requiredMarginPercent).append("baseAsset", baseAsset)
                .append("quoteAsset", quoteAsset).append("pricePrecision", pricePrecision)
                .append("quantityPrecision", quantityPrecision).append("baseAssetPrecision", baseAssetPrecision)
                .append("quotePrecision", quotePrecision).append("orderTypes", orderTypes)
                .append("timeInForce", timeInForce).append("filters", filters).toString();
    }
}
