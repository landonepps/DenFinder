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
public class Education {
	//rating of available education
	private int reviewRating;

	/**
	 * Create new education data
	 * @param coords the coordinates to query
	 */
	public Education(Coordinates coords) throws IOException {
        int sum = 0;
        int count = 0;
        for(int review : EducationSchoolAvgReviews(EducationSchoolID(coords))) {
            sum += review;
        }

		this.reviewRating = sum/count;
	}

	/**
	 * Get the rating
	 * @return education system rating
	 */
	public int getReviewRating() {
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

            String educationRevURL = new String("http://api.education.com/service/service.php?f=getReviews&key=495796837ec34a5d0c27dc770b87bdf6&%20sn=sf&v=4&nces_id="+s[i]+"&resf=json");
            @SuppressWarnings("unused")
            JSONObject educationJSONreviewRating = new JSONObject(educationContent(educationRevURL));
            int reviewRatingNumber = educationJSONreviewRating.getJSONObject("rating").getInt("average");
            reviewRatings[i] = reviewRatingNumber;
            System.out.print(reviewRatingNumber);
            System.out.println();
        }

        return reviewRatings;

    }

    public static String[] EducationSchoolID(Coordinates c) throws JSONException, IOException {

        String educationSchIDURL = new String("http://api.education.com/service/service.php?f=schoolSearch&key=495796837ec34a5d0c27dc770b87bdf6&%20sn=sf" +"&latitude=" + c.latitude + "&longitude=" + c.longitude + "&distance=1.5&v=4&resf=json");
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