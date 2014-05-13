/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jairsh
 */
@Entity
@Table(name = "Invitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invitacion.findAll", query = "SELECT i FROM Invitacion i"),
    @NamedQuery(name = "Invitacion.findByIdInv", query = "SELECT i FROM Invitacion i WHERE i.idInv = :idInv"),
    @NamedQuery(name = "Invitacion.findByIdRem", query = "SELECT i FROM Invitacion i WHERE i.idRem = :idRem"),
    @NamedQuery(name = "Invitacion.findByIdDest", query = "SELECT i FROM Invitacion i WHERE i.idDest = :idDest"),
    @NamedQuery(name = "Invitacion.findByFecha", query = "SELECT i FROM Invitacion i WHERE i.fecha = :fecha"),
    @NamedQuery(name = "Invitacion.findByResp", query = "SELECT i FROM Invitacion i WHERE i.resp = :resp")})
public class Invitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInv")
    private Long idInv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRem")
    private long idRem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDest")
    private long idDest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "resp")
    private Short resp;

    public Invitacion() {
    }

    public Invitacion(Long idInv) {
        this.idInv = idInv;
    }

    public Invitacion(Long idInv, long idRem, long idDest, Date fecha) {
        this.idInv = idInv;
        this.idRem = idRem;
        this.idDest = idDest;
        this.fecha = fecha;
    }

    public Long getIdInv() {
        return idInv;
    }

    public void setIdInv(Long idInv) {
        this.idInv = idInv;
    }

    public long getIdRem() {
        return idRem;
    }

    public void setIdRem(long idRem) {
        this.idRem = idRem;
    }

    public long getIdDest() {
        return idDest;
    }

    public void setIdDest(long idDest) {
        this.idDest = idDest;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Short getResp() {
        return resp;
    }

    public void setResp(Short resp) {
        this.resp = resp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInv != null ? idInv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invitacion)) {
            return false;
        }
        Invitacion other = (Invitacion) object;
        if ((this.idInv == null && other.idInv != null) || (this.idInv != null && !this.idInv.equals(other.idInv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.Invitacion[ idInv=" + idInv + " ]";
    }
    
}
