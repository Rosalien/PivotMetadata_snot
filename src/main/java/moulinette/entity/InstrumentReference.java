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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jbparoissien
 */
@Entity
@Table(name = "instrument_reference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstrumentReference.findAll", query = "SELECT i FROM InstrumentReference i")
    , @NamedQuery(name = "InstrumentReference.findByInstrrefId", query = "SELECT i FROM InstrumentReference i WHERE i.instrrefId = :instrrefId")})
public class InstrumentReference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "instrref_id")
    private Long instrrefId;
    @JoinColumn(name = "instr_id", referencedColumnName = "instr_id")
    @ManyToOne(optional = false)
    private Instrument instrId;
    @JoinColumn(name = "ref_id", referencedColumnName = "ref_id")
    @ManyToOne(optional = false)
    private Reference refId;

    public InstrumentReference() {
    }

    public InstrumentReference(Long instrrefId) {
        this.instrrefId = instrrefId;
    }

    public Long getInstrrefId() {
        return instrrefId;
    }

    public void setInstrrefId(Long instrrefId) {
        this.instrrefId = instrrefId;
    }

    public Instrument getInstrId() {
        return instrId;
    }

    public void setInstrId(Instrument instrId) {
        this.instrId = instrId;
    }

    public Reference getRefId() {
        return refId;
    }

    public void setRefId(Reference refId) {
        this.refId = refId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instrrefId != null ? instrrefId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstrumentReference)) {
            return false;
        }
        InstrumentReference other = (InstrumentReference) object;
        if ((this.instrrefId == null && other.instrrefId != null) || (this.instrrefId != null && !this.instrrefId.equals(other.instrrefId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.InstrumentReference[ instrrefId=" + instrrefId + " ]";
    }
    
}
