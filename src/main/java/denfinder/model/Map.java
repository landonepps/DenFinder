package denfinder.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

/**
 * List of all zone objects
 * @author latch
 *
 */
public class Map {
	//zones in this list
	private List<ArrayList<Zone>> map;
	
	private SchoolList schoolList = new SchoolList();

	//create new list
	public Map(Coordinates bottomLeft, Coordinates topRight, int dimensions) throws JSONException, IOException {
		this.map = new ArrayList<ArrayList<Zone>>();
		
		double latDiff = (topRight.getLatitude() - bottomLeft.getLatitude()) / dimensions;
		double lonDiff = (topRight.getLongitude() - bottomLeft.getLongitude()) / dimensions;
		
		System.out.println(" " + latDiff + " " + lonDiff);
		
		String state = GeocodingApi.getState(bottomLeft);
		schoolList.populate("", "", state, "");
		
		for (int i = 0; i < dimensions; i++) {
			ArrayList<Zone> longitudes = new ArrayList<Zone>();
			for (int j = 0; j < dimensions; j++) {
				longitudes.add(new Zone(new Coordinates(bottomLeft.getLatitude() + latDiff * i,
														bottomLeft.getLongitude() + lonDiff * j)));
			}
			map.add(longitudes);
		}
	}
	
	public int getDimensions() {
		return map.size();
	}
	
	public Zone getZone(int x, int y) {
		return map.get(x).get(y);
	}
	
}
