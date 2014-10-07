package denfinder.model;

import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by landon on 10/6/14.
 */
public class GeocodingApi {
    public static Coordinates getCoordinates(String address) throws IOException {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" +
                address + "&sensor=false&key=AIzaSyDmW7DnNY5wR_5DI4QwmS2Zxmg0q3Ba08E";

        JSONObject json = ApiCall.loadJSON(url);

        System.out.println(json);


        //TODO
        return new Coordinates(1,1);
    }
}
