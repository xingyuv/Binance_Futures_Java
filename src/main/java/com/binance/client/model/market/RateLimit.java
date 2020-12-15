package com.binance.client.model.market;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * API访问的限制
 *
 * @author xingyu
 */
public class RateLimit {
    /**
     * 按照分钟计算
     */
    private String interval;
    /**
     * 上限次数
     */
    private Long intervalNum;
    /**
     * 上限次数
     */
    private Long limit;
    /**
     * 按照访问权重来计算
     */
    private String rateLimitType;

    public String getRateLimitType() {
        return rateLimitType;
    }

    public void setRateLimitType(String rateLimitType) {
        this.rateLimitType = rateLimitType;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public Long getIntervalNum() {
        return intervalNum;
    }

    public void setIntervalNum(Long intervalNum) {
        this.intervalNum = intervalNum;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
                .append("rateLimitType", rateLimitType).append("interval", interval).append("intervalNum", intervalNum)
                .append("limit", limit).toString();
    }
}
