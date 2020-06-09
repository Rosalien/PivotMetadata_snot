/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.observation;

import moulinette.element.dataset.Document;



/**
 * Class describing a virtual Sensor. This sensor can be a model used to produce simulated data
 * @author coussotc
 */
public class VirtualSensor extends Sensor {
    /**
     * The name of the model
     */
    private String name;
    /**
     * The descirption of the paramter and different forcing for the observation
     */
    private String parametrisationDescription ;
    /**
     * related publications and notices
     */
    private Document document;

    
    
    /**
     * Senor constructor constructor with mandatory fields for
     * ObservationFabrique
     * @param vector
     */
    public VirtualSensor(Object[] vector) {
//        super((String) vector[0], (String) vector[1]);
        this.name = (String) vector[0];
        this.parametrisationDescription = (String) vector[1];
    }
    
//    public VirtualSensor(String name, String parametrisationDescription) {
//        this.name = name;
//        this.parametrisationDescription = parametrisationDescription;
//    }
    
    /**
     * name setter
     * @param name name of the model 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * parametrisationDescription setter
     * @param parametrisationDescription String describing the parametrisation and frocings oof the model 
     */
    public void setParametrisationDescription(String parametrisationDescription) {
        this.parametrisationDescription = parametrisationDescription;
    }
    
    /**
     * document setter
     * @param document Document object describing the documents linked to the model
     * @see Document
     */
    public void setDocument(Document document) {
        this.document = document;
    }
}

