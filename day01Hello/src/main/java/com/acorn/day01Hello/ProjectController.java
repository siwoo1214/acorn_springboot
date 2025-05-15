package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProjectController {

    // 1조 명단
    @GetMapping("/team1")
    public String getMember(Model model){
        List<User> team1 = new ArrayList<>();
        team1.add(new User("acorn1","윤현기","010-8336-4282"));
        team1.add(new User("acorn2","권지언","010-4699-6749"));
        team1.add(new User("acorn3","임형택","010-9959-8251"));
        team1.add(new User("acorn4","이수민","010-8383-7869"));
        team1.add(new User("acorn5","김보성","010-7766-5927"));

        model.addAttribute("team1",team1);
        return "team1";
    }

    // 2조 명단
    @GetMapping("/team2")
    public String getMember2(Model model){
        List<User> team2 = new ArrayList<>();
        team2.add(new User("acorn1","정연수","010-8336-4282"));
        team2.add(new User("acorn2","김유민","010-4699-6749"));
        team2.add(new User("acorn3","이정호","010-9959-8251"));
        team2.add(new User("acorn4","황예지","010-8383-7869"));
        team2.add(new User("acorn5","김민환","010-7766-5927"));
        team2.add(new User("acorn5","오윤석","010-7766-5927"));

        model.addAttribute("team2",team2);
        return "team2";
    }

    // 3조 명단
    @GetMapping("/team3")
    public String getMember3(Model model){
        List<User> team3 = new ArrayList<>();
        team3.add(new User("acorn1","최지태","010-8336-4282"));
        team3.add(new User("acorn2","박시우","010-4699-6749"));
        team3.add(new User("acorn3","박예린","010-9959-8251"));
        team3.add(new User("acorn4","박수경","010-8383-7869"));
        team3.add(new User("acorn5","최하은","010-7766-5927"));
        team3.add(new User("acorn5","이동우","010-7766-5927"));

        model.addAttribute("team3",team3);
        return "team3";
    }

    @GetMapping("/teamall")
    public String getProjectAll(Model model){
        List<User> team1 = new ArrayList<>();
        team1.add(new User("acorn1","윤현기","010-8336-4282"));
        team1.add(new User("acorn2","권지언","010-4699-6749"));
        team1.add(new User("acorn3","임형택","010-9959-8251"));
        team1.add(new User("acorn4","이수민","010-8383-7869"));
        team1.add(new User("acorn5","김보성","010-7766-5927"));

        List<User> team2 = new ArrayList<>();
        team2.add(new User("acorn1","정연수","010-8336-4282"));
        team2.add(new User("acorn2","김유민","010-4699-6749"));
        team2.add(new User("acorn3","이정호","010-9959-8251"));
        team2.add(new User("acorn4","황예지","010-8383-7869"));
        team2.add(new User("acorn5","김민환","010-7766-5927"));
        team2.add(new User("acorn5","오윤석","010-7766-5927"));

        List<User> team3 = new ArrayList<>();
        team3.add(new User("acorn1","최지태","010-8336-4282"));
        team3.add(new User("acorn2","박시우","010-4699-6749"));
        team3.add(new User("acorn3","박예린","010-9959-8251"));
        team3.add(new User("acorn4","박수경","010-8383-7869"));
        team3.add(new User("acorn5","최하은","010-7766-5927"));
        team3.add(new User("acorn5","이동우","010-7766-5927"));

        Map<String, List<User>> map = new HashMap<>();
        map.put("1",team1);
        map.put("2",team2);
        map.put("3",team3);

        model.addAttribute("team",map);

        return "teamAll";
    }
}
