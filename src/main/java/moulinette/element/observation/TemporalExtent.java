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
@XmlRootElement(name = "temporalextent")
@XmlAccessorType(XmlAccessType.FIELD)
public class TemporalExtent {

    private String dateBeg;
    private String dateEnd;

    public TemporalExtent(Object[] vector) {
        this((String) vector[0],(String) vector[1]);
    }

    public TemporalExtent(String dateDebut, String dateFin) {
        this.dateBeg = dateDebut;
        this.dateEnd = dateFin;
    }


    public TemporalExtent() {
    }

    public String getDateBeg() {
        return dateBeg;
    }

    public void setDateBeg(String dateBeg) {
        this.dateBeg = dateBeg;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public String toString() {
        return "TemporalExtent{" + "dateBeg=" + dateBeg + ", dateEnd=" + dateEnd + '}';
    }

}
