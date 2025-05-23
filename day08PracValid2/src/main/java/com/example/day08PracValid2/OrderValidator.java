package com.example.day08PracValid2;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class OrderValidator implements Validator {

    // Order를 상속받은 객체인지 확인하기
    @Override
    public boolean supports(Class<?> clazz) {
        return Order.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //order객체 => target
        Order order = (Order)target;

        if(order.getName()==null || order.getName().isEmpty()){
            errors.rejectValue("name","required","이름은 입력해야함");
        }

        if(order.getPrice()==null || order.getPrice()<100 || order.getPrice()>10000){
            errors.rejectValue("price","range",new Object[]{"100","10000"},"가격의 범위는 100에서 10000입니다");
        }

        if(order.getQty()==null || order.getQty()>999){
            errors.rejectValue("qty","max",new Object[]{"999"}, "999를 초과할 수 없다");
        }
    }
}
