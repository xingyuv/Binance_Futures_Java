package com.binance.client.model.user;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 账户信息推送
 *
 * @author xingyu
 */
public class UserDataUpdateEvent {

    /**
     * 事件类型
     */
    private String eventType;
    /**
     * 事件时间
     */
    private Long eventTime;
    /**
     * 撮合时间
     */
    private Long transactionTime;
    /**
     * 账户更新
     */
    private AccountUpdate accountUpdate;
    /**
     * 事件类型
     */
    private OrderUpdate orderUpdate;

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

    public AccountUpdate getAccountUpdate() {
        return accountUpdate;
    }

    public void setAccountUpdate(AccountUpdate accountUpdate) {
        this.accountUpdate = accountUpdate;
    }

    public OrderUpdate getOrderUpdate() {
        return orderUpdate;
    }

    public void setOrderUpdate(OrderUpdate orderUpdate) {
        this.orderUpdate = orderUpdate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("eventType", eventType)
                .append("eventTime", eventTime).append("accountUpdate", accountUpdate)
                .append("orderUpdate", orderUpdate).toString();
    }
}
