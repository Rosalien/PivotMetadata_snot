/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.observation;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import moulinette.element.Enum.EnumProcessingLevels;
import moulinette.element.Enum.EnumResultDataTypes;

/**
 * Class representing an Observation. Each datasets in composed of observations.
 An observation is an action whose the NumericalResult is a value of a Property of the 
 FeatureOfInterest at a given time, obtained following a Procedure.
 * @author coussotc
 */
@XmlRootElement(name = "observation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Observation {
    /**
     * Id of the observation. Corresponds to the trigramme of the provider, the number of the dataset, and the number of the observation 
     * of the dataset separated by underscores (ex: AMA_2_36);
     */
    private String observationId;
    /**
     * The feature of interest is an abstraction of a real-world object. It's the spatial object
     * sample by the Observation
     */
    private FeatureOfInterest featureOfInterest;
    /**
     * The observed property is a characteristic of the feature of interest. It identifies or
     * describes the phenomenon for which the observation is made.
     */
    private ObservedProperty observedProperty;
    /**
     * The procedure, or observation process, is the description of the processus used 
     * to produce the result from an observed property of the feature of interest
     */
    private Procedure procedure;
    /**
     * The result of an observation is an estimate value of a property of the feature of interest
     */
    private NumericalResult result;
    /**
     * boolean in order to know if the result is a time serie or not
     */
    private boolean timeSerie;
    /**
     * The temporalextent of the result. For result that are not time series, the date acquisition of the 
     * observation is precised. For results that are not temporal (e.g. geological map the date of acquisition of
     * the observation is precised followed by a 31-12-9999 00:00:00
     */
    private TemporalExtent temporalExtent;
    /**
     * The type of the result according to EnumResultDataTypes enumeration
     */
    private String dataType;
    /**
     * The level of processing for the data of the observation
     */
    private String processingLevel;
    
    /**
     * Observation constructor
     */
    public Observation() {
    }
    /**
     * featureOfInterest setter
     * @param featureOfInterest FeatureOfInterest object
     * @see FeatureOfInterest
     */
    public void setFeatureOfInterest(FeatureOfInterest featureOfInterest) {
        this.featureOfInterest = featureOfInterest;
    }
    /**
     * observedProperty setter
     * @param observedProperty ObservedProperty object
     * @see ObservedProperty
     */
    public void setObservedProperty(ObservedProperty observedProperty) {
        this.observedProperty = observedProperty;
    }
    /**
     * procedure setter
     * @param procedure Procedure object
     * @see Procedure
     */
    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }
    /**
     * result setter
     * @param result NumericalResult object 
     * @see NumericalResult
     */
    public void setResult(NumericalResult result) {
        this.result = result;
    }
    /**
     * timeSerie setter
     * @param timeSerie boolean 
     */
    public void setTimeSerie(boolean timeSerie) {
        this.timeSerie = timeSerie;
    }
    /**
     * temporalExtent setter
     * @param temporalExtent  
     */
    public void setTemporalExtent(TemporalExtent temporalExtent) {
        this.temporalExtent = temporalExtent;
    }
    /**
     * dataType setter
     * @param dataType EnumResultDataTypes
     * @see EnumResultDataTypes
     */
    public void setDataType(EnumResultDataTypes dataType) {
        this.dataType = dataType.toString();
    }    
    /**
     * featureOfInterest getter
     * @return FeatureOfInterest
     * @see FeatureOfInterest
     */
    public FeatureOfInterest getFeatureOfInterest() {
        return featureOfInterest;
    }

    /**
     * observedProperty getter
     * @return ObservedProperty
     * @see ObservedProperty
     */
    public ObservedProperty getObservedProperty() {
        return observedProperty;
    }
    /**
     * procedure getter
     * @return Procedure 
     * @see Procedure
     */
    public Procedure getProcedure() {
        return procedure;
    }
    /**
     * result getter
     * @return NumericalResult
     * @see NumericalResult
     */
    public NumericalResult getResult() {
        return result;
    }
    /**
     * processingLevel setter
     * @param processingLevel EnumProcessingLevel
     * @see EnumProcessingLevels
     */
    public void setProcessingLevel(EnumProcessingLevels processingLevel) {
        this.processingLevel = processingLevel.toString();
    }  
    
    /**
     * observationId setter
     * @param observationId String 
     */
    public void setObservationId(String observationId) {
        this.observationId = observationId;
    }
    
}

