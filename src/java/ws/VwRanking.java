/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "VwRanking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwRanking.findAll", query = "SELECT v FROM VwRanking v"),
    @NamedQuery(name = "VwRanking.findByIdJug", query = "SELECT v FROM VwRanking v WHERE v.idJug = :idJug"),
    @NamedQuery(name = "VwRanking.findByPuntos", query = "SELECT v FROM VwRanking v WHERE v.puntos = :puntos"),
    @NamedQuery(name = "VwRanking.findByNumSemana", query = "SELECT v FROM VwRanking v WHERE v.numSemana = :numSemana"),
    @NamedQuery(name = "VwRanking.findByAno", query = "SELECT v FROM VwRanking v WHERE v.ano = :ano")})
public class VwRanking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idJug")
    private long idJug;
    @Column(name = "puntos")
    private BigInteger puntos;
    @Id
    @Column(name = "numSemana")
    private Integer numSemana;
    @Column(name = "ano")
    private Integer ano;

    public VwRanking() {
    }

    public long getIdJug() {
        return idJug;
    }

    public void setIdJug(long idJug) {
        this.idJug = idJug;
    }

    public BigInteger getPuntos() {
        return puntos;
    }

    public void setPuntos(BigInteger puntos) {
        this.puntos = puntos;
    }

    public Integer getNumSemana() {
        return numSemana;
    }

    public void setNumSemana(Integer numSemana) {
        this.numSemana = numSemana;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
    
}
