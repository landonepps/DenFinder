package denfinder.model;

import org.apache.commons.lang3.tuple.Pair;
import org.json.JSONObject;
import org.springframework.web.util.UriUtils;
import java.io.IOException;

/**
 * Created by landon on 10/6/14.
 */
public class GeocodingAPI extends ApiCall {
    public static Pair<Coordinates, Coordinates> getCoordinates(String address) throws IOException {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" +
                UriUtils.encodeFragment(address, "UTF-8") + "&sensor=false&key=" + Common.GEOCODING_KEY;

        //TODO for error checking, verify status=OK

        JSONObject json = loadJSON(url);
        JSONObject location = json.getJSONArray("results")
                .getJSONObject(0)
                .getJSONObject("geometry")
                .getJSONObject("viewport")
                .getJSONObject("southwest");

        double latitudeSW  = location.getDouble("lat");
        double longitudeSW = location.getDouble("lng");
        
        location = json.getJSONArray("results")
        		.getJSONObject(0)
        		.getJSONObject("geometry")
        		.getJSONObject("viewport")
        		.getJSONObject("northeast");
        
        double latitudeNE  = location.getDouble("lat");
        double longitudeNE = location.getDouble("lng");
        
        Coordinates viewportSW = new Coordinates(latitudeSW, longitudeSW);
        Coordinates viewportNE = new Coordinates(latitudeNE, longitudeNE);

        Pair<Coordinates, Coordinates> viewport = Pair.of(viewportSW, viewportNE);
        
        return viewport;
    }
    
    public static String getState(Coordinates coords) throws IOException {
    	String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" +
                UriUtils.encodeFragment(coords.getLatitude() + " " + coords.getLongitude(), "UTF-8") + "&sensor=false&key=" +  Common.GEOCODING_KEY;

        JSONObject json = loadJSON(url);
        JSONObject location = json.getJSONArray("results")
                .getJSONObject(0)
                .getJSONArray("address_components")
                .getJSONObject(4);

        return location.getString("short_name");
    }
    
    public static String getZipCode(Coordinates coords) throws IOException{
    	String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" +
                UriUtils.encodeFragment(coords.getLatitude() + " " + coords.getLongitude(), "UTF-8") + "&sensor=false&key=" + Common.GEOCODING_KEY;

        JSONObject json = loadJSON(url);
        JSONObject zipcode = json.getJSONArray("results").getJSONObject(0).getJSONArray("address_components").getJSONObject(6);
        return zipcode.getString("short_name");

    }
}
