package com.example.day02Baytis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    OrderService service;

    //@ResponseBody     => 데이터응답하기
    @GetMapping("/orders")
    public List<Map<String , Object>>  getOrders(){

        List<Map<String , Object>>  list  = service.getOrderList();
        return  list;
    }
}
