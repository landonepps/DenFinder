package denfinder.model;

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
	
	
}
