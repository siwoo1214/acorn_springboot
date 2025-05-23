package com.example.day07SessionPrac;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String method  =request.getMethod();
        String uri=  request.getRequestURI();

        System.out.println( method);
        System.out.println(uri);
        System.out.println(" preHandle ^^^^^^^^^^");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println(" postandle  !!!!!!!!!!!!");
        System.out.println("모델과 뷰정보");
        System.out.println(modelAndView.getViewName());
        System.out.println(modelAndView.getModel());

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //HandlerInterceptor.super.afterCompletion(request, response, handler, ex);

        System.out.println( "aftercompletion  ~~~~~~~~~~~~~~");

    }
}
