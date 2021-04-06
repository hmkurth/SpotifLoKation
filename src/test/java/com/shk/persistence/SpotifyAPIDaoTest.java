package com.shk.persistence;

import com.wrapper.spotify.model_objects.specification.Artist;
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
        assert(returnedArtist.getName().equals("ABBA"));


    }
}
