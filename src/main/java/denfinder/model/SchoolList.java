/**
 * 
 */
package denfinder.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * @author PINTOR
 *
 */
public class SchoolList implements List<School> {

	private List<School> schoolList;
	
	public SchoolList() {
		this.schoolList = new ArrayList<School>();
	}
	
	@Override
	public boolean add(School e) {
		return schoolList.add(e);
	}
	
	
	@Override
	public void add(int index, School element) {
		schoolList.add(index, element);
		
	}
	
	@Override
	public boolean addAll(Collection<? extends School> c) {
		return schoolList.addAll(c);
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends School> c) {
		return schoolList.addAll(index, c);
	}
	
	@Override
	public boolean contains(Object o) {
		return schoolList.contains(o);
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		return schoolList.containsAll(c);
	}
	
	@Override
	public void clear() {
		schoolList.clear();
		
	}
	
	@Override
	public School get(int index) {
		return schoolList.get(index);
	}
	
	@Override
	public int indexOf(Object o) {
		return schoolList.indexOf(o);
	}
	
	@Override
	public boolean isEmpty() {
		return schoolList.isEmpty();
	}
	
	@Override
	public Iterator<School> iterator() {
		return schoolList.iterator();
	}
	
	@Override
	public int lastIndexOf(Object o) {
		return schoolList.lastIndexOf(o);
	}

	@Override
	public ListIterator<School> listIterator() {
		return schoolList.listIterator();
	}

	@Override
	public ListIterator<School> listIterator(int index) {
		return schoolList.listIterator(index);
	}
	
	@Override
	public School remove(int index) {
	    return schoolList.remove(index);
	}
	
	@Override
	public boolean remove(Object o) {
		return schoolList.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return schoolList.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return schoolList.retainAll(c);
	}
	
	@Override
	public School set(int index, School element) {
		return schoolList.set(index, element);
	}
	
	@Override
	public int size() {
		return schoolList.size();
	}

	@Override
	public List<School> subList(int fromIndex, int toIndex) {
		return schoolList.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return schoolList.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return schoolList.toArray(a);
	}
	
	private static String educationContent(String url) throws IOException {

        StringBuilder content = new StringBuilder();
        try
        {

            URL censusURL = new URL(url);
            URLConnection urlConnection = censusURL.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null){

                content.append(line + "\n");
            }
            bufferedReader.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }
	
	
	
	
	/**
	 * Populate list with all schools in a city, state, zip (must specify at least zipcode or state) 
	 * @param city city to search (if empty ignore)
	 * @param county county to search (if empty ignore)
	 * @param state state to search (must not be empty if zipcode is also empty)
	 * @param zipcode zipcode to search (must not be empty if state is also empty)
	 * @throws IOException 
	 * @throws JSONException 
	 */
	public void populate(String city, String county, String state,String zipcode) throws JSONException, IOException{
		if(state.length() == 0 && zipcode.length() == 0){
			throw new IOException("Must specify at least state or zipcode for Education.com API");
		}
		
		
		String educationRevURL = new String("http://api.education.com/service/service.php?f=schoolSearch&key=" + Common.EDUCATION_KEY + "&sn=sf&v=4&state="+state+ "&county=" + county + "&city=" + city + "&zip=" + zipcode + "&resf=json");
        JSONArray allSchoolsInZip = new JSONArray(educationContent(educationRevURL));
       
        for(int i = 0; i < allSchoolsInZip.length(); i++){
            String schoolName = allSchoolsInZip.getJSONObject(i).getJSONObject("school").getString("schoolname");
            System.out.println("[DEBUG] Adding school to school list: " + schoolName);
            String id;
            double testRating,lat,lon;
            
            id = allSchoolsInZip.getJSONObject(i).getJSONObject("school").getString("schoolid");
            String temp = allSchoolsInZip.getJSONObject(i).getJSONObject("school").getString("testrating_text");
            if(temp.length() == 0){
            	testRating = 0;
            }
            else{
            
            	testRating = Double.parseDouble((allSchoolsInZip.getJSONObject(i).getJSONObject("school").getString("testrating_text").substring(24)));
            //testRating = 0; //TODO: parse returned string for rating
            //System.out.print(testRating);
            }
            lat = allSchoolsInZip.getJSONObject(i).getJSONObject("school").getDouble("latitude");
            lon = allSchoolsInZip.getJSONObject(i).getJSONObject("school").getDouble("longitude");
            
            School s = new School(id,testRating,lat,lon);
            this.add(s);
            
        }
	}

}
