package menu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.WebResource;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher( "/Home.jsp" ).forward( request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientOperations clientop = new ClientOperations();
		//WebResource service = clientop.getService();
		//service.path("rest").path("res").accept(MediaType.APPLICATION_JSON).get(String.class);
		
		String[] userList = {"user1","user2","user3","user4","user4",};
		BusinessLogic users = new BusinessLogic();
		users.setMessage(userList);			
		request.setAttribute("users", users);	
		this.getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);
		
		
		
	}

}
