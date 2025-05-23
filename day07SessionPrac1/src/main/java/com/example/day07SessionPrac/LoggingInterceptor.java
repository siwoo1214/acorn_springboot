package com.example.day07SessionPrac;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //return HandlerInterceptor.super.preHandle(request, response, handler);

        String method = request.getMethod();
        String requestURI = request.getRequestURI();   // /order
        System.out.println("prehandle");
        System.out.println(method);
        System.out.println(requestURI);

        //시간측정
//        System.out.println(System.currentTimeMillis());

        long start = System.currentTimeMillis();   //controller호출전에 시간

        //request저장소 활용하기
        request.setAttribute("start",start);

        return true;
    }

    //controller가 정상적으로 반환되면 호출됨 (오류가 발생되면 실행되지 않음)
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

        System.out.println("postHandle");
        System.out.println(modelAndView.getViewName());
        System.out.println(modelAndView.getModel());

        //일괄적으로 모델정보를 담고싶을 때 interceptor을 활용할 수 있다.
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        long end = System.currentTimeMillis();

        long start = (long)request.getAttribute("start");

        System.out.println("afterCompletion===========");
        System.out.println("걸린 시간");
        System.out.println(end-start);
    }
}
