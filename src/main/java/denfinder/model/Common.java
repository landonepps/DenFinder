/**
 * Created on: 11/02/14
 * Author:     Isaac F. Fisher
 */
package denfinder.model;


public final class Common {
	
	//API keys
	static final String EDUCATION_KEY = "76b8929e74f004bf68c53ce9d350ad7f";
	
	static final int MAP_DIVISIONS = 5;
	
	// Input: "Income Range"
	static final int INCOME_TIER_1 = 0;
	static final int INCOME_TIER_2 = 25000;
	static final int INCOME_TIER_3 = 50000;
	static final int INCOME_TIER_4 = 75000;
	static final int INCOME_TIER_5 = 100000;
	
	static final int MATCHING_INCOME_POINTS = 10;
	
	
	
	
	/*
	
	static final double INCOME_MATCHING_PERCENTAGE_HIGH   = 60.0;
	static final double INCOME_MATCHING_PERCENTAGE_MEDIUM = 40.0;
	static final double INCOME_MATCHING_PERCENTAGE_LOW    = 20.0;
	
	static final double INCOME_MATCHING_MULTIPLIER_HIGH   = 5.0;
	static final double INCOME_MATCHING_MULTIPLIER_MEDIUM = 2.5;
	static final double INCOME_MATCHING_MULTIPLIER_LOW    = 0.75;
	static final double INCOME_MATCHING_MULTIPLIER_LOWEST = 0.25;
	static final double INCOME_MATCHING_MULTIPLIER_NO_PREFERENCE = 0.0;
	*/
	
	// Input: "Relationship Status"
	
	static final double RELATIONSHIP_MATCHING_RATIO = 1.3;
	static final int MATCHING_RELATIONSHIP_POINTS   = 7;
	
	
	/*
	static final double RELATIONSHIP_MATCHIMG_PERCENTAGE_HIGH   = 75.0;
	static final double RELATIONSHIP_MATCHING_PERCENTAGE_MEDIUM = 50.0;
	static final double RELATIONSHIP_MATCHING_PERCENTAGE_LOW    = 30.0;
	
	static final double RELATIONSHIP_MATCHING_MULTIPLIER_HIGH   = 4.0;
	static final double RELATIONSHIP_MATCHING_MULTIPLIER_MEDIUM = 1.5;
	static final double RELATIONSHIP_MATCHING_MULTIPLIER_LOW    = 0.6;
	static final double RELATIONSHIP_MATCHING_MULTIPLIER_LOWEST = 0.2;
	static final double RELATIONSHIP_MATCHING_MULTIPLIER_NO_PREFERENCE = 0.0;
	*/
	
	
	// Input: "Age Range"
	static final int AGE_TIER_1 = 0;
	static final int AGE_TIER_2 = 13;
	static final int AGE_TIER_3 = 20;
	static final int AGE_TIER_4 = 30;
	static final int AGE_TIER_5 = 40;
	static final int AGE_TIER_6 = 50;
	static final int AGE_TIER_7 = 60;
	
	static final int MATCHING_AGE_POINTS = 15;
	

	/*
	static final double AGE_MATCHING_PERCENTAGE_HIGH   = 40.0;
	static final double AGE_MATCHING_PERCENTAGE_MEDIUM = 30.0;
	static final double AGE_MATCHING_PERCENTAGE_LOW    = 20.0;
	
	static final double AGE_MATCHING_MULTIPLIER_HIGH          = 5.0;
	static final double AGE_MATCHING_MULTIPLIER_MEDIUM        = 2.5;
	static final double AGE_MATCHING_MULTIPLIER_LOW           = 1.0;
	static final double AGE_MATCHING_MULTIPLIER_LOWEST        = 0.3;
	static final double AGE_MATCHING_MULTIPLIER_NO_PREFERENCE = 0.0;
	*/
	
	
	// Input: "Importance of School System Quality"
	static final double MAXIMUM_SCHOOL_DISTANCE = 50.0;
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


