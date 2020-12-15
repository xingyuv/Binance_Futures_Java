package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

/**
 * @author xingyu
 */
public enum EtfStatus {
    NORMAL("1"),
    REBALANCING_START("2"),
    CREATION_AND_REDEMPTION_SUSPEND("3"),
    CREATION_SUSPEND("4"),
    REDEMPTION_SUSPEND("5");

    private static final EnumLookup<EtfStatus> lookup = new EnumLookup<>(EtfStatus.class);
    private final String code;

    EtfStatus(String code) {
        this.code = code;
    }

    public static EtfStatus lookup(String name) {
        return lookup.lookup(name);
    }

    @Override
    public String toString() {
        return code;
    }
}
