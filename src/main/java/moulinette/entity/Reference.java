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
@Table(name = "reference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reference.findAll", query = "SELECT r FROM Reference r")
    , @NamedQuery(name = "Reference.findByRefId", query = "SELECT r FROM Reference r WHERE r.refId = :refId")
    , @NamedQuery(name = "Reference.findByAnn\u00e9e", query = "SELECT r FROM Reference r WHERE r.ann\u00e9e = :ann\u00e9e")
    , @NamedQuery(name = "Reference.findByDoi", query = "SELECT r FROM Reference r WHERE r.doi = :doi")
    , @NamedQuery(name = "Reference.findByPremierAuteur", query = "SELECT r FROM Reference r WHERE r.premierAuteur = :premierAuteur")})
public class Reference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ref_id")
    private Long refId;
    @Size(max = 4)
    @Column(name = "ann\u00e9e")
    private String année;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "doi")
    private String doi;
    @Size(max = 50)
    @Column(name = "premier_auteur")
    private String premierAuteur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "refId")
    private Collection<InstrumentReference> instrumentReferenceCollection;

    public Reference() {
    }

    public Reference(Long refId) {
        this.refId = refId;
    }

    public Reference(Long refId, String doi) {
        this.refId = refId;
        this.doi = doi;
    }

    public Long getRefId() {
        return refId;
    }

    public void setRefId(Long refId) {
        this.refId = refId;
    }

    public String getAnnée() {
        return année;
    }

    public void setAnnée(String année) {
        this.année = année;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getPremierAuteur() {
        return premierAuteur;
    }

    public void setPremierAuteur(String premierAuteur) {
        this.premierAuteur = premierAuteur;
    }

    @XmlTransient
    public Collection<InstrumentReference> getInstrumentReferenceCollection() {
        return instrumentReferenceCollection;
    }

    public void setInstrumentReferenceCollection(Collection<InstrumentReference> instrumentReferenceCollection) {
        this.instrumentReferenceCollection = instrumentReferenceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (refId != null ? refId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reference)) {
            return false;
        }
        Reference other = (Reference) object;
        if ((this.refId == null && other.refId != null) || (this.refId != null && !this.refId.equals(other.refId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.Reference[ refId=" + refId + " ]";
    }
    
}
