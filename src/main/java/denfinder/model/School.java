/**
 * 
 */
package denfinder.model;

/**
 * @author PINTOR
 *
 */
public class School {
	
	private double reviewRating;
	private double testRating;
	private int rateCount;
	private double latitude, longitude;
	private String ID;
	
	public School() {
		
		reviewRating = 0.0;
		testRating = 0.0;
		rateCount = 0;
		latitude = longitude = 0.0;
		ID = "00000";
	}
	
	public School(String aID, double aReviewRating, double aTestRating,
				  int aRateCount, double aLatitude, double aLongitude) {
		
		ID = aID;
		reviewRating = aReviewRating;
		testRating = aTestRating;
		rateCount = aRateCount;
		latitude = aLatitude;
		longitude = aLongitude;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public double getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(double reviewRating) {
		this.reviewRating = reviewRating;
	}

	public double getTestRating() {
		return testRating;
	}

	public void setTestRating(double testRating) {
		this.testRating = testRating;
	}

	public int getRateCount() {
		return rateCount;
	}

	public void setRateCount(int rateCount) {
		this.rateCount = rateCount;
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
	
}
