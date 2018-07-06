package com.example.demo.service;

import com.nongfenqi.approve.adp.model.request.AdjustPriceDetailRequest;
import com.nongfenqi.approve.adp.model.request.AdjustPriceRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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
        approveService.send(buildApproveDto());
    }

    private AdjustPriceRequest buildApproveDto() {
        return AdjustPriceRequest.builder()
                .orderId("AO0001002")
                .customerName("雅俊")
//                .userId("1203251357-186916497")
                .userId("120325135721413309")
                .userName("小俊")
//                .ccList(new ArrayList<>(Arrays.asList("1203251357-186916497", "67072831-874948550")))
                .ccList(new ArrayList<>(Arrays.asList("120325135721413309")))
//                .approvers(new ArrayList<>(Collections.singletonList("67072831-874948550")))
                .approvers(new ArrayList<>(Collections.singletonList("120325135721413309")))
                .goods(new ArrayList<>(Collections.singletonList(
                        AdjustPriceDetailRequest.builder()
                                .orderGoodsId("AOG01239")
                                .goodsName("MacBook")
                                .originalUnitPrice(new BigDecimal("12000"))
                                .adjustUnitPrice(new BigDecimal("9999"))
                                .cashDiscountPrice(new BigDecimal("11000"))
                                .weight(new BigDecimal("1"))
                                .remark("测试")
                                .build())))
                .build();
    }

    @Test
    public void query() {
        approveService.query("a5466fd2-e582-43f7-a9ba-222ef9c082f8");
    }

}
