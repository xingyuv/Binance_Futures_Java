package com.binance.client.model.enums;

/**
 * @author xingyu
 */
public enum DealRole {

    /**
     * TAKER,MAKER
     */

    TAKER("taker"),
    MAKER("maker");

    private final String role;

    DealRole(String role) {
        this.role = role;
    }

    public static DealRole find(String role) {
        for (DealRole fr : DealRole.values()) {
            if (fr.getRole().equals(role)) {
                return fr;
            }
        }
        return null;
    }

    public String getRole() {
        return role;
    }
}
