package org.zhihao.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ChenZhihao
 * @Date 2024/9/25 20:49
 */
@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping("helloWorld")
    public String helloWorld() {
        return "Hello World";
    }

}
