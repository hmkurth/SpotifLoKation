package com.shk.service;

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
public class GetArtistLocation {
    @GET
    @Path("{id}")
    /**
     * This method takes the ArtistID from the path and gets all locations for that artist
     *
     * @return the response
     * @param id id of the artist
     */
    @Produces("application/json")
    public Response getArtistLocationById(@PathParam("id") String id) throws JsonProcessingException {

            ArtistDao dao = new ArtistDao();
            Artist artist = dao.getById(id);
            Set<Location> locations = artist.getLocations();

            ObjectMapper mapper = new ObjectMapper();
            String locationJSON = mapper.writeValueAsString(locations);
            return Response.status(200).entity(locationJSON).build();

    }
}
