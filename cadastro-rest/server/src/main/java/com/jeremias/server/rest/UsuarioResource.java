package com.jeremias.server.rest;

import com.jeremias.server.dao.DAO;
import com.jeremias.server.model.Usuario;
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

@Path("usuario")
@Transactional
public class UsuarioResource {
    @Inject
    private DAO<Usuario> dao;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario findById(@PathParam("id") long id) {
        return dao.findById(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public long update(Usuario usuario) {
        return dao.save(usuario);
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") long id ){
        return dao.remove(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public long insert(Usuario usuario) {
        return dao.save(usuario);
    }
    
}