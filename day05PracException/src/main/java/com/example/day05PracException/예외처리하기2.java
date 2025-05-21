package com.example.day05PracException;

import java.io.IOException;

public class 예외처리하기2 {
    public static void main(String[] args) {
        int money = -5000;
        int result=0;
        try {
            result = doubler(money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("처리되지 않았습니다 ...");
            //예외가 발생했을 때 아래로 내려가지 않게 하고싶으면
            //이런식으로 예외를 한번 더 일으켜주면 된다
            throw new RuntimeException(e);
        }
        System.out.println("투자 보고서");
        System.out.println("투자 금액 : "+money);
        System.out.println("투자 결과 : "+result);
        System.out.println("프로그램 정상종료");
    }

    //메소드 만들기
    // int doubler (int money)
    public static int doubler(int money) throws Exception {

        //money가 음수면 예외를 발생시키기
        if(money<=0){
            throw new Exception("마이너스 통장은 안됩니다...");
        }

        return money*2;
    }
}
