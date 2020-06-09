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
@Table(name = "realnode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Realnode.findAll", query = "SELECT r FROM Realnode r")
    , @NamedQuery(name = "Realnode.findById", query = "SELECT r FROM Realnode r WHERE r.id = :id")
    , @NamedQuery(name = "Realnode.findByPath", query = "SELECT r FROM Realnode r WHERE r.path = :path")})
public class Realnode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "path")
    private String path;
    @JoinColumn(name = "id_nodeable", referencedColumnName = "id")
    @ManyToOne
    private CompositeNodeable idNodeable;
    @OneToMany(mappedBy = "idAncestor")
    private Collection<Realnode> realnodeCollection;
    @JoinColumn(name = "id_ancestor", referencedColumnName = "id")
    @ManyToOne
    private Realnode idAncestor;
    @OneToMany(mappedBy = "idParentNode")
    private Collection<Realnode> realnodeCollection1;
    @JoinColumn(name = "id_parent_node", referencedColumnName = "id")
    @ManyToOne
    private Realnode idParentNode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stdtvarId")
    private Collection<PeriodeUtilisationInstrument> periodeUtilisationInstrumentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stdtvarId")
    private Collection<PeriodeApplicationMethode> periodeApplicationMethodeCollection;

    public Realnode() {
    }

    public Realnode(Long id) {
        this.id = id;
    }

    public Realnode(Long id, String path) {
        this.id = id;
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public CompositeNodeable getIdNodeable() {
        return idNodeable;
    }

    public void setIdNodeable(CompositeNodeable idNodeable) {
        this.idNodeable = idNodeable;
    }

    @XmlTransient
    public Collection<Realnode> getRealnodeCollection() {
        return realnodeCollection;
    }

    public void setRealnodeCollection(Collection<Realnode> realnodeCollection) {
        this.realnodeCollection = realnodeCollection;
    }

    public Realnode getIdAncestor() {
        return idAncestor;
    }

    public void setIdAncestor(Realnode idAncestor) {
        this.idAncestor = idAncestor;
    }

    @XmlTransient
    public Collection<Realnode> getRealnodeCollection1() {
        return realnodeCollection1;
    }

    public void setRealnodeCollection1(Collection<Realnode> realnodeCollection1) {
        this.realnodeCollection1 = realnodeCollection1;
    }

    public Realnode getIdParentNode() {
        return idParentNode;
    }

    public void setIdParentNode(Realnode idParentNode) {
        this.idParentNode = idParentNode;
    }

    @XmlTransient
    public Collection<PeriodeUtilisationInstrument> getPeriodeUtilisationInstrumentCollection() {
        return periodeUtilisationInstrumentCollection;
    }

    public void setPeriodeUtilisationInstrumentCollection(Collection<PeriodeUtilisationInstrument> periodeUtilisationInstrumentCollection) {
        this.periodeUtilisationInstrumentCollection = periodeUtilisationInstrumentCollection;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Realnode)) {
            return false;
        }
        Realnode other = (Realnode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.Realnode[ id=" + id + " ]";
    }
    
}
