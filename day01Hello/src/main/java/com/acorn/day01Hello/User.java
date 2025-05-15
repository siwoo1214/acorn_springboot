package com.acorn.day01Hello;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    String id;
    String pw;
    String tel;
}
