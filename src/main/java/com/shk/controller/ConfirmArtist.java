package com.shk.controller;

import com.shk.entity.Artist;
import com.shk.persistence.ArtistDao;
import com.shk.persistence.SpotifyAPIDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        urlPatterns = {"/confirm-artist"}
)
public class ConfirmArtist extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idEntered = req.getParameter("spotifyId");
        logger.info(idEntered);


        Artist artist;
        String message;


        if (idEntered != null) {
            artist = retrieveArtist(idEntered);

            if (artist != null ) {
                message = "artist found";
            } else {
                message = "I'm sorry we could not locate that artist";
            }

            req.setAttribute("artist", artist);
            req.setAttribute("message", message);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editArtist.jsp");
        dispatcher.forward(req, resp);

    }

    public Artist retrieveArtist(String id) {

        ArtistDao dao = new ArtistDao();
        Artist artist = dao.getById(id);

        if (artist != null ) {
            return artist;

        } else {
            artist = new Artist();

            SpotifyAPIDao spotifyAPIDao = new SpotifyAPIDao();
            spotifyAPIDao.clientCredentials_Sync();
            com.wrapper.spotify.model_objects.specification.Artist spotifyArtist = spotifyAPIDao.getSpotifyArtist(id);

            if (spotifyArtist != null) {
                String spotifyName = spotifyArtist.getName();
                artist.setArtist_name(spotifyName);
                artist.setId(id);
                dao.insert(artist);
            }

            return artist;
        }
    }

}
