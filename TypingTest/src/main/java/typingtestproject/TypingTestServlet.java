package typingtestproject;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TypingTestServlet")
public class TypingTestServlet extends HttpServlet {

    private static final String TEXT = "The quick brown fox jumps over the lazy dog";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        // Set up the passage of text for the user to type
        request.setAttribute("text", TEXT);
        
        // Display the typing test page to the user
        request.getRequestDispatcher("TypingTest.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Retrieve the user's typed text from the request parameters
        String typedText = request.getParameter("typedText");
        
        // Calculate the user's typing speed (in words per minute)
        int numWords = TEXT.split("\\s+").length;
        long elapsedTime = System.currentTimeMillis() - Long.parseLong(request.getParameter("startTime"));
        double typingSpeed = (numWords / ((double) elapsedTime / 60000.0));
        
        // Store the user's score in the database
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        TypingTestResult typingTestResult = new TypingTestResult(user.getId(), typingSpeed);
        TypingTestResultDao.save(typingTestResult);
        
        
        // Display the user's typing speed to the user
        request.setAttribute("typingSpeed", typingSpeed);
        request.getRequestDispatcher("typingspeed.jsp").forward(request, response);;
}
}
