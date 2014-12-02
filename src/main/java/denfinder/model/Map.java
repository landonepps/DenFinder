package denfinder.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.json.JSONException;

/**
 * List of all zone objects
 * @author latch
 *
 */
public class Map {
	// zones in this list
	private List<ArrayList<Zone>> map;
	
	// User's input data for this map request
	String income;
	String relationshipStatus;
	String age;
	String schoolImportance;
	String address;
	
	private SchoolList schoolList = new SchoolList();

	//create new list
	public Map(String address, String newIncome, String newRelationshipStatus,
									   String newAge, String newSchoolImportance) throws JSONException, IOException {
		this.map = new ArrayList<ArrayList<Zone>>();
		
		this.address = address;
		
		Pair<Coordinates, Coordinates> viewport = 
				GeocodingAPI.getCoordinates(address);
		
		Coordinates topRight = viewport.getRight();
		Coordinates bottomLeft = viewport.getLeft();
		
		double latDiff = (topRight.getLatitude() - bottomLeft.getLatitude()) / Common.MAP_DIVISIONS;
		double lonDiff = (topRight.getLongitude() - bottomLeft.getLongitude()) / Common.MAP_DIVISIONS;
		
		System.out.println(" " + latDiff + " " + lonDiff);
		
		//String state = GeocodingAPI.getState(bottomLeft);
		String zip = GeocodingAPI.getZipCode(bottomLeft);
		
		//debug information
		System.out.println("[DEBUG] Adding all schools from zip code: " + zip);
				
		//schoolList.populate("", "", state, "");
		schoolList.populate("", "", "", zip);
		
		
		for (int i = 0; i < Common.MAP_DIVISIONS; i++) {
			ArrayList<Zone> longitudes = new ArrayList<Zone>();
			for (int j = 0; j < Common.MAP_DIVISIONS; j++) {
				longitudes.add(new Zone(new Coordinates(bottomLeft.getLatitude() + latDiff * i,
														bottomLeft.getLongitude() + lonDiff * j)));
			}
			map.add(longitudes);
		}
		
		income 			   = newIncome;
		relationshipStatus = newRelationshipStatus;
		age   			   = newAge;
		schoolImportance   = newSchoolImportance;
	}
	
	public int getDimensions() {
		return map.size();
	}
	
	public Coordinates getMiddle() {
		return map.get(map.size()/2).get(map.get(map.size()/2).size()).getLocation();		
	}
	
	public Zone getZone(int x, int y) {
		return map.get(x).get(y);
	}
	
	public String getAddress() {
		return this.address;
	}
	

	public void rateAllZones() {
		for (int i = 0; i < map.size(); i++) {
			for (int j = 0; j < map.get(i).size(); j++) {
				rateZone(map.get(i).get(j));
			}
		}
	}
	
	public void rateZone(Zone aZone) {
		int zoneRating = 0;
		
		// Income rating:
		int incomePoints = 0;
		
		switch(income) {
			case Common.INCOME_STRING_TIER_1:
				if (aZone.getMedianIncome() >= Common.INCOME_TIER_1 &&
					aZone.getMedianIncome() <= Common.INCOME_TIER_2) {
					
					incomePoints += Common.MATCHING_INCOME_POINTS;
				}
			
				break;
		
			case Common.INCOME_STRING_TIER_2:
				if (aZone.getMedianIncome() >= Common.INCOME_TIER_2 &&
					aZone.getMedianIncome() <= Common.INCOME_TIER_3) {
						
					incomePoints += Common.MATCHING_INCOME_POINTS;
				}
				
				break;
				
			case Common.INCOME_STRING_TIER_3:
				if (aZone.getMedianIncome() >= Common.INCOME_TIER_3 &&
					aZone.getMedianIncome() <= Common.INCOME_TIER_4) {
					
					incomePoints += Common.MATCHING_INCOME_POINTS;
				}
				
				break;
				
			case Common.INCOME_STRING_TIER_4:
				if (aZone.getMedianIncome() >= Common.INCOME_TIER_4 &&
					aZone.getMedianIncome() <= Common.INCOME_TIER_5) {
						
					incomePoints += Common.MATCHING_INCOME_POINTS;
				}
				
				break;
				
			case Common.INCOME_STRING_TIER_5:
				if (aZone.getMedianIncome() >= Common.INCOME_TIER_5) {
						
					incomePoints += Common.MATCHING_INCOME_POINTS;
				}
				
				break;
		}
		
		zoneRating += incomePoints;
		
		
		// Age rating:
		int agePoints = 0;
		
		switch(age) {
			case Common.AGE_STRING_TIER_1:
				if (aZone.getMedianAge() >= Common.AGE_TIER_1 &&
					aZone.getMedianAge() <= Common.AGE_TIER_2) {
					
					agePoints += Common.MATCHING_AGE_POINTS;
				}
				
				break;
				
			case Common.AGE_STRING_TIER_2:
				if (aZone.getMedianAge() >= Common.AGE_TIER_2 &&
					aZone.getMedianAge() <= Common.AGE_TIER_3) {
					
					agePoints += Common.MATCHING_AGE_POINTS;
				}
				
				break;
				
			case Common.AGE_STRING_TIER_3:
				if (aZone.getMedianAge() >= Common.AGE_TIER_3 &&
					aZone.getMedianAge() <= Common.AGE_TIER_4) {
					
					agePoints += Common.MATCHING_AGE_POINTS;
				}
				
				break;
				
			case Common.AGE_STRING_TIER_4:
				if (aZone.getMedianAge() >= Common.AGE_TIER_4 &&
					aZone.getMedianAge() <= Common.AGE_TIER_5) {
					
					agePoints += Common.MATCHING_AGE_POINTS;
				}
				
				break;
				
			case Common.AGE_STRING_TIER_5:
				if (aZone.getMedianAge() >= Common.AGE_TIER_5 &&
					aZone.getMedianAge() <= Common.AGE_TIER_6) {
					
					agePoints += Common.MATCHING_AGE_POINTS;
				}
				
				break;
				
			case Common.AGE_STRING_TIER_6:
				if (aZone.getMedianAge() >= Common.AGE_TIER_6) {
					
					agePoints += Common.MATCHING_AGE_POINTS;
				}
				
				break;
		}
		
		zoneRating += agePoints;
		
		
		// Relationship status rating:
		int relationshipPoints = 0;
		
		double ratio      = 0;
		double numSingle  = aZone.getNumSingle();
		double numMarried = aZone.getNumMarried();
		
		if (relationshipStatus.equals(Common.RELATIONSHIP_STRING_SINGLE) &&
			numMarried != 0) {
			
			ratio = numSingle / numMarried;
		}
		
		else if (relationshipStatus.equals(Common.RELATIONSHIP_STRING_MARRIED) &&
			numSingle != 0) {
			
			ratio = numMarried / numSingle;
		}
		
		if (ratio != 0) {
			if (ratio >= Common.RELATIONSHIP_MATCHING_RATIO_TIER_1 && 
				ratio <= Common.RELATIONSHIP_MATCHING_RATIO_TIER_2) {
				
				relationshipPoints += Common.RELATIONSHIP_MATCHING_POINTS_TIER_1;
			}
			else if (ratio >= Common.RELATIONSHIP_MATCHING_RATIO_TIER_2 &&
					 ratio <= Common.RELATIONSHIP_MATCHING_RATIO_TIER_3) {
				
				relationshipPoints += Common.RELATIONSHIP_MATCHING_POINTS_TIER_2;
			}
			else if (ratio >= Common.RELATIONSHIP_MATCHING_RATIO_TIER_3) {
				
				relationshipPoints += Common.RELATIONSHIP_MATCHING_POINTS_TIER_3;
			}
			
			
			else if (ratio <= Common.RELATIONSHIP_NOT_MATCHING_RATIO_TIER_1 && 
					 ratio >= Common.RELATIONSHIP_NOT_MATCHING_RATIO_TIER_2) {
					
				relationshipPoints += Common.RELATIONSHIP_NOT_MATCHING_POINTS_TIER_1;
			}
			else if (ratio <= Common.RELATIONSHIP_NOT_MATCHING_RATIO_TIER_2 &&
					 ratio >= Common.RELATIONSHIP_NOT_MATCHING_RATIO_TIER_3) {
					
				relationshipPoints += Common.RELATIONSHIP_NOT_MATCHING_POINTS_TIER_2;
			}
			else if (ratio <= Common.RELATIONSHIP_NOT_MATCHING_RATIO_TIER_3) {
				
				relationshipPoints += Common.RELATIONSHIP_NOT_MATCHING_POINTS_TIER_3;
			}
		}
		
		zoneRating += relationshipPoints;
		
		
		// Education rating:
		int educationPoints = 0;
		


		
		
		
		// TODO: Education rating part of algorithm
		
		
		
		
		
		
		
		zoneRating += educationPoints;
		
		aZone.setRating(zoneRating);
	}
	

	public List<ArrayList<Zone>> getRawMap() {
		return map;
	}


}
	

