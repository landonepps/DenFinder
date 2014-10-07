package denfinder.model;

import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by landon on 10/6/14.
 */
public class FccApi {
    public static String getFIPSCode(double lat, double lon) throws IOException {
        String url = "http://data.fcc.gov/api/block/find?latitude=" +
                lat + "&longitude=" + lon +" &showall=false&format=json";

        JSONObject json = ApiCall.loadJSON(url);

        System.out.println(json);
        //TODO
        return new String();
    }
}
