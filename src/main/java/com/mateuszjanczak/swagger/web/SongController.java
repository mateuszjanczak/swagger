package com.mateuszjanczak.swagger.web;

import com.mateuszjanczak.swagger.domain.Song;
import com.mateuszjanczak.swagger.dto.SongRequest;
import com.mateuszjanczak.swagger.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {

    final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getSongList() {
        final List<Song> songs = songService.getList();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @PostMapping("/songs")
    public ResponseEntity<Song> addSong(@RequestBody SongRequest songRequest) {
        final Song song = songService.addSong(songRequest);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @PutMapping("/songs/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable int id, @RequestBody SongRequest songRequest){
        final Song song = songService.editSong(id, songRequest).get();
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @DeleteMapping("/songs/{id}")
    public ResponseEntity<Void> removeSong(@PathVariable int id) {
        songService.removeSong(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
