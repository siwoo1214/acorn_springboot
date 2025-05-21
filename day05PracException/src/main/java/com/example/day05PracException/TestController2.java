package com.example.day05PracException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

//예외처리를 직접하기
//try-catch

@Controller
public class TestController2 {



    @GetMapping("/method1")
    public String method1(){
        String viewName = "method1View";

        try {
            throw new SQLException("db 오류 ");
        } catch (SQLException e) {
            //예외 발생 상황
            viewName="errSQL";
        }
        return viewName;
    }

    @GetMapping("/method2")
    public String method2(){
        String viewName = "method1View2";

        try {
            throw new SQLException("db 오류 ");
            //service.getMembers() 뭐 이런 함수가 들어옴
        } catch (SQLException e) {
            //예외 발생 상황
            viewName="errSQL";
        }
        return viewName;
    }

    @GetMapping("/method3")
    public String method3(){
        String viewName = "method1View3";

        try {
            throw new SQLException("db 오류 ");
        } catch (SQLException e) {
            //예외 발생 상황
            viewName="errSQL";
        }
        return viewName;
    }

    //1이면 오류 안나게, 2이면 오류나게

//    @GetMapping("/method2")
//    public String method2(){
//        String viewName = "";
//        int result=2;
//
//        if(result==1){
//            //오루 발생
//            try {
//                throw new SQLException("데이터 베이스 오류");
//            } catch (SQLException e) {
////                throw new RuntimeException(e);
//                viewName="errSQL";
//            }
//        } else if(result==2){
//            viewName="method2View";
//        }
//        return viewName;
//    }

}
