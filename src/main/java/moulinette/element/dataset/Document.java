/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.dataset;

import moulinette.element.Enum.EnumDocumentTypes;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class representing the documents associated to the dataset
 * @author coussotc
 */
@XmlRootElement(name = "document")
@XmlAccessorType(XmlAccessType.FIELD)
public class Document {
    /**
     * The type of the document accordiong to the EnumDocumentTypes
     * @see EnumDocumentTypes
     */
    public String type;
    /**
     * Ordered list of the document of  given type for the dataset
     * @see Document#type
     */
    public String url;
    /**
     * Document constructor with the mandatory field
     * @param type EnumDocumentTypes value 
     * @see EnumDocumentTypes
     * @param url url of the document ex:doi
     * @see Document#type
     */
    public Document(EnumDocumentTypes type, String url) {
        this.type = type.toString();
        this.url = url;
    }
}
