package denfinder.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Census data
 *
 */
public class CensusApi extends ApiCall {
	
	private String stateCode;
	
	private String countyCode;
	
	// private String tractCode;
	
    private int medianIncome;
    private double medianAge;
    private int numSingle;
    private int numMarried;
    
	
	/**
	 * Create new census data
	 * @param fips code to query
	 * @throws JSONException
	 * @throws IOException
	 */
	public CensusApi(String fips) throws JSONException, IOException {
		
		this.stateCode = fips.substring(0,2);
		this.countyCode = fips.substring(2, 5);
		// this.tractCode = fips.substring(5, 11);
		
		queryDatabase();
	}
	
	/**
	 * Query census API and fill up this census object
	 * @throws IOException
	 * @throws JSONException
	 */
    public void queryDatabase() throws IOException, JSONException {
    	final String APIKEY = "247154b5274c2ce8ce3d4e6fbe375e33f3646afc";
    	// build queries
    	// median household income, median age, total with relationship status, never married
    	final String CODE = "B19013_001E,B01002_001E,B12005_001E,B12005_002E";
    	// http://api.census.gov/data/2013/acs3?get=NAME,B01001_001E&for=county:073&in=state:06&key=247154b5274c2ce8ce3d4e6fbe375e33f3646afc
    	String censusURL = "http://api.census.gov/data/2013/acs3?get=" + CODE + "&for=county:" + countyCode +
    			"&in=state:" + stateCode + "&key=" + APIKEY;

        //get JSON for population data
        JSONArray censusJSON = loadJSONArray(censusURL).getJSONArray(1);
        System.out.println(censusJSON);
        // set variables
        medianIncome = censusJSON.getInt(0);
        medianAge = censusJSON.getDouble(1);
        numSingle = censusJSON.getInt(3);
        int totalRelationship = censusJSON.getInt(2);
        numMarried = totalRelationship - numSingle;
        
        System.out.println(medianIncome + " " + medianAge + " " + numSingle + " " + numMarried);
    }

	public int getMedianIncome() {
		return medianIncome;
	}

	public double getMedianAge() {
		return medianAge;
	}

	public int getNumSingle() {
		return numSingle;
	}

	public int getNumMarried() {
		return numMarried;
	}
	
}
