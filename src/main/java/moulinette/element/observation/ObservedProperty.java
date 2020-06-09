/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.observation;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The observed property is a characteristic of the feature of interest. It
 * identifies or describes the phenomenon for which the observation is made.
 *
 * @author coussotc
 */
@XmlRootElement(name = "observedProperty")
@XmlAccessorType(XmlAccessType.FIELD)
public class ObservedProperty {

    /**
     * Name of the variable
     */
    private String name;
    /**
     * Unit of the variable
     */
    private String unit;
    /**
     * Short description of the variable
     */
    private String description;
    /**
     * Gcmd Keywords that the scientist wants to associate to the variable. All
     * the association made by the Theia/OZCAR team will be associated later.
     */
    private ArrayList<GcmdKeyword> gcmdKeywords;

    /**
     * A list of URI of Theia categories to be associated
     */
    private List<String> theiaCategories;

    /**
     * ObservedProperty constructor with mandatory fields for ObservationFabrique
     * @param name
     * @param description
     * @param unit
     */
    public ObservedProperty(String name, String description, String unit) {
        this.name = name;
        this.description = description;
        this.unit = unit;
    }
    
    /**
     * ObservedProperty constructor
     *
     * @param variableName the name of the variable
     * @param variableUnit the unit of the variable
     */
    public ObservedProperty(String variableName, String variableUnit) {
        this.name = variableName;
        this.unit = variableUnit;
    }

    public ObservedProperty(List<String> theiaCategories) {
        this.theiaCategories = theiaCategories;
    }

    /**
     * description setter
     *
     * @param description String describing the variable
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * gcmdKeyword setter
     *
     * @param gcmdKeywords a list of GcmdKeyword objects
     * @see GcmdKeyword
     */
    public void setGcmdKeyword(ArrayList<GcmdKeyword> gcmdKeywords) {
        this.gcmdKeywords = gcmdKeywords;
    }

    /**
     * name getter
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * unit getter
     *
     * @return String
     */
    public String getUnit() {
        return unit;
    }

    /**
     * variableDescritpion getter
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * theiaCategories setter
     *
     * @param theiaCategories List of URI
     */
    public void setTheiaCategories(List<String> theiaCategories) {
        this.theiaCategories = theiaCategories;
    }
    
    @Override
    public String toString() {
        return "ObservedProperty{" + "name=" + name + ", unit=" + unit + ", description=" + description + ", gcmdKeywords=" + gcmdKeywords + ", theiaCategories=" + theiaCategories + '}';
    }

}
