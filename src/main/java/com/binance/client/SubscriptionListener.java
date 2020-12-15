package com.binance.client;

/**
 * 您必须实现SubscriptionListener接口。
 * 服务器会将所有更新推送到客户端
 * 如果客户端获得更新，则将调用onReceive方法。
 *
 * @author xingyu
 */
@FunctionalInterface
public interface SubscriptionListener<T> {

    /**
     * 当获取服务器发送的数据时，将调用onReceive。
     *
     * @param data The data send by server.
     */
    void onReceive(T data);
}
