package com.example.day05PracException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

//@ControllerAdvice -> 전역으로 사용할 수 있는 값을 설정해줌
//패키지 단위나 전체단위로 예외처리를 진행할 수 있음
@ControllerAdvice
public class GlobalCatcher {

    //그래서 여기서 오류들에 대해서 어떻게 동작할지를
    //설정해줄 수 있음
    //서버가 오류를 처리하면 상태코드가 200으로 자동 설정됨
    // 그래서 상태코드를 변경해야 함
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(SQLException.class)
    public String catcher(){

        return "errSQL";
    }
}
