/**
 * Created on: 11/02/14
 * Author:     Isaac F. Fisher
 */
package denfinder.model;


public final class Common {
	
	//API keys
	static final String EDUCATION_KEY = "76b8929e74f004bf68c53ce9d350ad7f";
	
	// Map data
	static final int MAP_DIVISIONS = 5;
	
	
	// Algorithm input: "Income Range"
	static final int INCOME_TIER_1 = 0;
	static final int INCOME_TIER_2 = 25000;
	static final int INCOME_TIER_3 = 50000;
	static final int INCOME_TIER_4 = 75000;
	static final int INCOME_TIER_5 = 100000;
	
	static final int MATCHING_INCOME_POINTS = 10;
	
	
	// Algorithm input: "Relationship Status"
	static final double RELATIONSHIP_MATCHING_RATIO_LOW    = 1.5;
	static final double RELATIONSHIP_MATCHING_RATIO_MEDIUM = 2.0;
	static final double RELATIONSHIP_MATCHING_RATIO_HIGH   = 3.0;
	
	static final int RELATIONSHIP_MATCHING_POINTS_LOW    = 3;
	static final int RELATIONSHIP_MATCHING_POINTS_MEDIUM = 8;
	static final int RELATIONSHIP_MATCHING_POINTS_HIGH   = 15;
	
	
	// Algorithm input: "Age Range"
	static final int AGE_TIER_1 = 0;
	static final int AGE_TIER_2 = 13;
	static final int AGE_TIER_3 = 20;
	static final int AGE_TIER_4 = 30;
	static final int AGE_TIER_5 = 40;
	static final int AGE_TIER_6 = 50;
	static final int AGE_TIER_7 = 60;
	
	static final int MATCHING_AGE_POINTS = 15;
	
	
	// Algorithm input: "Importance of School System Quality"
	static final double MAXIMUM_SCHOOL_DISTANCE = 1.0;
	static final double TEST_SCORE_LOW = 3;
	static final double TEST_SCORE_MEDIUM = 5;
	static final double TEST_SCORE_HIGH = 8;
	
	static final int TEST_SCORE_LOW_POINTS = 1;
	static final int TEST_SCORE_MEDIUM_POINTS = 2;
	static final int TEST_SCORE_HIGH_POINTS = 3;
	
	static final double SCHOOl_QUALITY_MULTIPLIER_VERY_IMPORTANT     = 5.0;
	static final double SCHOOL_QUALITY_MULTIPLIER_SOMEWHAT_IMPORTANT = 2.0;
	static final double SCHOOL_QUALITY_MULTIPLIER_NOT_VERY_IMPORTANT = 0.8;
	static final double SCHOOL_QUALITY_MULTIPLIER_NO_PREFERENCE      = 0.0;
}
