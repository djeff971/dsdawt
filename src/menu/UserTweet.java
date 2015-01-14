package menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
@WebServlet("/UserTweet")
public class UserTweet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserTweet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/UserTweet.jsp" ).forward( request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientOperations clientop = new ClientOperations();
		String nickname = request.getParameter("username");
		try {
			if(nickname == ""){
				nickname = "null";
			}
			JSONObject service = clientop.getTweets(nickname);
			List<String> list = new ArrayList<String>();
			JSONArray array = service.getJSONArray("tweets");
			for(int i = 0 ; i < array.length() ; i++){
			    list.add(array.getJSONObject(i).getString("message"));
			}
			
			BusinessLogic tweets = new BusinessLogic();
			tweets.setMessage(list);			
			request.setAttribute("tweets", tweets);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/UserTweet.jsp").forward(request, response);
		
		
		
	}

}
