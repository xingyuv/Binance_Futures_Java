package com.binance.client.model.enums;

/**
 * 有效方式
 *
 * @author xingyu
 */
public enum TimeInForce {
    /**
     * 成交为止, 一直有效
     */
    GTC,
    /**
     * 无法立即成交(吃单)的部分就撤销
     */
    IOC,
    /**
     * 无法全部立即成交就撤销
     */
    FOK,
    /**
     * 无法成为挂单方就撤销
     */
    GTX
}
