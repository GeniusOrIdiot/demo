package com.example.demo.service.alipay.model.request;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LiuYJ
 * @since 21/03/2018
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlipayQueryReq {
    /**
     * 系统订单号 outOrderId
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 支付宝交易号
     */
    @SerializedName("trade_no")
    private String tradeNo;
}
