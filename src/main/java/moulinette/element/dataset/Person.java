/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.dataset;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import moulinette.element.Enum.EnumContactPersonRoles;

/**
 * Class representing a COntact of a dataset
 * @author coussotc
 */
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person extends Contact{
   
    /**
     * Person constructor with mandatory fields for MetadataFabrique
     */
    public Person(Object[] vector) {
        this.lastName = (String) vector[0];
        this.firstName = (String) vector[1];
        this.email = (String) vector[2];
        this.role = (String) vector[3];
    }
    
    /**
     * The first name of the Person
     */
    private final String firstName;
    /**
     * The last name of the Person
     */
    private final String lastName;
    /**
     * The email address of the Person
     */
    private final String email;
    /**
     * the role of the person within a dataset
     */
    private final String role;
    
    /**
     * The ORC ID of the Person
     */
    private String orcId;
    
    /**
     * the organisation where the Person belongs
     */
    private Organisation organisation;
    
    /**
     * Personconstructor with mandatory fields
     * @param firstName
     * @param lastName
     * @param email
     * @param role 
     */
    public Person(String firstName, String lastName, String email, EnumContactPersonRoles role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role.toString();
    }
    
    /**
     * Organisation where the Person belongs
     * @param organisation Organisation object
     */
    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    /**
     * Person setter
     * @param orcId orcId
     */
    public void setOrcId(String orcId) {
        this.orcId = orcId;
    }
    
    
    
}
