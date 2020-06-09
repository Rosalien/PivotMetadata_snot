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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "unite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unite.findAll", query = "SELECT u FROM Unite u")
    , @NamedQuery(name = "Unite.findByUniId", query = "SELECT u FROM Unite u WHERE u.uniId = :uniId")
    , @NamedQuery(name = "Unite.findByCode", query = "SELECT u FROM Unite u WHERE u.code = :code")
    , @NamedQuery(name = "Unite.findByName", query = "SELECT u FROM Unite u WHERE u.name = :name")})
public class Unite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "uni_id")
    private Long uniId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uniId")
    private Collection<DatatypeUniteVariableSnotVdt> datatypeUniteVariableSnotVdtCollection;

    public Unite() {
    }

    public Unite(Long uniId) {
        this.uniId = uniId;
    }

    public Unite(Long uniId, String code, String name) {
        this.uniId = uniId;
        this.code = code;
        this.name = name;
    }

    public Long getUniId() {
        return uniId;
    }

    public void setUniId(Long uniId) {
        this.uniId = uniId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (uniId != null ? uniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unite)) {
            return false;
        }
        Unite other = (Unite) object;
        if ((this.uniId == null && other.uniId != null) || (this.uniId != null && !this.uniId.equals(other.uniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.Unite[ uniId=" + uniId + " ]";
    }
    
}
