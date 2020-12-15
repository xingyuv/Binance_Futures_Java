package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

/**
 * 工作，锁。
 *
 * @author xingyu
 */
public enum AccountState {
    /**
     * 工作
     */
    WORKING("working"),
    /**
     * 锁
     */
    LOCK("lock");

    private static final EnumLookup<AccountState> ENUM_LOOKUP = new EnumLookup<>(AccountState.class);
    private final String code;

    AccountState(String code) {
        this.code = code;
    }

    public static AccountState lookup(String name) {
        return ENUM_LOOKUP.lookup(name);
    }

    @Override
    public String toString() {
        return code;
    }
}
