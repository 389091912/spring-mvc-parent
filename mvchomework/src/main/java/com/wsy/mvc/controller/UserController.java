package com.wsy.mvc.controller;

import com.github.pagehelper.PageInfo;
import com.wsy.mvc.entity.User;
import com.wsy.mvc.exception.UserExistException;
import com.wsy.mvc.exception.UserFindErrorException;
import com.wsy.mvc.service.UserService;
import com.wsy.mvc.util.AjaxResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: wsy
 * Date: 2018-07-18
 * Time: 17:12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addOrModifyUser")
    @ResponseBody
    public AjaxResult addOrModifyUser(HttpServletRequest request, User user){
        System.out.println(user);
        AjaxResult result = new AjaxResult();
        if (StringUtils.isEmpty( user.getId() )) {
            System.out.println("添加....");
            try {
                userService.addUser( user );
                result.setSuccess( true );
                return result;
            } catch (UserExistException e) {
                e.printStackTrace();
                result.setSuccess( false );
                result.setMsg( e.getMessage() );
                request.setAttribute( "error", e.getMessage() );
                return result;
            }

        } else {
            System.out.println("修改...");
            try {
                userService.modify( user );
                result.setSuccess( true );
                return result;
            } catch (UserExistException e) {
                e.printStackTrace();
                result.setSuccess( false );
                result.setMsg( e.getMessage() );
                return result;
            }
        }

    }

    @ResponseBody
    @RequestMapping("/findAll")
    public PageInfo<User> findAll(HttpServletRequest request, User user) {

        String pageNoStr = request.getParameter( "pageNo" );

        int pageNo = 1;
        try {
            pageNo = Integer.parseInt(pageNoStr);
        } catch (NumberFormatException e) {
            pageNo = 1;
        }
        PageInfo<User> pageInfo = userService.selectAll( pageNo, user );

        request.setAttribute( "userList",pageInfo );
        System.out.println( pageInfo.getPageNum() );
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping("/findUserById")
    public AjaxResult findUserById(HttpServletRequest request,@RequestParam("id") Integer id) {

        User user = userService.selectUserById( id );
        System.out.println("   "+ user );
        return new AjaxResult(true,"查询成功",user);
    }




  /*  @RequestMapping("/findAllUserList")
    public String findAllUserList(HttpServletRequest request,User user) {

        return null;
    }*/

    @RequestMapping("/login")
    public String login(HttpServletRequest request, User user) {

        try {
            User user1 = userService.selectByUsernameAndPassword( user );

            request.getSession().setAttribute( "user", user1 );
            return "redirect:/main";

        } catch (UserFindErrorException e) {
            e.printStackTrace();
            request.setAttribute( "msg", e.getMessage() );
            return "login";
        }


    }

    @ResponseBody
    @RequestMapping("/remove")
    public AjaxResult removeUser(HttpServletRequest request, @RequestParam("id") Integer id) {

        AjaxResult result = new AjaxResult();
        userService.deleteById( id );
        result.setSuccess( true );
        return result;
    }


}
