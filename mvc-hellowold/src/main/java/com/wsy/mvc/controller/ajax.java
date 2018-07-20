package com.wsy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.spec.PSSParameterSpec;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: wsy
 * Date: 2018-07-20
 * Time: 10:38
 */
@Controller
@RequestMapping("/ajax")
public class ajax {

    @RequestMapping("/test3")
    public String test3() {

        return "";
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String test2() {

        return "";
    }

    @RequestMapping("/ajaxJson")
    @ResponseBody
    public String ajaxJson() {

        System.out.println( "ajax.ajaxJson" );
        return "success";
    }

    @RequestMapping("/teset")
    @ResponseBody
    public Map<String, Object> test() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    @RequestMapping("/test01")
    @ResponseBody
    public Map<String, Object> test01() {
        Map<String, Object> map = new HashMap<>();


        return map;
    }

}
