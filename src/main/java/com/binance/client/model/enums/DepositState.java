package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;


/**
 * 提款，存款。
 *
 * @author xingyu
 */
public enum DepositState {

    UNKNOWN("unknown"),
    CONFIRMING("confirming"),
    SAFE("safe"),
    CONFIRMED("confirmed"),
    ORPHAN("orphan");


    private static final EnumLookup<DepositState> ENUM_LOOKUP = new EnumLookup<>(DepositState.class);
    private final String code;

    DepositState(String code) {
        this.code = code;
    }

    public static DepositState lookup(String name) {
        return ENUM_LOOKUP.lookup(name);
    }

    @Override
    public String toString() {
        return code;
    }

}
