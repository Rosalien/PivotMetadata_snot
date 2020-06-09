/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.dataset;

import java.util.ArrayList;
import java.util.Collection;
import moulinette.element.Enum.EnumClimates;
import moulinette.element.Enum.EnumGeologies;
import moulinette.element.Enum.EnumCriticalZoneCompartments;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class representing Portal search critera parameter to be used for the portal
 * for dataset discovery
 *
 * @author coussotc
 */
@XmlRootElement(name = "portalSearchCriteria")
@XmlAccessorType(XmlAccessType.FIELD)
public class PortalSearchCriteria {

    /**
     * Ordered list of climate according to EnumClimates values
     *
     * @see EnumClimates
     */
    private ArrayList<String>  climates;
    /**
     * Ordered list of geologies according to EnumGeologies values
     *
     * @see EnumGeologies
     */
    private ArrayList<String>  geologies;

    /**
     * Constructor of portal search criteria using mandatory fields
     *
     * @param climates Ordered list of climate according to EnumClimates values
     * @param geologies Ordered list of geologies according to EnumGeologies
     * values
     *
     * @see EnumClimates
     * @see EnumGeologies
     * @see PortalSearchCriteria#climates
     * @see PortalSearchCriteria#geologies
     *
     */
    public PortalSearchCriteria(ArrayList<String> climates, ArrayList<String> geologies) {
        this.climates = climates;
        this.geologies = geologies;
    }
    
    /**
     * PortalSearchCriteria constructor with mandatory fields for
     * MetadataFabrique
     */
//    public PortalSearchCriteria(Object[] vector) {
//        this.climates = (String) vector[0];
//        this.geologies = (String) vector[1];
//    }

}
