/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.observation;

import java.util.List;
import moulinette.element.geometry.Point;

/**
 * Class representing a feature geolocalised on on point sampled by the observation.
 * It can be a meteorological station measuring temperature a one given location
 * @author coussotc
 */
public class SamplingPoint extends SamplingFeature {

    /**
     * The position of the station 
     */
    protected Point geometry;
    
    /**
     * SamplingPoint constructor
     * @param name the name of the feature
     * @param geometry the geometry of the feature
     * @see Point
     */
    public SamplingPoint(String name, Point geometry) {
        super.name = name;
        this.geometry = geometry;
    }
    
    /**
     * SamplingPoint constructor
     * @param geometry the geometry of the feature
     * @see Point
     */
    public SamplingPoint(Point geometry) {
        this.geometry = geometry;
    }

    public SamplingPoint(List<List<Double>> l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
