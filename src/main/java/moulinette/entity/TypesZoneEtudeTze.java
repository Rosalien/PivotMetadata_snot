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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "types_zone_etude_tze")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypesZoneEtudeTze.findAll", query = "SELECT t FROM TypesZoneEtudeTze t")
    , @NamedQuery(name = "TypesZoneEtudeTze.findByTzeId", query = "SELECT t FROM TypesZoneEtudeTze t WHERE t.tzeId = :tzeId")
    , @NamedQuery(name = "TypesZoneEtudeTze.findByTzeCode", query = "SELECT t FROM TypesZoneEtudeTze t WHERE t.tzeCode = :tzeCode")
    , @NamedQuery(name = "TypesZoneEtudeTze.findByTzeDefinition", query = "SELECT t FROM TypesZoneEtudeTze t WHERE t.tzeDefinition = :tzeDefinition")
    , @NamedQuery(name = "TypesZoneEtudeTze.findByTzeNom", query = "SELECT t FROM TypesZoneEtudeTze t WHERE t.tzeNom = :tzeNom")})
public class TypesZoneEtudeTze implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tze_id")
    private Long tzeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "tze_code")
    private String tzeCode;
    @Size(max = 150)
    @Column(name = "tze_definition")
    private String tzeDefinition;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "tze_nom")
    private String tzeNom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tzeId")
    private Collection<SiteSnot> siteSnotCollection;

    public TypesZoneEtudeTze() {
    }

    public TypesZoneEtudeTze(Long tzeId) {
        this.tzeId = tzeId;
    }

    public TypesZoneEtudeTze(Long tzeId, String tzeCode, String tzeNom) {
        this.tzeId = tzeId;
        this.tzeCode = tzeCode;
        this.tzeNom = tzeNom;
    }

    public Long getTzeId() {
        return tzeId;
    }

    public void setTzeId(Long tzeId) {
        this.tzeId = tzeId;
    }

    public String getTzeCode() {
        return tzeCode;
    }

    public void setTzeCode(String tzeCode) {
        this.tzeCode = tzeCode;
    }

    public String getTzeDefinition() {
        return tzeDefinition;
    }

    public void setTzeDefinition(String tzeDefinition) {
        this.tzeDefinition = tzeDefinition;
    }

    public String getTzeNom() {
        return tzeNom;
    }

    public void setTzeNom(String tzeNom) {
        this.tzeNom = tzeNom;
    }

    @XmlTransient
    public Collection<SiteSnot> getSiteSnotCollection() {
        return siteSnotCollection;
    }

    public void setSiteSnotCollection(Collection<SiteSnot> siteSnotCollection) {
        this.siteSnotCollection = siteSnotCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tzeId != null ? tzeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypesZoneEtudeTze)) {
            return false;
        }
        TypesZoneEtudeTze other = (TypesZoneEtudeTze) object;
        if ((this.tzeId == null && other.tzeId != null) || (this.tzeId != null && !this.tzeId.equals(other.tzeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.TypesZoneEtudeTze[ tzeId=" + tzeId + " ]";
    }
    
}
