/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "promedio", catalog = "notas", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promedio.findAll", query = "SELECT p FROM Promedio p")
    , @NamedQuery(name = "Promedio.findByCodigo", query = "SELECT p FROM Promedio p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Promedio.findByAnioInicio", query = "SELECT p FROM Promedio p WHERE p.anioInicio = :anioInicio")
    , @NamedQuery(name = "Promedio.findByAnioFin", query = "SELECT p FROM Promedio p WHERE p.anioFin = :anioFin")
    , @NamedQuery(name = "Promedio.findByMes", query = "SELECT p FROM Promedio p WHERE p.mes = :mes")
    , @NamedQuery(name = "Promedio.findByValor", query = "SELECT p FROM Promedio p WHERE p.valor = :valor")})
public class Promedio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "anio_inicio")
    private int anioInicio;
    @Basic(optional = false)
    @Column(name = "anio_fin")
    private int anioFin;
    @Basic(optional = false)
    @Column(name = "mes")
    private int mes;
    @Basic(optional = false)
    @Column(name = "valor")
    private int valor;
    @JoinColumn(name = "nivel", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Nivel nivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPromedio")
    private List<Actividad> actividadList;

    public Promedio() {
    }

    public Promedio(Integer codigo) {
        this.codigo = codigo;
    }

    public Promedio(Integer codigo, int anioInicio, int anioFin, int mes, int valor) {
        this.codigo = codigo;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
        this.mes = mes;
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    public int getAnioFin() {
        return anioFin;
    }

    public void setAnioFin(int anioFin) {
        this.anioFin = anioFin;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promedio)) {
            return false;
        }
        Promedio other = (Promedio) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Promedio[ codigo=" + codigo + " ]";
    }
    
}
