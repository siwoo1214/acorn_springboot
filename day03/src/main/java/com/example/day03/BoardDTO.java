package com.example.day03;


import lombok.Data;

/*



CREATE TABLE boardt (
    board_no NUMBER PRIMARY KEY,
    title    VARCHAR2(200),
    writer   VARCHAR2(100),
    content  VARCHAR2(100)
);


 */
@Data
public class BoardDTO {

    int board_no;
    String title;
    String writer;
    String content;

}
