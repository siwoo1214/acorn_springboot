package com.example.day05PracException;

import java.io.IOException;

public class 예외처리하기 {
    public static void main(String[] args) {

        //콘솔로부터 한 바이트 읽기

        //예외 종류
        //exception(Checked 오류) 오류 예외처리하기 -> 빨간줄 뜨는 에러(예외처리가 필수임)
        //runtimeExceotion (unChecked 오류)  -> 예외처리 안해도 됌

        //checkedException -> try-catch, throws로 처리 가능
        int result=0;
        try {
            result = System.in.read();
        } catch (IOException e) {
            //throw new RuntimeException(e);
        }

        System.out.println(result);
    }
}
