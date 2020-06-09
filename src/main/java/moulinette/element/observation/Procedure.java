/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.observation;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author coussotc
 */
@XmlRootElement(name = "procedure")
@XmlAccessorType(XmlAccessType.FIELD)
public class Procedure {
    /**
     * List of the LineageInformation object describing the diffrent processes the observation 
 underwent before to present the final result
     */
    private List<LineageInformation> lineageInformations;
    /**
     * DataProduction object describing the dataProduction process of the observation
     */
    private DataProduction dataProduction;
    
    /**
     * Procedure constructor
     */
    public Procedure() {
    }
    
    /**
     * dataProduction setter
     * @param dataProduction DataProduction object
     * @see DataProduction
     */
    public void setDataProduction(DataProduction dataProduction) {
        this.dataProduction = dataProduction;
    }
    
    /**
     * lineageInformations setter 
     * @param lineageInformations ArrayList of the LineageInformation
     * @see LineageInformation
     */
    public void setLineageInformations(List<LineageInformation> lineageInformations) {
        this.lineageInformations = lineageInformations;
    }
    
}
