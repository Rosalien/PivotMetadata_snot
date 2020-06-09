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
 * Class representig a webservice for a dataset
 * @author coussotc
 */
@XmlRootElement(name = "webService")
@XmlAccessorType(XmlAccessType.FIELD)
public class Webservice {
    /**
     * Description of the service name
     */
    private String description;
    /**
     * url of the service
     */
    private String url;
    /**
     * construcor of webservice
     * @param description Accronym of the service name
     * @param url url of the service
     * @see Webservice#url
     */
    public Webservice(String description, String url) {
        this.description = description;
        this.url = url;
    }
}
