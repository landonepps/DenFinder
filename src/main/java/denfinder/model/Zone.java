package denfinder.model;

import java.io.IOException;

import org.json.JSONException;

/**
 * Zone object
 * @author latch
 *
 */
public class Zone {
	
	// Lat long pair representing the center of the zone
	private Coordinates location;

	// How good of a match is this zone?
	private int rating = -1;
	
	// Census data
    private int medianIncome;
    private double medianAge;
    private int numSingle;
    private int numMarried;
	
	
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
		
		String fips = FccAPI.getFIPSCode(location);
		CensusAPI census = new CensusAPI(fips);
		
		setMedianIncome(census.getMedianIncome());
		setMedianAge(census.getMedianAge());
		setNumSingle(census.getNumSingle());
		setNumMarried(census.getNumMarried());
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

	public int getMedianIncome() {
		return medianIncome;
	}

	public void setMedianIncome(int medianIncome) {
		this.medianIncome = medianIncome;
	}

	public double getMedianAge() {
		return medianAge;
	}

	public void setMedianAge(double medianAge) {
		this.medianAge = medianAge;
	}

	public int getNumSingle() {
		return numSingle;
	}

	public void setNumSingle(int numSingle) {
		this.numSingle = numSingle;
	}

	public int getNumMarried() {
		return numMarried;
	}

	public void setNumMarried(int numMarried) {
		this.numMarried = numMarried;
	}
}
