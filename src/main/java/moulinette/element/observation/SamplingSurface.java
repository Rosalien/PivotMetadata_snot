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
 * Class representing a feature geolocalised on a Surface sampled by the observation.
 * It can be Land use map.
 * @author coussotc
 */
public class SamplingSurface extends SamplingFeature {
    /**
     * The polygon or polygons of the surface 
     */
    private GeometryGeoJSON geometry;
    
    /**
     * SamplingSurface constructor
     * @param name the name of the feature
     * @param geometry the geometry of the feature
     * @see Polygon
     * @see MultiPolygon
     */
    public SamplingSurface(String name, GeometryGeoJSON geometry) {
        super.name = name;
        this.geometry = geometry;
    }
    
    /**
     * SamplingSurface constructor
     * @param geometry the geometry of the feature
     * @see Polygon
     * @see MultiPolygon
     */
    public SamplingSurface(GeometryGeoJSON geometry) {
        this.geometry = geometry;
    }   
}
