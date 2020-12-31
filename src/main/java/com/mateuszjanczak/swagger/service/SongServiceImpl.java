package com.mateuszjanczak.swagger.service;

import com.mateuszjanczak.swagger.domain.Song;
import com.mateuszjanczak.swagger.dto.SongRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    private final ArrayList<Song> songList;

    public SongServiceImpl() {
        this.songList = new ArrayList<>();
        songList.add(Song.builder().id(1).title("Wiatr").artist("Taco Hemingway").album("Wosk").build());
        songList.add(Song.builder().id(2).title("Bumerang").artist("Quebonafide").album("Egzotyka").build());
        songList.add(Song.builder().id(3).title("Sectumsempra").artist("Taconafide").album("SOMA").build());
    }

    @Override
    public Optional<Song> getById(int id) {
        return songList.stream()
                .filter(song -> song.getId() == id)
                .findFirst();
    }

    @Override
    public List<Song> getList() {
        return songList;
    }

    @Override
    public Song addSong(SongRequest songRequest) {
        int ID = songList.isEmpty() ? 1 : songList.stream().mapToInt(Song::getId).max().getAsInt() + 1;

        Song song = Song.builder()
                .id(ID)
                .title(songRequest.getTitle())
                .artist(songRequest.getArtist())
                .album(songRequest.getAlbum())
                .build();

        songList.add(song);

        return song;
    }

    @Override
    public Optional<Song> editSong(int id, SongRequest songRequest) {
        return songList.stream()
                .filter(song -> song.getId() == id)
                .peek(song -> {
                    song.setTitle(songRequest.getTitle());
                    song.setArtist(songRequest.getArtist());
                    song.setAlbum(songRequest.getAlbum());
                })
                .findFirst();
    }

    @Override
    public void removeSong(int id) {
        songList.stream()
                .filter(song -> song.getId() == id)
                .findFirst()
                .ifPresent(songList::remove);
    }
}
