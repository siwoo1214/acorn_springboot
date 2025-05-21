package com.example.day06Prac;

public class Main {
    public static void main(String[] args) {

        //int currentPage, int pagesize, int grpSize, int totRecords
        int currentPage = 9;
        int pageSize = 7;
        int grpSize = 6;
        int totRecords = 513;

        PageHandler handler = new PageHandler(currentPage, pageSize, grpSize, totRecords);

        int start = handler.getGrpStartPage();
        int end = handler.getGrpEndPage();

//        System.out.println(handler.getTotalPage());
//        System.out.println(handler.getCurrentGrp());
//        System.out.println(handler.getGrpStartPage());
//        System.out.println(handler.getGrpEndPage());
//
//        System.out.println(start);
//        System.out.println(end);

        if(handler.getGrpStartPage() > 1){
            System.out.println("[이전]");
            System.out.println(handler.getGrpStartPage()-1);
        }

            System.out.print("[ ");
        for(int i=start; i<=end; i++){
            System.out.print(i+" ");
        }
            System.out.print("]");

        if(handler.getGrpEndPage()<handler.getTotalPage()){
            System.out.println("[다음]");
            System.out.println(handler.getGrpEndPage()+1); //그니까 페이지의 마지막 번호보다 하나 더 가서가 나와야하기 때문에
        }
    }
}
