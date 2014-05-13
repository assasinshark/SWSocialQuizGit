/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import ws.Jugador;

/**
 *
 * @author jairsh
 */
@Stateless
@Path("ws.jugador")
public class JugadorFacadeREST extends AbstractFacade<Jugador> {
    @PersistenceContext(unitName = "SWSocialQuizPU")
    private EntityManager em;

    public JugadorFacadeREST() {
        super(Jugador.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Jugador entity) 
    {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Jugador entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Jugador find(@PathParam("id") Long id) 
    {
        Jugador jug = super.find(id);
        return jug;
    }
    
    @GET
    @Path("ListaContrincantes/{ids}")
    @Produces({"application/json"})
    public List<Jugador> findContrincantes(@PathParam("ids") String ids) 
    {
        List<Jugador> lista = new ArrayList<Jugador>();
        String [] arr = ids.split(":");
        for(int pib = 0; pib<arr.length; pib++)
        {
            javax.persistence.Query q = getEntityManager().createNamedQuery("Jugador.findByIdJugador");
            q.setParameter("idJugador",Long.valueOf(arr[pib]));
            lista.addAll(q.getResultList());
        }
        return lista;
    }

    @GET 
    @Path("Contrincantes/{id}") 
    @Produces({"application/json"}) 
    public List<Jugador> findContrincantes(@PathParam("id") Long id) 
    {
        javax.persistence.Query q = getEntityManager().createNamedQuery("Jugador.findContrincantes");
        q.setParameter("idJugador", id);
        return q.getResultList();
    }
    
    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Jugador> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Jugador> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) 
    {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
