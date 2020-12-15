package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

/**
 * 与资产变更通知相关的事件，例如：创建订单（order.place），提交订单（order.match），订单退款（order.refund），
 * 订单取消（order.cancel），卡扣除交易费用（order）。费用退款），杠杆账户转账（保证金转账），
 * 贷款本金（margin.loan），贷款利息（margin.interest），返还贷款利息（margin.re还款），其他资产变更（other）
 *
 * @author xingyu
 */
public enum AccountChangeType {

    /**
     * 创建订单
     */
    NEWORDER("order.place"),
    /**
     * 提交订单
     */
    TRADE("order.match"),
    /**
     * 订单退款
     */
    REFUND("order.refund"),
    /**
     * 订单取消
     */
    CANCELORDER("order.cancel"),
    /**
     * 费用退款
     */
    FEE("order.fee-refund"),
    /**
     * 杠杆账户转账
     */
    TRANSFER("margin.transfer"),
    /**
     * 贷款本金
     */
    LOAN("margin.loan"),
    /**
     * 贷款利息
     */
    INTEREST("margin.interest"),
    /**
     * 返还贷款利息
     */
    REPAY("margin.repay"),
    /**
     * 其他资产变更
     */
    OTHER("other"),
    /**
     * 无法识别
     */
    INVALID("INVALID");

    private static final EnumLookup<AccountChangeType> ENUM_LOOKUP = new EnumLookup<>(
            AccountChangeType.class);
    private final String code;

    AccountChangeType(String code) {
        this.code = code;
    }

    public static AccountChangeType lookup(String name) {
        return ENUM_LOOKUP.lookup(name);
    }

    @Override
    public String toString() {
        return code;
    }


}
