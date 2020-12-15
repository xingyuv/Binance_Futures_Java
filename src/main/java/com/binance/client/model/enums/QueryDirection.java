package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

/**
 * @author xingyu
 */
public enum QueryDirection {
    PREV("prev"),
    NEXT("next");

    private static final EnumLookup<QueryDirection> ENUM_LOOKUP = new EnumLookup<>(QueryDirection.class);
    private final String code;

    QueryDirection(String code) {
        this.code = code;
    }

    public static QueryDirection lookup(String name) {
        return ENUM_LOOKUP.lookup(name);
    }

    @Override
    public String toString() {
        return code;
    }
}
