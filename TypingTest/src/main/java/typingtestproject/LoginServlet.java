package typingtestproject;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Get the name and email parameters from the request
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");

	    // Create a new User object with the given name and email
	    User user = new User();
	    String id = UUID.randomUUID().toString();
	    user.setName(name);
	    user.setEmail(email);
	    user.setId(id);
	    
	    System.out.print(user.getName());
	    System.out.print(user.getId());
	    System.out.print(user.getEmail());

	    // Set the User object as a session attribute
	    HttpSession session = request.getSession();
	    session.setAttribute("user", user);

	    // Redirect the user to a welcome page
	    response.sendRedirect("TypingTest.jsp");;
	}

	}
