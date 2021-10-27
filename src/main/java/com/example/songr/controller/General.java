package com.example.songr.controller;

import com.example.songr.model.Album;
import com.example.songr.model.Song;
import com.example.songr.repository.AlbumRepository;
import com.example.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
public class General {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/")
    public String root(@RequestHeader Map<String, String> headers, Model model) {
        String browser = headers.get("sec-ch-ua").split(",")[0].split(";")[0];
        String OS = headers.get("sec-ch-ua-platform");
        model.addAttribute("OS", OS);
        model.addAttribute("browser", browser);
        return "index";
    }

    @GetMapping("/hello")
    public String greeting(@RequestParam("name") String name, Model model) {
        System.out.println(name);
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/album/{title}")
//    @ResponseBody
    public String albumByTitle(@PathVariable String title, Model model) {
        Album album = albumRepository.findAlbumByTitle(title);
        Song[] songs = songRepository.findSongByAlbum(album);
        model.addAttribute("album", album);
        model.addAttribute("songs", songs);
//        System.out.println(Arrays.toString(albums));
//        System.out.println(Arrays.toString(songs));
//        return album.getTitle();
        return "album";
    }

    @PostMapping("/album/{title}")
    public RedirectView addSongByAlbum(@PathVariable String title, @RequestBody Song song) {
        System.out.println(song);
        Album album = albumRepository.findAlbumByTitle(title);
//        songRepository.save(song);
        return new RedirectView("/album/" + title);
    }

    @PostMapping("/addAlbum")
    @ResponseBody
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        try {
            albumRepository.save(album);
            return new ResponseEntity<>(album, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAlbum/{title}")
    public ResponseEntity<Album> deleteAlbum(@PathVariable String title) {
        try {
            Album album = albumRepository.findAlbumByTitle(title);
            albumRepository.delete(album);
            return new ResponseEntity<>(album, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/albums")
    public String albums(Model model) {
        Album happierThanEver = new Album("Happier Than Ever", "Billie Eilish", 16, 3367, "/assets/Billie-Eilish-Happier-Than-Ever.jpeg");
        Album thankYouNext = new Album("thank u, next", "Ariana Grande", 12, 2471, "/assets/thankYouNext.jpg");
        Album origin = new Album("Origins", "Imagine Dragons", 12, 2402, "/assets/origin.jpg");
        Song badLair = new Song("Bad laier", 50, 12, origin);
        Song demon = new Song("Demon", 150, 10, origin);
        Song board = new Song("Board", 200, 9, happierThanEver);
        Song sevenRings = new Song("Seven Rings", 180, 10, thankYouNext);
        // this try and catch is just for seeding
        try {
            albumRepository.save(happierThanEver);
            albumRepository.save(thankYouNext);
            albumRepository.save(origin);
            songRepository.save(badLair);
            songRepository.save(demon);
            songRepository.save(board);
            songRepository.save(sevenRings);
        } catch (Exception e) {
            System.out.println("Duplicate title valuse");
        }
        Iterable<Album> albums = albumRepository.findAll();
        model.addAttribute("albums", albums);
        return "albums";

    }

    @GetMapping("/songs")
    public String showSongs(Model model) {
        Iterable<Song> songs = songRepository.findAll();
        model.addAttribute("songs", songs);
        return "songs";
    }
}