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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jairsh
 */
@Entity
@Table(name = "Turno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t"),
    @NamedQuery(name = "Turno.findByIdTurno", query = "SELECT t FROM Turno t WHERE t.idTurno = :idTurno"),
    @NamedQuery(name = "Turno.findByIdPartida", query = "SELECT t FROM Turno t WHERE t.idPartida = :idPartida"),
    @NamedQuery(name = "Turno.findByIdJug", query = "SELECT t FROM Turno t WHERE t.idJug = :idJug"),
    @NamedQuery(name = "Turno.findByNturno", query = "SELECT t FROM Turno t WHERE t.nturno = :nturno"),
    @NamedQuery(name = "Turno.findByPistas", query = "SELECT t FROM Turno t WHERE t.pistas = :pistas"),
    @NamedQuery(name = "Turno.findByResp", query = "SELECT t FROM Turno t WHERE t.resp = :resp"),
    @NamedQuery(name = "Turno.findByFecha", query = "SELECT t FROM Turno t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "Turno.findByPuntos", query = "SELECT t FROM Turno t WHERE t.puntos = :puntos"),
    @NamedQuery(name = "Turno.findByEstado", query = "SELECT t FROM Turno t WHERE t.estado = :estado"),
    @NamedQuery(name = "Turno.findUltimoTurno", query = "SELECT t.idTurno, t.idPartida, t.idJug, t.nturno, t.pistas, t.resp, t.fecha, t.puntos, t.estado FROM Turno t WHERE t.idPartida = :idPartida AND (SELECT MAX(tu.nturno) as turno FROM Turno tu WHERE tu.idPartida = :idPartida) = t.nturno")
})
public class Turno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTurno")
    private Long idTurno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPartida")
    private long idPartida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idJug")
    private long idJug;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nturno")
    private long nturno;
    @Size(max = 200)
    @Column(name = "pistas")
    private String pistas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "resp")
    private String resp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntos")
    private int puntos;
    @Column(name = "estado")
    private Short estado;

    public Turno() {
    }

    public Turno(Long idTurno) {
        this.idTurno = idTurno;
    }

    public Turno(Long idTurno, long idPartida, long idJug, long nturno, String resp, Date fecha, int puntos) {
        this.idTurno = idTurno;
        this.idPartida = idPartida;
        this.idJug = idJug;
        this.nturno = nturno;
        this.resp = resp;
        this.fecha = fecha;
        this.puntos = puntos;
    }

    public Long getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Long idTurno) {
        this.idTurno = idTurno;
    }

    public long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(long idPartida) {
        this.idPartida = idPartida;
    }

    public long getIdJug() {
        return idJug;
    }

    public void setIdJug(long idJug) {
        this.idJug = idJug;
    }

    public long getNturno() {
        return nturno;
    }

    public void setNturno(long nturno) {
        this.nturno = nturno;
    }

    public String getPistas() {
        return pistas;
    }

    public void setPistas(String pistas) {
        this.pistas = pistas;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTurno != null ? idTurno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.idTurno == null && other.idTurno != null) || (this.idTurno != null && !this.idTurno.equals(other.idTurno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.Turno[ idTurno=" + idTurno + " ]";
    }
    
}
