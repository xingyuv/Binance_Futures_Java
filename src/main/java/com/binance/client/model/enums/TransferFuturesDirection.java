package com.binance.client.model.enums;

/**
 * @author xingyu
 */
public enum TransferFuturesDirection {

    /**
     * FUTURES_TO_PRO,PRO_TO_FUTURES
     */
    FUTURES_TO_PRO("futures-to-pro"),
    PRO_TO_FUTURES("pro-to-futures");

    private String direction;

    TransferFuturesDirection(String direction) {
        this.direction = direction;
    }

    public static TransferFuturesDirection find(String direction) {
        for (TransferFuturesDirection d : TransferFuturesDirection.values()) {
            if (d.getDirection().equals(direction)) {
                return d;
            }
        }
        return null;
    }

    public String getDirection() {
        return direction;
    }
}
