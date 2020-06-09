/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.geometry;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Abstract class representing all type of geomtry possible for a GeoJSON object
 * @author coussotc
 */
@XmlRootElement(name = "geometryGeoGson")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class GeometryGeoJSON {
}
