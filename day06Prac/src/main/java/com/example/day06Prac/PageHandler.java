package com.example.day06Prac;

public class PageHandler {

    // 아 그니까 여기가 입력받는 값이고
    int currentPage;
    int pagesize;
    int grpSize;
    int totRecords;

    // 얘네들은 입력받은 값으로 계산되는 값들임
    int totalPage;
    int currentGrp;
    int grpStartPage;
    int grpEndPage;

    public PageHandler(int currentPage, int pagesize, int grpSize, int totRecords) {
        this.currentPage = currentPage;
        this.pagesize = pagesize;
        this.grpSize = grpSize;
        this.totRecords = totRecords;
        pageCalc();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getGrpSize() {
        return grpSize;
    }

    public void setGrpSize(int grpSize) {
        this.grpSize = grpSize;
    }

    public int getTotRecords() {
        return totRecords;
    }

    public void setTotRecords(int totRecords) {
        this.totRecords = totRecords;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentGrp() {
        return currentGrp;
    }

    public void setCurrentGrp(int currentGrp) {
        this.currentGrp = currentGrp;
    }

    public int getGrpStartPage() {
        return grpStartPage;
    }

    public void setGrpStartPage(int grpStartPage) {
        this.grpStartPage = grpStartPage;
    }

    public int getGrpEndPage() {
        return grpEndPage;
    }

    public void setGrpEndPage(int grpEndPage) {
        this.grpEndPage = grpEndPage;
    }

    private void pageCalc(){

        int remain = totRecords % pagesize;

        if(remain==0){
            totalPage = totRecords/pagesize;
        } else{
            totalPage = (totRecords/pagesize)+1;
        }

        //현재 그룹 구하기
        int remain2 = currentPage%grpSize;

        if(remain2==0){
            currentGrp = currentPage / grpSize;
        } else{
            currentGrp = (currentPage / grpSize)+1;
        }

        //현재 그룹의 tlwkrqjsgh
        //끝번호

        grpStartPage = (currentGrp-1)*grpSize+1;
        grpEndPage = currentGrp * grpSize;

        //그룹의 마지막을 확인하기
        if(grpEndPage > totalPage){
            grpEndPage=totalPage;
        }

//        System.out.println(currentPage);
//        System.out.println(pagesize);
//        System.out.println(grpSize);
//        System.out.println(totRecords);
//        System.out.println(totalPage);
//        System.out.println(currentGrp);
//        System.out.println(grpStartPage);
//        System.out.println(grpEndPage);

//        for(int i=grpStartPage; i<=grpEndPage; i++){
//            System.out.print(i+" ");
//        }
    }
}
