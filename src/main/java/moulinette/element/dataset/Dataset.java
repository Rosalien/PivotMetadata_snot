/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.dataset;

import moulinette.element.observation.Observation;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class representing a dataset of a provider
 *
 * @author coussotc
 */
@XmlRootElement(name = "dataset")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dataset {

    /**
     * ID of the dataset. trigramme of the provider plus the number of the dataset separated with underscore ex: AMA_1
     */
    private String datasetId;
    /**
     * Metadata object representing the metadata information of the dataset
     *
     * @see Metadata
     */
    private Metadata metadata;

    /**
     * Ordered list of Observation representing the list of all the Observation of the dataset
     *
     * @see Observation
     */
    private List<Observation> observations;

    /**
     * Dataset constructor with mandatory field
     *
     * @param metadata a Metadata object representing the metadata of the dataset
     * @param observations a orderder list of Observation objects representing the Observation of the dataset
     * @see Observation
     */
    public Dataset(String datasetId, Metadata metadata, List<Observation> observations) {
        this.datasetId = datasetId;
        this.metadata = metadata;
        this.observations = observations;
    }

}
