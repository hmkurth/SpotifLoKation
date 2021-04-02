package com.shk.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(
        urlPatterns = {"/confirm-artist"}
)
public class confirmArtist extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idEntered = req.getParameter("spotifyId");
        logger.info(idEntered);

        //check db
            // if yes: return artist object w/ location
            // if no: attempt to select from Spotify API

                // if yes: return artist object
                // in no: return error message

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editArtist.jsp");
        dispatcher.forward(req, resp);

    }

}
