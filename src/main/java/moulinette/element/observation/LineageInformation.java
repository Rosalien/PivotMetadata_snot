/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.observation;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author coussotc
 */
@XmlRootElement(name = "lineageinformation")
@XmlAccessorType(XmlAccessType.FIELD)
public class LineageInformation {

    /**
     * Senor constructor constructor with mandatory fields for
     * ObservationFabrique
     */
    public LineageInformation(Object[] vector) {
        this.processingDescription = (String) vector[1];
        //this.processDate = (Date) vector[1];
    }

    /**
     * Description of the process applied to the observation
     */
    private String processingDescription;
    /**
     * Date when the process has been applid to the observation
     */
    private Date processDate;

    /**
     * ProcessingInformation constructor
     *
     * @param processingDescription String describing the process applied to the
     * observation
     */
    public LineageInformation(String processingDescription) {
        this.processingDescription = processingDescription;
    }

    /**
     * processDate setter
     *
     * @param processDate Date of the process
     */
    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }
}
