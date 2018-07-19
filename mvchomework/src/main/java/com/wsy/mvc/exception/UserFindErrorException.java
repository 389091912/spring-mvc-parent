package com.wsy.mvc.exception;

/**
 * Created by IntelliJ IDEA.
 * User: wsy
 * Date: 2018-07-18
 * Time: 18:44
 */
public class UserFindErrorException extends Exception {

    public UserFindErrorException() {
    }

    public UserFindErrorException(String message) {
        super( message );
    }

    public UserFindErrorException(String message, Throwable cause) {
        super( message, cause );
    }

    public UserFindErrorException(Throwable cause) {
        super( cause );
    }

    public UserFindErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
