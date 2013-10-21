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

import Utils.Logged;
import model.Twitter;
import model.Tweet;
import model.User;

/**
 * Servlet implementation class Tweets
 */
@WebServlet("/Tweets")
public class TweetsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TweetsController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Twitter twitter =  (Twitter) getServletContext().getAttribute("Twitter") ;		
		List<Tweet> lt = twitter.getTweets();
		HttpSession session = request.getSession();
		session.setAttribute("tw",lt);
		
		TreeSet<User> lu;
		//Si utilisateur connecté, on ne l'affiche pas dans la liste
		//Sinon on affiche tous les utilisateurs
		if (Logged.isLoggedOrNot(request)){
			lu = twitter.getOthersUsers(request);
		}
		else{
			lu = twitter.getUsers();
		}


		session.setAttribute("users",lu);
		session.setAttribute("errorLogin", false);		
		//Afficher Formulaire de connexion ou de logout selon que identifié ou non
		Logged.isLogged(request);
		
		RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
