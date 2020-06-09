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
@Table(name = "theme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Theme.findAll", query = "SELECT t FROM Theme t")
    , @NamedQuery(name = "Theme.findByDescription", query = "SELECT t FROM Theme t WHERE t.description = :description")
    , @NamedQuery(name = "Theme.findById", query = "SELECT t FROM Theme t WHERE t.id = :id")
    , @NamedQuery(name = "Theme.findByName", query = "SELECT t FROM Theme t WHERE t.name = :name")})
public class Theme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private CompositeNodeable compositeNodeable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Collection<Jeu> jeuCollection;

    public Theme() {
    }

    public Theme(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompositeNodeable getCompositeNodeable() {
        return compositeNodeable;
    }

    public void setCompositeNodeable(CompositeNodeable compositeNodeable) {
        this.compositeNodeable = compositeNodeable;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theme)) {
            return false;
        }
        Theme other = (Theme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.Theme[ id=" + id + " ]";
    }
    
}
