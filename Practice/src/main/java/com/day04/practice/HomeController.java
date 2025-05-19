package com.day04.practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/map1")
    public String show1(){
        return "map1";
    }

    // 마커 여러개 생성한 다음에 아래에 정보도 같이 출력되게
    @GetMapping("/map2")
    public String show2(Model model){

        Location loc1 = new Location("강남역", "37.498102", "127.027740");
        Location loc2 = new Location("CGV 강남", "37.501780", "127.026439");
        Location loc3 = new Location("헤비 스테이크 강남", "37.496404", "127.030228");
        Location loc4 = new Location("카페 더 나인", "37.498491", "127.026790");

        List<Location> list = new ArrayList<>();
        list.add(loc1);
        list.add(loc2);
        list.add(loc3);
        list.add(loc4);

        System.out.println(list);
        model.addAttribute("list",list);

        return "map2";
    }

    @GetMapping("/map3")
    public String show3(){
        return "map3";
    }
}
