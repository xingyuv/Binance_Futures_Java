package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

/**
 * SPOT, MARGIN, OTC, POINT, UNKNOWN.
 *
 * @author xingyu
 */
public enum AccountType {
    SPOT("spot"),
    MARGIN("margin"),
    OTC("otc"),
    POINT("point"),
    SUPER_MARGIN("super-margin"),
    MINEPOOL("minepool"),
    ETF("etf"),
    AGENCY("agency"),
    UNKNOWN("unknown");

    private static final EnumLookup<AccountType> ENUM_LOOKUP = new EnumLookup<>(AccountType.class);
    private final String code;

    AccountType(String code) {
        this.code = code;
    }

    public static AccountType lookup(String name) {
        return ENUM_LOOKUP.lookup(name);
    }

    @Override
    public String toString() {
        return code;
    }

}
