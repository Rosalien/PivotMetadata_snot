/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "datatype_unite_variable_snot_vdt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatatypeUniteVariableSnotVdt.findAll", query = "SELECT d FROM DatatypeUniteVariableSnotVdt d")
    , @NamedQuery(name = "DatatypeUniteVariableSnotVdt.findByMax", query = "SELECT d FROM DatatypeUniteVariableSnotVdt d WHERE d.max = :max")
    , @NamedQuery(name = "DatatypeUniteVariableSnotVdt.findByMin", query = "SELECT d FROM DatatypeUniteVariableSnotVdt d WHERE d.min = :min")
    , @NamedQuery(name = "DatatypeUniteVariableSnotVdt.findByMissingvalue", query = "SELECT d FROM DatatypeUniteVariableSnotVdt d WHERE d.missingvalue = :missingvalue")
    , @NamedQuery(name = "DatatypeUniteVariableSnotVdt.findBySdvuId", query = "SELECT d FROM DatatypeUniteVariableSnotVdt d WHERE d.sdvuId = :sdvuId")})
public class DatatypeUniteVariableSnotVdt implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "max")
    private Float max;
    @Column(name = "min")
    private Float min;
    @Size(max = 20)
    @Column(name = "missingvalue")
    private String missingvalue;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sdvu_id")
    private Long sdvuId;
    @JoinColumn(name = "sdvu_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private CompositeNodeable compositeNodeable;
    @JoinColumn(name = "dty_id", referencedColumnName = "dty_id")
    @ManyToOne(optional = false)
    private Datatype dtyId;
    @JoinColumn(name = "jeu_id", referencedColumnName = "jeu_id")
    @ManyToOne(optional = false)
    private Jeu jeuId;
    @JoinColumn(name = "site_id", referencedColumnName = "site_id")
    @ManyToOne(optional = false)
    private SiteSnot siteId;
    @JoinColumn(name = "uni_id", referencedColumnName = "uni_id")
    @ManyToOne(optional = false)
    private Unite uniId;
    @JoinColumn(name = "id", referencedColumnName = "var_id")
    @ManyToOne(optional = false)
    private VariableSnot id;

    public DatatypeUniteVariableSnotVdt() {
    }

    public DatatypeUniteVariableSnotVdt(Long sdvuId) {
        this.sdvuId = sdvuId;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public String getMissingvalue() {
        return missingvalue;
    }

    public void setMissingvalue(String missingvalue) {
        this.missingvalue = missingvalue;
    }

    public Long getSdvuId() {
        return sdvuId;
    }

    public void setSdvuId(Long sdvuId) {
        this.sdvuId = sdvuId;
    }

    public CompositeNodeable getCompositeNodeable() {
        return compositeNodeable;
    }

    public void setCompositeNodeable(CompositeNodeable compositeNodeable) {
        this.compositeNodeable = compositeNodeable;
    }

    public Datatype getDtyId() {
        return dtyId;
    }

    public void setDtyId(Datatype dtyId) {
        this.dtyId = dtyId;
    }

    public Jeu getJeuId() {
        return jeuId;
    }

    public void setJeuId(Jeu jeuId) {
        this.jeuId = jeuId;
    }

    public SiteSnot getSiteId() {
        return siteId;
    }

    public void setSiteId(SiteSnot siteId) {
        this.siteId = siteId;
    }

    public Unite getUniId() {
        return uniId;
    }

    public void setUniId(Unite uniId) {
        this.uniId = uniId;
    }

    public VariableSnot getId() {
        return id;
    }

    public void setId(VariableSnot id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sdvuId != null ? sdvuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatatypeUniteVariableSnotVdt)) {
            return false;
        }
        DatatypeUniteVariableSnotVdt other = (DatatypeUniteVariableSnotVdt) object;
        if ((this.sdvuId == null && other.sdvuId != null) || (this.sdvuId != null && !this.sdvuId.equals(other.sdvuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.DatatypeUniteVariableSnotVdt[ sdvuId=" + sdvuId + " ]";
    }
    
}
