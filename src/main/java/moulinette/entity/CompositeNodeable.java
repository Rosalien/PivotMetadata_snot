/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jbparoissien
 */
@Entity
@Table(name = "composite_nodeable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompositeNodeable.findAll", query = "SELECT c FROM CompositeNodeable c")
    , @NamedQuery(name = "CompositeNodeable.findByDtype", query = "SELECT c FROM CompositeNodeable c WHERE c.dtype = :dtype")
    , @NamedQuery(name = "CompositeNodeable.findById", query = "SELECT c FROM CompositeNodeable c WHERE c.id = :id")
    , @NamedQuery(name = "CompositeNodeable.findByCode", query = "SELECT c FROM CompositeNodeable c WHERE c.code = :code")
    , @NamedQuery(name = "CompositeNodeable.findByOrdernumber", query = "SELECT c FROM CompositeNodeable c WHERE c.ordernumber = :ordernumber")})
public class CompositeNodeable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 31)
    @Column(name = "dtype")
    private String dtype;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "code")
    private String code;
    @Column(name = "ordernumber")
    private BigInteger ordernumber;
    @OneToMany(mappedBy = "idNodeable")
    private Collection<Realnode> realnodeCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "compositeNodeable")
    private Site site;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "compositeNodeable")
    private Datatype datatype;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "compositeNodeable")
    private Variable variable;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "compositeNodeable")
    private DatatypeUniteVariableSnotVdt datatypeUniteVariableSnotVdt;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "compositeNodeable")
    private Theme theme;

    public CompositeNodeable() {
    }

    public CompositeNodeable(Long id) {
        this.id = id;
    }

    public CompositeNodeable(Long id, String dtype, String code) {
        this.id = id;
        this.dtype = dtype;
        this.code = code;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigInteger getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(BigInteger ordernumber) {
        this.ordernumber = ordernumber;
    }

    @XmlTransient
    public Collection<Realnode> getRealnodeCollection() {
        return realnodeCollection;
    }

    public void setRealnodeCollection(Collection<Realnode> realnodeCollection) {
        this.realnodeCollection = realnodeCollection;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Datatype getDatatype() {
        return datatype;
    }

    public void setDatatype(Datatype datatype) {
        this.datatype = datatype;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public DatatypeUniteVariableSnotVdt getDatatypeUniteVariableSnotVdt() {
        return datatypeUniteVariableSnotVdt;
    }

    public void setDatatypeUniteVariableSnotVdt(DatatypeUniteVariableSnotVdt datatypeUniteVariableSnotVdt) {
        this.datatypeUniteVariableSnotVdt = datatypeUniteVariableSnotVdt;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompositeNodeable)) {
            return false;
        }
        CompositeNodeable other = (CompositeNodeable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.CompositeNodeable[ id=" + id + " ]";
    }
    
}
