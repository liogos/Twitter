package controller;

import java.io.IOException;
import java.util.ArrayList;
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

import Utils.Logged;
import model.Twitter;
import model.Tweet;
import model.User;

/**
 * Servlet implementation class Tweets
 */
@WebServlet("/addFollower")
public class UserAddFollower extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserAddFollower() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Twitter twitter =  (Twitter) getServletContext().getAttribute("Twitter") ;
		HttpSession session = request.getSession();
		User membre =  (User)session.getAttribute("connected");
		
		TreeSet<User> lu;
		
		
		if (membre != null){
			User lio = (User)session.getAttribute("visited");
			membre.addFollower((User)session.getAttribute("visited"));
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/home.jsp");
		view.forward(request, response);
	}		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}


}
