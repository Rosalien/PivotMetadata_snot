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
 *
 * @author coussotc
 */
@XmlRootElement(name = "sensor")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Sensor {

    private List<TemporalExtent> activityPeriods =  new ArrayList();

    public Sensor() {

    }

    public Sensor(String dateDebut, String dateFin) {
        activityPeriods.add(new TemporalExtent(dateDebut, dateFin));
    }

    /**
     * activityPeriods setter
     *
     * @param activityPeriods ArrayList of one or several Date[2] describing the activity interval of the sensor for a
     * time serie
     */
    public void setActivityPeriods(List<TemporalExtent> activityPeriods) {
        this.activityPeriods = activityPeriods;
    }

    public List<TemporalExtent> getActivityPeriods() {
        return activityPeriods;
    }

    @Override
    public String toString() {
        return "Sensor{" + "activityPeriods=" + activityPeriods + '}';
    }
    
    

}
