package com.wsy.mvc.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: wsy
 * Date: 2018-07-20
 * Time: 9:09
 */
public class HelloInterceptor implements HandlerInterceptor {
    /**
     * 定义一个类 ,实现相应的接口
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */

//   在调用目标处理方法之前 执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println( "HelloInterceptor.preHandle" );
        if (o instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) o;

            Object bean = handlerMethod.getBean();
            Method method = handlerMethod.getMethod();
            System.out.println( "HelloInterceptor.preHandle,   执行" + bean.getClass() + "   " + method.getName() + Arrays.toString( method.getParameterTypes() ) );

        }

        return true;
    }
//  调用目标处理方法之后  执行
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println( "HelloInterceptor.postHandle" );
    }
//  渲染视图之后，可以用来释放资源
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        System.out.println( "HelloInterceptor.afterCompletion" );

    }
}
