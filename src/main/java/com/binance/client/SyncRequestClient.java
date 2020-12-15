package com.binance.client;

import com.alibaba.fastjson.JSONObject;
import com.binance.client.impl.BinanceApiInternalFactory;
import com.binance.client.model.ResponseResult;
import com.binance.client.model.enums.*;
import com.binance.client.model.market.*;
import com.binance.client.model.trade.*;

import java.util.List;

/**
 * 同步请求接口，通过同步调用Binance RestAPI方法。
 * 此接口中的所有方法将被阻止，直到RestAPI响应。
 * 如果调用失败或超时，则将被抛出.
 * {@link com.binance.client.exception.BinanceApiException}
 *
 * @author xingyu
 */
public interface SyncRequestClient {

    /**
     * 创建同步客户端。 同步客户端中定义的所有接口
     * 由同步模式实现。
     *
     * @return 同步客户端的实例。
     */
    static SyncRequestClient create() {
        return create("", "", new RequestOptions());
    }

    /**
     * 创建同步客户端。 同步客户端中定义的所有接口
     * 由同步模式实现。
     *
     * @param apiKey    The public key applied from binance.
     * @param secretKey The private key applied from binance.
     * @return The instance of synchronous client.
     */
    static SyncRequestClient create(String apiKey, String secretKey) {
        return BinanceApiInternalFactory.getInstance().createSyncRequestClient(apiKey, secretKey, new RequestOptions());
    }

    /**
     * 创建同步客户端。 同步客户端中定义的所有接口
     * 由同步模式实现。
     *
     * @param apiKey    The public key applied from binance.
     * @param secretKey The private key applied from binance.
     * @param options   The request option.
     * @return The instance of synchronous client.
     */
    static SyncRequestClient create(String apiKey, String secretKey, RequestOptions options) {
        return BinanceApiInternalFactory.getInstance().createSyncRequestClient(apiKey, secretKey, options);
    }


    /**
     * 获取当前的交易所交易规则和交易品种信息。
     *
     * @return 当前的交易所交易规则和代码信息。
     */
    ExchangeInformation getExchangeInformation();

    /**
     * 获取订单。
     *
     * @return Order book.
     */
    OrderBook getOrderBook(String symbol, Integer limit);

    /**
     * 获取最近的交易。
     *
     * @return Recent trades.
     */
    List<Trade> getRecentTrades(String symbol, Integer limit);

    /**
     * 查询历史成交(需要有效的API-KEY)
     *
     * @param symbol YES	交易对
     * @param limit  NO	默认值:500 最大值:1000.
     * @param fromId NO	从哪一条成交id开始返回. 缺省返回最近的成交记录
     * @return List<Trade>
     */
    List<Trade> getOldTrades(String symbol, Integer limit, Long fromId);

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
    List<AggregateTrade> getAggregateTrades(String symbol, Long fromId, Long startTime, Long endTime, Integer limit);

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
    List<Candlestick> getCandlestick(String symbol, CandlestickInterval interval, Long startTime, Long endTime, Integer limit);

    /**
     * 最新标记价格和资金费率
     *
     * @param symbol NO	交易对
     * @return 采集各大交易所数据加权平均
     */
    List<MarkPrice> getMarkPrice(String symbol);

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
    List<FundingRate> getFundingRate(String symbol, Long startTime, Long endTime, Integer limit);

    /**
     * 24hr价格变动情况
     * 请注意，不携带symbol参数会返回全部交易对数据，不仅数据庞大，而且权重极高
     *
     * @param symbol 交易对
     * @return PriceChangeTicker
     */
    List<PriceChangeTicker> get24hrTickerPriceChange(String symbol);

    /**
     * 最新价格
     * 不发送交易对参数，则会返回所有交易对信息
     *
     * @param symbol NO	交易对
     * @return 返回最近价格
     */
    List<SymbolPrice> getSymbolPriceTicker(String symbol);

    /**
     * 当前最优挂单
     *
     * @param symbol NO 交易对
     * @return 返回当前最优的挂单(最高买单 ， 最低卖单)
     */
    List<SymbolOrderBook> getSymbolOrderBookTicker(String symbol);

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
    List<LiquidationOrder> getLiquidationOrders(String symbol, Long startTime, Long endTime, Integer limit);

    /**
     * 获取未平仓合约数
     *
     * @param symbol NO	交易对
     * @return 获取未平仓合约数
     */
    OpenInterest getOpenInterest(String symbol);

    /**
     * 批量下单 (TRADE)
     * 其中batchOrders应以list of JSON格式填写订单参数
     *
     * @param batchOrders YES	订单列表，最多支持5个订单
     * @return 批量下单
     */
    List<Object> postBatchOrders(String batchOrders);

    /**
     * 下单 (TRADE)
     *
     * @param symbol           YES	交易对
     * @param side             YES	买卖方向 SELL, BUY
     * @param positionSide     NO	持仓方向，单向持仓模式下非必填，默认且仅可填BOTH;在双向持仓模式下必填,且仅可选择 LONG 或 SHORT
     * @param orderType        YES	订单类型 MARKET 市价单、LIMIT 限价单、STOP 止损单、TAKE_PROFIT 止盈单、LIQUIDATION 强平单
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
    Order postOrder(String symbol, OrderSide side, PositionSide positionSide, OrderType orderType,
                    TimeInForce timeInForce, String quantity, String price, String reduceOnly,
                    String newClientOrderId, String stopPrice, WorkingType workingType, NewOrderRespType newOrderRespType);

    /**
     * 撤销订单 (TRADE)
     *
     * @param symbol            YES	交易对
     * @param orderId           NO	系统订单号
     * @param origClientOrderId NO	用户自定义的订单号
     * @return 撤销订单
     */
    Order cancelOrder(String symbol, Long orderId, String origClientOrderId);

    /**
     * 撤销全部订单 (TRADE)
     * orderId 与 origClientOrderId 必须至少发送一个
     *
     * @param symbol YES	交易对
     * @return 撤销全部订单
     */
    ResponseResult cancelAllOpenOrder(String symbol);

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
    List<Object> batchCancelOrders(String symbol, String orderIdList, String origClientOrderIdList);

    /**
     * 更改持仓模式(TRADE)
     *
     * @param dual YES	"true": 双向持仓模式；"false": 单向持仓模式
     * @return 持仓模式
     */
    ResponseResult changePositionSide(boolean dual);

    /**
     * 变换逐全仓模式 (TRADE)
     *
     * @param symbol     YES	交易对
     * @param marginType YES	保证金模式 ISOLATED(逐仓), CROSSED(全仓
     * @return 逐全仓模式
     */
    ResponseResult changeMarginType(String symbol, String marginType);

    /**
     * 调整逐仓保证金 (TRADE)
     *
     * @param symbol       YES	交易对
     * @param type         YES	调整方向 1: 增加逐仓保证金，2: 减少逐仓保证金
     * @param amount       YES	保证金资金
     * @param positionSide NO	持仓方向，单向持仓模式下非必填，默认且仅可填BOTH;在双向持仓模式下必填,且仅可选择 LONG 或 SHORT
     * @return 调整逐仓保证金
     */
    JSONObject addIsolatedPositionMargin(String symbol, int type, String amount, PositionSide positionSide);

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
    List<WalletDeltaLog> getPositionMarginHistory(String symbol, int type, long startTime, long endTime, int limit);

    /**
     * 查询持仓模式(需要有效的API-KEY)
     *
     * @return 持仓模式
     */
    JSONObject getPositionSide();

    /**
     * 查询订单 (需要有效的API-KEY)
     *
     * @param symbol            YES	交易对
     * @param orderId           NO	系统订单号
     * @param origClientOrderId NO	用户自定义的订单号
     * @return 订单
     */
    Order getOrder(String symbol, Long orderId, String origClientOrderId);

    /**
     * 查看当前全部挂单 (需要有效的API-KEY)
     *
     * @param symbol NO	交易对
     * @return 全部挂单
     */
    List<Order> getOpenOrders(String symbol);

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
    List<Order> getAllOrders(String symbol, Long orderId, Long startTime, Long endTime, Integer limit);

    /**
     * 账户余额V2 (需要有效的API-KEY)
     *
     * @return 账户余额V2 (需要有效的API-KEY)
     */
    List<AccountBalance> getBalance();

    /**
     * 获取当前帐户信息。
     *
     * @return Current account information.
     */
    AccountInformation getAccountInformation();

    /**
     * 账户信息V2 (需要有效的API-KEY)
     *
     * @return 账户信息
     */
    AccountInformationV2 getAccountInformationV2();

    /**
     * 调整开仓杠杆 (TRADE)
     *
     * @param symbol   YES	交易对
     * @param leverage YES	目标杠杆倍数：1 到 125 整数
     * @return 开仓杠杆
     */
    Leverage changeInitialLeverage(String symbol, Integer leverage);

    /**
     * 用户持仓风险
     *
     * @return 用户持仓风险
     */
    List<PositionRisk> getPositionRisk();

    /**
     * 用户持仓风险V2
     *
     * @return 用户持仓风险
     */
    List<PositionRiskV2> getPositionRiskV2();

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
    List<MyTrade> getAccountTrades(String symbol, Long startTime, Long endTime, Long fromId, Integer limit);

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
    List<Income> getIncomeHistory(String symbol, IncomeType incomeType, Long startTime, Long endTime, Integer limit);

    /**
     * 生成listenKey (需要有效的API-KEY)
     *
     * @return 生成
     */
    String startUserDataStream();

    /**
     * 延长listenKey有效期 (需要有效的API-KEY)
     *
     * @param listenKey listenKey
     * @return 有效期延长至本次调用后60分钟
     */
    String keepUserDataStream(String listenKey);

    /**
     * 关闭listenKey (需要有效的API-KEY)
     *
     * @param listenKey listenKey
     * @return 关闭某账户数据流
     */
    String closeUserDataStream(String listenKey);

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
    List<OpenInterestStat> getOpenInterestStat(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit);

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
    List<CommonLongShortRatio> getTopTraderAccountRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit);

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
    List<CommonLongShortRatio> getTopTraderPositionRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit);

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
    List<CommonLongShortRatio> getGlobalAccountRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit);

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
    List<TakerLongShortStat> getTakerLongShortRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit);

}
