package com.shk.persistence;


import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.Artist;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.artists.GetArtistRequest;
import com.wrapper.spotify.requests.data.artists.GetSeveralArtistsRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

import com.shk.utilities.PropertiesLoader;

public class SpotifyAPIDao implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private final SpotifyApi spotifyApi;

    /**
     *
     */
    public SpotifyAPIDao() {

        String clientId = null;
        String clientSecret = null;

        Properties spotifyProperties = new Properties();
        try {
            spotifyProperties = loadProperties("/spotifyAPI.properties");
            clientId = spotifyProperties.getProperty("clientId");
            clientSecret = spotifyProperties.getProperty("clientSecret");

        } catch (IOException iOException) {
            logger.error("SpotifyAPIDao failed to load properties..." + iOException);

        } catch (Exception exception) {
            logger.error("SpotifyAPIDao failed to load properties..." + exception);
        }

        spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build();

    }

    /**
     * Constructor with api builder
     *
     * @param clientId
     * @param clientSecret
     */
    public SpotifyAPIDao(String clientId, String clientSecret) {

        spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build();
    }

    /**
     * Sets the client credentials (Access Token)
     */
    public void clientCredentials_Sync() {

        final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
                .build();

        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            // Set access token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            //logger.info(clientCredentials.getAccessToken());
            //logger.info("Expires in: " + clientCredentials.getExpiresIn());
        } catch (IOException | SpotifyWebApiException e) {
            logger.error("Error: " + e.getMessage());
        } catch (org.apache.hc.core5.http.ParseException e) {
            logger.error("Error: " + e);
        }


    }

    /**
     * @param spotifyId
     * @return
     */
    public Artist getSpotifyArtist(String spotifyId) {

        final GetArtistRequest getArtistRequest = spotifyApi.getArtist(spotifyId)
                .build();

        Artist artist = null;

        try {
            artist = getArtistRequest.execute();


            //logger.info("Name: " + artist.getName());
            //logger.info("Spotify ID: " + artist.getId());


        } catch (IOException | SpotifyWebApiException | org.apache.hc.core5.http.ParseException e) {
            logger.info("Error: " + e.getMessage());
        }

        return artist;

    }

    public Artist[] getSeveralSpotifyArtists(String[] ids) {
        final GetSeveralArtistsRequest getSeveralArtistsRequest = spotifyApi.getSeveralArtists(ids)
                .build();
        Artist[] artists = null;

        try {
            artists = getSeveralArtistsRequest.execute();

            logger.error("Length: " + artists.length);
        } catch (IOException | SpotifyWebApiException | org.apache.hc.core5.http.ParseException e) {
            logger.error("Error: " + e.getMessage());
        }

        return artists;
    }
}
