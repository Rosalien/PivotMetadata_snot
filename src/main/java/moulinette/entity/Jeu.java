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
import javax.persistence.ManyToOne;
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
@Table(name = "jeu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jeu.findAll", query = "SELECT j FROM Jeu j")
    , @NamedQuery(name = "Jeu.findByJeuId", query = "SELECT j FROM Jeu j WHERE j.jeuId = :jeuId")
    , @NamedQuery(name = "Jeu.findByCodeJeu", query = "SELECT j FROM Jeu j WHERE j.codeJeu = :codeJeu")
    , @NamedQuery(name = "Jeu.findByDescription", query = "SELECT j FROM Jeu j WHERE j.description = :description")
    , @NamedQuery(name = "Jeu.findByGenealogie", query = "SELECT j FROM Jeu j WHERE j.genealogie = :genealogie")
    , @NamedQuery(name = "Jeu.findByObjectif", query = "SELECT j FROM Jeu j WHERE j.objectif = :objectif")
    , @NamedQuery(name = "Jeu.findByTitre", query = "SELECT j FROM Jeu j WHERE j.titre = :titre")
    , @NamedQuery(name = "Jeu.findByCitation", query = "SELECT j FROM Jeu j WHERE j.citation = :citation")
    , @NamedQuery(name = "Jeu.findByDoi", query = "SELECT j FROM Jeu j WHERE j.doi = :doi")})

public class Jeu implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jeuId")
    private Collection<PeriodeApplicationMethode> periodeApplicationMethodeCollection;

    @Size(max = 50)
    @Column(name = "titre_licence")
    private String titreLicence;
    @Size(max = 200)
    @Column(name = "url_download")
    private String urlDownload;
    @Size(max = 200)
    @Column(name = "url_info")
    private String urlInfo;
    @Size(max = 200)
    @Column(name = "url_licence")
    private String urlLicence;

    @Size(max = 500)
    @Column(name = "doi")
    private String doi;
    @Size(max = 2000)
    @Column(name = "citation")
    private String citation;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "jeu_id")
    private Long jeuId;
    @Size(max = 50)
    @Column(name = "code_jeu")
    private String codeJeu;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "genealogie")
    private String genealogie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "objectif")
    private String objectif;
    @Size(max = 150)
    @Column(name = "titre")
    private String titre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jeuId")
    private Collection<PeriodeUtilisationInstrument> periodeUtilisationInstrumentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jeuId")
    private Collection<DatatypeUniteVariableSnotVdt> datatypeUniteVariableSnotVdtCollection;
    @JoinColumn(name = "site_id", referencedColumnName = "site_id")
    @ManyToOne(optional = false)
    private SiteSnot siteId;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Theme id;

    public Jeu() {
    }

    public Jeu(Long jeuId) {
        this.jeuId = jeuId;
    }

    public Jeu(Long jeuId, String genealogie, String objectif) {
        this.jeuId = jeuId;
        this.genealogie = genealogie;
        this.objectif = objectif;
    }

    public Long getJeuId() {
        return jeuId;
    }

    public void setJeuId(Long jeuId) {
        this.jeuId = jeuId;
    }

    public String getCodeJeu() {
        return codeJeu;
    }

    public void setCodeJeu(String codeJeu) {
        this.codeJeu = codeJeu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenealogie() {
        return genealogie;
    }

    public void setGenealogie(String genealogie) {
        this.genealogie = genealogie;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @XmlTransient
    public Collection<PeriodeUtilisationInstrument> getPeriodeUtilisationInstrumentCollection() {
        return periodeUtilisationInstrumentCollection;
    }

    public void setPeriodeUtilisationInstrumentCollection(Collection<PeriodeUtilisationInstrument> periodeUtilisationInstrumentCollection) {
        this.periodeUtilisationInstrumentCollection = periodeUtilisationInstrumentCollection;
    }

    @XmlTransient
    public Collection<DatatypeUniteVariableSnotVdt> getDatatypeUniteVariableSnotVdtCollection() {
        return datatypeUniteVariableSnotVdtCollection;
    }

    public void setDatatypeUniteVariableSnotVdtCollection(Collection<DatatypeUniteVariableSnotVdt> datatypeUniteVariableSnotVdtCollection) {
        this.datatypeUniteVariableSnotVdtCollection = datatypeUniteVariableSnotVdtCollection;
    }

    public SiteSnot getSiteId() {
        return siteId;
    }

    public void setSiteId(SiteSnot siteId) {
        this.siteId = siteId;
    }

    public Theme getId() {
        return id;
    }

    public void setId(Theme id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jeuId != null ? jeuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jeu)) {
            return false;
        }
        Jeu other = (Jeu) object;
        if ((this.jeuId == null && other.jeuId != null) || (this.jeuId != null && !this.jeuId.equals(other.jeuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.Jeu[ jeuId=" + jeuId + " ]";
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getCitation() {
        return citation;
    }

    public void setCitation(String citation) {
        this.citation = citation;
    }

    public String getTitreLicence() {
        return titreLicence;
    }

    public void setTitreLicence(String titreLicence) {
        this.titreLicence = titreLicence;
    }

    public String getUrlDownload() {
        return urlDownload;
    }

    public void setUrlDownload(String urlDownload) {
        this.urlDownload = urlDownload;
    }

    public String getUrlInfo() {
        return urlInfo;
    }

    public void setUrlInfo(String urlInfo) {
        this.urlInfo = urlInfo;
    }

    public String getUrlLicence() {
        return urlLicence;
    }

    public void setUrlLicence(String urlLicence) {
        this.urlLicence = urlLicence;
    }

    @XmlTransient
    public Collection<PeriodeApplicationMethode> getPeriodeApplicationMethodeCollection() {
        return periodeApplicationMethodeCollection;
    }

    public void setPeriodeApplicationMethodeCollection(Collection<PeriodeApplicationMethode> periodeApplicationMethodeCollection) {
        this.periodeApplicationMethodeCollection = periodeApplicationMethodeCollection;
    }
    
}
