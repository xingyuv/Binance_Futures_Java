package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

/**
 * @author xingyu
 */
public enum PeriodType {
    _5m("5m"),
    _15m("15m"),
    _30m("30m"),
    _1h("1h"),
    _2h("2h"),
    _4h("4h"),
    _6h("6h"),
    _12h("12h"),
    _1d("1d");

    private static final EnumLookup<PeriodType> ENUM_LOOKUP = new EnumLookup<>(PeriodType.class);
    private final String code;


    PeriodType(String code) {
        this.code = code;
    }

    public static PeriodType lookup(String name) {
        return ENUM_LOOKUP.lookup(name);
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }
}
