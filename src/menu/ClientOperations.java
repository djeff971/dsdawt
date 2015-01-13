package menu;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ClientOperations {

	public JSONObject getService() throws JSONException {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8082/Awt_WebService/rest/res");
		String s = webResource.get(String.class);
		JSONObject userJSON = new JSONObject("{users : "+ s + "}");
		//JSONObject userJSON = webResource.get(JSONObject.class);
		return userJSON;
	
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8082/Awt_WebService/").port(8082).build();
	}
}
