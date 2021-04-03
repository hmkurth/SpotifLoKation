package com.shk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shk.entity.Artist;
import com.shk.entity.Location;
import com.shk.persistence.ArtistDao;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;

@Path("/locations")
public class RestService {
    @GET
    @Path("{id}")
    public Response getArtistLocationById(@PathParam("id") String id) throws JsonProcessingException {

            Artist artist = new Artist();
            artist.setId(id);
            artist.setArtist_name("Good Grief");
            ArtistDao dao = new ArtistDao();

        Set<Location> locations = new HashSet<>();
        Location location = new Location("US", "WI", "Madison");
        locations.add(location);
        artist.setLocations(locations);

        Set<Location> locationOutput = artist.getLocations();
        ObjectMapper mapper = new ObjectMapper();
        String locationJSON = mapper.writeValueAsString(locationOutput);
        return Response.status(200).entity(locationJSON + " The Artist ID: " + id).build();
    }
}
