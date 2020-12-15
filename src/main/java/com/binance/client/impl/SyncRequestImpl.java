package com.binance.client.impl;

import com.alibaba.fastjson.JSONObject;
import com.binance.client.SyncRequestClient;
import com.binance.client.model.ResponseResult;
import com.binance.client.model.enums.*;
import com.binance.client.model.market.*;
import com.binance.client.model.trade.*;

import java.util.List;

/**
 * @author xingyu
 */
public class SyncRequestImpl implements SyncRequestClient {

    private final RestApiRequestImpl requestImpl;

    SyncRequestImpl(RestApiRequestImpl requestImpl) {
        this.requestImpl = requestImpl;
    }


    /**
     * 获取当前的交易所交易规则和交易品种信息。
     *
     * @return 当前的交易所交易规则和代码信息。
     */
    @Override
    public ExchangeInformation getExchangeInformation() {
        return AbstractRestApiInvoker.callSync(requestImpl.getExchangeInformation());
    }

    /**
     * 获取订单。
     *
     * @return Order book.
     */
    @Override
    public OrderBook getOrderBook(String symbol, Integer limit) {
        return AbstractRestApiInvoker.callSync(requestImpl.getOrderBook(symbol, limit));
    }

    /**
     * 获取最近的交易。
     *
     * @return Recent trades.
     */
    @Override
    public List<Trade> getRecentTrades(String symbol, Integer limit) {
        return AbstractRestApiInvoker.callSync(requestImpl.getRecentTrades(symbol, limit));
    }

    /**
     * 查询历史成交(需要有效的API-KEY)
     *
     * @param symbol YES	交易对
     * @param limit  NO	默认值:500 最大值:1000.
     * @param fromId NO	从哪一条成交id开始返回. 缺省返回最近的成交记录
     * @return List<Trade>
     */
    @Override
    public List<Trade> getOldTrades(String symbol, Integer limit, Long fromId) {
        return AbstractRestApiInvoker.callSync(requestImpl.getOldTrades(symbol, limit, fromId));
    }

    /**
     * 近期成交(归集)
     *
     * @param symbol    YES	交易对
     * @param fromId    NO	从包含fromID的成交开始返回结果
     * @param startTime NO	从该时刻之后的成交记录开始返回结果
     * @param endTime   NO	返回该时刻为止的成交记录
     * @param limit     NO	默认 500; 最大 1000.
     * @return 近期成交(归集)
     */
    @Override
    public List<AggregateTrade> getAggregateTrades(String symbol, Long fromId, Long startTime,
                                                   Long endTime, Integer limit) {
        return AbstractRestApiInvoker.callSync(requestImpl.getAggregateTrades(symbol, fromId, startTime, endTime, limit));
    }

    /**
     * K线数据
     *
     * @param symbol    YES	交易对
     * @param interval  YES	时间间隔
     * @param startTime NO	起始时间
     * @param endTime   NO	结束时间
     * @param limit     NO	默认值:500 最大值:1500
     * @return K线数据
     */
    @Override
    public List<Candlestick> getCandlestick(String symbol, CandlestickInterval interval, Long startTime,
                                            Long endTime, Integer limit) {
        return AbstractRestApiInvoker.callSync(requestImpl.getCandlestick(symbol, interval, startTime, endTime, limit));
    }

    /**
     * 最新标记价格和资金费率
     *
     * @param symbol NO	交易对
     * @return 采集各大交易所数据加权平均
     */
    @Override
    public List<MarkPrice> getMarkPrice(String symbol) {
        return AbstractRestApiInvoker.callSync(requestImpl.getMarkPrice(symbol));
    }

    /**
     * 查询资金费率历史
     * 如果 startTime 和 endTime 都未发送, 返回最近 limit 条数据.
     * 如果 startTime 和 endTime 之间的数据量大于 limit, 返回 startTime + limit情况下的数据。
     *
     * @param symbol    YES	交易对
     * @param startTime NO	起始时间
     * @param endTime   NO	结束时间
     * @param limit     NO	默认值:100 最大值:1000
     * @return 资金费率历史
     */
    @Override
    public List<FundingRate> getFundingRate(String symbol, Long startTime, Long endTime, Integer limit) {
        return AbstractRestApiInvoker.callSync(requestImpl.getFundingRate(symbol, startTime, endTime, limit));
    }

    /**
     * 24hr价格变动情况
     * 请注意，不携带symbol参数会返回全部交易对数据，不仅数据庞大，而且权重极高
     *
     * @param symbol 交易对
     * @return PriceChangeTicker
     */
    @Override
    public List<PriceChangeTicker> get24hrTickerPriceChange(String symbol) {
        return AbstractRestApiInvoker.callSync(requestImpl.get24hrTickerPriceChange(symbol));
    }

    /**
     * 最新价格
     * 不发送交易对参数，则会返回所有交易对信息
     *
     * @param symbol NO	交易对
     * @return 返回最近价格
     */
    @Override
    public List<SymbolPrice> getSymbolPriceTicker(String symbol) {
        return AbstractRestApiInvoker.callSync(requestImpl.getSymbolPriceTicker(symbol));
    }

    /**
     * 当前最优挂单
     *
     * @param symbol NO 交易对
     * @return 返回当前最优的挂单(最高买单 ， 最低卖单)
     */
    @Override
    public List<SymbolOrderBook> getSymbolOrderBookTicker(String symbol) {
        return AbstractRestApiInvoker.callSync(requestImpl.getSymbolOrderBookTicker(symbol));
    }

    /**
     * 获取市场强平订单
     * 如果不提供symbol,返回全市场强平订单。
     *
     * @param symbol    NO	交易对
     * @param startTime NO	起始时间
     * @param endTime   NO	结束时间,默认当前时间
     * @param limit     NO	从endTime倒推算起的数据条数，默认值:100 最大值:1000
     * @return 市场强平订单
     */
    @Override
    public List<LiquidationOrder> getLiquidationOrders(String symbol, Long startTime, Long endTime, Integer limit) {
        return AbstractRestApiInvoker.callSync(requestImpl.getLiquidationOrders(symbol, startTime, endTime, limit));
    }

    /**
     * 获取未平仓合约数
     *
     * @param symbol NO	交易对
     * @return 获取未平仓合约数
     */
    @Override
    public OpenInterest getOpenInterest(String symbol) {
        return AbstractRestApiInvoker.callSync(requestImpl.getOpenInterest(symbol));
    }

    /**
     * 批量下单 (TRADE)
     * 其中batchOrders应以list of JSON格式填写订单参数
     *
     * @param batchOrders YES	订单列表，最多支持5个订单
     * @return 批量下单
     */
    @Override
    public List<Object> postBatchOrders(String batchOrders) {
        return AbstractRestApiInvoker.callSync(requestImpl.postBatchOrders(batchOrders));
    }

    /**
     * 下单 (TRADE)
     *
     * @param symbol           YES	交易对
     * @param side             YES	买卖方向 SELL, BUY
     * @param positionSide     NO	持仓方向，单向持仓模式下非必填，默认且仅可填BOTH;在双向持仓模式下必填,且仅可选择 LONG 或 SHORT
     * @param orderType        YES	订单类型 LIMIT, MARKET, STOP, TAKE_PROFIT, STOP_MARKET, TAKE_PROFIT_MARKET, TRAILING_STOP_MARKET
     * @param timeInForce      NO	有效方法
     * @param quantity         NO	下单数量,使用closePosition不支持此参数。
     * @param price            NO	委托价格
     * @param reduceOnly       NO	true, false; 非双开模式下默认false；双开模式下不接受此参数； 使用closePosition不支持此参数。
     * @param newClientOrderId NO	用户自定义的订单号，不可以重复出现在挂单中。如空缺系统会自动赋值
     * @param stopPrice        NO	触发价, 仅 STOP, STOP_MARKET, TAKE_PROFIT, TAKE_PROFIT_MARKET 需要此参数
     * @param workingType      NO	stopPrice 触发类型: MARK_PRICE(标记价格), CONTRACT_PRICE(合约最新价). 默认 CONTRACT_PRICE
     * @param newOrderRespType NO	"ACK", "RESULT", 默认 "ACK"
     * @return 下单
     */
    @Override
    public Order postOrder(String symbol, OrderSide side, PositionSide positionSide, OrderType orderType,
                           TimeInForce timeInForce, String quantity, String price, String reduceOnly,
                           String newClientOrderId, String stopPrice, WorkingType workingType, NewOrderRespType newOrderRespType) {
        return AbstractRestApiInvoker.callSync(requestImpl.postOrder(symbol, side, positionSide, orderType,
                timeInForce, quantity, price, reduceOnly,
                newClientOrderId, stopPrice, workingType, newOrderRespType));
    }

    /**
     * 撤销订单 (TRADE)
     *
     * @param symbol            YES	交易对
     * @param orderId           NO	系统订单号
     * @param origClientOrderId NO	用户自定义的订单号
     * @return 撤销订单
     */
    @Override
    public Order cancelOrder(String symbol, Long orderId, String origClientOrderId) {
        return AbstractRestApiInvoker.callSync(requestImpl.cancelOrder(symbol, orderId, origClientOrderId));
    }

    /**
     * 撤销全部订单 (TRADE)
     * orderId 与 origClientOrderId 必须至少发送一个
     *
     * @param symbol YES	交易对
     * @return 撤销全部订单
     */
    @Override
    public ResponseResult cancelAllOpenOrder(String symbol) {
        return AbstractRestApiInvoker.callSync(requestImpl.cancelAllOpenOrder(symbol));
    }

    /**
     * 批量撤销订单 (TRADE)
     * orderIdList 与 origClientOrderIdList 必须至少发送一个，不可同时发送
     *
     * @param symbol                YES	交易对
     * @param orderIdList           NO	系统订单号, 最多支持10个订单
     *                              比如[1234567,2345678]
     * @param origClientOrderIdList NO	用户自定义的订单号, 最多支持10个订单
     *                              比如["my_id_1","my_id_2"] 需要encode双引号。逗号后面没有空格。
     * @return 批量撤销订单
     */
    @Override
    public List<Object> batchCancelOrders(String symbol, String orderIdList, String origClientOrderIdList) {
        return AbstractRestApiInvoker.callSync(requestImpl.batchCancelOrders(symbol, orderIdList, origClientOrderIdList));
    }

    /**
     * 更改持仓模式(TRADE)
     *
     * @param dual YES	"true": 双向持仓模式；"false": 单向持仓模式
     * @return 持仓模式
     */
    @Override
    public ResponseResult changePositionSide(boolean dual) {
        return AbstractRestApiInvoker.callSync(requestImpl.changePositionSide(dual));
    }

    /**
     * 变换逐全仓模式 (TRADE)
     *
     * @param symbol     YES	交易对
     * @param marginType YES	保证金模式 ISOLATED(逐仓), CROSSED(全仓
     * @return 逐全仓模式
     */
    @Override
    public ResponseResult changeMarginType(String symbol, String marginType) {
        return AbstractRestApiInvoker.callSync(requestImpl.changeMarginType(symbol, marginType));
    }

    /**
     * 调整逐仓保证金 (TRADE)
     *
     * @param symbol       YES	交易对
     * @param type         YES	调整方向 1: 增加逐仓保证金，2: 减少逐仓保证金
     * @param amount       YES	保证金资金
     * @param positionSide NO	持仓方向，单向持仓模式下非必填，默认且仅可填BOTH;在双向持仓模式下必填,且仅可选择 LONG 或 SHORT
     * @return 调整逐仓保证金
     */
    @Override
    public JSONObject addIsolatedPositionMargin(String symbol, int type, String amount, PositionSide positionSide) {
        return AbstractRestApiInvoker.callSync(requestImpl.addPositionMargin(symbol, type, amount, positionSide));
    }

    /**
     * 逐仓保证金变动历史 (TRADE)
     *
     * @param symbol    YES	交易对
     * @param type      YES	调整方向 1: 增加逐仓保证金，2: 减少逐仓保证金
     * @param startTime NO	起始时间
     * @param endTime   NO	结束时间
     * @param limit     NO	返回的结果集数量 默认值: 500
     * @return 保证金变动历史
     */
    @Override
    public List<WalletDeltaLog> getPositionMarginHistory(String symbol, int type, long startTime, long endTime, int limit) {
        return AbstractRestApiInvoker.callSync(requestImpl.getPositionMarginHistory(symbol, type, startTime, endTime, limit));
    }

    /**
     * 查询持仓模式(需要有效的API-KEY)
     *
     * @return 持仓模式
     */
    @Override
    public JSONObject getPositionSide() {
        return AbstractRestApiInvoker.callSync(requestImpl.getPositionSide());
    }

    /**
     * 查询订单 (需要有效的API-KEY)
     *
     * @param symbol            YES	交易对
     * @param orderId           NO	系统订单号
     * @param origClientOrderId NO	用户自定义的订单号
     * @return 订单
     */
    @Override
    public Order getOrder(String symbol, Long orderId, String origClientOrderId) {
        return AbstractRestApiInvoker.callSync(requestImpl.getOrder(symbol, orderId, origClientOrderId));
    }

    /**
     * 查看当前全部挂单 (需要有效的API-KEY)
     *
     * @param symbol NO	交易对
     * @return 全部挂单
     */
    @Override
    public List<Order> getOpenOrders(String symbol) {
        return AbstractRestApiInvoker.callSync(requestImpl.getOpenOrders(symbol));
    }

    /**
     * 查询所有订单(包括历史订单) (需要有效的API-KEY)
     *
     * @param symbol    YES 交易对
     * @param orderId   NO 只返回此orderID及之后的订单，缺省返回最近的订单
     * @param startTime NO 起始时间
     * @param endTime   NO 结束时间
     * @param limit     NO	default 30, max 500
     * @return 所有订单
     */
    @Override
    public List<Order> getAllOrders(String symbol, Long orderId, Long startTime, Long endTime, Integer limit) {
        return AbstractRestApiInvoker.callSync(requestImpl.getAllOrders(symbol, orderId, startTime, endTime, limit));
    }

    /**
     * 账户余额V2 (需要有效的API-KEY)
     *
     * @return 账户余额V2 (需要有效的API-KEY)
     */
    @Override
    public List<AccountBalance> getBalance() {
        return AbstractRestApiInvoker.callSync(requestImpl.getBalance());
    }

    @Override
    public AccountInformation getAccountInformation() {
        return AbstractRestApiInvoker.callSync(requestImpl.getAccountInformation());
    }

    /**
     * 账户信息V2 (需要有效的API-KEY)
     *
     * @return 账户信息
     */
    @Override
    public AccountInformationV2 getAccountInformationV2() {
        return AbstractRestApiInvoker.callSync(requestImpl.getAccountInformationV2());
    }

    /**
     * 调整开仓杠杆 (TRADE)
     *
     * @param symbol   YES	交易对
     * @param leverage YES	目标杠杆倍数：1 到 125 整数
     * @return 开仓杠杆
     */
    @Override
    public Leverage changeInitialLeverage(String symbol, Integer leverage) {
        return AbstractRestApiInvoker.callSync(requestImpl.changeInitialLeverage(symbol, leverage));
    }

    /**
     * 用户持仓风险
     *
     * @return 用户持仓风险
     */
    @Override
    public List<PositionRisk> getPositionRisk() {
        return AbstractRestApiInvoker.callSync(requestImpl.getPositionRisk());
    }

    /**
     * 用户持仓风险V2
     *
     * @return 用户持仓风险
     */
    @Override
    public List<PositionRiskV2> getPositionRiskV2() {
        return AbstractRestApiInvoker.callSync(requestImpl.getPositionRiskV2());
    }

    /**
     * 账户成交历史 (需要有效的API-KEY)
     *
     * @param symbol    YES 交易对
     * @param startTime NO
     * @param endTime   NO
     * @param fromId    NO	返回该fromId及之后的成交，缺省返回最近的成交
     * @param limit     NO	default 30, max 500
     * @return 账户成交历史
     */
    @Override
    public List<MyTrade> getAccountTrades(String symbol, Long startTime, Long endTime, Long fromId, Integer limit) {
        return AbstractRestApiInvoker.callSync(requestImpl.getAccountTrades(symbol, startTime, endTime, fromId, limit));
    }

    /**
     * 获取账户损益资金流水(需要有效的API-KEY)
     * 如果incomeType没有发送，返回所有类型账户损益资金流水。
     *
     * @param symbol     YES 交易对
     * @param incomeType YES	资金流类型
     * @param startTime  NO
     * @param endTime    NO
     * @param limit      NO	default 30, max 500
     * @return 损益资金流水
     */
    @Override
    public List<Income> getIncomeHistory(String symbol, IncomeType incomeType, Long startTime, Long endTime, Integer limit) {
        return AbstractRestApiInvoker.callSync(requestImpl.getIncomeHistory(symbol, incomeType, startTime, endTime, limit));
    }

    /**
     * 生成listenKey (需要有效的API-KEY)
     * 创建一个新的user data stream，返回值为一个listenKey，即websocket订阅的stream名称。
     * 如果该帐户具有有效的listenKey，则将返回该listenKey并将其有效期延长60分钟。
     *
     * @return 生成
     */
    @Override
    public String startUserDataStream() {
        return AbstractRestApiInvoker.callSync(requestImpl.startUserDataStream());
    }

    /**
     * 延长listenKey有效期 (需要有效的API-KEY)
     *
     * @param listenKey listenKey
     * @return 有效期延长至本次调用后60分钟
     */
    @Override
    public String keepUserDataStream(String listenKey) {
        return AbstractRestApiInvoker.callSync(requestImpl.keepUserDataStream(listenKey));
    }

    /**
     * 关闭listenKey (需要有效的API-KEY)
     *
     * @param listenKey listenKey
     * @return 关闭某账户数据流
     */
    @Override
    public String closeUserDataStream(String listenKey) {
        return AbstractRestApiInvoker.callSync(requestImpl.closeUserDataStream(listenKey));
    }

    /**
     * 合约持仓量
     *
     * @param symbol    YES 交易对
     * @param period    YES	"5m","15m","30m","1h","2h","4h","6h","12h","1d"
     * @param startTime NO
     * @param endTime   NO
     * @param limit     NO	default 30, max 500
     * @return 合约持仓量
     */
    @Override
    public List<OpenInterestStat> getOpenInterestStat(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return AbstractRestApiInvoker.callSync(requestImpl.getOpenInterestStat(symbol, period, startTime, endTime, limit));
    }

    /**
     * 大户账户数多空比
     *
     * @param symbol    YES 交易对
     * @param period    YES	"5m","15m","30m","1h","2h","4h","6h","12h","1d"
     * @param startTime NO
     * @param endTime   NO
     * @param limit     NO	default 30, max 500
     * @return 大户账户数多空比
     */
    @Override
    public List<CommonLongShortRatio> getTopTraderAccountRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return AbstractRestApiInvoker.callSync(requestImpl.getTopTraderAccountRatio(symbol, period, startTime, endTime, limit));
    }

    /**
     * 大户持仓量多空比
     *
     * @param symbol    YES 交易对
     * @param period    YES	"5m","15m","30m","1h","2h","4h","6h","12h","1d"
     * @param startTime NO
     * @param endTime   NO
     * @param limit     NO	default 30, max 500
     * @return 大户持仓量多空比
     */
    @Override
    public List<CommonLongShortRatio> getTopTraderPositionRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return AbstractRestApiInvoker.callSync(requestImpl.getTopTraderPositionRatio(symbol, period, startTime, endTime, limit));
    }

    /**
     * 多空持仓人数比
     *
     * @param symbol    YES 交易对
     * @param period    YES	"5m","15m","30m","1h","2h","4h","6h","12h","1d"
     * @param startTime NO
     * @param endTime   NO
     * @param limit     NO	default 30, max 500
     * @return 多空持仓人数比
     */
    @Override
    public List<CommonLongShortRatio> getGlobalAccountRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return AbstractRestApiInvoker.callSync(requestImpl.getGlobalAccountRatio(symbol, period, startTime, endTime, limit));
    }

    /**
     * 合约主动买卖量
     *
     * @param symbol    YES 交易对
     * @param period    YES	"5m","15m","30m","1h","2h","4h","6h","12h","1d"
     * @param startTime NO
     * @param endTime   NO
     * @param limit     NO	default 30, max 500
     * @return 合约主动买卖量
     */
    @Override
    public List<TakerLongShortStat> getTakerLongShortRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return AbstractRestApiInvoker.callSync(requestImpl.getTakerLongShortRatio(symbol, period, startTime, endTime, limit));
    }
}
