package com.binance.client.model.enums;

/**
 * @author xingyu
 */
public enum PositionSide {
    /**
     * 双向
     */
    BOTH("BOTH"),
    /**
     * 空
     */
    SHORT("SHORT"),
    /**
     * 多
     */
    LONG("LONG"),
    ;

    private final String code;

    PositionSide(String side) {
        this.code = side;
    }

    @Override
    public String toString() {
        return code;
    }
}
