package com.binance.client.impl.utils;

/**
 * @author xingyu
 */
@FunctionalInterface
public interface Handler<T> {

    void handle(T t);
}
