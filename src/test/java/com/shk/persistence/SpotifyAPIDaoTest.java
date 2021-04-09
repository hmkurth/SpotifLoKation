package com.shk.persistence;

import com.wrapper.spotify.model_objects.specification.Artist;
import com.wrapper.spotify.model_objects.specification.Image;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class SpotifyAPIDaoTest {


    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testSpotifyAPI() {

        SpotifyAPIDao auth = new SpotifyAPIDao();
        auth.clientCredentials_Sync();

        Artist returnedArtist = auth.getSpotifyArtist("0LcJLqbBmaGUft1e9Mm8HV");

        //playing around with getting images
        com.wrapper.spotify.model_objects.specification.Image[] images = returnedArtist.getImages();
        for (Image image : images) {
            logger.info(image.getUrl());
        }
        assert(returnedArtist.getName().equals("ABBA"));


    }
}
