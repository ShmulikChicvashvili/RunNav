package bounding_box;

import utils.Coordinate;

/**
 * Created by Shmulik on 12/28/2015.
 * The class will hold a rectangle in a form of {minLat, minLon, maxLat, maxLon}
 */
public class BoundingBox {
    private Coordinate topLeft;
    private Coordinate bottomRight;

    public BoundingBox(Coordinate topLeft, Coordinate bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Coordinate getTopLeft() {
        return topLeft;
    }

    public Coordinate getBottomRight() {
        return bottomRight;
    }

    @Override
    public String toString() {
        return "BoundingBox{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                '}';
    }
}
