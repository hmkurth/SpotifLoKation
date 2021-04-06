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
        urlPatterns = {"/add-location"}
)
public class AddLocation extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String country = req.getParameter("country");
        String region = req.getParameter("region");
        String city = req.getParameter("city");
        String artistId = req.getParameter("artistId");

        LocationDao locationDao = new LocationDao();
        ArtistDao artistDao = new ArtistDao();

        Artist artist = artistDao.getById(artistId);

        //TODO - Does the entered location already exist?

        Location newLocation = new Location();
        newLocation.setCountry(country);
        newLocation.setRegion(region);
        newLocation.setCity(city);

        locationDao.insert(newLocation);
        artist.addLocation(newLocation);

        req.setAttribute("artist", artist);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editArtist.jsp");
        dispatcher.forward(req, resp);

    }
}
