/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moulinette.element.geometry;

import moulinette.element.Enum.EnumGeoJSONTypes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class representing Polygon geometry according to GeoJSON Specification
 *
 * @author coussotc
 */
public class Polygon extends GeometryGeoJSON {

    /**
     * Ordered list of ordered list of double[2] or double[3] that represent
     * coordinates of Polygon according to GeoJSON specification The ordered
     * list must contain only 1 ArrayList<double[]> object. The
     * ArrayList<double[]> object must contain at least 4 double[]. The first
     * and the last index of the ArrayList<double[]> must be the same object
     */
    private List<List<double[]>> coordinates = new ArrayList<>();
    
    /**
     * GeoJSON mandatory field
     */
    private final String type = EnumGeoJSONTypes.POLYGON.toString();

//    public Polygon(String arrayCoordonates) {
//        Pattern pattern = Pattern.compile("(?<=\\[)([0-9\\.,]*)(?=\\])");
//        final ArrayList<double[]> siteCoordonates = new ArrayList<double[]>();
//        coordinates.add(siteCoordonates);
//        Matcher matcher = pattern.matcher(arrayCoordonates);
//
//        while (matcher.find()) {
//            String group = matcher.group();
//            double[] coordonate = new double[2];
//            String[] doubles = group.split(",");
//            coordonate[0] = Double.valueOf(doubles[0]);
//            coordonate[1] = Double.valueOf(doubles[1]);
//            siteCoordonates.add(coordonate);
//        }
//    }
    
    public Polygon(List<List<Double>> arrayCoordonates) {
        List<double[]> list = new LinkedList();
        coordinates.add(list);
        for (List<Double> arrayCoordonate : arrayCoordonates) {
            double[] array = new double[2];
            for (int i = 0; i < arrayCoordonate.size(); i++) {
//                System.out.println(arrayCoordonate.get(i));
                array[i] = arrayCoordonate.get(i);
            }
            list.add(array);
        }
    }
    

    /**
     * Constructor for BBOX polygon
     *
     * @param topLeft top left position of the box
     * @param topRight top right position of the box
     * @param bottomRight bottom right position of the box
     * @param bottomLeft bottom left position of the box
     */
    public Polygon(Position topLeft, Position bottomLeft, Position bottomRight, Position topRight) {
        this.coordinates = new ArrayList<>();
        ArrayList<double[]> tmp = new ArrayList<>();
        tmp.add(topLeft.getPosition());
        tmp.add(bottomLeft.getPosition());
        tmp.add(bottomRight.getPosition());
        tmp.add(topRight.getPosition());
        tmp.add(topLeft.getPosition());
        //ArrayList<ArrayList<double[]>> tmp2 = new ArrayList<>();
        //tmp2.add(tmp);
        this.coordinates.add(tmp);
    }

    /**
     * Constructor of Polygon object
     *
     * @param positions ordered list of Position. The first and the last index
     * of the list must be equal
     */
    public Polygon(ArrayList<Position> positions) {
        this.coordinates = new ArrayList<>();
        ArrayList<double[]> tmp = new ArrayList<>();
        for (Position p : positions) {
            tmp.add(p.getPosition());
        }
        this.coordinates.add(tmp);
    }
}
