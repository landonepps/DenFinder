package denfinder.model;

/**
 * Created by landon on 10/6/14.
 */
public class Coordinates {
    double latitude;
    double longitude;

    public Coordinates(double lat, double lon) {
        latitude = lat;
        longitude = lon;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

}
