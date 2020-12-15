package com.binance.client.impl;

import okhttp3.Request;

/**
 * rest API 请求
 *
 * @author xingyu
 */
public class RestApiRequest<T> {

    public Request request;
    RestApiJsonParser<T> jsonParser;
}
