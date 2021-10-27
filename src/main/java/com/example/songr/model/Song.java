package com.example.songr.model;

import com.example.songr.repository.AlbumRepository;
import com.example.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int len;
    private int trackNumber;
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;


    public Song(String title, int len, int trackNumber, Album album) {
        this.title = title;
        this.len = len;
        this.trackNumber = trackNumber;
    }

    protected Song() {

    }

    public Album getAlbum() {
        return album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }
}
