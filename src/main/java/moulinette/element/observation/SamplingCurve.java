/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.observation;

import moulinette.element.geometry.GeometryGeoJSON;
import moulinette.element.geometry.LineString;
import moulinette.element.geometry.MultiLineString;

/**
 * Class representing a feature geolocalised on a profil or transect sampled by the observation.
 * It can be a profil measuring a the flow of a glacier
 * @author coussotc
 */
public class SamplingCurve extends SamplingFeature {
    /**
     * The geometry of the profil or transect
     */
    private GeometryGeoJSON geometry;
    
    /**
     * SamplingCurve constructor
     * @param name the name of the feature
     * @param geometry the geometry of the feature
     * @see LineString
     * @see MultiLineString
     */
    public SamplingCurve(String name, GeometryGeoJSON geometry) {
        super.name = name;
        this.geometry = geometry;
    }
    
    /**
     * SamplingCurve constructor
     * @param geometry the geometry of the feature
     * @see LineString
     * @see MultiLineString
     */
    public SamplingCurve(GeometryGeoJSON geometry) {
        this.geometry = geometry;
    }   
}
