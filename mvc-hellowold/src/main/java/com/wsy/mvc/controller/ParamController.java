package com.wsy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by IntelliJ IDEA.
 * User: wsy
 * Date: 2018-07-19
 * Time: 13:31
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/test01")
    public void test(HttpServletRequest request, HttpServletResponse response) {

        System.out.println( request + "    ," + response + "      " + request.getSession() );
        System.out.println("物理路径 "+request.getServletContext().getRealPath( "/" ));
        
        response.setContentType( "text/html;charset=utf-8" );

        String username = request.getParameter( "username" );


        try {
            username = (null != username) ? new String( username.getBytes( "ISO8859-1" ), "UTF-8" ) : " ";
            PrintWriter writer = response.getWriter();
            writer.print( "<h2>"+"你好 "+username+"</h2>" );
            writer.flush();
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @RequestMapping("/test4")
    public String test4(@RequestParam("username")String name,int age,@RequestParam(required = false,defaultValue = "180")Double height) {
        System.out.println( name+","+ age+","+ height );
        return "success";
    }

    @RequestMapping("/test5/{name}/{age}")
    public String test5(@PathVariable("name") String username, @PathVariable("age") int age) {
        System.out.println( username + "   " + age );
        return "success";
    }

}

