package com.jeremiasneres.rest;

import com.jeremiasneres.dao.DAO;
import com.jeremiasneres.model.Piloto;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author aluno
 */
@Transactional
@Path("/piloto")
public class PilotoResource {
   
    @Inject
    private DAO<Piloto> dao;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Piloto findById(@PathParam("id") long id) {
       //System.out.println("findById: " + id);
        return dao.findById(id);
       // return new Piloto();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Piloto piloto) {
        dao.save(piloto);
    }
}
