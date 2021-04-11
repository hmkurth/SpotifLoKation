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
/**
 * Responsible for confirming the artist id added, and forwarding artist to editArtist jsp
 */
public class ConfirmArtist extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets user-entered artist id. Attempts to get id from the db first, if not calls retrieveArtist
     * Forwards artist object and boolean representing if the object is found to edit artist.
     * @param req request object
     * @param resp response object
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idEntered = req.getParameter("spotifyId");
        //logger.info(idEntered);

        Artist artist;
        boolean isFound;

        if (idEntered != null) {
            artist = retrieveArtist(idEntered);

            if (artist.getId() != null ) {
                isFound = true;
            } else {
                isFound = false;
            }

            req.setAttribute("artist", artist);
            req.setAttribute("isFound", isFound);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editArtist.jsp");
        dispatcher.forward(req, resp);

    }

    /**
     * Fetches a Spotify Artist object and creates a new Artist object.
     * @param id spotify artist id
     * @return Artist object
     */
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
