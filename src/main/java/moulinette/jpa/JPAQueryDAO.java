/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.jpa;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import moulinette.entity.Jeu;
import moulinette.entity.SiteSnot;
import moulinette.entity.Variable;
import org.bouncycastle.pqc.math.linearalgebra.Vector;

/**
 *
 * @author jbparoissien
 */
public class JPAQueryDAO {

    @PersistenceContext(name = "MyPU")
    EntityManager entityManager;

    public List<Jeu> getJeuxObject(String codeJeu) {
        return entityManager
                .createNamedQuery("Jeu.findByCodeJeu", Jeu.class)
                .setParameter("codeJeu", codeJeu)
                .getResultList();
    }

    String querydataContraint = "SELECT "
            + "doi,citation,titre_licence,url_licence,url_download,url_info  "
            + "FROM jeu "
            + "WHERE code_jeu = ?";

    public List<Object[]> getDataContraint(String codeJeu) {
        return entityManager
                .createNativeQuery(querydataContraint)
                .setParameter(1, codeJeu)
                .getResultList();
    }

    String queryCategories = "SELECT "
            + "zet_climat, zet_geologie "
            + "FROM site_snot "
            + "INNER JOIN jeu on jeu.site_id=site_snot.site_id "
            + "INNER JOIN site on site.site_id=site_snot.site_id "
            + "WHERE code_jeu = ?";

    public List<Object[]> getCategories(String codeJeu) {
        return entityManager
                .createNativeQuery(queryCategories)
                .setParameter(1, codeJeu)
                .getResultList();
    }

    public List<SiteSnot> getSiteSnotObject(String codeJeu) {
        return entityManager
                .createQuery("SELECT j.siteId from Jeu as j where j.codeJeu=:codeJeu", SiteSnot.class)
                .setParameter("codeJeu", codeJeu)
                .getResultList();
    }

    String queryStations = "select * from site_snot sn "
            + "join site s using(site_id) "
            + "where s.name = ?1";

    public SiteSnot getStationobject(String codeStation) {
        final List<SiteSnot> resultList = entityManager
                .createNativeQuery(queryStations, SiteSnot.class)
                .setParameter(1, codeStation)
                .getResultList();
        return resultList.stream().findFirst().orElse(null);
    }

//    Version anglaise
    String queryStationsName = "select localestring, zet_coordonnees_bbox "
            + "from site_snot "
            + "inner join site as s on s.site_id = site_snot.site_id "
            + "inner join realnode as rn on rn.id_nodeable = site_snot.site_id "
            + "inner join localisation as l on l.defaultstring = s.name "
            + "where rn.path like ?1 "
            + "and localization like 'en' "
            + "and colonne like 'nom'";

        public List<Object[]> getStationsName(String sitePath) {
        return entityManager
                .createNativeQuery(queryStationsName)
                .setParameter(1, sitePath)
                .getResultList();
    }
    
    String queryCoordinates = "SELECT "
            + "zet_coordonnees_bbox "
            + "FROM site_snot "
            + "INNER JOIN jeu on jeu.site_id=site_snot.site_id "
            + "INNER JOIN site on site.site_id=site_snot.site_id "
            + "WHERE code_jeu = ?";

    public List<String> getCoordinates(String codeJeu) {
        return entityManager
                .createNativeQuery(queryCoordinates)
                .setParameter(1, codeJeu)
                .getResultList();
    }

    String queryContacts = "SELECT "
            + "gestionnairejeu.nom as nom,prenom,email,localestring "
            + "FROM gestionnairejeu "
            + "inner join jeu on jeu.jeu_id=gestionnairejeu.jeu_id "
            + "inner join valeur_qualitative on valeur_qualitative.vq_id = gestionnairejeu.vq_id "
            + "inner join localisation as l on l.defaultstring=valeur_qualitative.valeur "
            + "WHERE code_jeu = ? "
            + "and localization = 'en'"
            + "and date_fin is null "
            + "and valeur in ('data_manager','principal_investigator') "
            + "order by valeur='data_manager',valeur='principal_investigator'";

    public List<Object[]> getContacts(String codeJeu) {
        return entityManager
                .createNativeQuery(queryContacts)
                .setParameter(1, codeJeu)
                .getResultList();
    }

    String queryRealNodePath = "SELECT "
            + "PATH "
            + "FROM datatype_unite_variable_snot_vdt as dtuv "
            + "INNER JOIN Jeu as j on j.jeu_id=dtuv.jeu_id "
            + "INNER JOIN realnode as rn on rn.id_nodeable = dtuv.sdvu_id "
            + "WHERE code_jeu = ?1";

    public List<String> getRealNodePaths(String codeJeu) {
        return entityManager
                .createNativeQuery(queryRealNodePath)
                .setParameter(1, codeJeu)
                .getResultList();
    }

    //Requête pour récupérer tous les path du SNO-T
    String queryAllRealNodePath = "SELECT "
            + "PATH "
            + "FROM datatype_unite_variable_snot_vdt as dtuv "
            + "INNER JOIN Jeu as j on j.jeu_id=dtuv.jeu_id "
            + "INNER JOIN realnode as rn on rn.id_nodeable = dtuv.sdvu_id ";

    public List<String> getAllRealNodePaths() {
        return entityManager
                .createNativeQuery(queryAllRealNodePath)
                .getResultList();
    }
    
    //Requête pour récupérer tous les JDD du SNO-T
    String queryAllCodesJeu = "SELECT "
            + "distinct code_jeu "
            + "FROM carac_data_sensor_method_prod ";

    public List<String> getAllCodesJeu() {
        return entityManager
                .createNativeQuery(queryAllCodesJeu)
                .getResultList();
    }
        
//    En anglais, à tester
    String queryVariablesUnite = "SELECT "
            + "distinct cn.code as nom, localestring as definition_en, u.code as unite, theiacategories, missingvalue,path,definition as definition_fr "
            + "FROM variable as v "
            + "inner join datatype_unite_variable_snot_vdt as dtuvsnot on dtuvsnot.id = v.var_id "
            + "inner join composite_nodeable as cn on cn.id = v.var_id "
            + "inner join unite as u on u.uni_id = dtuvsnot.uni_id "
            + "inner join realnode as rn on rn.id_nodeable = dtuvsnot.sdvu_id "
            + "inner join variable_snot as vsnot on vsnot.var_id=v.var_id "
            + "inner join localisation as l on l.defaultstring=definition "
            + "where rn.path = ?1";

    public List<Object[]> getVariablesUnite(String realnodePath) {
        return entityManager
                .createNativeQuery(queryVariablesUnite)
                .setParameter(1, realnodePath)
                .getResultList();
    }

    String queryTheia = "SELECT "
            + "theiacategories "
            + "FROM variable as v "
            + "inner join datatype_unite_variable_snot_vdt as dtuvsnot on dtuvsnot.id = v.var_id "
            + "inner join composite_nodeable as cn on cn.id = v.var_id "
            + "inner join unite as u on u.uni_id = dtuvsnot.uni_id "
            + "inner join realnode as rn on rn.id_nodeable = dtuvsnot.sdvu_id "
            + "inner join variable_snot as vsnot on vsnot.var_id=v.var_id "
            + "where rn.path = ?1";

    public List<String> getTheia(String realnodePath) {
        return entityManager
                .createNativeQuery(queryTheia)
                .setParameter(1, realnodePath)
                .getResultList();
    }

//    En anglais, à tester
    String querySensor = "SELECT distinct date_debut, "
            + "(CASE "
            + "      WHEN date_fin is null "
            + "      THEN( "
            + "SELECT date_fin "
            + "from ("
            + "select max(date_fin) as date_fin "
            + "from "
            + "( "
            + "select to_char(max(mms_date),'YYYY-MM-DDThh:mm:ssZ') as date_fin,m.site_id,idi.id "
            + "from mesures_meteo_sh_mms as m "
            + "inner join insertion_dataset_ids as idi on idi.ivf_id=m.ivf_id "
            + "group by m.site_id,idi.id "
            + ")a "
            + "left join realnode rv ON rv.id = a.id "
            + "left join realnode rd ON rd.id = rv.id_parent_node "
            + "left join site on site.site_id=a.site_id "
            + "inner join jeu on jeu.site_id=parent_site_id "
            + "and jeu.id=rd.id_nodeable "
            + "where code_jeu like ?2 "
            + "group by code_jeu "
            + "UNION "
            + "select max(date_fin) as date_fin "
            + "from "
            + "( "
            + "select to_char(max(mfs_date),'YYYY-MM-DDThh:mm:ssZ') as date_fin,m.site_id,idi.id "
            + "from mesures_flux_mfs as m "
            + "inner join insertion_dataset_ids as idi on idi.ivf_id=m.ivf_id "
            + "group by m.site_id,idi.id "
            + ")a "
            + "left join realnode rv ON rv.id = a.id "
            + "left join realnode rd ON rd.id = rv.id_parent_node "
            + "left join site on site.site_id=a.site_id "
            + "inner join jeu on jeu.site_id=parent_site_id "
            + "and jeu.id=rd.id_nodeable "
            + "where code_jeu like ?2 "
            + "group by code_jeu "
            + ")b "
            + "       ) "
            + " ELSE date_fin "
            + " END), code,fabricant,libelle_en,infos_calibration "
            + " from ( "
            + " SELECT rn.path, "
            + " to_char(date_debut, 'YYYY-MM-DDThh:mm:ssZ') date_debut, to_char(date_fin, 'YYYY-MM-DDThh:mm:ssZ') date_fin,code,fabricant,localestring as libelle_en,infos_calibration,libelle as libelle_fr "
            + " FROM instrument as i "
            + " inner join periode_utilisation_instrument as pui on pui.instr_id=i.instr_id "
            + " inner join realnode as rn on rn.id=pui.stdtvar_id "
            + " inner join localisation as l on l.defaultstring=description "
            + " where rn.path = ?1 "
            + " and l.colonne like 'description' "
            + " )a ";

    public List<Object[]> getPhysicalSensor(String realnodePath, String codeJeu) {

        return entityManager
                .createNativeQuery(querySensor)
                .setParameter(1, realnodePath)
                .setParameter(2, codeJeu)
                .getResultList();
    }

    //    En anglais, à tester
    String queryVirtualSensor = "SELECT "
            //+ "to_char(date_debut, 'YYYY-MM-DDThh:mm:ssZ') date_debut, to_char(date_fin, 'YYYY-MM-DDThh:mm:ssZ') date_fin, libelle, m.description "
            + "l.localestring as libelle_en, l2.localestring as description_en,libelle as libelle_fr,m.description as description_fr "
            + "FROM methode_calcul as m "
            + "inner join periode_application_methode as pam on pam.mcalc_id=m.mcalc_id "
            + "inner join realnode as rn on rn.id=pam.stdtvar_id "
            + "inner join localisation as l on l.defaultstring=libelle "
            + "inner join localisation as l2 on l2.defaultstring=description "
            + "where rn.path = ?1";

    public List<Object[]> getLineageInformation(String realnodePath) {
        return entityManager
                .createNativeQuery(queryVirtualSensor)
                .setParameter(1, realnodePath)
                .getResultList();
    }

    String queryMissingvalue = "SELECT "
            + "missingvalue "
            + "FROM variable as v "
            + "inner join datatype_unite_variable_snot_vdt as dtuvsnot on dtuvsnot.id = v.var_id "
            + "inner join unite as u on u.uni_id = dtuvsnot.uni_id "
            + "inner join realnode as rn on rn.id_nodeable = dtuvsnot.sdvu_id "
            + "inner join variable_snot as vsnot on vsnot.var_id=v.var_id "
            + "where rn.path = ?1";

    public List<String> getMissingvalue(String realnodePath) {
        return entityManager
                .createNativeQuery(queryMissingvalue)
                .setParameter(1, realnodePath)
                .getResultList();
    }

    String queryTemporalExtent = "SELECT date_debut,date_fin "
            + "from ("
            + "select min(date_debut) as date_debut,max(date_fin) as date_fin "
            + "from "
            + "( "
            + "select to_char(min(mms_date),'YYYY-MM-DDThh:mm:ssZ') as date_debut, to_char(max(mms_date),'YYYY-MM-DDThh:mm:ssZ') as date_fin,m.site_id,idi.id "
            + "from mesures_meteo_sh_mms as m "
            + "inner join insertion_dataset_ids as idi on idi.ivf_id=m.ivf_id "
            + "group by m.site_id,idi.id "
            + ")a "
            + "left join realnode rv ON rv.id = a.id "
            + "left join realnode rd ON rd.id = rv.id_parent_node "
            + "left join site on site.site_id=a.site_id "
            + "inner join jeu on jeu.site_id=parent_site_id "
            + "and jeu.id=rd.id_nodeable "
            + "where code_jeu like ?1 "
            + "group by code_jeu "
            + "UNION "
            + "select min(date_debut) as date_debut,max(date_fin) as date_fin "
            + "from "
            + "( "
            + "select to_char(min(mfs_date),'YYYY-MM-DDThh:mm:ssZ') as date_debut, to_char(max(mfs_date),'YYYY-MM-DDThh:mm:ssZ') as date_fin,m.site_id,idi.id "
            + "from mesures_flux_mfs as m "
            + "inner join insertion_dataset_ids as idi on idi.ivf_id=m.ivf_id "
            + "group by m.site_id,idi.id "
            + ")a "
            + "left join realnode rv ON rv.id = a.id "
            + "left join realnode rd ON rd.id = rv.id_parent_node "
            + "left join site on site.site_id=a.site_id "
            + "inner join jeu on jeu.site_id=parent_site_id "
            + "and jeu.id=rd.id_nodeable "
            + "where code_jeu like ?1 "
            + "group by code_jeu "
            + ")b ";

    public List<Object[]> getTemporalExtentValue(String codeJeu) {
        return entityManager
                .createNativeQuery(queryTemporalExtent)
                .setParameter(1, codeJeu)
                .getResultList();
    }

}
