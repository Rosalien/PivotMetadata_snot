/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jbparoissien
 */
@Entity
@Table(name = "periode_utilisation_instrument")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodeUtilisationInstrument.findAll", query = "SELECT p FROM PeriodeUtilisationInstrument p")
    , @NamedQuery(name = "PeriodeUtilisationInstrument.findByPuiId", query = "SELECT p FROM PeriodeUtilisationInstrument p WHERE p.puiId = :puiId")
    , @NamedQuery(name = "PeriodeUtilisationInstrument.findByDateDebut", query = "SELECT p FROM PeriodeUtilisationInstrument p WHERE p.dateDebut = :dateDebut")
    , @NamedQuery(name = "PeriodeUtilisationInstrument.findByDateFin", query = "SELECT p FROM PeriodeUtilisationInstrument p WHERE p.dateFin = :dateFin")})
public class PeriodeUtilisationInstrument implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pui_id")
    private Long puiId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @JoinColumn(name = "instr_id", referencedColumnName = "instr_id")
    @ManyToOne(optional = false)
    private Instrument instrId;
    @JoinColumn(name = "jeu_id", referencedColumnName = "jeu_id")
    @ManyToOne(optional = false)
    private Jeu jeuId;
    @JoinColumn(name = "stdtvar_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Realnode stdtvarId;

    public PeriodeUtilisationInstrument() {
    }

    public PeriodeUtilisationInstrument(Long puiId) {
        this.puiId = puiId;
    }

    public PeriodeUtilisationInstrument(Long puiId, Date dateDebut) {
        this.puiId = puiId;
        this.dateDebut = dateDebut;
    }

    public Long getPuiId() {
        return puiId;
    }

    public void setPuiId(Long puiId) {
        this.puiId = puiId;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Instrument getInstrId() {
        return instrId;
    }

    public void setInstrId(Instrument instrId) {
        this.instrId = instrId;
    }

    public Jeu getJeuId() {
        return jeuId;
    }

    public void setJeuId(Jeu jeuId) {
        this.jeuId = jeuId;
    }

    public Realnode getStdtvarId() {
        return stdtvarId;
    }

    public void setStdtvarId(Realnode stdtvarId) {
        this.stdtvarId = stdtvarId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puiId != null ? puiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodeUtilisationInstrument)) {
            return false;
        }
        PeriodeUtilisationInstrument other = (PeriodeUtilisationInstrument) object;
        if ((this.puiId == null && other.puiId != null) || (this.puiId != null && !this.puiId.equals(other.puiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.PeriodeUtilisationInstrument[ puiId=" + puiId + " ]";
    }
    
}
