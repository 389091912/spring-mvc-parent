package com.wsy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: wsy
 * Date: 2018-07-18
 * Time: 13:32
 */
@Controller
public class HelloAnnotactionController {

    @RequestMapping("/hello1")
    public ModelAndView aaa(String name) {
        ModelAndView mav = new ModelAndView();
        name = (StringUtils.isEmpty( name )) ? " " : name;
        mav.addObject( "msg", "你好" +name);
        mav.setViewName( "hello" );
        return mav;
    }

    @RequestMapping("/hello2")
    public ModelAndView bbb(String name) {
        ModelAndView mav = new ModelAndView();
        mav.addObject( "msg", "您好啊" +name);
        mav.setViewName( "hello" );
        return mav;
    }
}
