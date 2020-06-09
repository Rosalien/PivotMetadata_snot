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
@Table(name = "instrument")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instrument.findAll", query = "SELECT i FROM Instrument i")
    , @NamedQuery(name = "Instrument.findByInstrId", query = "SELECT i FROM Instrument i WHERE i.instrId = :instrId")
    , @NamedQuery(name = "Instrument.findByCode", query = "SELECT i FROM Instrument i WHERE i.code = :code")
    , @NamedQuery(name = "Instrument.findByDescription", query = "SELECT i FROM Instrument i WHERE i.description = :description")
    , @NamedQuery(name = "Instrument.findByFabricant", query = "SELECT i FROM Instrument i WHERE i.fabricant = :fabricant")
    , @NamedQuery(name = "Instrument.findByInfosCalibration", query = "SELECT i FROM Instrument i WHERE i.infosCalibration = :infosCalibration")
    , @NamedQuery(name = "Instrument.findByLibelle", query = "SELECT i FROM Instrument i WHERE i.libelle = :libelle")})
public class Instrument implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "instr_id")
    private Long instrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "code")
    private String code;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 200)
    @Column(name = "fabricant")
    private String fabricant;
    @Size(max = 255)
    @Column(name = "infos_calibration")
    private String infosCalibration;
    @Size(max = 100)
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instrId")
    private Collection<PeriodeUtilisationInstrument> periodeUtilisationInstrumentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instrId")
    private Collection<InstrumentReference> instrumentReferenceCollection;

    public Instrument() {
    }

    public Instrument(Long instrId) {
        this.instrId = instrId;
    }

    public Instrument(Long instrId, String code) {
        this.instrId = instrId;
        this.code = code;
    }

    public Long getInstrId() {
        return instrId;
    }

    public void setInstrId(Long instrId) {
        this.instrId = instrId;
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

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public String getInfosCalibration() {
        return infosCalibration;
    }

    public void setInfosCalibration(String infosCalibration) {
        this.infosCalibration = infosCalibration;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public Collection<PeriodeUtilisationInstrument> getPeriodeUtilisationInstrumentCollection() {
        return periodeUtilisationInstrumentCollection;
    }

    public void setPeriodeUtilisationInstrumentCollection(Collection<PeriodeUtilisationInstrument> periodeUtilisationInstrumentCollection) {
        this.periodeUtilisationInstrumentCollection = periodeUtilisationInstrumentCollection;
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
        hash += (instrId != null ? instrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instrument)) {
            return false;
        }
        Instrument other = (Instrument) object;
        if ((this.instrId == null && other.instrId != null) || (this.instrId != null && !this.instrId.equals(other.instrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.Instrument[ instrId=" + instrId + " ]";
    }
    
}
