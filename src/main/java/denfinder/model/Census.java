package denfinder.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Census data
 *
 */
public class Census {
	
	//total population
	private String FIPSCode = null;
	private int population = -1;
	private String state = null;
	private int housingUnits = -1;
	private float percentVacant = -1;
	
	/**
	 * Create new census data
	 * @param population total population
	 * @param housing string representation of housing data
	 * @throws IOException 
	 * @throws JSONException 
	 */
	public Census(String FIPS) throws JSONException, IOException {
		this.FIPSCode = FIPS;
		
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
	
	public String getState(){
		return this.state;
	}
	
	public String getFIPS(){
		return this.FIPSCode;
	}
	
	public int getTotalPopulation(){
		return this.population;
	}
	
	public float getPercentHomesVacant(){
		return this.percentVacant;
	}
	
	/**
	 * Query census API and fill up this census object
	 * @throws IOException
	 * @throws JSONException
	 */
    public void queryDatabase() throws IOException, JSONException {
    	//build queries
        String censusURLPop = new String("http://api.usatoday.com/open/census/pop?keypat="+this.FIPSCode+"&keyname=FIPS&api_key=ess47cw42vehm8jjztp8qjwp");
        String censusURLHos = new String("http://api.usatoday.com/open/census/hou?keypat="+this.FIPSCode+"&keyname=FIPS&api_key=ess47cw42vehm8jjztp8qjwp");

        //get JSON for population data
        JSONObject censusJSONPop = ApiCall.loadJSON(censusURLPop);
        String placename = censusJSONPop.getJSONArray("response").getJSONObject(0).getString("Placename");
        String population = censusJSONPop.getJSONArray("response").getJSONObject(0).getString("Pop");

        //get JSON for houseing data
        JSONObject censusJSONHos = ApiCall.loadJSON(censusURLHos);
        String housing = censusJSONHos.getJSONArray("response").getJSONObject(0).getString("HousingUnits");
        String vacant = censusJSONHos.getJSONArray("response").getJSONObject(0).getString("PctVacant");

        //set attribs
        this.state = placename;
        this.population = Integer.parseInt(population);
        this.housingUnits = Integer.parseInt(housing);
        this.percentVacant = Float.parseFloat(vacant);
        
    }
	
}
