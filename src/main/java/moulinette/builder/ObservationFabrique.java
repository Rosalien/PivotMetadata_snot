/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.builder;

import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import moulinette.element.Enum.EnumProcessingLevels;
import moulinette.element.Enum.EnumResultDataTypes;
import moulinette.element.geometry.Point;
import moulinette.element.observation.AdditionalValue;
import moulinette.element.observation.DataFile;
import moulinette.element.observation.DataProduction;
import moulinette.element.observation.FeatureOfInterest;
import moulinette.element.observation.LineageInformation;
import moulinette.element.observation.NumericalResult;
import moulinette.element.observation.Observation;
import moulinette.element.observation.ObservedProperty;
import moulinette.element.observation.PhysicalSensor;
import moulinette.element.observation.Procedure;
import moulinette.element.observation.SamplingPoint;
import moulinette.element.observation.Sensor;
import moulinette.element.observation.TemporalExtent;
import moulinette.jpa.JPAQueryDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to import Observation of a dataset from a relational database
 *
 * @see Observation
 * @author coussotc
 */
public class ObservationFabrique {

    @Inject
    protected JPAQueryDAO requeteDAO;

    private final Logger logger = LoggerFactory.getLogger(ObservationFabrique.class);

    /**
     * Instanciate a Observation Object using information from a relational
     * database and external CSV files
     *
     * @see Connection
     * @param codeJeu id of the dataset
     * @param pathToCSVSourceFiles path to the folder of the external CSV
     * sources files
     * @return Observation object
     * @throws IOException
     */
    public Observation buildObservation(String codeJeu, String realNodePath, String pathToCSVSourceFiles) throws IOException {
        Observation observation = new Observation();

        String observationId = realNodePath.replaceAll("^(.*)\\/(.*),(.*),(.*),(.*)\\/(.*)-(.*)_(.*)-(.*)-(.*)$", "$1" + "-" + "$2" + "-" + "$3" + "-" + "$4" + "-" + "$9");
//        System.out.println("realPath" + realNodePath);

//        System.out.println("Début observation");
        /**
         * Set the ObservationId
         */
        observation.setObservationId("TOUR_OBS_" + observationId);

        /**
         * Set the featureOfInterest
         */
        spatialExtent(realNodePath, observation);

        /**
         * Set the Observation property
         */
        observationVariableUniteTheia(realNodePath, observation);//ici

        /**
         * Set the datatype
         */
        observation.setDataType(EnumResultDataTypes.NUMERIC);

        /**
         * Set the procedure
         */
        procedure(realNodePath, codeJeu, observation);

//        sensor(realNodePath, observation);
        /**
         * Set the result
         */
        numericalResult(realNodePath, observation);

        /**
         * Set the TimeSerie
         */
        observation.setTimeSerie(true);

        /**
         * Set the temporalExtent
         */
        temporalExtent(codeJeu, observation);

        /**
         * Set the processingLevel 
         */
        observation.setProcessingLevel(EnumProcessingLevels.QUALITY_CONTROLLED);

//        System.out.println("Fin observation");
        return observation;
    }

    private void spatialExtent(String realNodePath, Observation observation) throws JsonSyntaxException {
        /**
         * Set the featureOfInterest
         */

        String sitePath = realNodePath.replaceAll("^(.*),(.*),(.*),(.*)$", "$1");
//        System.out.println("sitePath :" + sitePath);

        Object[] stationsNameAndCoord = requeteDAO.getStationsName(sitePath).get(0);
        String stationName = (String) stationsNameAndCoord[0];
        String coord = (String) stationsNameAndCoord[1];

        Double longitude = Double.parseDouble(coord.replaceAll("^\\[(.*),(.*)\\]", "$1"));
        Double latitude = Double.parseDouble(coord.replaceAll("^\\[(.*),(.*)\\]", "$2"));

//        System.out.println("stationName :" + stationName);
//        System.out.println("longitude :" + longitude);
//        System.out.println("latitude :" + latitude);
        final FeatureOfInterest featureOfInterest = new FeatureOfInterest(new SamplingPoint(stationName, new Point(longitude, latitude)));

        observation.setFeatureOfInterest(featureOfInterest);
    }

//    private void observationVariableUnite(String realNodePath, Observation observation) {
//        requeteDAO.getVariablesUnite(realNodePath)
//                .stream()
//                .map(ObservedProperty::new)
//                .findFirst()
//                .ifPresent(observation::setObservedProperty);
//    }
    private void observationVariableUniteTheia(String realNodePath, Observation observation) {
        Object[] requete = requeteDAO.getVariablesUnite(realNodePath).get(0);
        String variable = (String) requete[0];
        String description = (String) requete[1];
        String unite = (String) requete[2];
        List<String> theiacategories = requeteDAO.getTheia(realNodePath);

        ObservedProperty observedProperty = new ObservedProperty(variable, description, unite);
        observedProperty.setTheiaCategories(theiacategories);
        observation.setObservedProperty(observedProperty);
    }

    private void procedure(String realNodePath, String codeJeu, Observation observation) {
        Procedure procedure = new Procedure();
        DataProduction testSetDataProduction = buildDataProduction(realNodePath, codeJeu);
//        System.out.println("TEST = " + (testSetDataProduction != null));
        if (testSetDataProduction != null) {
            procedure.setDataProduction(testSetDataProduction);
        }
        
        List<LineageInformation> testLineageInformation = buildLineageInformation(realNodePath);
        if (!testLineageInformation.isEmpty()) {
            procedure.setLineageInformations(testLineageInformation);
        }
       
        observation.setProcedure(procedure);
    }

    private List<LineageInformation> buildLineageInformation(String realNodePath) {
        List<LineageInformation> lineageinformations = new ArrayList();
        requeteDAO.getLineageInformation(realNodePath)
                .stream()
                .map(LineageInformation::new)
                .forEach(lineageinformations::add);

        return lineageinformations;
    }

    private DataProduction buildDataProduction(String realNodePath, String codeJeu) {
        DataProduction dataProduction = new DataProduction();
        List<Sensor> testGetSensors = getSensors(realNodePath, codeJeu);
        
//        System.out.println("buildDataProduction = " + !testGetSensors.isEmpty());
        
        if (!testGetSensors.isEmpty()) {
            dataProduction.setSensors(testGetSensors);
            return dataProduction;
        }else{
        return null;
        }
    }

//    private void sensor(String realNodePath, Observation observation) {
//        Sensor sensor = new Sensor() {
//        };
//        sensor.setActivityPeriods(getActivityPeriod(realNodePath));
//                            
//
//    }
//    private Sensor buildSensor(String realNodePath) {
//        Sensor sensor = new Sensor() {};
//        sensor.setActivityPeriods(getActivityPeriod(realNodePath));
//        return sensor;
//    }
    private List<Sensor> getSensors(String realNodePath, String codeJeu) {

        List<Sensor> sensors = new ArrayList<>();
//        sensor.getActivityPeriods().add(new TemporalExtent(validPeriod[0], validPeriod[1]));
//                                            sensors.add(sensor);

//        Object[] requetesVirtuel = requeteDAO.getVirtualSensor(realNodePath).get(0);
//        String name = (String) requetesVirtuel[0];
//        String parametrisationDescription = (String) requetesVirtuel[1];        
//        VirtualSensor sensorVirtuel = new VirtualSensor(name, parametrisationDescription);
//        sensorVirtuel.setName(name);
//        sensorVirtuel.setParametrisationDescription(parametrisationDescription);
//        sensors.add(sensorVirtuel);
        requeteDAO.getPhysicalSensor(realNodePath, codeJeu)
                .stream()
                .map(PhysicalSensor::new)
                .forEach(sensors::add);
        //Attention, problème avec VirtualSensor. Trouver un moyen de détacher activityPeriods, sinon, metadonnées invalide        

//        requeteDAO.getVirtualSensor(realNodePath)
//                .stream()
//                .map(VirtualSensor::new)
//                .forEach(sensors::add);
        return sensors;

    }

//    private Sensor buildSensorActivity(String realNodePath) {
//        Sensor sensorActivity = new Sensor() {
//        };
//        sensorActivity.setActivityPeriods(getActivityPeriod(realNodePath));
//        return sensorActivity;
//    }
//
//    private List<TemporalExtent> getActivityPeriod(String realNodePath) {
//        List<TemporalExtent> activityperiod = new ArrayList<>();
//        requeteDAO.getPhysicalSensor(realNodePath)
//                .stream()
//                .map(TemporalExtent::new)
//                .forEach(activityperiod::add);
//        return activityperiod;
//    }
    private String getMethode(String realNodePath) {
        return "-9999";
    }

    private void numericalResult(String realNodePath, Observation observation) {
        String observationId = realNodePath.replaceAll("^(.*)\\/(.*),(.*),(.*),(.*)\\/(.*)-(.*)_(.*)-(.*)-(.*)$", "$1" + "-" + "$2" + "-" + "$3" + "-" + "$4" + "-" + "$9");

        final DataFile dataFile = new DataFile("TOUR_OBS_" + observationId + ".txt");
        final NumericalResult numericalResult = new NumericalResult(dataFile);

        List<String> missingvalue = requeteDAO.getMissingvalue(realNodePath);
        numericalResult.setMissingValue(missingvalue.get(0));

//        numericalResult.setQualityFlags((List<QualityFlag>) qualityFlag);
//        numericalResult.setAdditionalValues(getAdditionalValue(realNodePath));
        observation.setResult(numericalResult);
    }

    private List<AdditionalValue> getAdditionalValue(String realNodePath) {
        List<AdditionalValue> additionalValues = new ArrayList<>();
        return additionalValues;
    }

    private void temporalExtent(String codeJeu, Observation observation) {
//        System.out.println("-----------------temporalExtent-----------------");

        List<TemporalExtent> temporalExtent = new ArrayList<>();
//        Object[] requete = requeteDAO.getTemporalExtentValue(codeJeu).get(0);
//
//        String urlDownload = (String) requete[4];
//
//        String dateDebut = (String) requete[0];
//        String dateFin = (String) requete[1];
//
//        System.out.println(dateDebut);
//        System.out.println(dateFin);
//        
//        TemporalExtent temporalExtent = new TemporalExtent(dateDebut, dateFin);
//        temporalExtent.setDateBeg(dateDebut);
//        temporalExtent.setDateBeg(dateFin);
//        
//        observation.setTemporalExtent(temporalExtent);
        requeteDAO.getTemporalExtentValue(codeJeu)
                .stream()
                .map(TemporalExtent::new)
                .findFirst()
                .ifPresent(observation::setTemporalExtent);

    }
}
