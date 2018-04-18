package com.example.demo.service;

import com.nongfenqi.approve.adp.api.AdjustPriceCallback;
import com.nongfenqi.approve.adp.model.response.AdjustPriceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author LiuYJ
 * @since 16/04/2018
 */
@Slf4j
@Service
public class ApproveCallbackImpl implements AdjustPriceCallback {
    @Override
    public void callback(AdjustPriceResult adjustPriceResult) {
        log.info("回调处理中……");
    }
}
