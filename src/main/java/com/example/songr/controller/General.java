package com.example.songr.controller;

import com.example.songr.model.Album;
import com.example.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class General {

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

    @GetMapping("/albums/{title}")
    public String albumByTitle(@PathVariable String title, Model model) {
        Album album = songRepository.findAlbumByTitle(title);
        Album[] albums = {album};
        model.addAttribute("albums", albums);
        return "albums";
    }

    @PostMapping("/addAlbum")
    @ResponseBody
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        try {
            songRepository.save(album);
            return new ResponseEntity<>(album, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAlbum/{title}")
    public ResponseEntity<Album> deleteAlbum(@PathVariable String title) {
        try {
            Album album = songRepository.findAlbumByTitle(title);
            songRepository.delete(album);
            return new ResponseEntity<>(album, HttpStatus.ACCEPTED);
//            return album;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/albums")
    public String albums(Model model) {
        Album happierThanEver = new Album("Happier Than Ever", "Billie Eilish", 16, 3367, "/assets/Billie-Eilish-Happier-Than-Ever.jpeg");
        Album thankYouNext = new Album("thank u, next", "Ariana Grande", 12, 2471, "/assets/thankYouNext.jpg");
        Album origin = new Album("Origins", "Imagine Dragons", 12, 2402, "/assets/origin.jpg");
        Album[] albums = {happierThanEver, thankYouNext, origin};
        model.addAttribute("albums", albums);
        // this try and catch is just for seeding
        try {
            songRepository.save(happierThanEver);
            songRepository.save(thankYouNext);
            songRepository.save(origin);
        } catch (Exception e) {
            System.out.println("Duplicate title value");
        }
        return "albums";

    }
}