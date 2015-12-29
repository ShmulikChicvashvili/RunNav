package bounding_box;

import utils.Coordinate;
import org.jetbrains.annotations.Contract;

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
    @Contract(pure = true)
    public static BoundingBox execute(Coordinate start, Coordinate end, double distance) {
        BoundingBox $ = null;

        double n1 = start.getLongitude();
        double t1 = start.getLatitude();
        double n2 = end.getLongitude();
        double t2 = end.getLatitude();

        double r = (n1 - n2) / (t1 - t2);
        double distanceN1ToN2 = Math.sqrt(Math.pow((n1 - n2), 2) + Math.pow((t1 - t2), 2));
        double k = Math.pow(((distance - distanceN1ToN2) / 2), 2);
        double denomForE = (1 + Math.pow(r, 2));
        double ne = ((Math.sqrt(k) * r * Math.sqrt(Math.pow(r, 2) + 1)) + n1 + n1 * Math.pow(r, 2)) / denomForE;
        double te = ((t1 * (1 + (Math.pow(r, 2)))) + (Math.sqrt(k) * Math.sqrt(Math.pow(r, 2) + 1))) / denomForE;

        double nj = (n1 + n2) / 2;
        double tj = (t1 + t2) / 2;
        double d2 = Math.pow((distance / 2), 2);
        double denomForG = Math.pow(t1, 2) - 2 * t1 * tj + Math.pow(tj, 2) + Math.pow(n1, 2) - 2 * nj * n1 + Math.pow(nj, 2);
        double tempVarForNg = (n1 - nj) * Math.sqrt((d2 * t1 * t1) - (2 * d2 * tj * t1) + (d2 * tj * tj) +
                (d2 * n1 * n1) - (2 * d2 * nj * n1) + (d2 * nj * nj));
        double ng = (Math.pow(nj, 3) - (2 * nj * nj * n1) + (nj * n1 * n1) + (nj * tj * tj) -
                (2 * nj * tj * t1) + (nj * t1 * t1) + tempVarForNg) / denomForG;
        double tempVarForTg = (Math.sqrt(d2) * (t1 - tj)) * ((t1 * t1) - (2 * tj * t1) + (tj * tj) +
                (n1 * n1) - (2 * n1 * nj) + (nj * nj));
        double tg = ((tj * ((n1 * n1) - (2 * nj * n1) + (nj * nj))) +
                Math.pow(tj, 3) - (2 * tj * tj * t1) + (tj * t1 * t1) + tempVarForTg) / denomForG;

        double nh = ng - nj + ne;
        double th = tg - tj + te;

        double nc = nj - ng + nj;
        double tc = tj - tg + tj;

        double ni = nc + ng - nh;
        double ti = tc + tg - th;

        $ = new BoundingBox(new Coordinate(nh, th), new Coordinate(ni, ti));

        return $;
    }
}
