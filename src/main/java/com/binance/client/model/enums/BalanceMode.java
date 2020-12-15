package com.binance.client.model.enums;

/**
 * 用于订阅余额通知的余额模式。
 *
 * @author xingyu
 */
public enum BalanceMode {

    /**
     * 订阅可用余额
     */
    AVAILABLE("0"),

    /**
     * 订阅TOTAL余额，总余额为可用余额和冻结余额之和
     */
    TOTAL("1");

    private final String code;

    BalanceMode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
