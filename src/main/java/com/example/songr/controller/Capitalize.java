package com.example.songr.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/capitalize")
@Controller
public class Capitalize {

    @GetMapping("/{word}")
//    @ResponseBody
    public String capitalize(@PathVariable String word, Model model) {
        model.addAttribute("word", word.toUpperCase());
        return "capitalize";
    }
}
