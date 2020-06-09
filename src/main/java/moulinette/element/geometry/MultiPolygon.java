/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.geometry;

import moulinette.element.Enum.EnumGeoJSONTypes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coussotc
 */
public class MultiPolygon extends GeometryGeoJSON {
    private ArrayList<Polygon> coordinates;
    private final String type  = EnumGeoJSONTypes.MULTIPOLYGON.toString();

    public MultiPolygon() {
        this.coordinates = new ArrayList<>();
        
    }

    public MultiPolygon(List<Polygon> collect) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
