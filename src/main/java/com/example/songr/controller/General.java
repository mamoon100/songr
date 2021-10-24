package com.example.songr.controller;

import com.example.songr.model.Album;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class General {

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


    @GetMapping("/albums")
    public String albums(Model model) {
        Album happierThanEver = new Album("Happier Than Ever", "Billie Eilish", 16, 3367, "assets/Billie-Eilish-Happier-Than-Ever.jpeg");
        Album thankYouNext = new Album("thank u, next", "Ariana Grande", 12, 2471, "assets/thankYouNext.jpg");
        Album origin = new Album("Origins", "Imagine Dragons", 12, 2402, "assets/origin.jpg");
        Album[] albums = {happierThanEver, thankYouNext, origin};
        model.addAttribute("albums", albums);
        return "albums";
    }
}