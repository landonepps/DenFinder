package denfinder.model;

import com.oracle.javafx.jmx.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Census data
 *
 */
public class Census {
	
	//total population
	private int population;
	
	//string representation of housing data
	private String housing;
	
	/**
	 * Create new census data
	 * @param population total population
	 * @param housing string representation of housing data
	 */
	public Census(int population, String housing) {
		this.population = population;
		this.housing = housing;
	}
	
	/**
	 * Get total population
	 * @return total population
	 */
	public int getPopulation() {
		return population;
	}
	
	/**
	 * Set population
	 * @param population the total population
	 */
	public void setPopulation(int population) {
		this.population = population;
	}
	
	/**
	 * Get housing data
	 * @return Housing data
	 */
	public String getHousing() {
		return housing;
	}
	
	/**
	 * Set housing info
	 * @param housing housing information
	 */
	public void setHousing(String housing) {
		this.housing = housing;
	}

    public static void censusDataStLvl() throws IOException, JSONException {


        String censusURLPop = new String("http://api.usatoday.com/open/census/pop?keypat=Louisiana&keyname=placename&api_key=ess47cw42vehm8jjztp8qjwp");
        String censusURLHos = new String("http://api.usatoday.com/open/census/hou?api_key=ess47cw42vehm8jjztp8qjwp");
        //String educationURL = new String("http://api.education.com/service/service.php?f=getReviews&key=0eb991b50ebfafa405a4a97f750e0175&sn=sf&v=4&Reqf");

        JSONObject censusJSONPop = ApiCall.loadJSON(censusURLPop);
        String placename = censusJSONPop.getJSONArray("response").getJSONObject(0).getString("Placename");
        String population = censusJSONPop.getJSONArray("response").getJSONObject(0).getString("Pop");


        JSONObject censusJSONHos = ApiCall.loadJSON(censusURLHos);
        String housing = censusJSONHos.getJSONArray("response").getJSONObject(0).getString("HousingUnits");
        String vacant = censusJSONHos.getJSONArray("response").getJSONObject(0).getString("PctVacant");

        float pctvacant = Float.parseFloat(vacant);
        int vacantPercent = (int) (pctvacant * 100);

        System.out.print("State: " + placename+ "\n");
        System.out.print("Population: "+ population + "\n");
        System.out.print("Housing Units: " + housing + "\n");
        System.out.print("Percent Vacant: " + vacantPercent + "% \n");

    }
    public static void censusDataCityLvl(String state) throws IOException, JSONException{


        String censusURLPop = new String("http://api.usatoday.com/open/census/pop?keypat=" +state+"&sumlevid=4,6&api_key=ess47cw42vehm8jjztp8qjwp");
        String censusURLHos = new String("http://api.usatoday.com/open/census/hou?keypat=VA&sumlevid=4,6&api_key=ess47cw42vehm8jjztp8qjwp");

        JSONObject censusJSONPop = ApiCall.loadJSON(censusURLPop);
        JSONObject censusJSONHos = ApiCall.loadJSON(censusURLHos);

        for(int i = 0; i < censusJSONHos.getJSONArray("response").length(); i++){
            String placename = censusJSONPop.getJSONArray("response").getJSONObject(i).getString("Placename");
            String population = censusJSONPop.getJSONArray("response").getJSONObject(i).getString("Pop");
            String housing = censusJSONHos.getJSONArray("response").getJSONObject(i).getString("HousingUnits");
            String vacant = censusJSONHos.getJSONArray("response").getJSONObject(i).getString("PctVacant");

            float pctvacant = Float.parseFloat(vacant);
            int vacantPercent = (int) (pctvacant * 100);

            System.out.print("State: " + state +"\n");
            System.out.print("City: " + placename+ "\n");
            System.out.print("Population: "+ population + "\n");
            System.out.print("Housing Units: " + housing + "\n");
            System.out.print("Percent Vacant: " + vacantPercent + "% \n");
            System.out.println();
        }

    }
	
	
}
