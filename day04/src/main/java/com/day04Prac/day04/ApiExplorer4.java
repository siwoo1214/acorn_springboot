package com.day04Prac.day04;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApiExplorer4 {



    //main 메소드의 코드를 호출가능한 메소드로 변경하기

    public static void main(String[] args) throws IOException {
        ApiExplorer4 api = new ApiExplorer4();
        String data = api.getData();

        System.out.println(data);

        List<DataDTO> list =api.fromJsontoDataDTO(data);

    }

    public List<DataDTO> fromJsontoDataDTO(String data) {
        // 1. json 문자열  ->  json객체로 변환하기
        // 2. items 키로 JsonArray꺼내기
        // 3. JsonArray로 반복하면서 자바 객체 List로 변환하기
        //    JsonObject -> DataDTO 변환하기
        //    ArrayList에 추가하기
        JSONObject obj = new JSONObject(data);

        JSONObject response = obj.getJSONObject("response");
        System.out.println(response);

        JSONObject body = response.getJSONObject("body");
        System.out.println(body);

        // key로 값을 꺼낼 때 주의사항 !
        // 값아 json객체이면 -> getJSONObject() 사용
        // 값아 json객체List이면 -> getJSONArray() 사용
        JSONArray array = body.getJSONArray("items");

        System.out.println(array);

        List<DataDTO> dataDTOList = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonItem = array.getJSONObject(i);

            String informCause = jsonItem.getString("informCause");
            String informGrade = jsonItem.getString("informGrade");
            String dataTime = jsonItem.getString("dataTime");

            DataDTO dataDTO = new DataDTO();
            dataDTO.setDataTime(dataTime);
            dataDTO.setInformGrade(informGrade);
            dataDTO.setInformCause(informCause);

            dataDTOList.add(dataDTO);
            System.out.println(dataDTOList);

        }
            return dataDTOList;

    }

    public String getData() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=%2BfkdhlryOGvNszk42AdFt53DhY6RaBDPsoSfo2DKSdHrXfvOBvmS8IVy2Zh%2ByfTeJY7CAq2COaAqu7%2B1i1x3jg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 또는 json*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder.append("&" + URLEncoder.encode("searchDate","UTF-8") + "=" + URLEncoder.encode("2025-05-18", "UTF-8")); /*통보시간 검색(조회 날짜 입력이 없을 경우 한달동안 예보통보 발령 날짜의 리스트 정보를 확인)*/
        urlBuilder.append("&" + URLEncoder.encode("InformCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*통보코드검색(PM10, PM25, O3)*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        return sb.toString();
    }
}