package com.inshare.concurrency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Guichao
 * @since 2018/9/10
 */
@Controller
@Slf4j
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Test";
    }
}
