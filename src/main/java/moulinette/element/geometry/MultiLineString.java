/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.geometry;

import moulinette.element.Enum.EnumGeoJSONTypes;
import java.util.ArrayList;

/**
 * Class representing MultiLineString geometrical object according to GeoJSON Specification
 * @author coussotc
 */
public class MultiLineString extends GeometryGeoJSON {
    /**
     * Ordered list of ordered list of double[2] or double[3] that represent coordinates of 
     * MultiLineString according to GeoJSON specification
     * ArrayList<double[]> is similar to LineString coordinates and must follow the same specifications
     * @see LineString
     * 
     */
    private ArrayList<ArrayList<double[]>> coordinates;
    /**
     * GeoJSON mandatory field
     */
    private final String type  = EnumGeoJSONTypes.MULTILINESTRING.toString();
    /**
     * Constructor of MulitLineString object
     * @param multiLineString ordered list ordered list of positions
     * This is similar to an ordered List of LineString objects
     * @see Position
     * @see LineString
     */
    public MultiLineString(ArrayList<ArrayList<Position>> multiLineString) {
        this.coordinates = new ArrayList<>();
       for (ArrayList<Position> p1 : multiLineString) {
            ArrayList<double[]> tmp = new ArrayList<>();
            for (Position p2 : p1) {
                tmp.add(p2.getPosition());
            }
            this.coordinates.add(tmp);
        }
    }
}
