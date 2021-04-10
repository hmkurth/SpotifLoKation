package com.shk.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shk.entity.Artist;
import com.shk.entity.Location;
import com.shk.persistence.ArtistDao;
import com.shk.persistence.LocationDao;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/all")
public class GetAll {
    @GET
    /**
     * This  method gets all artist and Location data and returns it as JSON data
     *
     * @return the response
     */
    public Response getAll() throws JsonProcessingException {
        ArtistDao artistDao = new ArtistDao();

        LocationDao locationDao = new LocationDao();

        List<Artist> artists = artistDao.getAllArtists();
        List<Location> locations = locationDao.getAllLocations();

        ObjectMapper mapper = new ObjectMapper();
        String artistData = mapper.writeValueAsString(artists);
        String locationData = mapper.writeValueAsString(locations);
        return Response.status(200).entity(artistData + locationData).build();
    }
}
