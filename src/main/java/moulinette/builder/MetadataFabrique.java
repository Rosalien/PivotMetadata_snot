/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.builder;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import moulinette.DAO.ThematicCategoryInspireKeywordDAO;
import moulinette.element.dataset.DataConstraint;
import moulinette.element.dataset.Licence;
import moulinette.element.dataset.Metadata;
import moulinette.element.dataset.OnlineResource;
import moulinette.element.dataset.Person;
import moulinette.element.dataset.PortalSearchCriteria;
import moulinette.element.dataset.SpatialExtent;
import moulinette.element.geometry.MultiPolygon;
import moulinette.element.geometry.Polygon;
import moulinette.entity.Jeu;
import moulinette.entity.SiteSnot;
import moulinette.exceptions.CSVImportException;
import moulinette.jpa.JPAQueryDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to import metadata of a dataset from a relational database
 *
 * @see Metadata
 * @author coussotc
 */
public class MetadataFabrique {

    @Inject
    protected JPAQueryDAO requeteDAO;

    private final Logger logger = LoggerFactory.getLogger(MetadataFabrique.class);

    /**
     * Instanciate a Metadata Object using information from a relational
     * database and external CSV files
     *
     * @see Connection
     * @param codeJeu id of the dataset
     * @param pathToCSVSourceFiles path to the folder of the external CSV
     * sources files
     * @return Metadata object
     * @throws IOException
     */
    public Metadata buildMetadata(String codeJeu, String pathToCSVSourceFiles) throws IOException {
        Metadata metadata = new Metadata();

//        System.out.println("Début dataset");
        datasetDescription(codeJeu, metadata);

        datasetOnlineRessources(codeJeu, metadata);

        datasetDataConstraint(codeJeu, metadata);

        SpatialExtent(codeJeu, metadata);

        PortalSearchCriteria(codeJeu, metadata);

        Contacts(codeJeu, metadata);

//        System.out.println("Fin dataset");
        /**
         * Set the Inspire theme
         */
        try {
            metadata.setInspireTheme(ThematicCategoryInspireKeywordDAO.setInspireTheme(codeJeu, pathToCSVSourceFiles));
        } catch (CSVImportException e) {
            logger.error(e.getMessageDataDatasetNotFound());
        }

        /**
         * Set the online resources of the dataset from a csv file
         */
//        try {
//            metadata.setOnlineRessources(OnlineResourceDAO.setOnlineResource(codeJeu, pathToCSVSourceFiles));
//        } catch (CSVImportException e) {
//            logger.error(e.getMessageDataDatasetNotFound());
//        }
        /**
         * Set data constraints of the dataset from a csv file
         */
//        try {
//            metadata.setDataConstraint(DataConstraintDAO.setDataConstraints(codeJeu, pathToCSVSourceFiles));
//        } catch (CSVImportException e) {
//            logger.error(e.getMessageDataDatasetNotFound());
//        }
        /**
         * Set thematic categories
         */
        try {
            metadata.setTopicCategories(ThematicCategoryInspireKeywordDAO.setTopicCategoriesCSV(codeJeu, pathToCSVSourceFiles));
        } catch (CSVImportException e) {
            logger.error(e.getMessageDataDatasetNotFound());
        }

        return metadata;
    }

    private void Contacts(String codeJeu, Metadata metadata) {
        /**
         * Setting contacts for the dataset
         */
        ArrayList<Person> contacts = new ArrayList<>();
        requeteDAO.getContacts(codeJeu)
                .stream()
                .map(Person::new)
                .forEach(contacts::add);
        metadata.setContacts(contacts);
    }

    private void datasetDescription(String codeJeu, Metadata metadata) {
        /**
         * Set the description dataset
         */
        List<Jeu> requetesJeux = requeteDAO.getJeuxObject(codeJeu);
        for (Jeu jeu : requetesJeux) {
            metadata.setTitle(jeu.getTitre());
            metadata.setDescription(jeu.getDescription());
            String jeuObjectif = jeu.getObjectif();
//            System.out.println("----jeuObjectif"+jeuObjectif);
            if (jeuObjectif != null && !jeuObjectif.isEmpty()) {
                metadata.setObjective(jeuObjectif);
            }
            metadata.setDatasetLineage(jeu.getGenealogie());
        }
    }

    private void datasetOnlineRessources(String codeJeu, Metadata metadata) {
//        System.out.println("*****************TRY-OnlineRessources****************************************");

        /**
         * Set the datasetOnlineRessources description
         */
        Object[] requete = requeteDAO.getDataContraint(codeJeu).get(0);

        String urlDownload = (String) requete[4];
        String urlInfo = (String) requete[5];
        String doi = (String) requete[0];

//        System.out.println(urlDownload);
//        System.out.println(urlInfo);
//        System.out.println(doi);
        OnlineResource onlineResource = new OnlineResource(urlDownload, urlInfo, doi);
        onlineResource.setUrlDownload(urlDownload);
        onlineResource.setUrlInfo(urlInfo);
        onlineResource.setDoi(doi);

        metadata.setOnlineRessources(onlineResource);
    }

    private void datasetDataConstraint(String codeJeu, Metadata metadata) {
//        System.out.println("*****************TRY-DataConstraints****************************************");

        /**
         * Set the datasetDataConstraint description
         */
        Object[] requete = requeteDAO.getDataContraint(codeJeu).get(0);

//        System.out.println(requete);
        String accessUseConstraint = (String) requete[1];
        String urlDataPolicy = "https://data-snot.cnrs.fr/snot/mentionLegale.jsf";
        String acknowledgment = "'The SNO Tourbières observing system https://www.sno-tourbieres.cnrs.fr/ was set up thanks to an incentive funding of the French Ministry of Research that allowed pooling together various pre-existing small scale observing setups. The continuity and long term perenity of the measurements are made possible by an undisrupted and continuous CNRS funding since 2008'";
        String titre_licence = (String) requete[2];
        String url_licence = (String) requete[3];

        Licence licence = null;

        DataConstraint dataConstraint = new DataConstraint(accessUseConstraint, urlDataPolicy, licence);

        if (accessUseConstraint != null) {
            dataConstraint.setAccessUseConstraint("The following sentence should appear in the acknowledgments of the publication : " + acknowledgment + ". Please also add this citation : " + accessUseConstraint);
        } else {
            dataConstraint.setAccessUseConstraint("The following sentence should appear in the acknowledgments of the publication : " + acknowledgment);
        }

        dataConstraint.setUrlDataPolicy(urlDataPolicy);
        dataConstraint.setLicence(new Licence(titre_licence, url_licence));

        metadata.setDataConstraint(dataConstraint);
    }

    private void PortalSearchCriteria(String codeJeu, Metadata metadata) {
//        /**
//         * Set PortalSearchCriteria
//         */

        Object[] requete = requeteDAO.getCategories(codeJeu).get(0);

        ArrayList<String> climates = new ArrayList<>();
        ArrayList<String> geologies = new ArrayList<>();

        String climat = requete[0].toString();
        String geologie = requete[1].toString();

        climates.add(climat);
        geologies.add(geologie);

        PortalSearchCriteria portalSearchCriteria = new PortalSearchCriteria(climates, geologies);
        metadata.setPortalSearchCriteria(portalSearchCriteria);
    }

    private void SpatialExtent(String codeJeu, Metadata metadata) throws JsonSyntaxException {
        /**
         * Set the SpatialExtent
         */
        List<SiteSnot> requetesSitesSnot = requeteDAO.getSiteSnotObject(codeJeu);
        for (SiteSnot sitesnot : requetesSitesSnot) {
            List<List<List<Double>>> coordinates = new Gson().fromJson(sitesnot.getZetCoordonneesBbox(), List.class);

            if (coordinates.size() > 1) {
                metadata.setSpatialExtent(new SpatialExtent(new MultiPolygon(
                        coordinates.stream()
                                .map(l -> new Polygon(l))
                                .collect(Collectors.toList())
                )));
            } else {
                coordinates
                        .forEach(l -> metadata.setSpatialExtent(new SpatialExtent(new Polygon(l))));
            }
        }
    }
}
