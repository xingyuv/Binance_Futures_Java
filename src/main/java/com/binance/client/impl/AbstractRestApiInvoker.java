package com.binance.client.impl;

import com.binance.client.exception.BinanceApiException;
import com.binance.client.impl.utils.JsonWrapper;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * rest api 调用 抽象类
 *
 * @author xingyu
 */
abstract class AbstractRestApiInvoker {

    private static final Logger log = LoggerFactory.getLogger(AbstractRestApiInvoker.class);
    private static final OkHttpClient CLIENT = new OkHttpClient();

    private static final String SUCCESS = "success";

    private static final String CODE = "code";

    private static final String MSG = "msg";

    static void checkResponse(JsonWrapper json) {
        try {
            if (json.containKey(SUCCESS)) {
                boolean success = json.getBoolean(SUCCESS);
                if (!success) {
                    String errCode = json.getStringOrDefault(CODE, "");
                    String errMsg = json.getStringOrDefault(MSG, "");
                    if ("".equals(errCode)) {
                        throw new BinanceApiException(BinanceApiException.EXEC_ERROR, "[Executing] " + errMsg);
                    } else {
                        throw new BinanceApiException(BinanceApiException.EXEC_ERROR,
                                "[Executing] " + errCode + ": " + errMsg);
                    }
                }
            } else if (json.containKey(CODE)) {

                int code = json.getInteger(CODE);
                if (code != 200) {
                    String message = json.getStringOrDefault(MSG, "");
                    throw new BinanceApiException(BinanceApiException.EXEC_ERROR,
                            "[Executing] " + code + ": " + message);
                }
            }
        } catch (BinanceApiException e) {
            throw e;
        } catch (Exception e) {
            throw new BinanceApiException(BinanceApiException.RUNTIME_ERROR,
                    "[Invoking] Unexpected error: " + e.getMessage());
        }
    }

    static <T> T callSync(RestApiRequest<T> request) {
        try {
            String str;
            log.debug("Request URL " + request.request.url());
            Response response = CLIENT.newCall(request.request).execute();
            if (response != null && response.body() != null) {
                str = response.body().string();
                response.close();
            } else {
                throw new BinanceApiException(BinanceApiException.ENV_ERROR,
                        "[Invoking] Cannot get the response from server");
            }
            log.debug("Response =====> " + str);
            JsonWrapper jsonWrapper = JsonWrapper.parseFromString(str);
            checkResponse(jsonWrapper);
            return request.jsonParser.parseJson(jsonWrapper);
        } catch (BinanceApiException e) {
            throw e;
        } catch (Exception e) {
            throw new BinanceApiException(BinanceApiException.ENV_ERROR,
                    "[Invoking] Unexpected error: " + e.getMessage());
        }
    }

    static WebSocket createWebSocket(Request request, WebSocketListener listener) {
        return CLIENT.newWebSocket(request, listener);
    }

}
