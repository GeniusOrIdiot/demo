package com.example.demo.controller;

import com.example.demo.service.ValueService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

    @RequestMapping(value = "/pOrg", method = {RequestMethod.GET, RequestMethod.POST})
    public String getPostParams(HttpServletRequest request,
                                @RequestBody String body,
                                @RequestParam Map<String, Object> params) {
        valueService.doPOrG(body, params);
        return "success" + request.getQueryString();
    }
}
