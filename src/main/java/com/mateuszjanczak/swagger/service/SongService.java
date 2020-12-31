package com.mateuszjanczak.swagger.service;

import com.mateuszjanczak.swagger.domain.Song;
import com.mateuszjanczak.swagger.dto.SongRequest;

import java.util.List;
import java.util.Optional;

public interface SongService {
    Optional<Song> getById(int id);

    List<Song> getList();

    Song addSong(SongRequest songRequest);

    Optional<Song> editSong(int id, SongRequest songRequest);

    void removeSong(int id);
}
