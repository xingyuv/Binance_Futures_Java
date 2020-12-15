package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

/**
 * 订单类型
 *
 * @author xingyu
 */
public enum OrderType {
    /**
     * 限价单
     */
    LIMIT("LIMIT"),
    /**
     * 市价单
     */
    MARKET("MARKET"),
    /**
     * 止损单
     */
    STOP("STOP"),
    /**
     * 止损市价单
     */
    STOP_MARKET("STOP_MARKET"),
    /**
     * 止盈单
     */
    TAKE_PROFIT("TAKE_PROFIT"),
    /**
     * 市价止盈单
     */
    TAKE_PROFIT_MARKET("TAKE_PROFIT_MARKET"),
    /**
     * 跟踪止损市价单
     */
    INVALID(null);

    private static final EnumLookup<OrderType> ENUM_LOOKUP = new EnumLookup<>(OrderType.class);
    private final String code;

    OrderType(String code) {
        this.code = code;
    }

    public static OrderType lookup(String name) {
        return ENUM_LOOKUP.lookup(name);
    }

    @Override
    public String toString() {
        return code;
    }

}
