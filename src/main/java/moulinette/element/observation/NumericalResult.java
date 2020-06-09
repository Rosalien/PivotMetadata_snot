/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.observation;

import java.util.List;

/**
 * Class representing the numerical result of an observation. The result of an
 * observation is an estimate value of a property of the feature of interest
 *
 * @author coussotc
 */
public class NumericalResult extends Result {

    /**
     * character String of missing data value in the output file
     */
    private String missingValue;

    /**
     * List of QualityFlag object describing the quality flag of the observation
     */
    private List<QualityFlag> qualityFlags;

    /**
     * DataFile object representing the file containing the data of the
     * observation
     */
    private DataFile dataFile;

    /**
     * List of additional value that can be set for each time step. For exemple,
     * incertitude calculation, error, sensor parameter...
     */
    private List<AdditionalValue> additionalValues;  
    
    /**
     * Result constructor
     *
     * @param datafile DataFile object representiong the data files containing
     * the observation
     * @see DataFile
     */
    public NumericalResult(DataFile datafile) {
        this.dataFile = datafile;
    }

    /**
     * missingValue setter
     *
     * @param missingValue character string for the missing values of the
     * observation
     */
    public void setMissingValue(String missingValue) {
        this.missingValue = missingValue;
    }

    /**
     * qualityFlagDescription setter
     *
     * @param qualityFlags List of QualityFlag describing each quality flag that
     * can be applied on the observation
     * @see QualityFlag
     */
    public void setQualityFlags(List<QualityFlag> qualityFlags) {
        this.qualityFlags = qualityFlags;
    }

    /**
     * additionalValues setter
     *
     * @param additionalValues List of the AdditionalValue object describing the
     * additional values present in the result file of the observation
     */
    public void setAdditionalValues(List<AdditionalValue> additionalValues) {
        this.additionalValues = additionalValues;
    }
}
