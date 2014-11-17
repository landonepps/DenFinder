/**
 *  by Nicholas Flye
 */

package denfinder.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Contains education data
 *
 */
public class EducationAPI {
	//rating of available education
	private double reviewRating;

	/**
	 * Create new education data
	 * @param coords the coordinates to query
	 */
	public EducationAPI(Coordinates coords) throws IOException {
        
		/*
		int count = 0;
        int sum = 0;
        for(int rating : EducationSchoolAvgReviews(EducationSchoolID(coords))) {
            if (rating != 0) {
                count++;
                sum += rating;
            }
        }

		this.reviewRating = count != 0 ? sum/count : 0;
		*/
		
		SchoolList list = new SchoolList();
		list.populate("","","","75093");
	}

	/**
	 * Get the rating
	 * @return education system rating
	 */
	public double getReviewRating() {
		return reviewRating;
	}

	/**
	 * Set education rating
	 * @param reviewRating the rating
	 */
	public void setReviewRating(int reviewRating) {
		this.reviewRating = reviewRating;
	}

    public void queryDatabase(Coordinates coords) throws IOException {
        EducationSchoolAvgReviews(EducationSchoolID(coords));
    }

    public static int[] EducationSchoolAvgReviews(String[] s) throws JSONException, IOException{

        int[] reviewRatings = new int[s.length];

        for(int i = 0; i < s.length; i++){

            String educationRevURL = new String("http://api.education.com/service/service.php?f=getReviews&key=31aa350a664bac9e173954e6d10ad77a&%20sn=sf&v=4&nces_id="+s[i]+"&resf=json");
            JSONObject educationJSONreviewRating = new JSONObject(educationContent(educationRevURL));
            int reviewRatingNumber = educationJSONreviewRating.getJSONObject("rating").getInt("average");
            reviewRatings[i] = reviewRatingNumber;
            System.out.print(reviewRatingNumber);
            System.out.println();
        }

        return reviewRatings;

    }

    public static String[] EducationSchoolID(Coordinates c) throws JSONException, IOException {

        String educationSchIDURL = new String("http://api.education.com/service/service.php?f=schoolSearch&key=31aa350a664bac9e173954e6d10ad77a&%20sn=sf" +"&latitude=" + c.latitude + "&longitude=" + c.longitude + "&distance=1.5&v=4&resf=json");
        JSONArray educationJSONid = new JSONArray(educationContent(educationSchIDURL));
        String[]  schoolIDs = new String[educationJSONid.length()];
        for(int i = 0; i < educationJSONid.length(); i++){
            String IDs = educationJSONid.getJSONObject(i).getJSONObject("school").getString("nces_id");
            System.out.print(IDs);
            System.out.println();
            schoolIDs[i] = IDs;
        }
        return schoolIDs;

    }
    
    public static Coordinates[] EducationSchoolLatLong(String state, String city) throws JSONException, IOException {

        String educationSchLatLongURL = new String("http://api.education.com/service/service.php?f=schoolSearch&key=31aa350a664bac9e173954e6d10ad77a&%20sn=sf&state" + state + "&city" + city + "&resf=json");
        JSONArray educationJSONlatlong= new JSONArray(educationContent(educationSchLatLongURL));
        Coordinates[]  cLatLong = new Coordinates[educationJSONlatlong.length()];
        
        for(int i = 0; i < educationJSONlatlong.length(); i++){
        	
            long latitude = Long.valueOf(educationJSONlatlong.getJSONObject(i).getJSONObject("school").getString("latitude"));
            long longitude = Long.valueOf(educationJSONlatlong.getJSONObject(i).getJSONObject("school").getString("longitude"));
            System.out.print(latitude);
            System.out.print(longitude);
            System.out.println();
            cLatLong[i].latitude = latitude;
            cLatLong[i].longitude = longitude;
        }
        return cLatLong;

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
	
}
