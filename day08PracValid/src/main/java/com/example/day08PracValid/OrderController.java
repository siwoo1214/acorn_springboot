package com.example.day08PracValid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class OrderController {

    @GetMapping("/orderForm")
    // 비어있는 Order객체를 모델에 저장해줌
    // orderForm에서 form안에 있는 th:object에서 form과 order객체의 바인딩이 오류없이 일어난다
    public String orderForm(@ModelAttribute Order order){ //@ModelAttribute 꼭 있어야함
        return "orderForm";
    }

    @PostMapping("/order")
    public String order(@ModelAttribute Order order, Model model){
        log.info( "order ={}" , order);

        //order 객체 검증하기

        //실패하면 다시 form으로, 오류메세지 출력
        //성공하면 service 실행, home화면으로
        Map<String,String> errors = new HashMap<>();

        // 이름 입력했는지 검증
        if(order.getName() == null || order.getName().isEmpty()){
            errors.put("name","상품 이름을 입력하세요");
        }

        //금액 검증
        if(order.getPrice()==null || order.getPrice()<100 || order.getPrice()>10000){
            errors.put("price","상품 금액은 100원~10000원 이어야 합니다");
        }

        //수량 검증 (999를 넘어갈 수 없다)
        if(order.getQty()==null || order.getQty()>999){
            errors.put("qty","수량은 999개를 넘길 수 없습니다");
        }

        //에러가 있으면
        if(!errors.isEmpty()) {
            model.addAttribute("errors",errors);
            log.info( "errors ={}" , errors);
            return "orderForm";
        }

//        return "orderForm";

        //에러가 없는경우
        return "redirect:/home";
    }
}
