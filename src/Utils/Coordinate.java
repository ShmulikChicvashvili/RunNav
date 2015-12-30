package Utils;

/**
 * Created by Shmulik on 12/28/2015.
 */
public class Coordinate {
    private double latitude;
    private double longitude;

    public Coordinate(double latitude, double longtitude) {
        this.latitude = latitude;
        this.longitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
