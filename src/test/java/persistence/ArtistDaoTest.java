package persistence;

import entity.Artist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.util.Database;

import static org.junit.jupiter.api.Assertions.*;

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

    }

    @Test
    void update() {
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void getById() {
        String id = "5L3STwlqP4cN3E9rMWES48";
        Artist retrievedArtist = dao.getById(id);
        assert(retrievedArtist != null);
        assert(retrievedArtist.getArtist_name().equals("Good Grief"));

    }
}