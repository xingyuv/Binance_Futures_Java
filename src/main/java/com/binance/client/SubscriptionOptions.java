package com.binance.client;

import com.binance.client.exception.BinanceApiException;

import java.net.URI;

/**
 * 订阅API的配置
 *
 * @author xingyu
 */
public class SubscriptionOptions {

    private String uri = "wss://api.binance.pro/";
    private boolean isAutoReconnect = true;
    private int receiveLimitMs = 60_000;
    private int connectionDelayOnFailure = 15;

    public SubscriptionOptions(SubscriptionOptions options) {
        this.uri = options.uri;
        this.isAutoReconnect = options.isAutoReconnect;
        this.receiveLimitMs = options.receiveLimitMs;
        this.connectionDelayOnFailure = options.connectionDelayOnFailure;
    }

    public SubscriptionOptions() {
    }

    public boolean isAutoReconnect() {
        return isAutoReconnect;
    }

    /**
     * 当订阅行发生连接丢失时，请指定
     * 客户端是否自动重新连接到服务器。
     * <p>
     * 连接丢失意味着：
     * <ul>
     * <li>由网络问题引起的</ li>
     * <li>由服务器触发的连接关闭（每24小时发生一次）</ li>
     * <li>在指定时间内无法从服务器收到任何消息，请参阅
     * {@link #setReceiveLimitMs(int)} (int)}</li>
     * </ul>
     *
     * @param isAutoReconnect The boolean flag, true for enable, false for disable
     * @return Return self for chaining
     */
    public SubscriptionOptions setAutoReconnect(boolean isAutoReconnect) {
        this.isAutoReconnect = isAutoReconnect;
        return this;
    }

    public int getReceiveLimitMs() {
        return receiveLimitMs;
    }

    /**
     * 设置接收限制（以毫秒为单位）。 如果在此范围内未收到任何消息
     * 限制时间，连接将被断开。
     *
     * @param receiveLimitMs The receive limit in millisecond.
     */
    public void setReceiveLimitMs(int receiveLimitMs) {
        this.receiveLimitMs = receiveLimitMs;
    }

    public int getConnectionDelayOnFailure() {
        return connectionDelayOnFailure;
    }

    /**
     * 如果启用了自动重新连接，请指定重新连接之前的延迟时间。
     *
     * @param connectionDelayOnFailure The delay time in second.
     */
    public void setConnectionDelayOnFailure(int connectionDelayOnFailure) {
        this.connectionDelayOnFailure = connectionDelayOnFailure;
    }

    public String getUri() {
        return uri;
    }

    /**
     * 设置订阅的URI。
     *
     * @param uri The URI name like "wss://api.binance.pro".
     */
    public void setUri(String uri) {
        try {
            URI u = new URI(uri);
            this.uri = u.toString();
        } catch (Exception e) {
            throw new BinanceApiException(BinanceApiException.INPUT_ERROR, "The URI is incorrect: " + e.getMessage());
        }
        this.uri = uri;
    }
}
