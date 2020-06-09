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
@XmlRootElement(name = "qualityflag")
@XmlAccessorType(XmlAccessType.FIELD)
public class QualityFlag {
    
    private String code, description;

    public QualityFlag(String flag, String description) {
        this.code = flag;
        this.description = description;
    }

    public String getCode() {
        return code;
    }
}
