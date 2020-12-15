package com.binance.client.constant;

import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Binance API中使用的常量。
 *
 * @author xingyu
 */
public class BinanceApiConstants {

    /**
     * REST API基本URL。
     */
    public static final String API_BASE_URL = "https://fapi.binance.com";

    /**
     * 流API基本URL。
     */
    public static final String WS_API_BASE_URL = "wss://fstream.binance.com/ws";

    /**
     * 用于API密钥身份验证的HTTP标头。
     */
    public static final String API_KEY_HEADER = "X-MBX-APIKEY";

    /**
     * 装饰器，指示端点需要API密钥。
     */
    public static final String ENDPOINT_SECURITY_TYPE_APIKEY = "APIKEY";
    public static final String ENDPOINT_SECURITY_TYPE_APIKEY_HEADER = ENDPOINT_SECURITY_TYPE_APIKEY + ": #";

    /**
     * 装饰器，指示端点需要签名。
     */
    public static final String ENDPOINT_SECURITY_TYPE_SIGNED = "SIGNED";
    public static final String ENDPOINT_SECURITY_TYPE_SIGNED_HEADER = ENDPOINT_SECURITY_TYPE_SIGNED + ": #";

    /**
     * 默认接收窗口。
     */
    public static final long DEFAULT_RECEIVING_WINDOW = 60_000L;

    /**
     * toString方法使用的默认ToStringStyle。
     * 覆盖此属性以更改覆盖的toString方法的输出格式。
     * -示例ToStringStyle.JSON_STYLE
     */
    public static ToStringStyle TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;
}
