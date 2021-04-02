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

class LocationDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    LocationDao dao;
    @BeforeEach
    void setUp() {
        dao = new LocationDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllLocations() {
        List<Location> allLocations = dao.getAllLocations();
        assert(allLocations.size() == 3);
    }

    @Test
    void update() {
        int id = 1;
        Location retrievedLocation = dao.getById(id);
        retrievedLocation.setCity("Mad Town");
        dao.update(retrievedLocation);

        Location updatedLocation = dao.getById(id);
        assert(updatedLocation.getCity().equals("Mad Town"));

    }

    @Test
    void insert() {
        Location newLocation = new Location ("US", "WI", "Milwaukee");
        int id = dao.insert(newLocation);

        Location retrievedLocation = dao.getById(id);
        assert(retrievedLocation.getCity().equals("Milwaukee"));
    }

    @Test
    void delete() {
        int id = 1;
        Location locationToDelete = dao.getById(id);
        dao.delete(locationToDelete);

        Location locationAfterDelete = dao.getById(id);
        assert(locationAfterDelete == null);


    }

    @Test
    void getById() {
        int id = 1;
        Location retrievedLocation = dao.getById(id);
        assert(retrievedLocation.getCity().equals("Madison"));
    }



}