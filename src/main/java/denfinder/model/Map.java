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

	//create new list
	public Map(Coordinates topLeft, Coordinates bottomRight, int dimensions) throws JSONException, IOException {
		this.map = new ArrayList<ArrayList<Zone>>();
		
		double latDiff = (bottomRight.getLatitude() - topLeft.getLatitude()) / dimensions;
		double lonDiff = (bottomRight.getLongitude() - topLeft.getLongitude()) / dimensions;
		
		System.out.println(" " + latDiff + " " + lonDiff);
		
		for (int i = 0; i < dimensions; i++) {
			ArrayList<Zone> longitudes = new ArrayList<Zone>();
			for (int j = 0; j < dimensions; j++) {
				longitudes.add(new Zone(new Coordinates(topLeft.getLatitude() + latDiff * i,
														topLeft.getLongitude() + lonDiff * j)));
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
