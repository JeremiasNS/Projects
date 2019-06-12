package com.jeremiasneres.rest;

import com.jeremiasneres.dao.DAO;
import com.jeremiasneres.model.Piloto;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author aluno
 */
@Path("/piloto")
public class PilotoResource {
   
    @Inject
    private DAO<Piloto> dao;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Piloto findById(@PathParam("id") long id) {
       // System.out.println("findById: " + id);
        return dao.findById(id);
       // return new Piloto();
    }
}
