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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author coussotc
 */
@XmlRootElement(name = "onLineResource")
@XmlAccessorType(XmlAccessType.FIELD)
public class OnlineResource {
    @XmlElement(nillable=true)
    private String urlDownload;
    @XmlElement(nillable=true)
    private String urlInfo;
    @XmlElement(nillable=true)
    private String doi;
    //private List<Webservice> webservices = new ArrayList<>();

    public OnlineResource() {
    }    

    public OnlineResource(String urlDownload, String urlInfo, String doi) {
        this.urlDownload = urlDownload;
        this.urlInfo = urlInfo;
        this.doi = doi;
    }

    public void setUrlDownload(String urlDownload) {
        this.urlDownload = urlDownload;
    }

    public void setUrlInfo(String urlInfo) {
        this.urlInfo = urlInfo;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

//    public void setWebservices(List<Webservice> webservices) {
//        this.webservices = webservices;
//    }
}
