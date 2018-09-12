package com.inshare.concurrency.example.threadLocal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Guichao
 * @since 2018/9/12
 */
@Controller
@RequestMapping("/threadLocal")
@Slf4j
public class ThreadLocalController {

    @GetMapping("/test")
    @ResponseBody
    public Long test() {
        return RequestHolder.getId();
    }
}
