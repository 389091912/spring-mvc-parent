package com.wsy.mvc.controller;

import com.wsy.mvc.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: wsy
 * Date: 2018-07-20
 * Time: 11:16
 */
@RestController()     /*相当于 ResponseBody + Controller  所有的传值都是json类型的 */
@RequestMapping("/r-ajax")
public class AjaxController {

    @RequestMapping("/test")
    public String test() {
        System.out.println( "AjaxController.test" );
        return "success";
    }

    @RequestMapping("/test3")
    public Map<String,Object> test3() {
        Map<String, Object> map = new HashMap<>();
        map.put( "status", 200 );
        map.put( "msg", "success" );
        map.put( "data", "welcome to itany" );
        User user = new User();
        user.setId( 1001 );
        user.setUsername( "wsy" );
        user.setPassword( "1234" );
        user.setAge( 12 );
        map.put( "data", user );


        return map;
    }
}
