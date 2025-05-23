package com.example.day08PracValid2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class OrderController {

    @InitBinder
    public void init(WebDataBinder dataBinder){

        //내가 만든 validator등록하기
        dataBinder.addValidators( new OrderValidator()   );
    }

    @GetMapping("/orderForm")
    //form화면에서 form,model객체를 바인딩 할 것 이기 때문에 빈 객체를 제공해야한다
    //안하면 오류발생된다
    public String orderForm(@ModelAttribute Order order){
        return "orderForm";
    }

    // 검증하려면
    // 1. 검증하려는 객체 뒤에 BindingResult를 붙인다
    // 2. 검증객체 작성하기 (Validator interface를 구현해야한다), 에러코드 만들기
    // 3. 검증하는 객체 앞에 @Validated를 붙여야 한다.
    // 4. 오류 메세지 등록하기 (에러 코드에 대한에러 메세지 작성하기)
    // 5. view에서 에러가 있는 필드는 에러메세지가 나올 수 있게 한다
    // 6. validator 등록하기

    @PostMapping("/order")
    public String order(@ModelAttribute @Validated Order order, BindingResult bindingResult){
        log.info( "order ={}" , order);

        //검증로직
        if(bindingResult.hasErrors()){
            log.info( "bindingResult ={}" , bindingResult);
            return "orderForm";
        }

        return "redirect:/home";
    }
}
