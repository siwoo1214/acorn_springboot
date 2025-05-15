package com.acorn.day01Hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mapMain {
    public static void main(String[] args) {
        Map<String, List<User>> map = new HashMap<>();

        List<User> team3 = new ArrayList<>();
        team3.add(new User("acorn1","최지태","010-8336-4282"));
        team3.add(new User("acorn2","박시우","010-4699-6749"));
        team3.add(new User("acorn3","박예린","010-9959-8251"));
        team3.add(new User("acorn4","박수경","010-8383-7869"));
        team3.add(new User("acorn5","최하은","010-7766-5927"));
        team3.add(new User("acorn5","이동우","010-7766-5927"));

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

        map.put("1",team1);
        map.put("2",team2);
        map.put("3",team3);

        List<User> result = map.get("2");

        map.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);

            for(User user : value){
                System.out.println(user.getId());
                System.out.println(user.getPw());
                System.out.println(user.getTel());
            }
        });

        System.out.println("----------------------------------------");

        //map.entrySet()은 map의 값을 {key, value}로 받아온다
        //이거는 Map.Entry<T,T>로 받아올 수 있다
        for(Map.Entry<String, List<User>> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

            for(User user : entry.getValue()){
                System.out.println(user.getId());
                System.out.println(user.getPw());
                System.out.println(user.getTel());
            }
        }
    }
}
