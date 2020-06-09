/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.observation;

import moulinette.element.geometry.GeometryGeoJSON;
import moulinette.element.geometry.MultiPolygon;
import moulinette.element.geometry.Polygon;

/**
 * Class representing a feature a geolocalised volume sampled by the observation.
 * @author coussotc
 */
public class SamplingSolid extends SamplingFeature {
    /**
     * The polygon or polygons of the volume
     */
    private GeometryGeoJSON geometry;
    
    /**
     * SamplingSolid constructor
     * @param name the name of the feature
     * @param geometry the geometry of the feature
     * @see Polygon
     * @see MultiPolygon
     */
    public SamplingSolid(String name, GeometryGeoJSON geometry) {
        super.name = name;
        this.geometry = geometry;
    }
    
    /**
     * SamplingSolid constructor
     * @param geometry the geometry of the feature
     * @see Polygon
     * @see MultiPolygon
     */
    public SamplingSolid(GeometryGeoJSON geometry) {
        this.geometry = geometry;
    }   
}
