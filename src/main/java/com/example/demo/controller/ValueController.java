package com.example.demo.controller;

import com.example.demo.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author LiuYJ
 * @since 2018/1/27
 */
@RestController
public class ValueController {
    private ValueService valueService;

    public ValueController(ValueService valueService) {
        this.valueService = valueService;
    }

    @RequestMapping(value = "/introduce", method = RequestMethod.GET)
    public String introduce() {
        return valueService.introduce();
    }

    @GetMapping("/model")
    public ModelAndView modelData() {
        return new ModelAndView("/model").addObject("myName", "LiuYajun");
    }
}
