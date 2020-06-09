/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.dataset;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class representing  the embargo set on data of a given dataset
 * @author coussotc
 */
@XmlRootElement(name = "embargo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Embargo {
    /**
     * duration of the embargo in days from the current date
     */
    private  int duration;
    /**
     * Ordered list of user email address that can overstep the embargo 
     */
    private List<String> priviledgedUsers;
    
    /**
    * Embargo constructor
    */
    public Embargo() {
    }

    /**
     * duration setter
     * @param duration the duration in days of the embargo 
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    /**
     * priviliedgedUsers setter
     * @param priviledgedUsers the list of users email allowed to overcome the embargo
     */
    public void setPriviledgedUsers(ArrayList<String> priviledgedUsers) {
        this.priviledgedUsers = priviledgedUsers;
    }
    
    
}
