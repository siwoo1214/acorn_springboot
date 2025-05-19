package com.day04Prac.day04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NaverController {

    @Autowired
//    NaverApi2 api;
    NaverApi3 api1;
    //데이터로 응답하기
    @ResponseBody
    @GetMapping(value="/naverData", produces = "application/json;charset=utf-8")
    public String getData(){
        String data = api1.getData();
        return data;
    }

//    public List<ItemDTO> getDataList(){
//        api.getData();
//    }
    NaverApi4 api = new NaverApi4();
@ResponseBody
@GetMapping("/naverList")
public List<ItemDTO> getDataList(){
    String data = api.getData();
    List<ItemDTO> list = api.extracted(data);

    return list;
}

    @GetMapping("/naverView")
    public String getNaverView(Model model){

        String data = api.getData();
        List<ItemDTO> list = api.extracted(data);
        model.addAttribute("list",list);

        return "naverView";
    }
}
