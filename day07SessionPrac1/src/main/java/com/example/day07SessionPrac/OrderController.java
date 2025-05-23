package com.example.day07SessionPrac;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("/order")
    public  String getOrderList(HttpServletRequest request){

         HttpSession session = request.getSession(false);

         if( session==null  ||  session.getAttribute("USERID") == null){
             return "redirect:/loginForm";
         }
        //

        return  "orderList";
    }
}
