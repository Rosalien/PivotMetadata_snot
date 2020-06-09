/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.observation;

/**
 *
 * @author coussotc
 */
public class PhysicalSensor extends Sensor {

    /**
     * model of the sensor
     */
    private String model;
    /**
     * manufacturer of the sensor
     */
    private String manufacturer;
    /**
     * serial number of the sensor
     */
    private String serialNumber;
    /**
     * type of the sensor
     */
    private String sensorType;
    /**
     * calibration description of the sensor
     */
    private String calibration;

    /**
     * Senor constructor
     */
    public PhysicalSensor() {
    }

    /**
     * Sensor constructor with mandatory fields for
     * ObservationFabrique
     * @param vector
     */
    public PhysicalSensor(Object[] vector) {
        super((String) vector[0], (String) vector[1]);
        this.model = (String) vector[2];
        this.manufacturer = (String) vector[3];
        this.sensorType = (String) vector[4];
        this.calibration = (String) vector[5];
    }

    /**
     * SerialNumber setter
     *
     * @param serialNumber Sring representing the serial number of the sensor
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * sensorType setter
     *
     * @param sensorType String representing the sensor type
     */
    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    /**
     * calibration setter
     *
     * @param calibration String describing the calibration of the sensor
     */
    public void setCalibration(String calibration) {
        this.calibration = calibration;
    }

    /**
     * model setter
     *
     * @param model String describing the model of the senor
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * manufacturer setter
     *
     * @param manufacturer String describing the manufacturer of the sensor
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}
