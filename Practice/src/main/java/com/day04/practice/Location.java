package com.day04.practice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    String title;
    String lat;
    String lng;
}
