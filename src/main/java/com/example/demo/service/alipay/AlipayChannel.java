package com.example.demo.service.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayRequest;
import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.example.demo.service.alipay.model.request.AlipayPreCreateReq;
import com.example.demo.service.alipay.model.request.AlipayQueryReq;
import com.example.demo.service.alipay.model.response.AlipayNotifyResp;
import com.example.demo.utils.CommonUtils;
import com.example.demo.utils.DateUtils;
import com.example.demo.utils.exception.ResultCode;
import com.example.demo.utils.exception.RpcException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付宝扫码支付通道
 *
 * @author LiuYJ
 * @since 19/03/2018
 */
@Slf4j
@Component
@EnableConfigurationProperties(AlipayConfig.class)
public class AlipayChannel {
    private static Gson gson = new GsonBuilder().create();

    private AlipayConfig alipayConfig;
    private AlipayClient alipayClient;

    /**
     * 初始化AlipayClient
     */
    public AlipayChannel(AlipayConfig alipayConfig) {
        this.alipayConfig = alipayConfig;
        this.alipayClient = alipayConfig.alipayClient();
    }

    /**
     * 支付宝扫码支付订单预创建接口
     *
     * @param preCreateReq 订单信息
     * @param notifyUrl    回调地址
     * @return 支付二维码地址
     */
    public AlipayTradePrecreateResponse preCreate(AlipayPreCreateReq preCreateReq, String notifyUrl) throws RpcException {
        // 支付宝支付页面标题：若商品描述为空，则取配置的默认值
        String subject = preCreateReq.getSubject();
        if (CommonUtils.isEmpty(subject)) {
            preCreateReq.setSubject(alipayConfig.getSubject());
        }
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setNotifyUrl(notifyUrl);
        request.setBizContent(toJsonString(preCreateReq));
        AlipayTradePrecreateResponse response = (AlipayTradePrecreateResponse) this.send(request);
        this.checkResponse(response);
        return response;
    }

    /**
     * 支付宝扫码支付订单状态查询接口
     *
     * @param queryReq 查询参数
     */
    public AlipayTradeQueryResponse query(AlipayQueryReq queryReq) throws RpcException {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent(toJsonString(queryReq));
        AlipayTradeQueryResponse response = (AlipayTradeQueryResponse) this.send(request);
        this.checkResponse(response);
        return response;
    }

    /**
     * 校验接口返回结果
     *
     * @param response 接口返回参数
     */
    private void checkResponse(AlipayResponse response) throws RpcException {
        if (CommonUtils.isEmpty(response)) {
            throw new RpcException(ResultCode.REQUEST_NO_RESULT);
        }
        if (!response.getCode().equals("10000")) {
            log.error("支付宝交易查询请求失败，错误代码：{}，失败原因：{}", response.getSubCode(), response.getSubMsg());
            throw new RpcException(ResultCode.REQUEST_FAILED, response.getSubMsg());
        }
    }

    /**
     * 支付宝回调结果验签
     *
     * @param params 推送的参数列表
     * @return 验签结果
     */
    public boolean checkSign(Map<String, Object> params) {
        Map<String, String> alipayParams = new HashMap<>();
        // 将Object转成String
        params.forEach((key, value) -> alipayParams.put(key, (String) value));
        String publicKey = alipayConfig.getAlipayPublicKey();
        String signType = alipayConfig.getSignType();
        try {
            return AlipaySignature.rsaCheckV2(alipayParams, publicKey, "utf-8", signType);
        } catch (AlipayApiException e) {
            log.error("支付宝回调验签失败，错误代码：{}，失败原因：{}", e.getErrCode(), e.getErrMsg());
            return false;
        }
    }


    /**
     * 支付宝接口调用方法
     *
     * @param request 请求参数
     * @return AlipayResponse
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private AlipayResponse send(AlipayRequest request) {
        try {
            AlipayResponse response = alipayClient.execute(request);
            if (response != null) {
                log.info(response.getBody());
            }
            return response;
        } catch (AlipayApiException e) {
            log.error("调用支付宝接口失败，错误代码：{}，失败原因：{}", e.getErrCode(), e.getErrMsg());
            return null;
        }
    }

    /**
     * 解析异步通知
     *
     * @param params Map
     */
    public AlipayNotifyResp parseNotifyParams(Map<String, Object> params) {
        AlipayNotifyResp resp = AlipayNotifyResp.builder().build();
        ReflectionUtils.doWithFields(resp.getClass(), field -> {
            String fieldName = field.getName();
            Class clazz = field.getType();
            try {
                // 拼接set方法
                Method method = resp.getClass().getMethod("set" + firstUpperCase(fieldName), clazz);
                // 根据注解处理对应map中的key的值
                SerializedName annotation = field.getAnnotation(SerializedName.class);
                if (CommonUtils.isNotEmpty(annotation)) {
                    fieldName = annotation.value();
                }
                Object value = params.get(fieldName);
                if (CommonUtils.isEmpty(value)) {
                    return;
                }

                // Date和BigDecimal需要特殊处理
                if (clazz.equals(Date.class)) {
                    method.invoke(resp, DateUtils.parseString((String) value));
                } else if (clazz.equals(BigDecimal.class)) {
                    method.invoke(resp, new BigDecimal((String) value));
                } else {
                    method.invoke(resp, value);
                }
            } catch (Exception e) {
                log.error("支付宝异步通知数据解析异常，异常字段：{}，异常信息：{}", fieldName, e.getClass() + ":" + e.getMessage());
            }
        });
        return resp;
    }

    /**
     * 首字母大写转换
     *
     * @param str 源字符串
     */
    private static String firstUpperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }

    /**
     * JSON转换
     *
     * @param src 源字符串
     */
    private static String toJsonString(Object src) {
        return gson.toJson(src);
    }

//    public static void main(String[] args) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("notify_time", "2015-14-27 15:45:58");
//        params.put("signs", "asdiausdn");
//        params.put("total_amount", "192.33");
//        AlipayNotifyResp resp = parseNotifyParams(params);
//        System.out.println(resp.getNotifyTime());
//        System.out.println(resp.getSign());
//        System.out.println(resp.getTotalAmount());
//    }
}
