package com.wsy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: wsy
 * Date: 2018-07-20
 * Time: 10:08
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping("/test")
    public String test() {
        int i = 5 / 0;
        return "success";
    }

    @RequestMapping("/test2")
    public String test2() {
        String str = null;
        System.out.println(str);
        return "success";
    }
}
