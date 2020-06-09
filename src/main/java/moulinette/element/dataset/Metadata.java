/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.dataset;

import moulinette.element.Enum.EnumDocumentTypes;
import moulinette.element.Enum.EnumTopicCategories;
import moulinette.element.Enum.EnumInspireThemes;
import moulinette.element.geometry.MultiPolygon;
import moulinette.element.geometry.Polygon;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class representing all the metadata associated to a dataset
 * @see Dataset
 * @author coussotc
 */
@XmlRootElement(name = "metadata")
@XmlAccessorType(XmlAccessType.FIELD)
public class Metadata {
    /**
     * Title of the dataset. It should be a unique name that can reference the geographical area covered.
     */
    private String title;
    /**
     * Short description, abstract, description of the dataset. 
     */
    private String description;
    /**
     * Description of the scientifique objectives of the dataset
     */
    private String objective;
    /**
     * Description of the previous processing that the dataset underwent
     */
    private String datasetLineage;
    /**
     * ordered list of contact for the dataset
     * @see Person
     */
    private List<Person> contacts;
    /**
     * Ordered list of thematic catégories for the dataset. Each element of the list must
 be a value of the EnumTopicCategories enumeration.
     * @see EnumTopicCategories
     */
    private ArrayList<String> topicCategories;
    /**
     * Inspire theme for the dataset. It must be a value of the EnumInspireThemes enumeration
     * @see EnumInspireThemes
     */
    private String inspireTheme;
    /**
     * A list of Keyword objects for the dataset.
     * @see Keyword
     */
    private List<Keyword> keywords;
    /**
     * A list of Document objects for the dataset.The list can contain a maxium of 2 elements 
     * since only two types of documents are possible in the EnumDocumentTypes enumeration
     * @see Document
     * @see EnumDocumentTypes
     */
    private List<Document> documents;
    /**
     * A OnlineResource object representing the online resource for the dataset.
     * @see OnlineResource
     */
    private OnlineResource onlineResource;
    /**
     * A DataConstraint objet representing access and use constraint on the dataset.
     * @see DataConstraint
     */
    private DataConstraint dataConstraint;
    /**
     * A PortalSearchCriteria object that represents the some search criteria on the dataset to be used by the portal.
     * @see PortalSearchCriteria
     */
    private PortalSearchCriteria portalSearchCriteria;
    /**
     * The spatialExtent of the dataset. This must be a bounding box or several bouding boxes.
     * @see SpatialExtent
     */
    private SpatialExtent spatialExtent;
    /**
     * Constructor with all the mandatory fields for the metadata of a dataset
     * @param title Title of the dataset
     * @see Metadata#title
     * @param resume abstract, description or description for the dataset
     * @see Metadata#description
     * @param dataLineage history the processing for the dataset
     * @see Metadata#datasetLineage
     * @param contacts ordered list of Person objects for the dataset
     * @see Metadata#contacts
     * @see Person
     * @param topicCategories ordered list of thematic categories for the dataset
     * @see EnumInspireThemes
     * @see Metadata#topicCategories
     * @param inspireTheme Inspire theme for the dataset
     * @see EnumTopicCategories
     * @see Metadata#title
     * @param dataConstraints data constraint for the dataset
     * @see Metadata#dataConstraint
     * @param portalSearchCriteria Portal search criteria for the dataset
     * @see Metadata#portalSearchCriteria
     * @param spatialExtent spatialExtent for the dataset. The geometrical object represented by the spatial extent 
     * must be a bounding box or a set of bounding boxes. 
     * @see Polygon
     * @see MultiPolygon
     * @see Metadata#spatialExtent
     */
    public Metadata(String title, String resume, String dataLineage, ArrayList<Person> contacts,
            ArrayList<String> topicCategories, String inspireTheme, DataConstraint dataConstraints,
            PortalSearchCriteria portalSearchCriteria, SpatialExtent spatialExtent) {
        this.title = title;
        this.description = resume;
        this.datasetLineage = dataLineage;
        this.contacts = contacts;
        this.topicCategories = topicCategories;
        this.inspireTheme = inspireTheme;
        this.dataConstraint = dataConstraints;
        this.portalSearchCriteria = portalSearchCriteria;
        this.spatialExtent = spatialExtent;
    }
    /**
     * Constructor of a metadata object for a dataset 
     */
    public Metadata() {
    }
    /**
     * Set Objective for the dataset
     * @param objective Description of the objective of the dataset
     * @see Metadata#objective
     */
    public void setObjective(String objective) {
        this.objective = objective;
    }
    
    /**
     * Set a ordered list of Keyword objects for the dataset
     * @param keywords A list of Keyword object
     * @see Keyword
     * @see Metadata#keywords
     */
    public void setKeywords(ArrayList<Keyword> keywords) {
        this.keywords = keywords;
    }
    
    /**
     * Set list of Document object for the dataset
     * @param documents ordered list of Document
     * @see Document
     * @see Metadata#documents
     */
    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }
    
    /**
     * set OnlineResource object for the dataset
     * @param onlineRessources OnlineResource object
     * @see OnlineResource
     * @see Metadata#onlineResource
     */
    public void setOnlineRessources(OnlineResource onlineRessources) {
        this.onlineResource = onlineRessources;
    }
    /**
     * set title for the dataset
     * @param title title of the dataset
     * @see Metadata#title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Set description for the dataset
     * @param description Description of the dataset
     * @see Metadata#description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Set datasetLineage for the dataset
     * @param datasetLineage history of processings for the dataset
     * @see Metadata#datasetLineage
     */
    public void setDatasetLineage(String datasetLineage) {
        this.datasetLineage = datasetLineage;
    }
    /**
     * Set a ordered list of Person objects for hte dataset
     * @param contacts ordered list of Person
     * @see Person
     * @see Metadata#contacts
     */
    public void setContacts(ArrayList<Person> contacts) {
        this.contacts = contacts;
    }
   
    /**
     * Set a list of thematic categories for the dataset. 
     * @param topicCategories ordered list of thematic categories according to 
 EnumInspireThemes values
     * @see Metadata#topicCategories
     * @see EnumInspireThemes
     */
    public void setTopicCategories(ArrayList<String> topicCategories) {
        this.topicCategories = topicCategories;
    }
    /**
     * Set INSPIRE theme for the dataset
     * @param inspireTheme INSPIRE theme according to EnumInspireThemes values
     * @see EnumTopicCategories
     * @see Metadata#inspireTheme
     */
    public void setInspireTheme(String inspireTheme) {
        this.inspireTheme = inspireTheme;
    }
    /**
     * Set dataconstraint for the dataset
     * @param dataConstraint a DataConstraint object
     * @see Metadata#dataConstraint
     * @see DataConstraint
     */
    public void setDataConstraint(DataConstraint dataConstraint) {
        this.dataConstraint = dataConstraint;
    }
    /**
     * Set the portal search criteria foor the dataset
     * @param portalSearchCriteria a PortalSearchCriteria object 
     * @see PortalSearchCriteria
     * @see Metadata#portalSearchCriteria
     */
    public void setPortalSearchCriteria(PortalSearchCriteria portalSearchCriteria) {
        this.portalSearchCriteria = portalSearchCriteria;
    }

    /**
     * Set spatial extent for the dataset
     * @param spatialExtent Spatial extent object representing a bounding box or a set of bounding boxes
     * @see Polygon
     * @see MultiPolygon
     * @see Metadata#spatialExtent
     */
    public void setSpatialExtent(SpatialExtent spatialExtent) {
        this.spatialExtent = spatialExtent;
    }

    /**
     * title getter
     * @return String
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * contacts getter
     * @return List of Person
     * @see Person
     */
    public List<Person> getContacts() {
        return contacts;
    }

    /**
     * contacts getter
     * @return List of PortalSearchCriteria
     * @see PortalSearchCriteria
     */
    public PortalSearchCriteria getPortalSearchCriteria() {
        return portalSearchCriteria;
    }


    
}
