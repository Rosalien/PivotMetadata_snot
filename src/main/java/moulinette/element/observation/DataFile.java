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
 * A file containing Result
 * @author coussotc
 */
@XmlRootElement(name = "datafile")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataFile {
    /**
     * The name of the file with the extension
     * ex: temperature_time_serie.csv
     */
    private String name;
    
    /**
     * DataFile constructor 
     * @param name The name of the file with the extension
     */
    public DataFile(String name) {
        this.name = name;
    }   
}

