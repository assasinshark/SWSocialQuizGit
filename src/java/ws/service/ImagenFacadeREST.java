/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
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
import ws.Imagen;
import ws.Jugador;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author jairsh
 */
@Stateless
@Path("ws.imagen")
public class ImagenFacadeREST extends AbstractFacade<Imagen> {
    @PersistenceContext(unitName = "SWSocialQuizPU")
    private EntityManager em;
    private String ruta="/Users/jairsh/Pictures/FotosJuego/";
    
    @Context
    private ServletContext context; 
    

    public ImagenFacadeREST() {
        super(Imagen.class);
    }
    @POST
    @Path("Subir")
    @Consumes({"application/json"})
    public void subir(Imagen entity) 
    {
        this.crearImagen(entity.getId(),entity.getDatos(),entity.getTipo(),entity.getIndice());
        //Imagen img = new Imagen();
        //super.create(entity);
    }
    @PUT
    @Path("SubirImg/{tipo}/{id}/{indice}/{datos}")
    @Consumes({"application/json"})
    public void subirImg(@PathParam("tipo") int tipo, @PathParam("id") Long id, @PathParam("indice") int indice, @PathParam("datos") String datos) 
    {
        
        this.crearImagen(id,datos,tipo,indice);
        Imagen img = new Imagen();
        //super.create(entity);
    }
    

/*
    @GET
    @Path("SubirImgs/{tipo}/{id}/{indice}/{datos}")
    @Consumes({"application/json"})
    public Boolean subirImgGet(@PathParam("tipo") int tipo, @PathParam("id") Long id, @PathParam("indice") int indice, @PathParam("datos") byte[] datos) 
    {
        this.crearImagen(id,datos.toString(),tipo,indice);
        Imagen img = new Imagen();
        //super.create(entity);
        return true;
    }
    */
    @GET
    @Path("Imagen/{tipo}/{id}/{indice}")
    @Produces({"application/json"})
    public Imagen find(@PathParam("tipo") int tipo,@PathParam("id") Long id, @PathParam("indice") int indice) 
    {
        Imagen img = new Imagen();
        img.setDatos(this.cargarImagen(id,tipo,indice));
        img.setId((long)indice);
        img.setTipo(tipo);
        return img;
    }
    
    @GET
    @Path("StringImagen/{id}/{indice}")
    @Produces({"image/png"})
    public byte[] StringImagen(@PathParam("id") Long id, @PathParam("indice") int indice) 
    {
        return this.cargarImagenBytes(id,2,indice);
    }
    @GET
    @Path("StringImagenUsu/{id}/{indice}")
    @Produces({"image/png"})
    public byte[] StringImagenUsu(@PathParam("id") Long id, @PathParam("indice") int indice) 
    {
        return this.cargarImagenBytes(id,1,indice);
    }
    
    
    @GET
    @Path("ImagenesPartida/{id}")
    @Produces({"application/json"})
    public List<Imagen> imagenesPartida(@PathParam("id") Long id) 
    {
        List<Imagen> imgs = new ArrayList<Imagen>();
        Imagen img = new Imagen();
        img.setDatos(this.cargarImagen(id,2,1));
        img.setTipo(2);
        img.setId(1L);
        imgs.add(img);
        img.setDatos(this.cargarImagen(id,2,2));
        img.setTipo(2);
        img.setId(2L);
        imgs.add(img);
        return imgs;
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public String cargarImagen(Long idimg,int tipo, int indice)
    {
        File fnew;
        String img = null;
        try 
        {
            if(tipo == 1)
            {
                fnew=new File(ruta+"Jugadores/Jug_"+idimg+".png");
            }
            else
            {
                fnew=new File(ruta+"/Turnos/Partida_"+idimg+"_Ind_"+indice+".png");
            }
            boolean exi =fnew.exists();
            String a = fnew.getAbsolutePath();
            BufferedImage originalImage;
            originalImage = ImageIO.read(fnew);
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            ImageIO.write(originalImage, "png", baos );
            byte [] byteimg=baos.toByteArray();
            img = new String(byteimg,"utf-8");
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return img;
    }
    public byte[] cargarImagenBytes(Long idimg,int tipo, int indice)
    {
        File fnew;
        byte [] byteimg = null;
        try 
        {
            if(tipo == 1)
            {
                fnew=new File(ruta+"Jugadores/Jug_"+idimg+".png");
            }
            else
            {
                fnew=new File(ruta+"/Turnos/Partida_"+idimg+"_Ind_"+indice+".png");
            }
            boolean exi =fnew.exists();
            String a = fnew.getAbsolutePath();
            BufferedImage originalImage;
            originalImage = ImageIO.read(fnew);
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            ImageIO.write(originalImage, "png", baos );
            byteimg=baos.toByteArray();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return byteimg;
    }
    public boolean crearImagen(Long idimg,String datos,int tipo,int indice)
    {
        boolean res = false;
        File fnew;
        try 
        {
            if(tipo == 1)
            {
                fnew=new File(ruta+"/Jugadores/Jug_"+idimg+".png");
            }
            else
            {
                fnew=new File(ruta+"/Turnos/Partida_"+idimg+"_Ind_"+indice+".png");
            }
            //byte [] bytes = datos.getBytes();
            byte[] bytes = Base64.decodeBase64(datos);
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
            ImageIO.write(img, "png", fnew);
            //res = true;            
        } 
        catch (IOException ex) 
        {
            //Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
