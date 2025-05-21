package com.acorn.ExceptionSample;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


//패키지를 명시해서 어느 패키지만 예외처리를 시켜줄 수 있음
//@ControllerAdvice(basePackages = "com.acorn.ExceptionSample")
 //@ControllerAdvice   <- globalcatcher을 사용하려면 이 어노테이션이 있어야한다
public class GlobalCatcher {
	
	//@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	//@ExceptionHandler(Exception.class)
	public String catcher( Model model, Exception ex ) {		 			 
		  model.addAttribute("ex", ex);
		  return "err";
	}


}
