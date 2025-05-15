package com.acorn.day01Hello;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    String name;
    int age;
    String team;
}
