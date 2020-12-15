package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

/**
 * @author xingyu
 */

public enum BalanceType {
    TRADE("trade"),
    FROZEN("frozen"),
    LOAN("loan"),
    INTEREST("interest"),
    LOAN_AVAILABLE("loan-available"),
    TRANSFER_OUT_AVAILABLE("transfer-out-available");


    private static final EnumLookup<BalanceType> ENUM_LOOKUP = new EnumLookup<>(BalanceType.class);
    private final String code;

    BalanceType(String code) {
        this.code = code;
    }

    public static BalanceType lookup(String name) {
        return ENUM_LOOKUP.lookup(name);
    }

    @Override
    public String toString() {
        return code;
    }

}
