package com.shk.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/edit-location"}
)

public class EditLocation extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("submit").equals("removeLocation")){
            logger.info("remove location");
        } else if (req.getParameter("submit").equals("addLocation")) {
            logger.info("add location");
        }


    }

    public void removeLocation(int locationId, String artistId) {

    }

    public void addLocation(String artistId) {

    }
}