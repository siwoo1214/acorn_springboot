package com.example.day08PracConvert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

//로그 남기는 어노테이션
@Slf4j
@Controller
public class ItemController {

    //컨트롤러가 시작되기 전에 적용되는거임
    //Date를 받아오는 형식을 지정해주는 코드
    // 2025-05-23 이렇게 받을 수 있게 만들어줌
    //컨버터 등록하기

    //날짜를  2025-05-23 으로 다시 입력해 보자 !! 오류가 발생되는것을 확인하자


    //날짜를  2025-05-23 형식으로 받고 싶다면
    //InitBinder사용해서
    //initBinder에 등록해야 한다
    //initBinder의 위치는 controller안에 위치한다
    //컨버터 등록하기
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //날짜
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/itemForm")
    // 최초의 Form화면 요청시
    // Item 타입의 빈 객체를 생성하고 모델에 저장해 준다
    // 모델키의 이름은 Type의 첫글자 소문자 큐칙을 가진다
    public String itemForm(@ModelAttribute Item item){
        return "itemForm";
    }

    //검증하고 싶은 객체 뒤에 BindingResult
    // 이거로 에러메세지를 얻을 수 있음
    @PostMapping("/item")
    public String item(@ModelAttribute Item item, BindingResult bindingResult){

        //item에 뭐가 들어갔는지 콘솔에다가 찍어줌
        //대신 위에 어노테이션을 추가해줘야함
        log.info( "item ={}" , item);
        log.info( "item ={}" , bindingResult); //오류발생하면 Whitelabel안나옴

        //무조건 성공
        return "itemForm";
    }

}
