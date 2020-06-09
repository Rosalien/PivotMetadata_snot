/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.geometry;

import moulinette.element.Enum.EnumGeoJSONTypes;
import java.util.ArrayList;

/**
 * Class representing the geometrical object LineString according to GeoJSON
 * specification
 *
 * @author coussotc
 */
public class LineString extends GeometryGeoJSON {

    /**
     * Ordered list of coordinates, the list must at least contain 2 double[2]
     * or 2 double[3] objects after being instanciated.
     * double[2] or double[3] are similar to Point coordinates and must follow the same specification
     * @see Point
     */
    private final ArrayList<double[]> coordinates;
    /**
     * GeoJSON mandatory fields
     *
     * @see EnumGeoJSONTypes
     */
    private final String type = EnumGeoJSONTypes.LINESTRING.toString();

    /**
     * LineString constructor
     * @param positions List of Position object, the list must contain at least two position
     * @see Position
     */
    public LineString(ArrayList<Position> positions) {
        this.coordinates = new ArrayList<>();
        for (Position p : positions) {
            this.coordinates.add(p.getPosition());
        }
    }
}
