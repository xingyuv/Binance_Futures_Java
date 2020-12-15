package com.binance.client;


/**
 * 定义异步调用回调的接口。
 * 如果要使用异步调用，则必须自己实现ResponseCallback。
 * onResponse方法是强制性的，异步调用完成后将调用此方法。
 * 您应检查AsyncResult以了解异步调用是否成功，并从AsyncResult获取响应数据。
 *
 * @author xingyu
 */
@FunctionalInterface
public interface ResponseCallback<T> {

    /**
     * 请求成功时被调用。
     *
     * @param response The {@link AsyncResult} of the asynchronous invoking.
     */
    void onResponse(T response);
}
