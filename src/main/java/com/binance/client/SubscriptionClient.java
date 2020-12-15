package com.binance.client;

import com.binance.client.impl.BinanceApiInternalFactory;
import com.binance.client.model.enums.CandlestickInterval;
import com.binance.client.model.event.*;
import com.binance.client.model.user.UserDataUpdateEvent;

import java.util.List;

/***
 * 订阅客户端接口，它用于订阅任何市场数据更新和帐户更改，它是异步的，因此必须实现SubscriptionListener接口。
 * 服务器将任何更新推送到客户端。如果客户端获得更新，则将调用onReceive方法。
 * @author xingyu
 */
public interface SubscriptionClient {
    /**
     * 创建订阅客户端以从服务器订阅更新。
     *
     * @return The instance of synchronous client.
     */
    static SubscriptionClient create() {
        return create("", "", new SubscriptionOptions());
    }

    /**
     * 创建订阅客户端以从服务器订阅更新。
     *
     * @param apiKey    The public key applied from Binance.
     * @param secretKey The private key applied from Binance.
     * @return The instance of synchronous client.
     */
    static SubscriptionClient create(String apiKey, String secretKey) {
        return BinanceApiInternalFactory.getInstance().createSubscriptionClient(apiKey, secretKey,
                new SubscriptionOptions());
    }

    /**
     * 创建订阅客户端以从服务器订阅更新。
     *
     * @param apiKey              The public key applied from Binance.
     * @param secretKey           The private key applied from Binance.
     * @param subscriptionOptions The option of subscription connection, see
     *                            {@link SubscriptionOptions}
     * @return The instance of synchronous client.
     */
    static SubscriptionClient create(String apiKey, String secretKey, SubscriptionOptions subscriptionOptions) {
        return BinanceApiInternalFactory.getInstance().createSubscriptionClient(apiKey, secretKey, subscriptionOptions);
    }

    /**
     * 取消订阅所有订阅。
     */
    void unsubscribeAll();

    /**
     * 归集交易
     *
     * @param symbol       交易对
     * @param callback     订阅
     * @param errorHandler 如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    void subscribeAggregateTradeEvent(String symbol,
                                      SubscriptionListener<AggregateTradeEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * 最新标记价格
     *
     * @param symbol       交易对
     * @param callback     订阅
     * @param errorHandler 如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    void subscribeMarkPriceEvent(String symbol,
                                 SubscriptionListener<MarkPriceEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * K线
     * K线stream逐秒推送所请求的K线种类(最新一根K线)的更新。推送间隔250毫秒(如有刷新)
     *
     * @param symbol       交易对
     * @param interval     m -> 分钟; h -> 小时; d -> 天; w -> 周; M -> 月
     * @param callback     订阅
     * @param errorHandler 如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    void subscribeCandlestickEvent(String symbol, CandlestickInterval interval,
                                   SubscriptionListener<CandlestickEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * 按Symbol的精简Ticker
     *
     * @param symbol       交易对
     * @param callback     订阅
     * @param errorHandler 如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    void subscribeSymbolMiniTickerEvent(String symbol,
                                        SubscriptionListener<SymbolMiniTickerEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * 全市场的精简Ticker
     *
     * @param callback     订阅
     * @param errorHandler 如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    void subscribeAllMiniTickerEvent(SubscriptionListener<List<SymbolMiniTickerEvent>> callback, SubscriptionErrorHandler errorHandler);

    /**
     * 按Symbol的完整Ticker
     *
     * @param symbol       交易对
     * @param callback     订阅
     * @param errorHandler 如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    void subscribeSymbolTickerEvent(String symbol,
                                    SubscriptionListener<SymbolTickerEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * 全市场的完整Ticker
     *
     * @param callback     订阅
     * @param errorHandler 如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    void subscribeAllTickerEvent(SubscriptionListener<List<SymbolTickerEvent>> callback, SubscriptionErrorHandler errorHandler);

    /**
     * 按Symbol的最优挂单信息
     *
     * @param symbol       交易对
     * @param callback     订阅
     * @param errorHandler 如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    void subscribeSymbolBookTickerEvent(String symbol,
                                        SubscriptionListener<SymbolBookTickerEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * 全市场最优挂单信息
     *
     * @param callback     订阅
     * @param errorHandler 如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    void subscribeAllBookTickerEvent(SubscriptionListener<SymbolBookTickerEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * 强平订单
     *
     * @param symbol       交易对
     * @param callback     订阅
     * @param errorHandler 如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    void subscribeSymbolLiquidationOrderEvent(String symbol,
                                              SubscriptionListener<LiquidationOrderEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * 全市场强平订单
     *
     * @param callback     订阅
     * @param errorHandler 如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    void subscribeAllLiquidationOrderEvent(SubscriptionListener<LiquidationOrderEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * 有限档深度信息
     *
     * @param symbol       交易对
     * @param limit        档
     * @param callback     订阅
     * @param errorHandler 如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    void subscribeBookDepthEvent(String symbol, Integer limit,
                                 SubscriptionListener<OrderBookEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * 增量深度信息
     *
     * @param symbol       交易对
     * @param callback     订阅
     * @param errorHandler 如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    void subscribeDiffDepthEvent(String symbol,
                                 SubscriptionListener<OrderBookEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * 账户信息有变动时，会推送此事件
     *
     * @param listenKey    listenKey
     * @param callback     订阅
     * @param errorHandler 如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     */
    void subscribeUserDataEvent(String listenKey,
                                SubscriptionListener<UserDataUpdateEvent> callback, SubscriptionErrorHandler errorHandler);


}
