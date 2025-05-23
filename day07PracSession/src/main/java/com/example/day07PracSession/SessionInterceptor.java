package com.example.day07PracSession;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //return HandlerInterceptor.super.preHandle(request, response, handler);


        //order -> true -> controller(/order)
        //order -> false -> controller( x )
        // -> 로그인 사용자가 아니면 리턴값을 false로 해서 정상적인 흐름이 되지 않도록 만들어줘야함
        // -> 로그인 화면으로 redirect시키기
        //리턴값 true => 컨트롤러가 정상적으로 호출됨
        System.out.println("preHandle");

        HttpSession session = request.getSession(false);
        if(session==null || session.getAttribute("USERID")==null){
            //비로그인 사용자
            String context = request.getContextPath();
            response.sendRedirect(context+"/loginForm");
            return false;
        }else{
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("posthandler");
        System.out.println(modelAndView);
        //HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        //HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
