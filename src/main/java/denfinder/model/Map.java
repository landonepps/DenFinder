package denfinder.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
	public Map(Coordinates bottomLeft, Coordinates topRight, String income, String relationship, String age, String school) throws JSONException, IOException {
		this.map = new ArrayList<ArrayList<Zone>>();
		
		double latDiff = (topRight.getLatitude() - bottomLeft.getLatitude()) / Common.MAP_DIVISIONS;
		double lonDiff = (topRight.getLongitude() - bottomLeft.getLongitude()) / Common.MAP_DIVISIONS;
		
		System.out.println(" " + latDiff + " " + lonDiff);
		
		String state = GeocodingApi.getState(bottomLeft);
		schoolList.populate("", "", state, "");
		
		for (int i = 0; i < Common.MAP_DIVISIONS; i++) {
			ArrayList<Zone> longitudes = new ArrayList<Zone>();
			for (int j = 0; j < Common.MAP_DIVISIONS; j++) {
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
	
	public List<ArrayList<Zone>> getRawMap() {
		return map;
	}

}
