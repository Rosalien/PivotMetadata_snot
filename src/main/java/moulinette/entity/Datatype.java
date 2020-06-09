/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "datatype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datatype.findAll", query = "SELECT d FROM Datatype d")
    , @NamedQuery(name = "Datatype.findByDescription", query = "SELECT d FROM Datatype d WHERE d.description = :description")
    , @NamedQuery(name = "Datatype.findByName", query = "SELECT d FROM Datatype d WHERE d.name = :name")
    , @NamedQuery(name = "Datatype.findByDtyId", query = "SELECT d FROM Datatype d WHERE d.dtyId = :dtyId")})
public class Datatype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dty_id")
    private Long dtyId;
    @JoinColumn(name = "dty_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private CompositeNodeable compositeNodeable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtyId")
    private Collection<DatatypeUniteVariableSnotVdt> datatypeUniteVariableSnotVdtCollection;

    public Datatype() {
    }

    public Datatype(Long dtyId) {
        this.dtyId = dtyId;
    }

    public Datatype(Long dtyId, String name) {
        this.dtyId = dtyId;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDtyId() {
        return dtyId;
    }

    public void setDtyId(Long dtyId) {
        this.dtyId = dtyId;
    }

    public CompositeNodeable getCompositeNodeable() {
        return compositeNodeable;
    }

    public void setCompositeNodeable(CompositeNodeable compositeNodeable) {
        this.compositeNodeable = compositeNodeable;
    }

    @XmlTransient
    public Collection<DatatypeUniteVariableSnotVdt> getDatatypeUniteVariableSnotVdtCollection() {
        return datatypeUniteVariableSnotVdtCollection;
    }

    public void setDatatypeUniteVariableSnotVdtCollection(Collection<DatatypeUniteVariableSnotVdt> datatypeUniteVariableSnotVdtCollection) {
        this.datatypeUniteVariableSnotVdtCollection = datatypeUniteVariableSnotVdtCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dtyId != null ? dtyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datatype)) {
            return false;
        }
        Datatype other = (Datatype) object;
        if ((this.dtyId == null && other.dtyId != null) || (this.dtyId != null && !this.dtyId.equals(other.dtyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.Datatype[ dtyId=" + dtyId + " ]";
    }
    
}
