package Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.User;

public class Follow {

	public static void canFollow(HttpServletRequest request){
		//Pour pouvoir ajouter une personne à suivre dans sa liste
		//Il faut être connecté et ne pas déjà suivre la personne
		if (Logged.isLoggedOrNot(request)){
			HttpSession session = request.getSession();
			User userLogged = (User)session.getAttribute("connected"); 
			User userVisited = (User)session.getAttribute("visited");
		}
	}
}
