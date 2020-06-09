/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.observation;

/**
 * The feature of interest is an abstraction of a real-world object. It's the spatial object
 * from which one characteristic is sampled by the observation
 * @author coussotc
 */
public class FeatureOfInterest {
    /**
     * Spatial representation of the feature of interest
     */
    private SamplingFeature samplingFeature;
    /**
     * FeatureOfInterest constructor
     * @param samplingFeature Spatial representation of the feature of interest
     */
    public FeatureOfInterest(SamplingFeature samplingFeature) {
        this.samplingFeature = samplingFeature;
    }
    /**
     * samplinfFeature getter
     * @return SamplingFeature
     * @see SamplingFeature
     */
    public SamplingFeature getSamplingFeature() {
        return samplingFeature;
    }

    @Override
    public String toString() {
        return "FeatureOfInterest{" + "samplingFeature=" + samplingFeature + '}';
    }
}
