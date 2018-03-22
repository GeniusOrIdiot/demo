package com.example.demo.service.alipay.model.response;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付宝异步通知回调信息
 *
 * @author LiuYJ
 * @since 20/03/2018
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlipayNotifyResp {
    /**
     * 通知的发送时间。格式为yyyy-MM-dd HH:mm:ss
     */
    @SerializedName("notify_time")
    private Date notifyTime;

    /**
     * 通知的类型
     */
    @SerializedName("notify_type")
    private String notifyType;

    /**
     * 通知校验ID
     */
    @SerializedName("notify_id")
    private String notifyId;

    /**
     * 商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
     */
    @SerializedName("sign_type")
    private String signType;

    /**
     * 签名
     */
    private String sign;

    /**
     * 支付宝交易凭证号
     */
    @SerializedName("trade_no")
    private String tradeNo;

    /**
     * 支付宝分配给开发者的应用Id
     */
    @SerializedName("app_id")
    private String appId;

    /**
     * 原支付请求的商户订单号
     */
    @SerializedName("out_trade_no")
    private String outTradeNo;

    /**
     * 商户业务ID，主要是退款通知中返回退款申请的流水号
     */
    @SerializedName("out_biz_no")
    private String outBizNo;

    /**
     * 买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字
     */
    @SerializedName("buyer_id")
    private String buyerId;

    /**
     * 买家支付宝账号
     */
    @SerializedName("buyer_logon_id")
    private String buyerLogonId;

    /**
     * 卖家支付宝用户号
     */
    @SerializedName("seller_id")
    private String sellerId;

    /**
     * 卖家支付宝账号
     */
    @SerializedName("seller_email")
    private String sellerEmail;

    /**
     * 交易状态：
     * WAIT_BUYER_PAY  交易创建，等待买家付款
     * TRADE_SUCCESS   未付款交易超时关闭，或支付完成后全额退款
     * WAIT_BUYER_PAY  交易支付成功
     * TRADE_CLOSED    交易结束，不可退款
     */
    @SerializedName("trade_status")
    private String tradeStatus;

    /**
     * 本次交易支付的订单金额，单位为人民币（元）
     */
    @SerializedName("total_amount")
    private BigDecimal totalAmount;

    /**
     * 商家在交易中实际收到的款项，单位为元
     */
    @SerializedName("receipt_amount")
    private BigDecimal receiptAmount;

    /**
     * 用户在交易中支付的可开发票的金额
     */
    @SerializedName("invoice_amount")
    private BigDecimal invoiceAmount;

    /**
     * 用户在交易中支付的金额
     */
    @SerializedName("buyer_pay_amount")
    private BigDecimal buyerPayAmount;

    /**
     * 使用集分宝支付的金额
     */
    @SerializedName("point_amount")
    private BigDecimal pointAmount;

    /**
     * 退款通知中，返回总退款金额，单位为元，支持两位小数
     */
    @SerializedName("refund_fee")
    private BigDecimal refundFee;

    /**
     * 商户实际退款给用户的金额，单位为元，支持两位小数
     */
    @SerializedName("send_back_fee")
    private BigDecimal sendBackFee;

    /**
     * 商品的标题/交易标题/订单标题/订单关键字等，是请求时对应的参数，原样通知回来
     */
    private String subject;

    /**
     * 该订单的备注、描述、明细等。对应请求时的body参数，原样通知回来
     */
    private String body;

    /**
     * 该笔交易创建的时间。格式为yyyy-MM-dd HH:mm:ss
     */
    @SerializedName("gmt_create")
    private Date gmtCreate;

    /**
     * 该笔交易的买家付款时间。格式为yyyy-MM-dd HH:mm:ss
     */
    @SerializedName("gmt_payment")
    private Date gmtPayment;

    /**
     * 该笔交易的退款时间。格式为yyyy-MM-dd HH:mm:ss.S
     */
    @SerializedName("gmt_refund")
    private Date gmtRefund;

    /**
     * 该笔交易结束时间。格式为yyyy-MM-dd HH:mm:ss
     */
    @SerializedName("gmt_close")
    private Date gmtClose;

    /**
     * 支付成功的各个渠道金额信息  JSON格式
     */
    @SerializedName("fund_bill_list")
    private String fundBillList;
}
