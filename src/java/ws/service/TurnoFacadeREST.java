/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import ws.Turno;

/**
 *
 * @author jairsh
 */
@Stateless
@Path("ws.turno")
public class TurnoFacadeREST extends AbstractFacade<Turno> {
    @PersistenceContext(unitName = "SWSocialQuizPU")
    private EntityManager em;

    public TurnoFacadeREST() {
        super(Turno.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Turno entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/json"})
    public void edit(Turno entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) 
    {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Turno find(@PathParam("id") Long id) {
        return super.find(id);
    }
    @GET
    @Path("UltimoTurno/{id}")
    @Produces({"application/json"})
    public Turno findUltimoTurno(@PathParam("id") Long id) 
    {
        Turno resp = null;
        javax.persistence.Query q = getEntityManager().createNamedQuery("Turno.findUltimoTurno");
        q.setParameter("idPartida",id);
        Object [] lista = (Object[]) ((Vector) q.getResultList()).get(0);
        if(lista!=null)
        {
            resp = new Turno();
             resp.setIdTurno((Long) lista[0]); 
             resp.setIdPartida((Long) lista[1]);
             resp.setIdJug((Long) lista[2]);
             resp.setNturno((Long) lista[3]);
             resp.setEstado((Short) lista[8]);
             resp.setFecha((Date) lista[6]);
             resp.setPistas((String) lista[4]);
             resp.setPuntos((int) lista[7]);
             resp.setResp((String) lista[5]);
        }
        return resp;
    }
    
    @GET
    @Path("UltimosTurnos/{ids}")
    @Produces({"application/json"})
    public List<Turno> findUltimosTurnos(@PathParam("ids") String ids) 
    {
        List<Turno> turnos = new ArrayList<Turno>();
        String [] arr = ids.split(":");
        for(int pib = 0; pib<arr.length; pib++)
        {
            Turno resp = null;
            javax.persistence.Query q = getEntityManager().createNamedQuery("Turno.findUltimoTurno");
            q.setParameter("idPartida",Long.valueOf(arr[pib]));
            Object [] lista = (Object[]) ((Vector) q.getResultList()).get(0);
            if(lista!=null)
            {
                resp = new Turno();
                resp.setIdTurno((Long) lista[0]); 
                resp.setIdPartida((Long) lista[1]);
                resp.setIdJug((Long) lista[2]);
                resp.setNturno((Long) lista[3]);
                resp.setEstado((Short) lista[8]);
                resp.setFecha((Date) lista[6]);
                resp.setPistas((String) lista[4]);
                resp.setPuntos((int) lista[7]);
                resp.setResp((String) lista[5]);
            }
            turnos.add(resp);
        }
        return turnos;
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Turno> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Turno> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
