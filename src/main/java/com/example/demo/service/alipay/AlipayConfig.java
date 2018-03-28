package com.example.demo.service.alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 支付宝扫码支付配置信息
 *
 * @author LiuYJ
 * @since 19/03/2018
 */
@Data
@Configuration()
@ConfigurationProperties(prefix = "thirdparty.alipay")
public class AlipayConfig {
    private String alipayUrl = "https://openapi.alipay.com/gateway.do";
    private String appId;
    private String format = "json";
    private String charset = "utf-8";
    private String appPrivateKey;
    private String alipayPublicKey;
    private String signType = "RSA2";
    private String subject = "肥宝宝";

    @Bean
    public AlipayClient alipayClient() {
        return new DefaultAlipayClient(alipayUrl, appId, appPrivateKey, format, charset, alipayPublicKey, signType);
    }
}
