package denfinder.model;

public class Zone {
	private double latitude;
	private double longitude;
	private int rating = -1;
	private Education itsEducationData;
	private Census itsCensusData;
	
	
	public Zone(double latitude, double longitude, int rating,
			Education itsEducationData, Census itsCensusData) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.rating = rating;
		this.itsEducationData = itsEducationData;
		this.itsCensusData = itsCensusData;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public Education getEducationData() {
		return itsEducationData;
	}


	public void setEducationData(Education educationData) {
		this.itsEducationData = educationData;
	}


	public Census getCensusData() {
		return itsCensusData;
	}


	public void setCensusData(Census censusData) {
		this.itsCensusData = censusData;
	}
	
	
	
	
	
	
}
