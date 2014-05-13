/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;


import java.io.Serializable;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "Jugador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j"),
    @NamedQuery(name = "Jugador.findByIdJugador", query = "SELECT j FROM Jugador j WHERE j.idJugador = :idJugador"),
    @NamedQuery(name = "Jugador.findByIdFace", query = "SELECT j FROM Jugador j WHERE j.idFace = :idFace"),
    @NamedQuery(name = "Jugador.findByPuntGen", query = "SELECT j FROM Jugador j WHERE j.puntGen = :puntGen"),
    @NamedQuery(name = "Jugador.findByCreditos", query = "SELECT j FROM Jugador j WHERE j.creditos = :creditos"),
    @NamedQuery(name = "Jugador.findContrincantes", query = "SELECT j FROM Jugador j, Partida p WHERE (j.idJugador = p.idJug1 AND :idJugador = p.idJug2) OR (j.idJugador = p.idJug2 AND :idJugador = p.idJug1)")
})
public class Jugador implements Serializable {
    
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idJugador")
    private Long idJugador;
    @Column(name = "idFace")
    private BigInteger idFace;
    @NotNull
    @Column(name = "usuario")
    private String usuario;
    @Lob
    @Column(name = "contra")
    private byte[] contra;
    @Column(name = "puntGen")
    private BigInteger puntGen;
    @Column(name = "creditos")
    private BigInteger creditos;

    public Jugador() {
    }

    public Jugador(Long idJugador) {
        this.idJugador = idJugador;
    }

    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador = idJugador;
    }

    public BigInteger getIdFace() {
        return idFace;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setIdFace(BigInteger idFace) {
        this.idFace = idFace;
    }

    public byte[] getContra() {
        return contra;
    }

    public void setContra(byte[] contra) {
        this.contra = contra;
    }

    public BigInteger getPuntGen() {
        return puntGen;
    }

    public void setPuntGen(BigInteger puntGen) {
        this.puntGen = puntGen;
    }

    public BigInteger getCreditos() {
        return creditos;
    }

    public void setCreditos(BigInteger creditos) {
        this.creditos = creditos;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJugador != null ? idJugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.idJugador == null && other.idJugador != null) || (this.idJugador != null && !this.idJugador.equals(other.idJugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.Jugador[ idJugador=" + idJugador + " ]";
    }
    
}
