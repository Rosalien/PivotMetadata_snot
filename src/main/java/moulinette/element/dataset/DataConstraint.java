/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.dataset;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  Class representing the data constraints for a given dataset
 * @author coussotc
 */
@XmlRootElement(name = "dataConstraint")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataConstraint {
    /**
     * String mentionning the use constraint of a given dataset
     */
    private String accessUseConstraint;
    /**
     * data policy of a given dataset 
     */
    private String urlDataPolicy;
    /**
     * Licence of a given dataset 
     * @see Licence
     */
    private Licence licence;
    /**
     * embargo on the data of a given dataset
     * @see Embargo
     */
    private Embargo embargo;

    public String getAccessUseConstraint() {
        return accessUseConstraint;
    }

    public void setAccessUseConstraint(String accessUseConstraint) {
        this.accessUseConstraint = accessUseConstraint;
    }

    public DataConstraint(String accessUseConstraint, String urlDataPolicy, Licence licence) {
        this.accessUseConstraint = accessUseConstraint;
        this.urlDataPolicy = urlDataPolicy;
        this.licence = licence;
    }
    
    /**
     * DataConstraints constructor with mandatory fields
     * @param accessUseConstraint 
     */
    public DataConstraint(String accessUseConstraint) {
        this.accessUseConstraint = accessUseConstraint;
    }
    /**
     * set DataConstraint dataPoolicy
     * @param urlDataPolicy 
     * @see DataConstraint#urlDataPolicy
     */
    public void setUrlDataPolicy(String urlDataPolicy) {
        this.urlDataPolicy = urlDataPolicy;
    }
    /**
     * Set DataConstraint licence field
     * @param licence 
     * @see DataConstraint#licence
     */
    public void setLicence(Licence licence) {
        this.licence = licence;
    }
    /**
     * Set DataConstraint embargo field
     * @param embargo 
     * @see DataConstraint#embargo
     */
    public void setEmbargo(Embargo embargo) {
        this.embargo = embargo;
    }
}
