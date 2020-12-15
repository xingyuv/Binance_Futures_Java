package com.binance.client.impl;

import com.binance.client.constant.BinanceApiConstants;
import com.binance.client.exception.BinanceApiException;
import com.binance.client.impl.utils.UrlParamsBuilder;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Api签名
 *
 * @author xingyu
 */
class ApiSignature {

    public static final String SIGNATURE_VERSION_VALUE = "2";
    static final String OP = "op";
    static final String OP_VALUE = "auth";
    private static final String SIGNATURE_METHOD_VALUE = "HmacSHA256";

    void createSignature(String accessKey, String secretKey, UrlParamsBuilder builder) {

        if (accessKey == null || "".equals(accessKey) || secretKey == null || "".equals(secretKey)) {
            throw new BinanceApiException(BinanceApiException.KEY_MISSING, "API key and secret key are required");
        }

        builder.putToUrl("recvWindow", Long.toString(BinanceApiConstants.DEFAULT_RECEIVING_WINDOW))
                .putToUrl("timestamp", Long.toString(System.currentTimeMillis()));

        Mac hmacSha256;
        try {
            hmacSha256 = Mac.getInstance(SIGNATURE_METHOD_VALUE);
            SecretKeySpec secKey = new SecretKeySpec(secretKey.getBytes(), SIGNATURE_METHOD_VALUE);
            hmacSha256.init(secKey);
        } catch (NoSuchAlgorithmException e) {
            throw new BinanceApiException(BinanceApiException.RUNTIME_ERROR,
                    "[Signature] No such algorithm: " + e.getMessage());
        } catch (InvalidKeyException e) {
            throw new BinanceApiException(BinanceApiException.RUNTIME_ERROR,
                    "[Signature] Invalid key: " + e.getMessage());
        }
        String payload = builder.buildSignature();
        String actualSign = new String(Hex.encodeHex(hmacSha256.doFinal(payload.getBytes())));

        builder.putToUrl("signature", actualSign);

    }

}
