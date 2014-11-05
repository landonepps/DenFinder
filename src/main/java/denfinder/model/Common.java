/**
 * Created on: 11/02/14
 * Author:     Isaac F. Fisher
 */
package denfinder.model;


public final class Common {
	
	//API keys
	static final String EDUCATION_KEY = "abb2d91d6c9168b709f889e2fdfdcfb3";
	
	// Income range multipliers
	// Input: "Income Range"
	static final double INCOME_MATCHING_PERCENTAGE_HIGH   = 60.0;
	static final double INCOME_MATCHING_PERCENTAGE_MEDIUM = 40.0;
	static final double INCOME_MATCHING_PERCENTAGE_LOW    = 20.0;
	
	static final double INCOME_MATCHING_MULTIPLIER_HIGH   = 5.0;
	static final double INCOME_MATCHING_MULTIPLIER_MEDIUM = 2.5;
	static final double INCOME_MATCHING_MULTIPLIER_LOW    = 0.75;
	static final double INCOME_MATCHING_MULTIPLIER_LOWEST = 0.25;
	static final double INCOME_MATCHING_MULTIPLIER_NO_PREFERENCE = 0.0;
	
	
	// Relationship status multipliers
	// Input: "Relationship Status"
	static final double RELATIONSHIP_MATCHIMG_PERCENTAGE_HIGH   = 75.0;
	static final double RELATIONSHIP_MATCHING_PERCENTAGE_MEDIUM = 50.0;
	static final double RELATIONSHIP_MATCHING_PERCENTAGE_LOW    = 30.0;
	
	static final double RELATIONSHIP_MATCHING_MULTIPLIER_HIGH   = 4.0;
	static final double RELATIONSHIP_MATCHING_MULTIPLIER_MEDIUM = 1.5;
	static final double RELATIONSHIP_MATCHING_MULTIPLIER_LOW    = 0.6;
	static final double RELATIONSHIP_MATCHING_MULTIPLIER_LOWEST = 0.2;
	static final double RELATIONSHIP_MATCHING_MULTIPLIER_NO_PREFERENCE = 0.0;
	
	
	// Age multipliers
	// Input: "Age Range"
	static final double AGE_MATCHING_PERCENTAGE_HIGH   = 40.0;
	static final double AGE_MATCHING_PERCENTAGE_MEDIUM = 30.0;
	static final double AGE_MATCHING_PERCENTAGE_LOW    = 20.0;
	
	static final double AGE_MATCHING_MULTIPLIER_HIGH          = 5.0;
	static final double AGE_MATCHING_MULTIPLIER_MEDIUM        = 2.5;
	static final double AGE_MATCHING_MULTIPLIER_LOW           = 1.0;
	static final double AGE_MATCHING_MULTIPLIER_LOWEST        = 0.3;
	static final double AGE_MATCHING_MULTIPLIER_NO_PREFERENCE = 0.0;
	
	
	// Community type
	// Input: "Preferred Community Type"
	static final double COMMUNITY_MATCHING     = 2.0;
	static final double COMMUNITY_NOT_MATCHING = 0.5;
	
	
	// Education rating multipliers 
	// Input: "Importance of School System Quality"
	static final double SCHOOl_QUALITY_MULTIPLIER_VERY_IMPORTANT     = 5.0;
	static final double SCHOOL_QUALITY_MULTIPLIER_SOMEWHAT_IMPORTANT = 2.0;
	static final double SCHOOL_QUALITY_MULTIPLIER_NOT_VERY_IMPORTANT = 0.8;
	static final double SCHOOL_QUALITY_MULTIPLIER_NO_PREFERENCE      = 0.0;
}


