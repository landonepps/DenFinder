package denfinder.model;

/**
 * Zone object
 * @author latch
 *
 */
public class Zone {
	
	//lat long pair
	private double latitude;
	private double longitude;

	//hoe good of a match is this zone?
	private int rating = -1;
	
	//has eduacation and census data
	private Education itsEducationData;
	private CensusApi itsCensusData;
	
	
	/**
	 * Create new zone
	 * @param latitude lat of center point
	 * @param longitude long of center point
	 * @param rating how good a match this zone is to query
	 * @param itsEducationData this zone's education data
	 * @param itsCensusData this zone's census data
	 */
	public Zone(double latitude, double longitude, int rating,
			Education itsEducationData, CensusApi itsCensusData) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.rating = rating;
		this.itsEducationData = itsEducationData;
		this.itsCensusData = itsCensusData;
	}

	/**
	 * Get lat of center point
	 * @return latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Set lat of center point
	 * @param latitude lat to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Get long of center point
	 * @return longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Set long of center point
	 * @param longitude long of center point
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	/**
	 * Get how good a match this zone is to query
	 * @return match score, -1 if uninitialized
	 */
	public int getRating() {
		return rating;
	}


	/**
	 * Set match score for this zone
	 * @param rating rating to assign
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * Get this zone's education data
	 * @return education data
	 */
	public Education getEducationData() {
		return itsEducationData;
	}

	/**
	 * Set education data
	 * @param educationData the data
	 */
	public void setEducationData(Education educationData) {
		this.itsEducationData = educationData;
	}

	/**
	 * Get this zone's census data
	 * @return census data
	 */
	public CensusApi getCensusData() {
		return itsCensusData;
	}

	/**
	 * Set this zone's census data
	 * @param censusData data to set
	 */
	public void setCensusData(CensusApi censusData) {
		this.itsCensusData = censusData;
	}
	
	
	
	
	
	
}
