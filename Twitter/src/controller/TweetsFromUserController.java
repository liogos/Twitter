package controller;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.Logged;
import model.Twitter;
import model.Tweet;
import model.User;

/**
 * Servlet implementation class Tweets
 */
@WebServlet("/tweetsfromuser")
public class TweetsFromUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TweetsFromUserController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Twitter twitter =  (Twitter) getServletContext().getAttribute("Twitter") ;		
		String who = request.getParameter("who");
		
		
		if(!twitter.checkUserExists(who)){
			request.setAttribute("BadParam", who);
			throw new ServletException("Le nom d'utilisateur du paramétre who de la requête n'est pas reconnu: ");
		}
		

		
		List<Tweet> lt = twitter.getTweetsFrom(who);
		request.setAttribute("tw",lt);

		request.getSession().setAttribute("visited",twitter.getUserByFirstnameLastName(who));		
		
		TreeSet<User> lu = twitter.getUsers();
		request.setAttribute("users",lu);
		
		//Logged 
		//TODO user not in list of followers
		if (Logged.isLoggedOrNot(request)){
			request.setAttribute("addFollowerOption", true);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("userTweets.jsp");
		view.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
