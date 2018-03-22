package com.example.demo.service.alipay.model.request;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 订单预创建参数
 *
 * @author LiuYJ
 * @since 19/03/2018
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlipayPreCreateReq {
    /**
     * 商户订单号，64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 订单总金额，单位为元，精确到小数点后两位
     */
    @SerializedName("total_amount")
    private BigDecimal totalAmount;

    /**
     * 订单标题
     */
    private String subject;
}
