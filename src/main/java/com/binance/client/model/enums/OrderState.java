package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

/**
 * SUBMITTED, PARTIALFILLED, CANCELLING. PARTIALCANCELED FILLED CANCELED CREATED
 *
 * @author xingyu
 */
public enum OrderState {
    SUBMITTED("submitted"),
    CREATED("created"),
    PARTIALFILLED("partial-filled"),
    CANCELLING("cancelling"),
    PARTIALCANCELED("partial-canceled"),
    FILLED("filled"),
    CANCELED("canceled");


    private static final EnumLookup<OrderState> ENUM_LOOKUP = new EnumLookup<>(OrderState.class);
    private final String code;

    OrderState(String code) {
        this.code = code;
    }

    public static OrderState lookup(String name) {
        return ENUM_LOOKUP.lookup(name);
    }

    @Override
    public String toString() {
        return code;
    }
}
