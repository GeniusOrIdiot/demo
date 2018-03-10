package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiuYJ
 * @since 2018/3/7
 */
@Slf4j
@Service
public class BoService {
    @Autowired
    private ValueService valueService;

    public void setValue() {
        valueService.addValue(1,1);
    }

    public void introduce() {
        log.info("BoService.");
    }
}
