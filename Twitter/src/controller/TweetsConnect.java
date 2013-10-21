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
@WebServlet("/TweetsConnect")
public class TweetsConnect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TweetsConnect() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Twitter twitter =  (Twitter) getServletContext().getAttribute("Twitter") ;
		String login= request.getParameter("email");
		String pwd= request.getParameter("pwd");
		String where = request.getParameter("where");
		HttpSession session = request.getSession();
		User membre =  twitter.getUserByEmail(login);
		
		TreeSet<User> lu;
		
		
		if (membre != null){
			if (membre.getPwd().equals(pwd)){
				session.setAttribute("connected", membre);
				System.out.println();
				session.setAttribute("errorLogin", false);				
			}
			else{
				session.setAttribute("errorLogin", true);
				List<Tweet> lt = twitter.getTweets();
				session.setAttribute("tw",lt);				
			}
		}
		else
		{
			session.setAttribute("errorLogin", true);
			List<Tweet> lt = twitter.getTweets();
			session.setAttribute("tw",lt);				
		}
		
		//Si utilisateur connecté, on ne l'affiche pas dans la liste
		//Sinon on affiche tous les utilisateurs
		if (Logged.isLoggedOrNot(request)){
			lu = twitter.getOthersUsers(request);
		}
		else{
			lu = twitter.getUsers();
		}		
		session.setAttribute("users",lu);	
		//Afficher Formulaire de connexion ou de logout selon que identifié ou non
		Logged.isLogged(request);	
		
		RequestDispatcher view = request.getRequestDispatcher("/home.jsp");
		view.forward(request, response);
	}

}
