package test;

import bounding_box.BoundingBox;
import bounding_box.FindBoundingBox;
import utils.Coordinate;

/**
 * Created by Shmulik on 12/29/2015.
 */
public class FindBoundingBoxTest {
    public static void main(String[] args) {
        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(2, 2);
        BoundingBox bbox = FindBoundingBox.execute(start, end, 5);

        System.out.println(bbox);
    }
}
