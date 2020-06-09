/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.observation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author coussotc
 */
@XmlRootElement(name = "additionalvalue")
@XmlAccessorType(XmlAccessType.FIELD)
public class AdditionalValue {

    /**
     * additional value attributes
     */
    private final String name, columnName;

    private String unit, description;

    /**
     * AdditionalValue constructor
     * @param name the name of the additional value
     * @param columnName the name of the column containing the AdditionalValue in the NumericalResult file.
     */
    public AdditionalValue(String name, String columnName) {
        this.name = name;
        this.columnName = columnName;
    }
    
    /**
     * unit setter
     * @param unit The unit of the AdditionalValue if it has one
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * description setter
     * @param description the description of the AdditionalValue 
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
