package com.shk.controller;

import com.shk.entity.Artist;
import com.shk.entity.Location;
import com.shk.persistence.ArtistDao;
import com.shk.persistence.LocationDao;
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
        urlPatterns = {"/remove-location"}
)

public class RemoveLocation extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artistId = req.getParameter("artistId");
        int locationId = Integer.parseInt((req.getParameter("location")));
        logger.info("remove location for artist: " + artistId + ", and location: " + locationId);

        LocationDao locationDao = new LocationDao();
        ArtistDao artistDao = new ArtistDao();
        Location location = locationDao.getById(locationId);
        Artist artist = artistDao.getById(artistId);
        artist.removeLocation(location);
        artistDao.update(artist);

        req.setAttribute("artist", artist);
        req.setAttribute("isFound", true);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editArtist.jsp");
        dispatcher.forward(req, resp);



    }


}
