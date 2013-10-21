package Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.User;

public class Logged {
	
	public static void isLogged(HttpServletRequest request){
		HttpSession session = request.getSession();

		if (session.getAttribute("connected") != null){
			session.setAttribute("loginAddress", "components/Welcome.jsp");			
		}
		else{
			session.setAttribute("loginAddress", "components/FormConnect.jsp");			
		}
	}
	
	public static Boolean isLoggedOrNot(HttpServletRequest request){
		HttpSession session = request.getSession();

		if (session.getAttribute("connected") != null){
			return true;		
		}
		return false;
	}	
	
	public static User getUserLogged(HttpServletRequest request){
		HttpSession session = request.getSession();
		return (User)session.getAttribute("connected");
	}
}
