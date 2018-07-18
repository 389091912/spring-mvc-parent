package com.wsy.mvc.controller;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: wsy
 * Date: 2018-07-18
 * Time: 11:13
 * Description 实现一个接口的形式
 */

public class HelloController implements Controller {


    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding( "utf-8" );
        response.setContentType( "text/html;charset=utf-8" );
        String name = request.getParameter( "name" );
        name = (null != name) ? "hello   " + new String( name.getBytes( "ISO8859-1" ), "UTF-8" ) : "hello";

        ModelAndView mav=new ModelAndView();
        mav.addObject( "msg", name );
        System.out.println("name = "+ name );
        mav.setViewName("hello");
        return mav;
    }

}
