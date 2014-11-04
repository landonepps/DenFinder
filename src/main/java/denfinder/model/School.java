/**
 * 
 */
package denfinder.model;

/**
 * @author PINTOR
 *
 */
public class School {
	
	private double testRating;
	private double latitude, longitude;
	private String ID;
	
	public School() {
		testRating = 0.0;
		latitude = longitude = 0.0;
		ID = "00000";
	}
	
	public School(String aID, double aTestRating,
				  double aLatitude, double aLongitude) {
		
		ID = aID;
		testRating = aTestRating;
		latitude = aLatitude;
		longitude = aLongitude;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	

	

	public double getTestRating() {
		return testRating;
	}

	public void setTestRating(double testRating) {
		this.testRating = testRating;
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
