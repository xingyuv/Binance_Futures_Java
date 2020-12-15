package com.binance.client.model.enums;

/**
 * @author xingyu
 */
public enum MarginTransferType {
    IN("1"),
    OUT("2");

    private final String code;

    MarginTransferType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
