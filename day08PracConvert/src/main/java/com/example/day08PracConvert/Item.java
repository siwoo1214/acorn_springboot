package com.example.day08PracConvert;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 대표적인  convert오류
// null일 때 발생 -> int 기본자료형 데이터를 담으려고 할 떄
// "문자열" -> int,Integer 오류 발생
// "2025/05/23" -> 사실 이건 String임 But Date로 받고싶다면 말이지
// 문자열을 날짜타입으로 변환해야함 안맞으면 400오류가 발생한다(request bad)

// 변환오류 밣생하면 오류화면 응답
// 변환오류 발생했을 때 처리한 후에 사용자 친화적인 오류메세지를
// 원래 폼에서 확인하게 해줘야함

@Data
public class Item {
    Long money;
    String name;

    //이런식으로  initbinder를 사용하지 않고 날짜형식을 지정할 수 있음
    //@DateTimeFormat(pattern = "yyyy-mm-dd")
    Date inDate;
}
