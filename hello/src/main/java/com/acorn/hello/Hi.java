package com.acorn.hello;

import java.util.Random;

public class Hi {
    public static void main(String[] args) {
        String[] teams = new String[10];
        for (int i = 0; i < teams.length; i++) {
            if(i%2==0) teams[i]="1조";
            else teams[i]="3조";
        }
        Random rd = new Random();
        int destiny = rd.nextInt(10);

        System.out.println(teams[destiny]);
    }
}
