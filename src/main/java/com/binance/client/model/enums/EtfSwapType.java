package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

/**
 * @author xingyu
 */
public enum EtfSwapType {
    ETF_SWAP_IN("1"),
    ETF_SWAP_OUT("2");

    private static final EnumLookup<EtfSwapType> ENUM_LOOKUP = new EnumLookup<>(EtfSwapType.class);
    private final String code;

    EtfSwapType(String code) {
        this.code = code;
    }

    public static EtfSwapType lookup(String name) {
        return ENUM_LOOKUP.lookup(name);
    }

    @Override
    public String toString() {
        return code;
    }
}
