/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.producer;

import moulinette.element.dataset.OnlineResource;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import moulinette.element.dataset.Contact;

/**
 * Class representing a provider of datasets and all the metadata associated to this provider
 * @author coussotc
 */
@XmlRootElement(name = "producer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Producer {
    /**
     * ID of the Producer as defined by Theia/OZCAR comity
     */
    private String producerId;
    /**
     * Acronym of the Producer. ex AMMA-CATCH
     */
    private String name;
    
    /**
     * Title of the Producer
     */
    private String title;
    /**
     * Short description of the Producer
     */
    private String description;
    
    /**
     * Mail adresse for the Producer
     */
    private String email;
    
    /**
     * List of funders for the Producer
     */
    private List<Funding> fundings;
    /**
     * List of Contact - project leader and Data manager
     */
    private List<Contact> contacts;
    
    
    /**
     * Online resources of the producer
     */
    private OnlineResource onlineResource;

    /**
     * Producer constructor with all the mandatory fields
     * @param id id of the producer as defined by Theia/OZCAR comity
     * @param name name of the Producer
     * @param contacts
     * @see Producer#name
     * @param description Descritpion of the Producer
     * @see Producer#description
     * @param fundings Ordered list of the funders for the Producer
     * @see Producer#fundings
     */
    public Producer(String id, String name, String description,ArrayList<Funding> fundings, List<Contact> contacts) {
        this.producerId = id;
        this.name = name;
        this.description = description;
        this.fundings = fundings;
        this.contacts = contacts;
    }

    /**
     * emial setter
     * @param email String -  email of the Producer 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Get the name of the Producer
     * @return the name of the Producer
     * @see Producer#name
     */
    public String getName() {
        return name;
    }
    
    
    /**
     * Get the fundings of the producer
     * @return 
     */
    public List<Funding> getFundings() {
        return fundings;
    }
    
    /**
     * Producer setter
     * @param title the title of the producer
     */
    public void setTitle(String title) {
        this.title = title;
    }    

    /**
     * Producer setter
     * @param onlineResource the online resources of the producer
     */
    public void setOnlineResource(OnlineResource onlineResource) {
        this.onlineResource = onlineResource;
    }
  
}
