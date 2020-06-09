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
@Table(name = "variable_snot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VariableSnot.findAll", query = "SELECT v FROM VariableSnot v")
    , @NamedQuery(name = "VariableSnot.findByTheiacategories", query = "SELECT v FROM VariableSnot v WHERE v.theiacategories = :theiacategories")
    , @NamedQuery(name = "VariableSnot.findByVarId", query = "SELECT v FROM VariableSnot v WHERE v.varId = :varId")})
public class VariableSnot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 150)
    @Column(name = "theiacategories")
    private String theiacategories;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "var_id")
    private Long varId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Collection<DatatypeUniteVariableSnotVdt> datatypeUniteVariableSnotVdtCollection;
    @JoinColumn(name = "var_id", referencedColumnName = "var_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Variable variable;

    public VariableSnot() {
    }

    public VariableSnot(Long varId) {
        this.varId = varId;
    }

    public String getTheiacategories() {
        return theiacategories;
    }

    public void setTheiacategories(String theiacategories) {
        this.theiacategories = theiacategories;
    }

    public Long getVarId() {
        return varId;
    }

    public void setVarId(Long varId) {
        this.varId = varId;
    }

    @XmlTransient
    public Collection<DatatypeUniteVariableSnotVdt> getDatatypeUniteVariableSnotVdtCollection() {
        return datatypeUniteVariableSnotVdtCollection;
    }

    public void setDatatypeUniteVariableSnotVdtCollection(Collection<DatatypeUniteVariableSnotVdt> datatypeUniteVariableSnotVdtCollection) {
        this.datatypeUniteVariableSnotVdtCollection = datatypeUniteVariableSnotVdtCollection;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (varId != null ? varId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VariableSnot)) {
            return false;
        }
        VariableSnot other = (VariableSnot) object;
        if ((this.varId == null && other.varId != null) || (this.varId != null && !this.varId.equals(other.varId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.VariableSnot[ varId=" + varId + " ]";
    }
    
}
