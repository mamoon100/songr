package com.example.songr.repository;

import com.example.songr.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Album, Integer> {
    Album findAlbumByTitle(String title);
}
