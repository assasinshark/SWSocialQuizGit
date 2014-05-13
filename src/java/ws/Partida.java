/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jairsh
 */
@Entity
@Table(name = "Partida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partida.findAll", query = "SELECT p FROM Partida p"),
    @NamedQuery(name = "Partida.findByIdPartida", query = "SELECT p FROM Partida p WHERE p.idPartida = :idPartida"),
    @NamedQuery(name = "Partida.findByIdJug1", query = "SELECT p FROM Partida p WHERE p.idJug1 = :idJug1"),
    @NamedQuery(name = "Partida.findByIdJug2", query = "SELECT p FROM Partida p WHERE p.idJug2 = :idJug2"),
    @NamedQuery(name = "Partida.findByEstado", query = "SELECT p FROM Partida p WHERE p.estado = :estado"),
    @NamedQuery(name = "Partida.findByIdJug", query = "SELECT p FROM Partida p WHERE p.idJug1 = :idJug OR p.idJug2 = :idJug")
})
public class Partida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPartida")
    private Long idPartida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idJug1")
    private long idJug1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idJug2")
    private long idJug2;
    @Column(name = "estado")
    private Short estado;
    

    public Partida() {
    }

    public Partida(Long idPartida) {
        this.idPartida = idPartida;
    }

    public Partida(Long idPartida, long idJug1, long idJug2) {
        this.idPartida = idPartida;
        this.idJug1 = idJug1;
        this.idJug2 = idJug2;
    }

    public Long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Long idPartida) {
        this.idPartida = idPartida;
    }

    public long getIdJug1() {
        return idJug1;
    }

    public void setIdJug1(long idJug1) {
        this.idJug1 = idJug1;
    }

    public long getIdJug2() {
        return idJug2;
    }

    public void setIdJug2(long idJug2) {
        this.idJug2 = idJug2;
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
        hash += (idPartida != null ? idPartida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partida)) {
            return false;
        }
        Partida other = (Partida) object;
        if ((this.idPartida == null && other.idPartida != null) || (this.idPartida != null && !this.idPartida.equals(other.idPartida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.Partida[ idPartida=" + idPartida + " ]";
    }
    
}
