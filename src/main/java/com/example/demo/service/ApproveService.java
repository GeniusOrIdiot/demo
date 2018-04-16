package com.example.demo.service;

import com.nongfenqi.approve.adp.api.AdjustPriceService;
import com.nongfenqi.approve.adp.model.request.AdjustPriceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiuYJ
 * @since 13/04/2018
 */
@Service
public class ApproveService {
    @Autowired
    private AdjustPriceService adjustPriceService;

    public void send(AdjustPriceRequest request) {
        adjustPriceService.publish(request);
    }

    public void query(String approvalId) {
        System.out.println(adjustPriceService.query(approvalId).getApproverUserids());
    }
}
