package com.shk.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

class GetAllTest {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    void getAll() {
        Response result = null;
        GetAll test = new GetAll();

        try {
            result = test.getAll();
        } catch (JsonProcessingException e) {
            logger.error(e);
        }
        assertEquals(result.getStatus(), 200);
    }
}