package denfinder.model;

/**
 * Contains education data
 *
 */
public class Education {
	//rating of available education
	private int reviewRating;

	/**
	 * Create new education data
	 * @param reviewRating rating of this school system
	 */
	public Education(int reviewRating) {
		this.reviewRating = reviewRating;
	}

	/**
	 * Get the rating
	 * @return education system rating
	 */
	public int getReviewRating() {
		return reviewRating;
	}

	/**
	 * Set education rating
	 * @param reviewRating the rating
	 */
	public void setReviewRating(int reviewRating) {
		this.reviewRating = reviewRating;
	}
	
	
}
