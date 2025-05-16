package com.theater.Theater;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
    private String movieId;
    private String title;
    private String genre;
    private int runtime;
    private String director;
    private String released;
}
