package com.binance.client.impl;

import com.binance.client.SubscriptionErrorHandler;
import com.binance.client.SubscriptionListener;
import com.binance.client.impl.utils.AbstractChannels;
import com.binance.client.impl.utils.JsonWrapper;
import com.binance.client.impl.utils.JsonWrapperArray;
import com.binance.client.model.enums.CandlestickInterval;
import com.binance.client.model.event.*;
import com.binance.client.model.market.OrderBookEntry;
import com.binance.client.model.user.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xingyu
 */
class WebsocketRequestImpl {

    WebsocketRequestImpl() {
    }

    /**
     * 归集交易
     *
     * @param symbol               交易对
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     * @return 归集交易
     */
    WebsocketRequest<AggregateTradeEvent> subscribeAggregateTradeEvent(String symbol,
                                                                       SubscriptionListener<AggregateTradeEvent> subscriptionListener,
                                                                       SubscriptionErrorHandler errorHandler) {
        InputChecker.checker()
                .shouldNotNull(symbol, "symbol")
                .shouldNotNull(subscriptionListener, "listener");
        WebsocketRequest<AggregateTradeEvent> request = new WebsocketRequest<>(subscriptionListener, errorHandler);
        request.name = "***Aggregate Trade for " + symbol + "***";
        request.connectionHandler = (connection) -> connection.send(AbstractChannels.aggregateTradeChannel(symbol));

        request.jsonParser = (jsonWrapper) -> {
            AggregateTradeEvent result = new AggregateTradeEvent();
            result.setEventType(jsonWrapper.getString("e"));
            result.setEventTime(jsonWrapper.getLong("E"));
            result.setSymbol(jsonWrapper.getString("s"));
            result.setId(jsonWrapper.getLong("a"));
            result.setPrice(jsonWrapper.getBigDecimal("p"));
            result.setQty(jsonWrapper.getBigDecimal("q"));
            result.setFirstId(jsonWrapper.getLong("f"));
            result.setLastId(jsonWrapper.getLong("l"));
            result.setTime(jsonWrapper.getLong("T"));
            result.setIsBuyerMaker(jsonWrapper.getBoolean("m"));
            return result;
        };
        return request;
    }

    /**
     * 最新标记价格
     *
     * @param symbol               交易对
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     * @return 最新标记价格
     */
    WebsocketRequest<MarkPriceEvent> subscribeMarkPriceEvent(String symbol,
                                                             SubscriptionListener<MarkPriceEvent> subscriptionListener,
                                                             SubscriptionErrorHandler errorHandler) {
        InputChecker.checker()
                .shouldNotNull(symbol, "symbol")
                .shouldNotNull(subscriptionListener, "listener");
        WebsocketRequest<MarkPriceEvent> request = new WebsocketRequest<>(subscriptionListener, errorHandler);
        request.name = "***Mark Price for " + symbol + "***";
        request.connectionHandler = (connection) -> connection.send(AbstractChannels.markPriceChannel(symbol));

        request.jsonParser = (jsonWrapper) -> {
            MarkPriceEvent result = new MarkPriceEvent();
            result.setEventType(jsonWrapper.getString("e"));
            result.setEventTime(jsonWrapper.getLong("E"));
            result.setSymbol(jsonWrapper.getString("s"));
            result.setMarkPrice(jsonWrapper.getBigDecimal("p"));
            result.setFundingRate(jsonWrapper.getBigDecimal("r"));
            result.setNextFundingTime(jsonWrapper.getLong("T"));
            return result;
        };
        return request;
    }

    /**
     * K线
     * K线stream逐秒推送所请求的K线种类(最新一根K线)的更新。推送间隔250毫秒(如有刷新)
     *
     * @param symbol               交易对
     * @param interval             m -> 分钟; h -> 小时; d -> 天; w -> 周; M -> 月
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     * @return K线
     */
    WebsocketRequest<CandlestickEvent> subscribeCandlestickEvent(String symbol, CandlestickInterval interval,
                                                                 SubscriptionListener<CandlestickEvent> subscriptionListener,
                                                                 SubscriptionErrorHandler errorHandler) {
        InputChecker.checker()
                .shouldNotNull(symbol, "symbol")
                .shouldNotNull(subscriptionListener, "listener");
        WebsocketRequest<CandlestickEvent> request = new WebsocketRequest<>(subscriptionListener, errorHandler);
        request.name = "***Candlestick for " + symbol + "***";
        request.connectionHandler = (connection) -> connection.send(AbstractChannels.candlestickChannel(symbol, interval));

        request.jsonParser = (jsonWrapper) -> {
            CandlestickEvent result = new CandlestickEvent();
            result.setEventType(jsonWrapper.getString("e"));
            result.setEventTime(jsonWrapper.getLong("E"));
            result.setSymbol(jsonWrapper.getString("s"));
            JsonWrapper jsonObject = jsonWrapper.getJsonObject("k");
            result.setStartTime(jsonObject.getLong("t"));
            result.setCloseTime(jsonObject.getLong("T"));
            result.setSymbol(jsonObject.getString("s"));
            result.setInterval(jsonObject.getString("i"));
            result.setFirstTradeId(jsonObject.getLong("f"));
            result.setLastTradeId(jsonObject.getLong("L"));
            result.setOpen(jsonObject.getBigDecimal("o"));
            result.setClose(jsonObject.getBigDecimal("c"));
            result.setHigh(jsonObject.getBigDecimal("h"));
            result.setLow(jsonObject.getBigDecimal("l"));
            result.setVolume(jsonObject.getBigDecimal("v"));
            result.setNumTrades(jsonObject.getLong("n"));
            result.setIsClosed(jsonObject.getBoolean("x"));
            result.setQuoteAssetVolume(jsonObject.getBigDecimal("q"));
            result.setTakerBuyBaseAssetVolume(jsonObject.getBigDecimal("V"));
            result.setTakerBuyQuoteAssetVolume(jsonObject.getBigDecimal("Q"));
            result.setIgnore(jsonObject.getLong("B"));
            return result;
        };
        return request;
    }

    /**
     * 按Symbol的精简Ticker
     *
     * @param symbol               交易对
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     * @return 按Symbol的精简Ticker
     */
    WebsocketRequest<SymbolMiniTickerEvent> subscribeSymbolMiniTickerEvent(String symbol,
                                                                           SubscriptionListener<SymbolMiniTickerEvent> subscriptionListener,
                                                                           SubscriptionErrorHandler errorHandler) {
        InputChecker.checker()
                .shouldNotNull(symbol, "symbol")
                .shouldNotNull(subscriptionListener, "listener");
        WebsocketRequest<SymbolMiniTickerEvent> request = new WebsocketRequest<>(subscriptionListener, errorHandler);
        request.name = "***Individual Symbol Mini Ticker for " + symbol + "***";
        request.connectionHandler = (connection) -> connection.send(AbstractChannels.miniTickerChannel(symbol));

        request.jsonParser = (jsonWrapper) -> {
            SymbolMiniTickerEvent result = new SymbolMiniTickerEvent();
            result.setEventType(jsonWrapper.getString("e"));
            result.setEventTime(jsonWrapper.getLong("E"));
            result.setSymbol(jsonWrapper.getString("s"));
            result.setOpen(jsonWrapper.getBigDecimal("o"));
            result.setClose(jsonWrapper.getBigDecimal("c"));
            result.setHigh(jsonWrapper.getBigDecimal("h"));
            result.setLow(jsonWrapper.getBigDecimal("l"));
            result.setTotalTradedBaseAssetVolume(jsonWrapper.getBigDecimal("v"));
            result.setTotalTradedQuoteAssetVolume(jsonWrapper.getBigDecimal("q"));
            return result;
        };
        return request;
    }

    /**
     * 全市场的精简Ticker
     *
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     * @return 全市场的精简Ticker
     */
    WebsocketRequest<List<SymbolMiniTickerEvent>> subscribeAllMiniTickerEvent(
            SubscriptionListener<List<SymbolMiniTickerEvent>> subscriptionListener,
            SubscriptionErrorHandler errorHandler) {
        InputChecker.checker()
                .shouldNotNull(subscriptionListener, "listener");
        WebsocketRequest<List<SymbolMiniTickerEvent>> request = new WebsocketRequest<>(subscriptionListener, errorHandler);
        request.name = "***All Market Mini Tickers";
        request.connectionHandler = (connection) -> connection.send(AbstractChannels.miniTickerChannel());

        request.jsonParser = (jsonWrapper) -> {
            List<SymbolMiniTickerEvent> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach(item -> {
                SymbolMiniTickerEvent element = new SymbolMiniTickerEvent();
                element.setEventType(item.getString("e"));
                element.setEventTime(item.getLong("E"));
                element.setSymbol(item.getString("s"));
                element.setOpen(item.getBigDecimal("o"));
                element.setClose(item.getBigDecimal("c"));
                element.setHigh(item.getBigDecimal("h"));
                element.setLow(item.getBigDecimal("l"));
                element.setTotalTradedBaseAssetVolume(item.getBigDecimal("v"));
                element.setTotalTradedQuoteAssetVolume(item.getBigDecimal("q"));
                result.add(element);
            });
            return result;
        };
        return request;
    }

    /**
     * 按Symbol的完整Ticker
     *
     * @param symbol               交易对
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     * @return 全市场的完整Ticker
     */
    WebsocketRequest<SymbolTickerEvent> subscribeSymbolTickerEvent(String symbol,
                                                                   SubscriptionListener<SymbolTickerEvent> subscriptionListener,
                                                                   SubscriptionErrorHandler errorHandler) {
        InputChecker.checker()
                .shouldNotNull(symbol, "symbol")
                .shouldNotNull(subscriptionListener, "listener");
        WebsocketRequest<SymbolTickerEvent> request = new WebsocketRequest<>(subscriptionListener, errorHandler);
        request.name = "***Individual Symbol Ticker for " + symbol + "***";
        request.connectionHandler = (connection) -> connection.send(AbstractChannels.tickerChannel(symbol));

        request.jsonParser = (jsonWrapper) -> {
            SymbolTickerEvent result = new SymbolTickerEvent();
            result.setEventType(jsonWrapper.getString("e"));
            result.setEventTime(jsonWrapper.getLong("E"));
            result.setSymbol(jsonWrapper.getString("s"));
            result.setPriceChange(jsonWrapper.getBigDecimal("p"));
            result.setPriceChangePercent(jsonWrapper.getBigDecimal("P"));
            result.setWeightedAvgPrice(jsonWrapper.getBigDecimal("w"));
            result.setLastPrice(jsonWrapper.getBigDecimal("c"));
            result.setLastQty(jsonWrapper.getBigDecimal("Q"));
            result.setOpen(jsonWrapper.getBigDecimal("o"));
            result.setHigh(jsonWrapper.getBigDecimal("h"));
            result.setLow(jsonWrapper.getBigDecimal("l"));
            result.setTotalTradedBaseAssetVolume(jsonWrapper.getBigDecimal("v"));
            result.setTotalTradedQuoteAssetVolume(jsonWrapper.getBigDecimal("q"));
            result.setOpenTime(jsonWrapper.getLong("O"));
            result.setCloseTime(jsonWrapper.getLong("C"));
            result.setFirstId(jsonWrapper.getLong("F"));
            result.setLastId(jsonWrapper.getLong("L"));
            result.setCount(jsonWrapper.getLong("n"));
            return result;
        };
        return request;
    }

    /**
     * 全市场的完整Ticker
     *
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     * @return 全市场的完整Ticker
     */
    WebsocketRequest<List<SymbolTickerEvent>> subscribeAllTickerEvent(
            SubscriptionListener<List<SymbolTickerEvent>> subscriptionListener,
            SubscriptionErrorHandler errorHandler) {
        InputChecker.checker()
                .shouldNotNull(subscriptionListener, "listener");
        WebsocketRequest<List<SymbolTickerEvent>> request = new WebsocketRequest<>(subscriptionListener, errorHandler);
        request.name = "***All Market Tickers";
        request.connectionHandler = (connection) -> connection.send(AbstractChannels.tickerChannel());

        request.jsonParser = (jsonWrapper) -> {
            List<SymbolTickerEvent> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach(item -> {
                SymbolTickerEvent element = new SymbolTickerEvent();
                element.setEventType(item.getString("e"));
                element.setEventTime(item.getLong("E"));
                element.setSymbol(item.getString("s"));
                element.setPriceChange(item.getBigDecimal("p"));
                element.setPriceChangePercent(item.getBigDecimal("P"));
                element.setWeightedAvgPrice(item.getBigDecimal("w"));
                element.setLastPrice(item.getBigDecimal("c"));
                element.setLastQty(item.getBigDecimal("Q"));
                element.setOpen(item.getBigDecimal("o"));
                element.setHigh(item.getBigDecimal("h"));
                element.setLow(item.getBigDecimal("l"));
                element.setTotalTradedBaseAssetVolume(item.getBigDecimal("v"));
                element.setTotalTradedQuoteAssetVolume(item.getBigDecimal("q"));
                element.setOpenTime(item.getLong("O"));
                element.setCloseTime(item.getLong("C"));
                element.setFirstId(item.getLong("F"));
                element.setLastId(item.getLong("L"));
                element.setCount(item.getLong("n"));
                result.add(element);
            });

            return result;
        };
        return request;
    }

    /**
     * 按Symbol的最优挂单信息
     *
     * @param symbol               交易对
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     * @return 按Symbol的最优挂单信息
     */
    WebsocketRequest<SymbolBookTickerEvent> subscribeSymbolBookTickerEvent(String symbol,
                                                                           SubscriptionListener<SymbolBookTickerEvent> subscriptionListener,
                                                                           SubscriptionErrorHandler errorHandler) {
        InputChecker.checker()
                .shouldNotNull(symbol, "symbol")
                .shouldNotNull(subscriptionListener, "listener");
        WebsocketRequest<SymbolBookTickerEvent> request = new WebsocketRequest<>(subscriptionListener, errorHandler);
        request.name = "***Individual Symbol Book Ticker for " + symbol + "***";
        request.connectionHandler = (connection) -> connection.send(AbstractChannels.bookTickerChannel(symbol));

        request.jsonParser = (jsonWrapper) -> {
            SymbolBookTickerEvent result = new SymbolBookTickerEvent();
            result.setEventType(jsonWrapper.getString("e"));
            result.setOrderBookUpdateId(jsonWrapper.getLong("u"));
            result.setEventTime(jsonWrapper.getLong("E"));
            result.setTime(jsonWrapper.getLong("T"));
            result.setSymbol(jsonWrapper.getString("s"));
            result.setBestBidPrice(jsonWrapper.getBigDecimal("b"));
            result.setBestBidQty(jsonWrapper.getBigDecimal("B"));
            result.setBestAskPrice(jsonWrapper.getBigDecimal("a"));
            result.setBestAskQty(jsonWrapper.getBigDecimal("A"));
            return result;
        };
        return request;
    }

    /**
     * 全市场最优挂单信息
     *
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     * @return 全市场最优挂单信息
     */
    WebsocketRequest<SymbolBookTickerEvent> subscribeAllBookTickerEvent(
            SubscriptionListener<SymbolBookTickerEvent> subscriptionListener,
            SubscriptionErrorHandler errorHandler) {
        InputChecker.checker()
                .shouldNotNull(subscriptionListener, "listener");
        WebsocketRequest<SymbolBookTickerEvent> request = new WebsocketRequest<>(subscriptionListener, errorHandler);
        request.name = "***All Market Book Tickers***";
        request.connectionHandler = (connection) -> connection.send(AbstractChannels.bookTickerChannel());

        request.jsonParser = (jsonWrapper) -> {
            SymbolBookTickerEvent result = new SymbolBookTickerEvent();
            result.setEventType(jsonWrapper.getString("e"));
            result.setOrderBookUpdateId(jsonWrapper.getLong("u"));
            result.setEventTime(jsonWrapper.getLong("E"));
            result.setTime(jsonWrapper.getLong("T"));
            result.setSymbol(jsonWrapper.getString("s"));
            result.setBestBidPrice(jsonWrapper.getBigDecimal("b"));
            result.setBestBidQty(jsonWrapper.getBigDecimal("B"));
            result.setBestAskPrice(jsonWrapper.getBigDecimal("a"));
            result.setBestAskQty(jsonWrapper.getBigDecimal("A"));
            return result;
        };
        return request;
    }

    /**
     * 强平订单
     *
     * @param symbol               交易对
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     * @return 推送特定symbol的强平订单信息
     */
    WebsocketRequest<LiquidationOrderEvent> subscribeSymbolLiquidationOrderEvent(String symbol,
                                                                                 SubscriptionListener<LiquidationOrderEvent> subscriptionListener,
                                                                                 SubscriptionErrorHandler errorHandler) {
        InputChecker.checker()
                .shouldNotNull(symbol, "symbol")
                .shouldNotNull(subscriptionListener, "listener");
        WebsocketRequest<LiquidationOrderEvent> request = new WebsocketRequest<>(subscriptionListener, errorHandler);
        request.name = "***Individual Symbol Liquidation Order for " + symbol + "***";
        request.connectionHandler = (connection) -> connection.send(AbstractChannels.liquidationOrderChannel(symbol));

        request.jsonParser = (jsonWrapper) -> {
            LiquidationOrderEvent result = new LiquidationOrderEvent();
            result.setEventType(jsonWrapper.getString("e"));
            result.setEventTime(jsonWrapper.getLong("E"));
            JsonWrapper jsondata = jsonWrapper.getJsonObject("o");
            result.setSymbol(jsondata.getString("s"));
            result.setSide(jsondata.getString("S"));
            result.setType(jsondata.getString("o"));
            result.setTimeInForce(jsondata.getString("f"));
            result.setOrigQty(jsondata.getBigDecimal("q"));
            result.setPrice(jsondata.getBigDecimal("p"));
            result.setAveragePrice(jsondata.getBigDecimal("ap"));
            result.setOrderStatus(jsondata.getString("X"));
            result.setLastFilledQty(jsondata.getBigDecimal("l"));
            result.setLastFilledAccumulatedQty(jsondata.getBigDecimal("z"));
            result.setTime(jsondata.getLong("T"));
            return result;
        };
        return request;
    }

    /**
     * 全市场强平订单
     *
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     * @return 全市场强平订单
     */
    WebsocketRequest<LiquidationOrderEvent> subscribeAllLiquidationOrderEvent(
            SubscriptionListener<LiquidationOrderEvent> subscriptionListener,
            SubscriptionErrorHandler errorHandler) {
        InputChecker.checker()
                .shouldNotNull(subscriptionListener, "listener");
        WebsocketRequest<LiquidationOrderEvent> request = new WebsocketRequest<>(subscriptionListener, errorHandler);
        request.name = "***All Liquidation Orders***";
        request.connectionHandler = (connection) -> connection.send(AbstractChannels.liquidationOrderChannel());

        request.jsonParser = (jsonWrapper) -> {
            LiquidationOrderEvent result = new LiquidationOrderEvent();
            result.setEventType(jsonWrapper.getString("e"));
            result.setEventTime(jsonWrapper.getLong("E"));
            JsonWrapper jsondata = jsonWrapper.getJsonObject("o");
            result.setSymbol(jsondata.getString("s"));
            result.setSide(jsondata.getString("S"));
            result.setType(jsondata.getString("o"));
            result.setTimeInForce(jsondata.getString("f"));
            result.setOrigQty(jsondata.getBigDecimal("q"));
            result.setPrice(jsondata.getBigDecimal("p"));
            result.setAveragePrice(jsondata.getBigDecimal("ap"));
            result.setOrderStatus(jsondata.getString("X"));
            result.setLastFilledQty(jsondata.getBigDecimal("l"));
            result.setLastFilledAccumulatedQty(jsondata.getBigDecimal("z"));
            result.setTime(jsondata.getLong("T"));
            return result;
        };
        return request;
    }

    /**
     * 有限档深度信息
     *
     * @param symbol               交易对
     * @param limit                档
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     * @return 有限档深度信息
     */
    WebsocketRequest<OrderBookEvent> subscribeBookDepthEvent(String symbol, Integer limit,
                                                             SubscriptionListener<OrderBookEvent> subscriptionListener,
                                                             SubscriptionErrorHandler errorHandler) {
        InputChecker.checker()
                .shouldNotNull(symbol, "symbol")
                .shouldNotNull(limit, "limit")
                .shouldNotNull(subscriptionListener, "listener");
        WebsocketRequest<OrderBookEvent> request = new WebsocketRequest<>(subscriptionListener, errorHandler);
        request.name = "***Partial Book Depth for " + symbol + "***";
        request.connectionHandler = (connection) -> connection.send(AbstractChannels.bookDepthChannel(symbol, limit));

        request.jsonParser = (jsonWrapper) -> {
            OrderBookEvent result = new OrderBookEvent();
            result.setEventType(jsonWrapper.getString("e"));
            result.setEventTime(jsonWrapper.getLong("E"));
            result.setTransactionTime(jsonWrapper.getLong("T"));
            result.setSymbol(jsonWrapper.getString("s"));
            result.setFirstUpdateId(jsonWrapper.getLong("U"));
            result.setLastUpdateId(jsonWrapper.getLong("u"));
            result.setLastUpdateIdInlastStream(jsonWrapper.getLong("pu"));

            List<OrderBookEntry> elementList = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("b");
            dataArray.forEachAsArray((item) -> {
                OrderBookEntry element = new OrderBookEntry();
                element.setPrice(item.getBigDecimalAt(0));
                element.setQty(item.getBigDecimalAt(1));
                elementList.add(element);
            });
            result.setBids(elementList);

            List<OrderBookEntry> askList = new LinkedList<>();
            JsonWrapperArray askArray = jsonWrapper.getJsonArray("a");
            askArray.forEachAsArray((item) -> {
                OrderBookEntry element = new OrderBookEntry();
                element.setPrice(item.getBigDecimalAt(0));
                element.setQty(item.getBigDecimalAt(1));
                askList.add(element);
            });
            result.setAsks(askList);

            return result;
        };
        return request;
    }

    /**
     * 增量深度信息
     *
     * @param symbol               交易对
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     * @return 增量深度信息
     */
    WebsocketRequest<OrderBookEvent> subscribeDiffDepthEvent(String symbol,
                                                             SubscriptionListener<OrderBookEvent> subscriptionListener,
                                                             SubscriptionErrorHandler errorHandler) {
        InputChecker.checker()
                .shouldNotNull(symbol, "symbol")
                .shouldNotNull(subscriptionListener, "listener");
        WebsocketRequest<OrderBookEvent> request = new WebsocketRequest<>(subscriptionListener, errorHandler);
        request.name = "***Partial Book Depth for " + symbol + "***";
        request.connectionHandler = (connection) -> connection.send(AbstractChannels.diffDepthChannel(symbol));

        request.jsonParser = (jsonWrapper) -> {
            OrderBookEvent result = new OrderBookEvent();
            result.setEventType(jsonWrapper.getString("e"));
            result.setEventTime(jsonWrapper.getLong("E"));
            result.setTransactionTime(jsonWrapper.getLong("T"));
            result.setSymbol(jsonWrapper.getString("s"));
            result.setFirstUpdateId(jsonWrapper.getLong("U"));
            result.setLastUpdateId(jsonWrapper.getLong("u"));
            result.setLastUpdateIdInlastStream(jsonWrapper.getLong("pu"));

            List<OrderBookEntry> elementList = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("b");
            dataArray.forEachAsArray((item) -> {
                OrderBookEntry element = new OrderBookEntry();
                element.setPrice(item.getBigDecimalAt(0));
                element.setQty(item.getBigDecimalAt(1));
                elementList.add(element);
            });
            result.setBids(elementList);

            List<OrderBookEntry> askList = new LinkedList<>();
            JsonWrapperArray askArray = jsonWrapper.getJsonArray("a");
            askArray.forEachAsArray((item) -> {
                OrderBookEntry element = new OrderBookEntry();
                element.setPrice(item.getBigDecimalAt(0));
                element.setQty(item.getBigDecimalAt(1));
                askList.add(element);
            });
            result.setAsks(askList);

            return result;
        };
        return request;
    }

    /**
     * 账户信息有变动时，会推送此事件
     *
     * @param listenKey            listenKey
     * @param subscriptionListener 订阅
     * @param errorHandler         如果订阅失败，将调用错误处理程序或客户端和Binance服务器之间发生错误。
     * @return 账户信息变动
     */
    WebsocketRequest<UserDataUpdateEvent> subscribeUserDataEvent(String listenKey,
                                                                 SubscriptionListener<UserDataUpdateEvent> subscriptionListener,
                                                                 SubscriptionErrorHandler errorHandler) {
        InputChecker.checker()
                .shouldNotNull(listenKey, "listenKey")
                .shouldNotNull(subscriptionListener, "listener");
        WebsocketRequest<UserDataUpdateEvent> request = new WebsocketRequest<>(subscriptionListener, errorHandler);
        request.name = "***User Data***";
        request.connectionHandler = (connection) -> connection.send(AbstractChannels.userDataChannel(listenKey));

        request.jsonParser = (jsonWrapper) -> {
            UserDataUpdateEvent result = new UserDataUpdateEvent();
            result.setEventType(jsonWrapper.getString("e"));
            result.setEventTime(jsonWrapper.getLong("E"));

            if (jsonWrapper.containKey("T")) {
                result.setTransactionTime(jsonWrapper.getLong("T"));
            }

            if ("ACCOUNT_UPDATE".equals(jsonWrapper.getString("e"))) {
                AccountUpdate accountUpdate = new AccountUpdate();

                List<BalanceUpdate> balanceList = new LinkedList<>();
                JsonWrapperArray dataArray = jsonWrapper.getJsonObject("a").getJsonArray("B");
                dataArray.forEach(item -> {
                    BalanceUpdate balance = new BalanceUpdate();
                    balance.setAsset(item.getString("a"));
                    balance.setWalletBalance(item.getBigDecimal("wb"));
                    balanceList.add(balance);
                });
                accountUpdate.setBalances(balanceList);

                List<PositionUpdate> positionList = new LinkedList<>();
                JsonWrapperArray datalist = jsonWrapper.getJsonObject("a").getJsonArray("P");
                datalist.forEach(item -> {
                    PositionUpdate position = new PositionUpdate();
                    position.setSymbol(item.getString("s"));
                    position.setAmount(item.getBigDecimal("pa"));
                    position.setEntryPrice(item.getBigDecimal("ep"));
                    position.setPreFee(item.getBigDecimal("cr"));
                    position.setUnrealizedPnl(item.getBigDecimal("up"));
                    positionList.add(position);
                });
                accountUpdate.setPositions(positionList);

                result.setAccountUpdate(accountUpdate);

            } else if ("ORDER_TRADE_UPDATE".equals(jsonWrapper.getString("e"))) {
                OrderUpdate orderUpdate = new OrderUpdate();
                JsonWrapper jsonObject = jsonWrapper.getJsonObject("o");
                orderUpdate.setSymbol(jsonObject.getString("s"));
                orderUpdate.setClientOrderId(jsonObject.getString("c"));
                orderUpdate.setSide(jsonObject.getString("S"));
                orderUpdate.setType(jsonObject.getString("o"));
                orderUpdate.setTimeInForce(jsonObject.getString("f"));
                orderUpdate.setOrigQty(jsonObject.getBigDecimal("q"));
                orderUpdate.setPrice(jsonObject.getBigDecimal("p"));
                orderUpdate.setAvgPrice(jsonObject.getBigDecimal("ap"));
                orderUpdate.setStopPrice(jsonObject.getBigDecimal("sp"));
                orderUpdate.setExecutionType(jsonObject.getString("x"));
                orderUpdate.setOrderStatus(jsonObject.getString("X"));
                orderUpdate.setOrderId(jsonObject.getLong("i"));
                orderUpdate.setLastFilledQty(jsonObject.getBigDecimal("l"));
                orderUpdate.setCumulativeFilledQty(jsonObject.getBigDecimal("z"));
                orderUpdate.setLastFilledPrice(jsonObject.getBigDecimal("L"));
                //    "N":"USDT",             // Commission Asset, will not push if no commission
                orderUpdate.setCommissionAsset(jsonObject.getStringOrDefault("N", null));
                //    "n":"0",                // Commission, will not push if no commission
                orderUpdate.setCommissionAmount(jsonObject.getBigDecimalOrDefault("n", null));
                orderUpdate.setOrderTradeTime(jsonObject.getLong("T"));
                orderUpdate.setTradeID(jsonObject.getLong("t"));
                orderUpdate.setBidsNotional(jsonObject.getBigDecimal("b"));
                orderUpdate.setAsksNotional(jsonObject.getBigDecimal("a"));
                orderUpdate.setIsMarkerSide(jsonObject.getBoolean("m"));
                orderUpdate.setIsReduceOnly(jsonObject.getBoolean("R"));
                orderUpdate.setWorkingType(jsonObject.getString("wt"));
                result.setOrderUpdate(orderUpdate);
            }

            return result;
        };
        return request;
    }

}
