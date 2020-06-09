/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.geometry;

/**
 *  Class representing position in order to make easier the construction of Geometrical object 
 * @author coussotc
 */
public class Position {
    /**
     * double[2] or double[3] reprensenting longitude, latitude or longitude, latitude, altitude
     */
    private double[] position;
    /**
     * Constructor of a Position object without altitude
     * @param longitude double value of longitude in WGS84
     * @param latitude double value of latitude in WGS84
     */
    public Position(double longitude, double latitude) {
        position = new double[2];
        position[0] = longitude;
        position[1] = latitude;
    }
    /**
     * Constructor of a Position object with altitude
     * @param longitude double value of longitude in WGS84
     * @param latitude double value of latitude in WGS84
     * @param altitude double value of altitude in WGS84
     */
    public Position(double longitude, double latitude, double altitude){
        position = new double[3];
        position[0] = longitude;
        position[1] = latitude;
        position[2] = altitude; 
    }
    /**
     * Get a position
     * @return  double[longitude, latitude] or double[longitude, latitude, altitude]
     */
    public double[] getPosition() {
        return position;
    }
    
}
