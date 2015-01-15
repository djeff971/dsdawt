package menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Servlet implementation class Home
 */
@WebServlet("/ListAllTweet")
public class ListAllTweet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllTweet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/ListAllTweet.jsp" ).forward( request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientOperations clientop = new ClientOperations();
		try {
			//HashMap<String, List<String>> donnees = new HashMap<String, List<String>>();
			HashMap<String,String> donnees = new HashMap<String, String>();
			JSONObject getUsers = clientop.getAllUsers();
			List<String> listofusers = new ArrayList<String>();
			JSONArray array = getUsers.getJSONArray("users");
			for(int i = 0 ; i < array.length() ; i++){
				listofusers.add(array.getJSONObject(i).getString("nickname"));
				//List<String> listoftweets = new ArrayList<String>();
				String listoftweets = "";
				JSONObject getTweet = clientop.getTweets(array.getJSONObject(i).getString("nickname"));
				JSONArray arrayoftweets = getTweet.getJSONArray("tweets");
				for(int j = 0 ; j < arrayoftweets.length() ; j++){
					//listoftweets.add(arrayoftweets.getJSONObject(j).getString("message"));
					listoftweets += "<li>" + arrayoftweets.getJSONObject(j).getString("message") + "</li></br>";
					donnees.put(array.getJSONObject(i).getString("nickname"), listoftweets);
				}
			}
			//.substring(1, me.getValue().toString().length()-1)
			BusinessLogic informations = new BusinessLogic();
			informations.setDonnees(donnees);			
			request.setAttribute("informations", informations);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/ListAllTweet.jsp").forward(request, response);
		
		
		
	}

}
