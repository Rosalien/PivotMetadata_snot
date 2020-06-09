package moulinette.element.geometry;

import java.util.LinkedList;
import java.util.List;
import moulinette.element.Enum.EnumGeoJSONTypes;

/**
 *
 * @author coussotc
 */
public class Point extends GeometryGeoJSON {

    private double[] coordinates;
    private final String type = EnumGeoJSONTypes.POINT.toString();

    public Point(double longitude, double latitude) {
        this.coordinates = new double[2];
        this.coordinates[0] = longitude;
        this.coordinates[1] = latitude;
    }

    public Point(double longitude, double latitude, double altitude) {
        this.coordinates = new double[3];
        this.coordinates[0] = longitude;
        this.coordinates[1] = latitude;
        this.coordinates[2] = altitude;
    }

    public Point(Position position) {
        this.coordinates = position.getPosition();
    }

    public Point(List<Double> l) {
        this.coordinates = new double[2];
        this.coordinates[0] = l.get(0);
        this.coordinates[1] = l.get(1);
    }

    @Override
    public String toString() {
        return "Point{" + "coordinates=[" + coordinates[0]+","+ coordinates[1] + "], type=" + type + '}';
    }
    
    
}
