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
@Table(name = "methode_calcul")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MethodeCalcul.findAll", query = "SELECT m FROM MethodeCalcul m")
    , @NamedQuery(name = "MethodeCalcul.findByMcalcId", query = "SELECT m FROM MethodeCalcul m WHERE m.mcalcId = :mcalcId")
    , @NamedQuery(name = "MethodeCalcul.findByCode", query = "SELECT m FROM MethodeCalcul m WHERE m.code = :code")
    , @NamedQuery(name = "MethodeCalcul.findByDescription", query = "SELECT m FROM MethodeCalcul m WHERE m.description = :description")
    , @NamedQuery(name = "MethodeCalcul.findByLibelle", query = "SELECT m FROM MethodeCalcul m WHERE m.libelle = :libelle")})
public class MethodeCalcul implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mcalc_id")
    private Long mcalcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "code")
    private String code;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mcalcId")
    private Collection<PeriodeApplicationMethode> periodeApplicationMethodeCollection;

    public MethodeCalcul() {
    }

    public MethodeCalcul(Long mcalcId) {
        this.mcalcId = mcalcId;
    }

    public MethodeCalcul(Long mcalcId, String code) {
        this.mcalcId = mcalcId;
        this.code = code;
    }

    public Long getMcalcId() {
        return mcalcId;
    }

    public void setMcalcId(Long mcalcId) {
        this.mcalcId = mcalcId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public Collection<PeriodeApplicationMethode> getPeriodeApplicationMethodeCollection() {
        return periodeApplicationMethodeCollection;
    }

    public void setPeriodeApplicationMethodeCollection(Collection<PeriodeApplicationMethode> periodeApplicationMethodeCollection) {
        this.periodeApplicationMethodeCollection = periodeApplicationMethodeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mcalcId != null ? mcalcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MethodeCalcul)) {
            return false;
        }
        MethodeCalcul other = (MethodeCalcul) object;
        if ((this.mcalcId == null && other.mcalcId != null) || (this.mcalcId != null && !this.mcalcId.equals(other.mcalcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.MethodeCalcul[ mcalcId=" + mcalcId + " ]";
    }
    
}
