package com.shk.persistence;

import com.shk.entity.Artist;
import com.shk.entity.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.util.Database;

import java.util.List;
import java.util.Set;

class ArtistDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    ArtistDao dao;
    @BeforeEach
    void setUp() {
        dao = new ArtistDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllArtists() {
        List<Artist> allArtists = dao.getAllArtists();
        assert(allArtists.size() == 3 );
    }

    @Test
    void update() {
        String id = "5L3STwlqP4cN3E9rMWES48";
        Artist retrievedArtist = dao.getById(id);
        retrievedArtist.setArtist_name("Great Grief");
        dao.update(retrievedArtist);

        Artist updatedArtist = dao.getById(id);
        assert(updatedArtist.getArtist_name().equals("Great Grief"));
    }

    @Test
    void insert() {
        Artist newArtist = new Artist("1US3cA3tVZ50O7n4xE1o0K", "The Weakerthans");
        dao.insert(newArtist);

        assert(dao.getAllArtists().size() == 4);

    }

    @Test
    void delete() {
        String id = "5L3STwlqP4cN3E9rMWES48";
        Artist artistToDelete = dao.getById(id);
        dao.delete(artistToDelete);

        Artist artistAfterDelete = dao.getById(id);
        assert(artistAfterDelete == null);
    }

    @Test
    void getById() {
        String id = "5L3STwlqP4cN3E9rMWES48";
        Artist retrievedArtist = dao.getById(id);
        assert(retrievedArtist.getArtist_name().equals("Good Grief"));

    }

    @Test
    void getArtistLocations() {
        String id = "5L3STwlqP4cN3E9rMWES48";
        Artist artist = dao.getById(id);
        Set<Location> locations = artist.getLocations();
        assert(locations.size() == 2);

    }


    @Test
    void addArtistLocation() {
        Location location = new Location("US", "WI", "Milwaukee");
        LocationDao locationDao = new LocationDao();
        locationDao.insert(location);

        String id = "5L3STwlqP4cN3E9rMWES48";
        Artist artist = dao.getById(id);
        artist.addLocation(location);

        dao.update(artist);

        Artist artistAfterUpdate = dao.getById(id);
        Set<Location> locationsAfterUpdate = artistAfterUpdate.getLocations();
        assert(locationsAfterUpdate.size() == 3);


    }

    @Test
    void deleteArtistLocation() {
        LocationDao locationDao = new LocationDao();
        Location location = locationDao.getById(1);

        String id = "5L3STwlqP4cN3E9rMWES48";
        Artist artist = dao.getById(id);
        artist.removeLocation(location);

        dao.update(artist);
        //locationDao.update(location);

        Artist artistAfterUpdate = dao.getById(id);
        Set<Location> locationsAfterUpdate = artistAfterUpdate.getLocations();
        logger.info(locationsAfterUpdate.size());
        assert(locationsAfterUpdate.size() == 1);
    }


}