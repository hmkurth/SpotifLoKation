package edu.matc.persistence;

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

        String[]ids = {"2uYWxilOVlUdk4oV9DvwqK", "07D1Bjaof0NFlU32KXiqUP", "1r1uxoy19fzMxunt3ONAkG"};
        Artist[] artists = auth.getSeveralSpotifyArtists(ids);
        assert(artists.length == 3 );


    }
}
