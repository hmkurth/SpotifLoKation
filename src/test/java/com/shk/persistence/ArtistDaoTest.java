package com.shk.persistence;

import com.shk.entity.Artist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.util.Database;

import java.util.List;

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
}