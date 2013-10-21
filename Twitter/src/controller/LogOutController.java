package controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Twitter;
import model.Tweet;
import model.User;

/**
 * Servlet implementation class Tweets
 */
@WebServlet("/Logout")
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogOutController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		logout(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logout(request, response);	
	}

	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		HttpSession session = request.getSession(true); 
		session.invalidate();		
		response.sendRedirect("Tweets");
	}

}
