/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jbparoissien
 */
@Entity
@Table(name = "site_snot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteSnot.findAll", query = "SELECT s FROM SiteSnot s")
    , @NamedQuery(name = "SiteSnot.findByZetAltitude", query = "SELECT s FROM SiteSnot s WHERE s.zetAltitude = :zetAltitude")
    , @NamedQuery(name = "SiteSnot.findByZetClimat", query = "SELECT s FROM SiteSnot s WHERE s.zetClimat = :zetClimat")
    , @NamedQuery(name = "SiteSnot.findByZetCoordonneesBbox", query = "SELECT s FROM SiteSnot s WHERE s.zetCoordonneesBbox = :zetCoordonneesBbox")
    , @NamedQuery(name = "SiteSnot.findByZetDateDebut", query = "SELECT s FROM SiteSnot s WHERE s.zetDateDebut = :zetDateDebut")
    , @NamedQuery(name = "SiteSnot.findByZetDateFin", query = "SELECT s FROM SiteSnot s WHERE s.zetDateFin = :zetDateFin")
    , @NamedQuery(name = "SiteSnot.findByZetDirVent", query = "SELECT s FROM SiteSnot s WHERE s.zetDirVent = :zetDirVent")
    , @NamedQuery(name = "SiteSnot.findByZetGeologie", query = "SELECT s FROM SiteSnot s WHERE s.zetGeologie = :zetGeologie")
    , @NamedQuery(name = "SiteSnot.findByZetPays", query = "SELECT s FROM SiteSnot s WHERE s.zetPays = :zetPays")
    , @NamedQuery(name = "SiteSnot.findByZetSurface", query = "SELECT s FROM SiteSnot s WHERE s.zetSurface = :zetSurface")
    , @NamedQuery(name = "SiteSnot.findBySiteId", query = "SELECT s FROM SiteSnot s WHERE s.siteId = :siteId")})
public class SiteSnot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 4)
    @Column(name = "zet_altitude")
    private String zetAltitude;
    @Size(max = 50)
    @Column(name = "zet_climat")
    private String zetClimat;
    @Size(max = 250)
    @Column(name = "zet_coordonnees_bbox")
    private String zetCoordonneesBbox;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zet_date_debut")
    @Temporal(TemporalType.DATE)
    private Date zetDateDebut;
    @Column(name = "zet_date_fin")
    @Temporal(TemporalType.DATE)
    private Date zetDateFin;
    @Size(max = 50)
    @Column(name = "zet_dir_vent")
    private String zetDirVent;
    @Size(max = 50)
    @Column(name = "zet_geologie")
    private String zetGeologie;
    @Size(max = 50)
    @Column(name = "zet_pays")
    private String zetPays;
    @Size(max = 10)
    @Column(name = "zet_surface")
    private String zetSurface;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "site_id")
    private Long siteId;
    @JoinColumn(name = "site_id", referencedColumnName = "site_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Site site;
    @JoinColumn(name = "tze_id", referencedColumnName = "tze_id")
    @ManyToOne(optional = false)
    private TypesZoneEtudeTze tzeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siteId")
    private Collection<DatatypeUniteVariableSnotVdt> datatypeUniteVariableSnotVdtCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siteId")
    private Collection<Jeu> jeuCollection;

    public SiteSnot() {
    }

    public SiteSnot(Long siteId) {
        this.siteId = siteId;
    }

    public SiteSnot(Long siteId, Date zetDateDebut) {
        this.siteId = siteId;
        this.zetDateDebut = zetDateDebut;
    }

    public String getZetAltitude() {
        return zetAltitude;
    }

    public void setZetAltitude(String zetAltitude) {
        this.zetAltitude = zetAltitude;
    }

    public String getZetClimat() {
        return zetClimat;
    }

    public void setZetClimat(String zetClimat) {
        this.zetClimat = zetClimat;
    }

    public String getZetCoordonneesBbox() {
        return zetCoordonneesBbox;
    }

    public void setZetCoordonneesBbox(String zetCoordonneesBbox) {
        this.zetCoordonneesBbox = zetCoordonneesBbox;
    }

    public Date getZetDateDebut() {
        return zetDateDebut;
    }

    public void setZetDateDebut(Date zetDateDebut) {
        this.zetDateDebut = zetDateDebut;
    }

    public Date getZetDateFin() {
        return zetDateFin;
    }

    public void setZetDateFin(Date zetDateFin) {
        this.zetDateFin = zetDateFin;
    }

    public String getZetDirVent() {
        return zetDirVent;
    }

    public void setZetDirVent(String zetDirVent) {
        this.zetDirVent = zetDirVent;
    }

    public String getZetGeologie() {
        return zetGeologie;
    }

    public void setZetGeologie(String zetGeologie) {
        this.zetGeologie = zetGeologie;
    }

    public String getZetPays() {
        return zetPays;
    }

    public void setZetPays(String zetPays) {
        this.zetPays = zetPays;
    }

    public String getZetSurface() {
        return zetSurface;
    }

    public void setZetSurface(String zetSurface) {
        this.zetSurface = zetSurface;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public TypesZoneEtudeTze getTzeId() {
        return tzeId;
    }

    public void setTzeId(TypesZoneEtudeTze tzeId) {
        this.tzeId = tzeId;
    }

    @XmlTransient
    public Collection<DatatypeUniteVariableSnotVdt> getDatatypeUniteVariableSnotVdtCollection() {
        return datatypeUniteVariableSnotVdtCollection;
    }

    public void setDatatypeUniteVariableSnotVdtCollection(Collection<DatatypeUniteVariableSnotVdt> datatypeUniteVariableSnotVdtCollection) {
        this.datatypeUniteVariableSnotVdtCollection = datatypeUniteVariableSnotVdtCollection;
    }

    @XmlTransient
    public Collection<Jeu> getJeuCollection() {
        return jeuCollection;
    }

    public void setJeuCollection(Collection<Jeu> jeuCollection) {
        this.jeuCollection = jeuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siteId != null ? siteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SiteSnot)) {
            return false;
        }
        SiteSnot other = (SiteSnot) object;
        if ((this.siteId == null && other.siteId != null) || (this.siteId != null && !this.siteId.equals(other.siteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.SiteSnot[ siteId=" + siteId + " ]";
    }

}
