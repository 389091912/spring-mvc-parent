package com.wsy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: wsy
 * Date: 2018-07-18
 * Time: 14:44
 */
@Controller
public class LoginController {

    @PostMapping("/login/user")
    public String login(HttpServletRequest request,@RequestParam("username") String username, @RequestParam("password") String password) {

        if (!StringUtils.isEmpty( username ) && "123".equals( password )) {
            System.out.println( "登陆成功" );
            return "redirect:/hello";
        } else {
            System.out.println("密码错误");
            request.setAttribute( "msg", "用户名或密码错误" );
            return "login";
        }

    }

}
