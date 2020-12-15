package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

/**
 * @author xingyu
 */
public enum TransferMasterType {


    MASTER_TRANSFER_IN("master-transfer-in"),
    MASTER_TRANSFER_OUT("master-transfer-out"),
    MASTER_POINT_TRANSFER_IN("master-point-transfer-in"),
    MASTER_POINT_TRANSFER_OUT("master-point-transfer-out");
    private static final EnumLookup<TransferMasterType> ENUM_LOOKUP = new EnumLookup<>(TransferMasterType.class);
    private final String code;

    TransferMasterType(String side) {
        this.code = side;
    }

    public static TransferMasterType lookup(String name) {
        return ENUM_LOOKUP.lookup(name);
    }

    @Override
    public String toString() {
        return code;
    }
}
