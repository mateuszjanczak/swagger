package com.mateuszjanczak.swagger.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    private int id;
    private String title;
    private String artist;
    private String album;
}
