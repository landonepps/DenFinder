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
	
	private String tractCode;
	
	//total population
	private int population = -1;
	
	//state that contains this area
	private String state;
	
	//number of housing units
	private int housingUnits = -1;
	
	//percent housing units vacant
	private float percentVacant = -1;
	
	/**
	 * Create new census data
	 * @param fips code to query
	 * @throws JSONException
	 * @throws IOException
	 */
	public CensusApi(String fips) throws JSONException, IOException {
		
		this.stateCode = fips.substring(0,2);
		this.countyCode = fips.substring(2, 5);
		this.tractCode = fips.substring(5, 11);
		
		queryDatabase();
	}
	
	/**
	 * Get total population
	 * @return total population
	 */
	public int getPopulation() {
		return population;
	}
	
	/**
	 * Get housing data
	 * @return Housing data
	 */
	public int getHousingUnits() {
		return housingUnits;
	}
	
	/**
	 * Get state
	 * @return state
	 */
	public String getState(){
		return this.state;
	}
	
	/**
	 * Get percent homes vacant
	 * @return percent vacant
	 */
	public float getPercentHomesVacant(){
		return this.percentVacant;
	}
	
	/**
	 * Query census API and fill up this census object
	 * @throws IOException
	 * @throws JSONException
	 */
    public void queryDatabase() throws IOException, JSONException {
    	final String APIKEY = "247154b5274c2ce8ce3d4e6fbe375e33f3646afc";
    	//build queries
    	final String CODE = "B09019_003E,B25077_001E";
    	String censusURL = "http://api.census.gov/data/2013/acs3?get=" + CODE + ",NAME&for=county+subdivision:" + tractCode +
    			"&in=state:" + stateCode +"+county:" + countyCode + "&key=" + APIKEY;
 
        //censusURLPop = new String("http://api.usatoday.com/open/census/pop?keypat="+this.FIPSCode+"&keyname=FIPS&sumlevid=3&api_key=ess47cw42vehm8jjztp8qjwp");
        // String censusURLHos = new String("http://api.usatoday.com/open/census/hou?keypat="+this.FIPSCode+"&keyname=FIPS&sumlevid=3&api_key=ess47cw42vehm8jjztp8qjwp");

        //get JSON for population data
        JSONArray censusJSONPop = loadJSONArray(censusURL);
        
        String json = censusJSONPop.toString();
        
        System.out.println(json);
        
        //this.state = censusJSONPop.getJSONArray("response").getJSONObject(0).getString("Placename");
        //this.population = Integer.parseInt(censusJSONPop.getJSONArray("response").getJSONObject(0).getString("Pop"));

        //get JSON for housing data
        //JSONObject censusJSONHos = ApiCall.loadJSON(censusURLHos);
        //this.housingUnits = Integer.parseInt(censusJSONHos.getJSONArray("response").getJSONObject(0).getString("HousingUnits"));
        //this.percentVacant = Float.parseFloat(censusJSONHos.getJSONArray("response").getJSONObject(0).getString("PctVacant"));
    }
    
    @Override
    public String toString(){
    	return "State: " + this.getState() + "\nTotal Housing: "
    			+ this.getHousingUnits() + "\nPercent Vacant: " + this.getPercentHomesVacant() + "\nToal Population: "
    			+this.getPopulation();
    }
	
}
