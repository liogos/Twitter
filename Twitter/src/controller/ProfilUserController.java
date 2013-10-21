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
@WebServlet("/Profile")
public class ProfilUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ProfilUserController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Twitter twitter =  (Twitter) getServletContext().getAttribute("Twitter") ;

		HttpSession session = request.getSession();
		User membre =  Logged.getUserLogged(request);
		
		TreeSet<User> lu;
		
		
		if (membre != null){
				if (!membre.getFollowers().isEmpty()){
					lu = new TreeSet<User>(membre.getFollowers());
					session.setAttribute("users",lu);	
					//Tweets follows
					System.out.println("tweets----------------------------");
					System.out.println(membre.getFollowers().size()+" "+membre.getFollowers().toString());
					List<Tweet> lt = twitter.getTweetsFollows(membre.getFollowers());
					session.setAttribute("tw",lt);					
				}
				else{
					session.setAttribute("users",new TreeSet<User>());	
					session.setAttribute("tw", new ArrayList<Tweet>());
				}
				session.setAttribute("errorLogin", false);
				
			}

		//Afficher Formulaire de connexion ou de logout selon que identifié ou non
		Logged.isLogged(request);
		
		RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
		view.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
