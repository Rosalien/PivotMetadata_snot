/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.geometry;

import moulinette.element.Enum.EnumGeoJSONTypes;
import java.util.ArrayList;

/**
 *
 * @author coussotc
 */
public class MultiPoint extends GeometryGeoJSON {
    
    private ArrayList<ArrayList<double[]>> coordinates;
    private final String type  = EnumGeoJSONTypes.MULTIPOINT.toString();

    public MultiPoint(ArrayList<Position> positions) {
        this.coordinates = new ArrayList<>();
        ArrayList<double[]> tmp = new ArrayList<>();
        for (Position p : positions) {
            tmp.add(p.getPosition());
        }
        this.coordinates.add(tmp);
        
    }
    
    
}
