package com.wsy.mvc.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by IntelliJ IDEA.
 * User: wsy
 * Date: 2018-07-20
 * Time: 9:51
 */
@ControllerAdvice

public class ExceptionAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public String arithemtic(Exception e) {
        System.out.println( "ExceptionAdvice.arithemtic" + e.getMessage() );
        return "../../500";
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception e) {
        System.out.println( "ExceptionAdvice.exception" +e);
        return "../../500";
    }


}
