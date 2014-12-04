/**
 * Created on: 11/02/14
 * Author:     Isaac F. Fisher
 */
package denfinder.model;


public final class Common {
	
	//API keys
	static final String EDUCATION_KEY = "277df245ae9d53f1cd36667569138498";
	//static final String EDUCATION_KEY = "efb9b316554a9f2eb62e8eaafa8f9bfe"; //education key for wind
	
	
	static final String GEOCODING_KEY = "AIzaSyDmW7DnNY5wR_5DI4QwmS2Zxmg0q3Ba08E";
	static final String CENSUS_KEY = "247154b5274c2ce8ce3d4e6fbe375e33f3646afc";
	
	// Map data
	static final int MAP_DIVISIONS = 10;
	
	// Algorithm input: General
	static final String INPUT_STRING_NO_PREFERENCE = "No Preference";
	
	// Algorithm input: "Income Range"
	static final String INCOME_STRING_TIER_1 = "0-25";
	static final String INCOME_STRING_TIER_2 = "25-50";
	static final String INCOME_STRING_TIER_3 = "50-75";
	static final String INCOME_STRING_TIER_4 = "75-100";
	static final String INCOME_STRING_TIER_5 = "100+";
	
	static final int INCOME_TIER_1 = 0;
	static final int INCOME_TIER_2 = 25000;
	static final int INCOME_TIER_3 = 50000;
	static final int INCOME_TIER_4 = 75000;
	static final int INCOME_TIER_5 = 100000;
	
	static final double MATCHING_INCOME_POINTS = 10;
	
	
	// Algorithm input: "Age Range"
	static final String AGE_STRING_TIER_1 = "13-19";
	static final String AGE_STRING_TIER_2 = "20-29";
	static final String AGE_STRING_TIER_3 = "30-39";
	static final String AGE_STRING_TIER_4 = "40-49";
	static final String AGE_STRING_TIER_5 = "50-59";
	static final String AGE_STRING_TIER_6 = "60+";
	
	static final double AGE_TIER_1 = 13;
	static final double AGE_TIER_2 = 20;
	static final double AGE_TIER_3 = 30;
	static final double AGE_TIER_4 = 40;
	static final double AGE_TIER_5 = 50;
	static final double AGE_TIER_6 = 60;
	
	static final double MATCHING_AGE_POINTS = 15;
	
	
	// Algorithm input: "Relationship Status"
	static final String RELATIONSHIP_STRING_SINGLE  = "Single";
	static final String RELATIONSHIP_STRING_MARRIED = "Married";
	
	static final double RELATIONSHIP_MATCHING_RATIO_TIER_1 = 1.5;
	static final double RELATIONSHIP_MATCHING_RATIO_TIER_2 = 2.0;
	static final double RELATIONSHIP_MATCHING_RATIO_TIER_3 = 3.0;
	
	static final double RELATIONSHIP_NOT_MATCHING_RATIO_TIER_1 = 0.667;
	static final double RELATIONSHIP_NOT_MATCHING_RATIO_TIER_2 = 0.50;
	static final double RELATIONSHIP_NOT_MATCHING_RATIO_TIER_3 = 0.333;

	static final double RELATIONSHIP_MATCHING_POINTS_TIER_1 = 3;
	static final double RELATIONSHIP_MATCHING_POINTS_TIER_2 = 8;
	static final double RELATIONSHIP_MATCHING_POINTS_TIER_3 = 15;
	
	static final double RELATIONSHIP_NOT_MATCHING_POINTS_TIER_1 = -3;
	static final double RELATIONSHIP_NOT_MATCHING_POINTS_TIER_2 = -8;
	static final double RELATIONSHIP_NOT_MATCHING_POINTS_TIER_3 = -15;
	
	
	// Algorithm input: "Importance of School System Quality"
	static final String SCHOOL_IMPORTANCE_STRING_LOW    = "Not Very Important";
	static final String SCHOOL_IMPORTANCE_STRING_MEDIUM = "Somewhat Important";
	static final String SCHOOL_IMPORTANCE_STRING_HIGH   = "Very Important";
	
	static final double MAXIMUM_SCHOOL_DISTANCE = 1.0;
	static final double TEST_SCORE_LOW = 3;
	static final double TEST_SCORE_MEDIUM = 5;
	static final double TEST_SCORE_HIGH = 8;
	
	static final double TEST_SCORE_LOW_POINTS = 1;
	static final double TEST_SCORE_MEDIUM_POINTS = 2;
	static final double TEST_SCORE_HIGH_POINTS = 3;
	
	static final double SCHOOl_QUALITY_MULTIPLIER_VERY_IMPORTANT     = 3.0;
	static final double SCHOOL_QUALITY_MULTIPLIER_SOMEWHAT_IMPORTANT = 1.5;
	static final double SCHOOL_QUALITY_MULTIPLIER_NOT_VERY_IMPORTANT = 0.5;
	static final double SCHOOL_QUALITY_MULTIPLIER_NO_PREFERENCE      = 0.0;
}
