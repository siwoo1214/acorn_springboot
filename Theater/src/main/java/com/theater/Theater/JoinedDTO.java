package com.theater.Theater;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JoinedDTO {
    String movie_id;
    String title;
    String genre;
    int runtime;
    String director;
    String released;
    String screen_id;
    String screen_num;
    int seat_count;
    String start_time;
    String date_time;
}
