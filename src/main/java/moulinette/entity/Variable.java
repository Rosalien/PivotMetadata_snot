/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jbparoissien
 */
@Entity
@Table(name = "variable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Variable.findAll", query = "SELECT v FROM Variable v")
    , @NamedQuery(name = "Variable.findByAffichage", query = "SELECT v FROM Variable v WHERE v.affichage = :affichage")
    , @NamedQuery(name = "Variable.findByDefinition", query = "SELECT v FROM Variable v WHERE v.definition = :definition")
    , @NamedQuery(name = "Variable.findByIsqualitative", query = "SELECT v FROM Variable v WHERE v.isqualitative = :isqualitative")
    , @NamedQuery(name = "Variable.findByVarId", query = "SELECT v FROM Variable v WHERE v.varId = :varId")
    , @NamedQuery(name = "Variable.findByNom", query = "SELECT v FROM Variable v WHERE v.nom = :nom")})
public class Variable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "affichage")
    private String affichage;
    @Size(max = 2147483647)
    @Column(name = "definition")
    private String definition;
    @Column(name = "isqualitative")
    private Boolean isqualitative;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "var_id")
    private Long varId;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @JoinColumn(name = "var_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private CompositeNodeable compositeNodeable;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "variable")
    private VariableSnot variableSnot;

    public Variable() {
    }

    public Variable(Long varId) {
        this.varId = varId;
    }

    public String getAffichage() {
        return affichage;
    }

    public void setAffichage(String affichage) {
        this.affichage = affichage;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Boolean getIsqualitative() {
        return isqualitative;
    }

    public void setIsqualitative(Boolean isqualitative) {
        this.isqualitative = isqualitative;
    }

    public Long getVarId() {
        return varId;
    }

    public void setVarId(Long varId) {
        this.varId = varId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public CompositeNodeable getCompositeNodeable() {
        return compositeNodeable;
    }

    public void setCompositeNodeable(CompositeNodeable compositeNodeable) {
        this.compositeNodeable = compositeNodeable;
    }

    public VariableSnot getVariableSnot() {
        return variableSnot;
    }

    public void setVariableSnot(VariableSnot variableSnot) {
        this.variableSnot = variableSnot;
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
        if (!(object instanceof Variable)) {
            return false;
        }
        Variable other = (Variable) object;
        if ((this.varId == null && other.varId != null) || (this.varId != null && !this.varId.equals(other.varId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.Variable[ varId=" + varId + " ]";
    }
    
}
