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
 * Class representing keyword of the dataset
 * @author coussotc
 */
@XmlRootElement(name = "keyword")
@XmlAccessorType(XmlAccessType.FIELD)
public class Keyword {
    /**
     * The keyword
     */
    private String keyword;
    /**
     * URI of the keyword in a published thesaurus
     */
    private String uri;
    
    /**
     * Constructor
     * @param keyword the keyword name
     */
    public Keyword(String keyword) {
        this.keyword = keyword;
    }
    /**
     * Constructor
     * @param keyword the keyword name
     * @param uri URI of the keyword in a published thesaurus
     */
    public Keyword(String keyword, String uri) {
        this.keyword = keyword;
        this.uri = uri;
    }
    
    /**
     * set uri of an existing keyword
     * @param uri URI of the keyword in a published thesaurus
     */
    public void setUri(String uri) {
        this.uri = uri;
    }
}
