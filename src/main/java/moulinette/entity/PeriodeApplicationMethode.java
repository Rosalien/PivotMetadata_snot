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
@Table(name = "periode_application_methode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodeApplicationMethode.findAll", query = "SELECT p FROM PeriodeApplicationMethode p")
    , @NamedQuery(name = "PeriodeApplicationMethode.findByPamId", query = "SELECT p FROM PeriodeApplicationMethode p WHERE p.pamId = :pamId")
    , @NamedQuery(name = "PeriodeApplicationMethode.findByDateDebut", query = "SELECT p FROM PeriodeApplicationMethode p WHERE p.dateDebut = :dateDebut")
    , @NamedQuery(name = "PeriodeApplicationMethode.findByDateFin", query = "SELECT p FROM PeriodeApplicationMethode p WHERE p.dateFin = :dateFin")})
public class PeriodeApplicationMethode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pam_id")
    private Long pamId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @JoinColumn(name = "jeu_id", referencedColumnName = "jeu_id")
    @ManyToOne(optional = false)
    private Jeu jeuId;
    @JoinColumn(name = "mcalc_id", referencedColumnName = "mcalc_id")
    @ManyToOne(optional = false)
    private MethodeCalcul mcalcId;
    @JoinColumn(name = "stdtvar_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Realnode stdtvarId;

    public PeriodeApplicationMethode() {
    }

    public PeriodeApplicationMethode(Long pamId) {
        this.pamId = pamId;
    }

    public PeriodeApplicationMethode(Long pamId, Date dateDebut) {
        this.pamId = pamId;
        this.dateDebut = dateDebut;
    }

    public Long getPamId() {
        return pamId;
    }

    public void setPamId(Long pamId) {
        this.pamId = pamId;
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

    public Jeu getJeuId() {
        return jeuId;
    }

    public void setJeuId(Jeu jeuId) {
        this.jeuId = jeuId;
    }

    public MethodeCalcul getMcalcId() {
        return mcalcId;
    }

    public void setMcalcId(MethodeCalcul mcalcId) {
        this.mcalcId = mcalcId;
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
        hash += (pamId != null ? pamId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodeApplicationMethode)) {
            return false;
        }
        PeriodeApplicationMethode other = (PeriodeApplicationMethode) object;
        if ((this.pamId == null && other.pamId != null) || (this.pamId != null && !this.pamId.equals(other.pamId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moulinette.entity.PeriodeApplicationMethode[ pamId=" + pamId + " ]";
    }
    
}
