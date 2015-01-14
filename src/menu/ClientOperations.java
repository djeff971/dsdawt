package menu;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ClientOperations {
	
	public JSONObject getAllUsers() throws JSONException {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8082/Awt_WebService/rest/res/getUsers");
		String s = webResource.get(String.class);
		JSONObject userJSON = new JSONObject("{users : "+ s + "}");
		//JSONObject userJSON = webResource.get(JSONObject.class);
		return userJSON;
	
	}
	public JSONObject getTweets(String nickname) throws JSONException {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8082/Awt_WebService/rest/res/getTweets/"+nickname);
		String s = webResource.get(String.class);
		JSONObject userJSON = null;
		if(s.startsWith("[]")){
			String chaineJSON = "[{"+"message:"+"..."+"}]";
			userJSON = new JSONObject("{tweets : "+chaineJSON+"}");
		}else {
			userJSON = new JSONObject("{tweets : "+ s + "}");
		}	
		//JSONObject userJSON = new JSONObject("{tweets : "+ s + "}");
		return userJSON;
	}
	
	public JSONObject listAllTweet(long id, String nickname) throws JSONException{
		JSONObject userJSON = new JSONObject("{listalltweet : }");
		return userJSON;
	}
	


}
