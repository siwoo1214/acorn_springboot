package com.example.day07SessionPrac;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BorderController {

    @GetMapping("/board")
    public  String  getList(HttpServletRequest request){
        /*

          로그인 확인 =>  세션저장소에 저장해 놓은 정보 활용
         */

        HttpSession session = request.getSession(false);

        //request.getSession(false);
        //세션을 얻어올 때   false 이면  => 기존에 세션이 없다면   null 을 반환
        //                            => 기존에 세션이 있다면 기본세션을 반환


        if( session == null  || session.getAttribute("USERID" )== null){
            // 로그인이 안된 사용자 !!
            return "redirect:/loginForm";
        }

        return "boardList";
    }
}
