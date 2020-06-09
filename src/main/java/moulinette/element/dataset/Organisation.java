/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.dataset;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import moulinette.element.Enum.EnumContactOrganisationRoles;

/**
 *
 * @author coussotc
 */
@XmlRootElement(name = "organisation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organisation extends Contact {
    private String name;
    private String acronym;
    private String role;

    public Organisation() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public void setRole(String role) {
        this.role = role.toString();
    }
    
    
}
