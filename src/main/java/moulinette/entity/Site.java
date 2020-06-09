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
@Table(name = "site")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s")
    , @NamedQuery(name = "Site.findByDescription", query = "SELECT s FROM Site s WHERE s.description = :description")
    , @NamedQuery(name = "Site.findByName", query = "SELECT s FROM Site s WHERE s.name = :name")
    , @NamedQuery(name = "Site.findBySiteId", query = "SELECT s FROM Site s WHERE s.siteId = :siteId")})
public class Site implements Serializable {

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
    @Column(name = "site_id")
    private Long siteId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "site")
    private SiteSnot siteSnot;
    @JoinColumn(name = "site_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private CompositeNodeable compositeNodeable;
    @OneToMany(mappedBy = "parentSiteId")
    private Collection<Site> siteCollection;
    @JoinColumn(name = "parent_site_id", referencedColumnName = "site_id")
    @ManyToOne
    private Site parentSiteId;

    public Site() {
    }

    public Site(Long siteId) {
        this.siteId = siteId;
    }

    public Site(Long siteId, String name) {
        this.siteId = siteId;
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

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public SiteSnot getSiteSnot() {
        return siteSnot;
    }

    public void setSiteSnot(SiteSnot siteSnot) {
        this.siteSnot = siteSnot;
    }

    public CompositeNodeable getCompositeNodeable() {
        return compositeNodeable;
    }

    public void setCompositeNodeable(CompositeNodeable compositeNodeable) {
        this.compositeNodeable = compositeNodeable;
    }

    @XmlTransient
    public Collection<Site> getSiteCollection() {
        return siteCollection;
    }

    public void setSiteCollection(Collection<Site> siteCollection) {
        this.siteCollection = siteCollection;
    }

    public Site getParentSiteId() {
        return parentSiteId;
    }

    public void setParentSiteId(Site parentSiteId) {
        this.parentSiteId = parentSiteId;
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
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.siteId == null && other.siteId != null) || (this.siteId != null && !this.siteId.equals(other.siteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.Site[ siteId=" + siteId + " ]";
    }
    
}
