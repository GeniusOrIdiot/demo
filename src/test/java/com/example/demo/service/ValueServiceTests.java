package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LiuYJ
 * @since 2018/1/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ValueServiceTests {
    @Autowired
    private ValueService valueService;

    @Test
    public void testIntroduce() {
        valueService.introduce();
    }
}
