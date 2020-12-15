package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

/**
 * created, accrual, cleared, invalid.
 *
 * @author xingyu
 */
public enum LoanOrderStates {

    CREATED("created"),
    ACCRUAL("accrual"),
    CLEARED("cleared"),
    INVALID("invalid");

    private static final EnumLookup<LoanOrderStates> ENUM_LOOKUP = new EnumLookup<>(LoanOrderStates.class);
    private final String code;

    LoanOrderStates(String state) {
        this.code = state;
    }

    public static LoanOrderStates lookup(String name) {
        return ENUM_LOOKUP.lookup(name);
    }

    @Override
    public String toString() {
        return code;
    }
}
