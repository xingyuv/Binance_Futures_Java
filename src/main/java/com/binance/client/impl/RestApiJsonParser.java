package com.binance.client.impl;

import com.binance.client.impl.utils.JsonWrapper;

/**
 * @author xingyu
 */
@FunctionalInterface
public interface RestApiJsonParser<T> {
    /**
     * json 转换
     *
     * @param json json
     * @return 数据
     */
    T parseJson(JsonWrapper json);
}
