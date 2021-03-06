package com.example.songr.repository;


import com.example.songr.model.Album;
import com.example.songr.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Integer> {
    Song findSongByTitle(String title);

    Song[] findSongByAlbum(Album album);
}
