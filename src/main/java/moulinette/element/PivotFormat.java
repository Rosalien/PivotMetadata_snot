/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element;

import moulinette.element.dataset.Dataset;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import moulinette.element.producer.Producer;

/**
 * The object to be parsed into a JSON file
 * @author coussotc
 */
@XmlRootElement(name = PivotFormat.PIVOT)
@XmlAccessorType(XmlAccessType.FIELD)
public class PivotFormat {
    public static final String PIVOT = "pivot";

    private String version;
    private Producer producer;
    private List<Dataset> datasets;

    public PivotFormat() {
    }

    public PivotFormat(Producer producer, List<Dataset> datasets) {
        this.version = "1.0";
        this.producer = producer;
        this.datasets = datasets;
    }

    public Producer getProducter() {
        return producer;
    }
    
}
