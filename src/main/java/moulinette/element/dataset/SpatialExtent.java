/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.dataset;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import moulinette.element.Enum.EnumGeoJSONTypes;
import moulinette.element.geometry.GeometryGeoJSON;
import moulinette.element.geometry.MultiPolygon;
import moulinette.element.geometry.Polygon;
import moulinette.element.geometry.Properties;

/**
 * Class representing the spatial extent of a dataset. This spatial extent is either a 
 * bounding box or several bounding boxes
 * @author coussotc
 */
@XmlRootElement(name = "spatialExtent")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpatialExtent {
    /**
     * The geometry of the spatial extent. It can be either a Polygon Object 
     * or a MultiPolygon object
     * @see GeometryGeoJSON
     * @see Polygon
     * @see MultiPolygon
     */
    private final GeometryGeoJSON geometry;
    /**
     * a GeoJSON mandatoruy field
     */
    private final Properties properties = new Properties();
    /**
     * a GeoJSON mandatoruy field
     */
    private final String type = EnumGeoJSONTypes.FEATURE.toString();

    /**
     * Constructor of spatial extent for Bounding boxes
     * @param geometry A Polygon representing a bounding box
     * @see Polygon
     */
    public SpatialExtent(Polygon geometry) {
        this.geometry = geometry;
    }
    /**
     * Constructor of spatial extent for several Bounding boxes
     * @param geometry A MultiPolygon object each Polygon representing a bounding box
     * @see MultiPolygon
     * @see Polygon
     */
    public SpatialExtent(MultiPolygon geometry) {
        this.geometry = geometry;
    }

}
