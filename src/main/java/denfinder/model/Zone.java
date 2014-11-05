package denfinder.model;

import java.io.IOException;

import org.json.JSONException;

/**
 * Zone object
 * @author latch
 *
 */
public class Zone {
	
	//lat long pair
	private Coordinates location;

	//hoe good of a match is this zone?
	private int rating = -1;
	
	//has education and census data
	// private Education educationData;
	// private CensusApi censusData;
	
	
	/**
	 * Create new zone
	 * @param latitude lat of center point
	 * @param longitude long of center point
	 * @param rating how good a match this zone is to query
	 * @param itsEducationData this zone's education data
	 * @param itsCensusData this zone's census data
	 * @throws IOException 
	 * @throws JSONException 
	 */
	public Zone(Coordinates location) throws JSONException, IOException {
		super();
		this.location = location;
		
		String fips = FccApi.getFIPSCode(location);
		CensusApi census = new CensusApi(fips);
		
		census.getMedianIncome();
		census.getMedianAge();
		census.getNumMarried();
		census.getNumSingle();
		
		//TODO calculate rating
		
		//this.rating = rating;
	}

	/**
	 * Get location coordinates
	 * @return location
	 */
	public Coordinates getLocation() {
		return location;
	}


	/**
	 * Get how good a match this zone is to query
	 * @return match score, -1 if uninitialized
	 */
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
}
