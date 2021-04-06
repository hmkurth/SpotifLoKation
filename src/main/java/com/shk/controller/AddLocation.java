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
import java.util.List;

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
        Location location = null;

        //TODO - This doesn't really work, there's not a good way to check for an existing location
        List<Location> locations = locationDao.getAllLocations();
        for (Location l : locations) {
            String thisCountry = l.getCountry();
            String thisRegion = l.getRegion();
            String thisCity = l.getCity();

            if (thisCountry.equals(country) && thisRegion.equals(region) && thisCity.equals(city)) {
                location = l;
            } else {
                location = new Location();
                location.setCountry(country);
                location.setRegion(region);
                location.setCity(city);
            }
        }



        locationDao.insert(location);
        artist.addLocation(location);

        req.setAttribute("artist", artist);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editArtist.jsp");
        dispatcher.forward(req, resp);

    }
}
