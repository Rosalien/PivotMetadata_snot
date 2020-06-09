/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.observation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import moulinette.element.Enum.EnumGeoJSONTypes;
import moulinette.element.geometry.Properties;

/**
 * Abstract class representing the different form of feature that can be sampled by an observation
 * @author coussotc
 */
@XmlRootElement(name = "samplingFeature")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class SamplingFeature {
    /**
    * The name of the feature. i.e. the name of the station.
    */
    protected  String name;
    protected  String type;
    protected  Properties properties = new Properties();

    public SamplingFeature() {
        this.type = EnumGeoJSONTypes.FEATURE.toString();
    }
    /**
     * name getter
     * @return String
     */
    public String getName() {
        return name;
    }
    
    
    
    
}
