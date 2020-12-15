package com.binance.client.impl;

import com.binance.client.SubscriptionClient;
import com.binance.client.SubscriptionErrorHandler;
import com.binance.client.SubscriptionListener;
import com.binance.client.SubscriptionOptions;
import com.binance.client.model.enums.CandlestickInterval;
import com.binance.client.model.event.*;
import com.binance.client.model.user.UserDataUpdateEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Websocket 行情推送 stream格式
 *
 * @author xingyu
 */
public class WebSocketStreamClientImpl implements SubscriptionClient {

    private final SubscriptionOptions options;
    private final WebsocketRequestImpl requestImpl;
    private final List<WebSocketConnection> connections = new LinkedList<>();
    private final String apiKey;
    private final String secretKey;
    private WebSocketWatchDog watchDog;

    WebSocketStreamClientImpl(String apiKey, String secretKey, SubscriptionOptions options) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.watchDog = null;
        this.options = Objects.requireNonNull(options);

        this.requestImpl = new WebsocketRequestImpl();
    }

    private <T> void createConnection(WebsocketRequest<T> request, boolean autoClose) {
        if (watchDog == null) {
            watchDog = new WebSocketWatchDog(options);
        }
        WebSocketConnection connection = new WebSocketConnection(apiKey, secretKey, options, request, watchDog,
                autoClose);
        if (autoClose == false) {
            connections.add(connection);
        }
        connection.connect();
    }

    private <T> void createConnection(WebsocketRequest<T> request) {
        createConnection(request, false);
    }

    /**
     * 取消订阅所有订阅。
     */
    @Override
    public void unsubscribeAll() {
        for (WebSocketConnection connection : connections) {
            watchDog.onClosedNormally(connection);
            connection.close();
        }
        connections.clear();
    }

    /**
     * 归集交易
     *
     * @param symbol               交易对
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    @Override
    public void subscribeAggregateTradeEvent(String symbol,
                                             SubscriptionListener<AggregateTradeEvent> subscriptionListener,
                                             SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAggregateTradeEvent(symbol, subscriptionListener, errorHandler));
    }

    /**
     * 最新标记价格
     *
     * @param symbol               交易对
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    @Override
    public void subscribeMarkPriceEvent(String symbol,
                                        SubscriptionListener<MarkPriceEvent> subscriptionListener,
                                        SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeMarkPriceEvent(symbol, subscriptionListener, errorHandler));
    }

    /**
     * K线
     * K线stream逐秒推送所请求的K线种类(最新一根K线)的更新。推送间隔250毫秒(如有刷新)
     *
     * @param symbol               交易对
     * @param interval             m -> 分钟; h -> 小时; d -> 天; w -> 周; M -> 月
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    @Override
    public void subscribeCandlestickEvent(String symbol, CandlestickInterval interval,
                                          SubscriptionListener<CandlestickEvent> subscriptionListener,
                                          SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeCandlestickEvent(symbol, interval, subscriptionListener, errorHandler));
    }

    /**
     * 按Symbol的精简Ticker
     *
     * @param symbol               交易对
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    @Override
    public void subscribeSymbolMiniTickerEvent(String symbol,
                                               SubscriptionListener<SymbolMiniTickerEvent> subscriptionListener,
                                               SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeSymbolMiniTickerEvent(symbol, subscriptionListener, errorHandler));
    }

    /**
     * 全市场的精简Ticker
     *
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    @Override
    public void subscribeAllMiniTickerEvent(SubscriptionListener<List<SymbolMiniTickerEvent>> subscriptionListener,
                                            SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAllMiniTickerEvent(subscriptionListener, errorHandler));
    }

    /**
     * 按Symbol的完整Ticker
     *
     * @param symbol               交易对
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    @Override
    public void subscribeSymbolTickerEvent(String symbol,
                                           SubscriptionListener<SymbolTickerEvent> subscriptionListener,
                                           SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeSymbolTickerEvent(symbol, subscriptionListener, errorHandler));
    }

    /**
     * 全市场的完整Ticker
     *
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    @Override
    public void subscribeAllTickerEvent(SubscriptionListener<List<SymbolTickerEvent>> subscriptionListener,
                                        SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAllTickerEvent(subscriptionListener, errorHandler));
    }

    /**
     * 按Symbol的最优挂单信息
     *
     * @param symbol               交易对
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    @Override
    public void subscribeSymbolBookTickerEvent(String symbol,
                                               SubscriptionListener<SymbolBookTickerEvent> subscriptionListener,
                                               SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeSymbolBookTickerEvent(symbol, subscriptionListener, errorHandler));
    }

    /**
     * 全市场最优挂单信息
     *
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    @Override
    public void subscribeAllBookTickerEvent(SubscriptionListener<SymbolBookTickerEvent> subscriptionListener,
                                            SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAllBookTickerEvent(subscriptionListener, errorHandler));
    }

    /**
     * 强平订单
     *
     * @param symbol               交易对
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    @Override
    public void subscribeSymbolLiquidationOrderEvent(String symbol,
                                                     SubscriptionListener<LiquidationOrderEvent> subscriptionListener,
                                                     SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeSymbolLiquidationOrderEvent(symbol, subscriptionListener, errorHandler));
    }

    /**
     * 全市场强平订单
     *
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    @Override
    public void subscribeAllLiquidationOrderEvent(SubscriptionListener<LiquidationOrderEvent> subscriptionListener,
                                                  SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAllLiquidationOrderEvent(subscriptionListener, errorHandler));
    }

    /**
     * 有限档深度信息
     *
     * @param symbol               交易对
     * @param limit                档
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    @Override
    public void subscribeBookDepthEvent(String symbol, Integer limit,
                                        SubscriptionListener<OrderBookEvent> subscriptionListener,
                                        SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeBookDepthEvent(symbol, limit, subscriptionListener, errorHandler));
    }

    /**
     * 增量深度信息
     *
     * @param symbol               交易对
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    @Override
    public void subscribeDiffDepthEvent(String symbol,
                                        SubscriptionListener<OrderBookEvent> subscriptionListener,
                                        SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeDiffDepthEvent(symbol, subscriptionListener, errorHandler));
    }

    /**
     * 账户信息有变动时，会推送此事件
     *
     * @param listenKey            listenKey
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    @Override
    public void subscribeUserDataEvent(String listenKey,
                                       SubscriptionListener<UserDataUpdateEvent> subscriptionListener,
                                       SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeUserDataEvent(listenKey, subscriptionListener, errorHandler));
    }


}
