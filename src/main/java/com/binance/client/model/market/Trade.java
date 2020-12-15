package com.binance.client.model.market;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 成交
 *
 * @author xingyu
 */
public class Trade {
    /**
     * 成交ID
     */
    private Long id;
    /**
     * 成交价格
     */
    private BigDecimal price;
    /**
     * 成交量
     */
    private BigDecimal qty;
    /**
     * 成交额
     */
    private BigDecimal quoteQty;
    /**
     * 时间
     */
    private Long time;
    /**
     * 买方是否为挂单方
     */
    private Boolean isBuyerMaker;

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

    public BigDecimal getQuoteQty() {
        return quoteQty;
    }

    public void setQuoteQty(BigDecimal quoteQty) {
        this.quoteQty = quoteQty;
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
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("id", id)
                .append("price", price).append("qty", qty).append("quoteQty", quoteQty).append("time", time)
                .append("isBuyerMaker", isBuyerMaker).toString();
    }
}
