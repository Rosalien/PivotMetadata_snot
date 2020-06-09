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
 * Class representing a licence on a dataset
 * @author coussotc
 */
@XmlRootElement(name = "licence")
@XmlAccessorType(XmlAccessType.FIELD)
public class Licence {
    /**
     * Name of the licence
     */
    private String title;
    /**
     * url of the description of the licence
     */
    private String url;
    /**
     * Constructor of a Licence object with the mandatory fields
     * @param title name of the licence
     * @see Licence#title
     * @param url url of the description of the licence
     * @see Licence#url
     */
    public Licence(String title, String url) {
        this.title = title;
        this.url = url;
    } 
}
