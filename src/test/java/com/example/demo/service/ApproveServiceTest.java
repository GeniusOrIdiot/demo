package com.example.demo.service;

import com.nongfenqi.approve.adp.exception.AdpException;
import com.nongfenqi.approve.adp.model.request.AdjustPriceDetailRequest;
import com.nongfenqi.approve.adp.model.request.AdjustPriceRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author LiuYJ
 * @since 13/04/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApproveServiceTest {
    @Autowired
    private ApproveService approveService;

    @Test
    public void testSend() {
        try {
            approveService.send(buildApproveDto());
        } catch (AdpException e) {
            System.out.println(e.getMsg());
        }
    }

    private AdjustPriceRequest buildApproveDto() {
        return AdjustPriceRequest.builder()
                .orderId("AO0001002")
                .customerName("雅俊")
                .userId("1203251357-186916497")
                .userName("小俊")
                .ccList(new ArrayList<>(Collections.singleton("0861675150122379809")))
                .approvers(new ArrayList<>(Collections.singletonList("1203251357-186916497")))
                .goods(new ArrayList<>(Collections.singletonList(
                        AdjustPriceDetailRequest.builder()
                                .orderGoodsId("AOG01239")
                                .goodsName("MacBook")
                                .originalUnitPrice(new BigDecimal("12000"))
                                .adjustUnitPrice(new BigDecimal("9999"))
                                .weight(new BigDecimal("1"))
                                .remark("测试")
                                .build())))
                .build();
    }

    @Test
    public void query() {
        approveService.query("7040dcc5-9e8f-44ff-ae32-bc5c8d037160");
    }

}
