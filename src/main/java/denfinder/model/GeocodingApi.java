package denfinder.model;

import org.json.JSONObject;
import org.springframework.web.util.UriUtils;

import java.io.IOException;

/**
 * Created by landon on 10/6/14.
 */
public class GeocodingApi extends ApiCall {
    public static Coordinates getCoordinates(String address) throws IOException {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" +
                UriUtils.encodeFragment(address, "UTF-8") + "&sensor=false&key=AIzaSyDmW7DnNY5wR_5DI4QwmS2Zxmg0q3Ba08E";


        //TODO for error checking, verify status=OK

        JSONObject json = loadJSON(url);
        JSONObject location = json.getJSONArray("results")
                .getJSONObject(0)
                .getJSONObject("geometry")
                .getJSONObject("location");

        double latitude = location.getDouble("lat");
        double longitude = location.getDouble("lng");

        return new Coordinates(latitude, longitude);
    }
}
