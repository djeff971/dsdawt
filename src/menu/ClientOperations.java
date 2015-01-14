package menu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
	public void update() throws IOException {
		try {
			URL url = new URL("http://localhost:8082/Awt_WebService/rest/res/updateData");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.connect();

			InputStream input = connection.getInputStream();
			int data = input.read();
			while(data != -1){
			    System.out.print((char) data);
			    data = input.read();
			}
			input.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		Client client = Client.create();
		client.resource("http://localhost:8082/Awt_WebService/rest/res/updateData/"+go);
		*/
	}
	


}
