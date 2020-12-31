package com.mateuszjanczak.swagger.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SongRequest {
    private String title;
    private String artist;
    private String album;
}
