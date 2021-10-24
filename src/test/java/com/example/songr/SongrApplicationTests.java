package com.example.songr;

import com.example.songr.model.Album;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SongrApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void albumTester() {
        Album happierThanEver = new Album("Happier Than Ever", "Billie Eilish", 16, 3367, "assets/Billie-Eilish-Happier-Than-Ever.jpeg");
        Assertions.assertEquals(happierThanEver.getArtist(), "Billie Eilish", "There was problem in the getter method");
        happierThanEver.setTitle("Mamoun");
        Assertions.assertEquals(happierThanEver.getTitle(), "Mamoun", "There was a problem in the setter method");
    }

}
