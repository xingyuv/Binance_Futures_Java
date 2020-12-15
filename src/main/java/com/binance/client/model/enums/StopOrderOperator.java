package com.binance.client.model.enums;

/**
 * @author xingyu
 */
public enum StopOrderOperator {
    /**
     * GTE，大于等于（> =），LTE小于等于（<=）
     */
    GTE("gte", "greater than and equal (>=)"), LTE("lte", "less than and equal (<=)");

    private String operator;

    private String desc;

    StopOrderOperator(String operator, String desc) {
        this.operator = operator;
        this.desc = desc;
    }

    public static StopOrderOperator find(String operator) {
        for (StopOrderOperator op : StopOrderOperator.values()) {
            if (op.getOperator().equals(operator)) {
                return op;
            }
        }
        return null;
    }

    public String getOperator() {
        return operator;
    }

    public String getDesc() {
        return desc;
    }

}
