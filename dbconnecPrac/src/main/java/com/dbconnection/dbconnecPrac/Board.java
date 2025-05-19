package com.dbconnection.dbconnecPrac;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    int board_no;
    String title;
    String writer;
    String content;
}
