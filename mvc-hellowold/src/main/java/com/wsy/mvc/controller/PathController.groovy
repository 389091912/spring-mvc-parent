package com.wsy.mvc.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by IntelliJ IDEA.
 * User: wsy
 * Date: 2018-07-19
 * Time: 11:12
 */
@Controller
@RequestMapping("/path")
class PathController {

    @RequestMapping("/test1")
    String test1() {
        println("PathController.test1")
        return "success"
    }

    @RequestMapping("/test2")
    String test2() {
        println("PathController.test2")
        return "redirect:/path/test1"
    }


    @RequestMapping("/test3/*")
    String test3(){
        println ("PathController.test3")
        return "success"
    }
    @RequestMapping("test4/**")
    String test4(){
        println "PathController.test4"
        return "success"
    }

    @RequestMapping("test5/?")
    String test5(){
        println("PathController.test5")
        return "success"
    }

    @RequestMapping("/test7/{name/{age:\\d+}")
    String test7(@PathVariable String name, @PathVariable int age) {
        println "PathController.test7"
        return "success"

    }


    @GetMapping("/user")
    String getTest10() {
        println "使用GET方法获取"
        return "success"
    }

    @PostMapping("/user")
    String postTest10() {
        println("使用Post方法获取")
        return "success"
    }

    @DeleteMapping("/user")
    String deleteTest10(){
        println("使用Delete方法获取")
        return "success"
    }


}
