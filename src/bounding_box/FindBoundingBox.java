package bounding_box;

import utils.Coordinate;

/**
 * Created by Shmulik on 12/28/2015.
 * The class will be in charge of the algorithm for finding the rectangle which close all possible geo-locations which
 * can create routes from A to B in a distance D
 */
public class FindBoundingBox {
    public FindBoundingBox() {
        // For now I don't see a reason why this class should hold anything
        // I'll invoke static methods which will be executing the algorithm correctly
    }


    /**
     * @param start    The start point
     * @param end      The end point
     * @param distance The distance
     * @return Bounding box which bounds all possible routs from start point to end point
     */
    public static BoundingBox execute(Coordinate start, Coordinate end, double distance) {
        BoundingBox $ = null;

        double n1 = start.getLongitude();
        double t1 = start.getLatitude();
        double n2 = end.getLongitude();
        double t2 = end.getLatitude();

        double r = (n1 - n2) / (t1 - t2);
        double distanceStartEnd = Math.sqrt(Math.pow((n1 - n2), 2) + Math.pow((t1 - t2), 2));
        double k = Math.pow(((distance - distanceStartEnd) / 2), 2);
        double denomOfE = Math.pow(r, 2) + 1;
        double ne = -((Math.sqrt(k) * r * Math.sqrt((Math.pow(r, 2) + 1))) + (n1 * (-Math.pow(r, 2) - 1))) / denomOfE;
        double te = (((Math.pow(r, 2) + 1) * t1) - (Math.sqrt(k) * Math.sqrt((Math.pow(r, 2)) + 1))) / denomOfE;

        return $;
    }
}
