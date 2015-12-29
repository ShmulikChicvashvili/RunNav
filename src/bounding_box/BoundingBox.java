package bounding_box;

import utils.Coordinate;

/**
 * Created by Shmulik on 12/28/2015.
 * The class will hold a rectangle in a form of {minLat, minLon, maxLat, maxLon}
 */
public class BoundingBox {
    private Coordinate min;
    private Coordinate max;

    public BoundingBox(Coordinate min, Coordinate max) {
        this.min = min;
        this.max = max;
    }

    public Coordinate getMin() {
        return min;
    }

    public Coordinate getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "BoundingBox{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}
