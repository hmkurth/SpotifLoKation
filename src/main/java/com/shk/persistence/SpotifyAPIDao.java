package com.shk.persistence;


import com.shk.entity.Image;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.Artist;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.artists.GetArtistRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

import com.shk.utilities.PropertiesLoader;

public class SpotifyAPIDao implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private final SpotifyApi spotifyApi;

    /**
     * Default constructor loads in client information from the properties file
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


        } catch (IOException | SpotifyWebApiException | org.apache.hc.core5.http.ParseException e) {
            logger.info("Error: " + e.getMessage());
        }

        return artist;

    }

    /**
     * @param spotifyArtist
     * @return
     */
    public Image getSpotifyArtistImage(Artist spotifyArtist) {

       Image imageToSave = null;
            com.wrapper.spotify.model_objects.specification.Image[] images = spotifyArtist.getImages();
            for (Image image : images) {
                imageToSave = image;
                logger.info(image.getUrl());
            }



        return imageToSave;

    }
}
