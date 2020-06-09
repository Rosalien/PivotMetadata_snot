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

/**
 * The acquisition procedure
 *
 * @author coussotc
 */
@XmlRootElement(name = "dataproduction")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataProduction {

    /**
     * Descritpion of the method used for the acquisition of the data
     */
    private String method;

    /**
     * Descritpion of the sensor used for the acquisition of the data
     */
    private List<Sensor> sensors;

    /**
     * Acquisition constructor
     */
    public DataProduction() {
    }

    /**
     * method setter
     *
     * @param method String describing the method of acquisition
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * sensor setter
     *
     * @param sensors ArrayList of PhysicalSensor object describing the sensors used to
 get the data
     */
    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

}
