package com.shk.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shk.entity.Artist;
import com.shk.persistence.ArtistDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

class GetArtistLocationTest {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    void getArtistLocationById() {
        String id = "5L3STwlqP4cN3E9rMWES48";
        Response result = null;
        GetArtistLocation test = new GetArtistLocation();

        try {
            result = test.getArtistLocationById(id);
        } catch (JsonProcessingException e) {
            logger.error(e);
        }
        assertEquals(result.getStatus(), 200);
    }
}