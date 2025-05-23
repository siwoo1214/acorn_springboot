package com.example.day08PracConvert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// 에이콘 학생등록 서비스
@Slf4j
@Controller
public class AcornController {

    @GetMapping("/acornForm")
    //빈 객체를 스프링이 생성해서 모델에 저장해줌
    public String acornForm(@ModelAttribute Acorn acorn){
        return "acornForm";
    }

    @PostMapping("/acorn")
    public String acorn(@ModelAttribute Acorn acorn){
        log.info( "acorn ={}" , acorn);
        return "acornForm";
    }

}
