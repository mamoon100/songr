package com.example.songr.model;

import javax.persistence.*;

@Entity
public class Album {
    //    title, an artist, a songCount, a length (in seconds), and an imageUr

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    private String title;
    private String artist;
    private int songCount;
    private int len;
    private String imageUrl;


    public Album(String title, String artist, int songCount, int len, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.len = len;
        this.imageUrl = imageUrl;
    }

    protected Album() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUr) {
        this.imageUrl = imageUr;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", songCount=" + songCount +
                ", len=" + len +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
