package com.binance.client;

import com.binance.client.exception.BinanceApiException;

/**
 * 订阅的错误处理程序。
 *
 * @author xingyu
 */
@FunctionalInterface
public interface SubscriptionErrorHandler {

    /**
     * 错误
     *
     * @param exception 异常
     */
    void onError(BinanceApiException exception);
}
