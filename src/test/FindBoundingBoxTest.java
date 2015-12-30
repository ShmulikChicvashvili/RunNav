package test;

import bounding_box.BoundingBox;
import bounding_box.FindBoundingBox;
import utils.Coordinate;

/**
 * Created by Shmulik on 12/29/2015.
 */
public class FindBoundingBoxTest {
    public static void main(String[] args) {
        Coordinate start = new Coordinate(4, 3);
        Coordinate end = new Coordinate(9, 6);
        BoundingBox bbox = FindBoundingBox.execute(start, end, 1);

        System.out.println(bbox);
    }
}
