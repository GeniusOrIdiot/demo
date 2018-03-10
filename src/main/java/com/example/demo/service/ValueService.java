package com.example.demo.service;

import com.example.demo.model.entity.Values;
import com.example.demo.repository.ValuesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LiuYJ
 * @since 2018/1/27
 */
@Slf4j
@Service
public class ValueService {
    @Autowired
    private ValuesRepository valuesRepository;

    @Autowired
    private BoService boService;

    @Value("${my-name}")
    private String name;

    public String introduce() {
        boService.introduce();
        return "Hello! I am " + name;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void addValue(int id, int change) {
        Values values = valuesRepository.findOne(id);
        int value = values.getValue();
        log.info("Thread:[{}], previous value:[{}]", Thread.currentThread().getName(), value);
        values.setValue(value + change);
        valuesRepository.save(values);
        log.info("Thread:[{}], current value:[{}]", Thread.currentThread().getName(), value);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void subtractValue(int id, int change) {
        Values values = valuesRepository.findOne(id);
        int value = values.getValue();
        log.info("Thread:[{}], previous value:[{}]", Thread.currentThread().getName(), value);
        values.setValue(value - change);
        valuesRepository.save(values);
        log.info("Thread:[{}], current value:[{}]", Thread.currentThread().getName(), value);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void _addValue(int id, int change) {
        valuesRepository.addValue(id, change);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void _subtractValue(int id, int change) {
        valuesRepository.subtractValue(id, change);
    }
}
