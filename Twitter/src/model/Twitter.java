package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import Utils.Logged;

public class Twitter {
	
	private static Twitter instanceUnique = new Twitter();
			
	List<Tweet> listTweets = new ArrayList<Tweet>();
	
	private Twitter(){
		User lionel = new User("Lionel","Gosseries",new java.util.Date(1977-8-23),"lionel.gosseries@gmail.com","123456");
		add(new Tweet(lionel,"Si vous rencontrez un homme et que vous vous dites qu'il ferait un bon mari, vous vous rendez compte un peu plus tard qu'il l'est déjà.",new java.util.Date()));
		add(new Tweet(new User("Jeanne","Mouse",new java.util.Date(1987-6-14),"jmouse@gmail.com","123456" )," Si vous pensez que le meilleur moyen de toucher le coeur d'un homme est de passer par son estomac... vous visez trop haut.",new java.util.Date()));
		add(new Tweet(new User("Aurélie","Dubois",new java.util.Date(1994-2-23),"adubois@gmail.com","123456" ),"Un homme qui sait s'habiller tout seul sans ressembler à Bozo le clown a toutes les chances d'être homosexuel ",new java.util.Date()));		
		add(new Tweet(lionel,"Si vous rencontrez un homme et que vous vous dites qu'il ferait un bon mari, vous vous rendez compte un peu plus tard qu'il l'est .",new java.util.Date()));
	}	
	
	public static Twitter getInstance(){
		return instanceUnique;
	}
	
	public void add(Tweet t){
		listTweets.add(t);
	}
	
	public List<Tweet>getTweets(){
		return listTweets;
	}
	
	public List<Tweet>getTweetsFrom(String u){
		List<Tweet> listTweetsUser = new ArrayList<Tweet>();
		for(Tweet t:listTweets){
			if(t.getUser().toString().equals(u)){
				listTweetsUser.add(t);
			}
		}
		return listTweetsUser;
	}
	
	public List<Tweet>getTweetsFollows(List<User> lu){
		List<Tweet> listTweetsFollows = new ArrayList<Tweet>();
		for(User u:lu){
			listTweetsFollows.addAll(getTweetsFrom(u.getUser()));
		}
		return listTweetsFollows;
	}
	
	public TreeSet<User>getUsers(){
		List<Tweet> lt = getTweets();
		List<User> lu = new ArrayList<User>();
		for(Tweet l:lt){
			lu.add(l.getUser());
		}
		TreeSet<User> u = new TreeSet<User>(lu);
		return u;
	}
	
	public TreeSet<User>getOthersUsers(HttpServletRequest request){
		List<Tweet> lt = getTweets();
		List<User> lu = new ArrayList<User>();
		User meUser = Logged.getUserLogged(request);
		for(Tweet l:lt){
			if(l.getUser() !=  meUser){
				lu.add(l.getUser());
			}	
		}
		TreeSet<User> u = new TreeSet<User>(lu);		
		return u;
	}
		
	public User getUserByEmail(String mail){
		User toto = null;
		TreeSet<User> lu = getUsers();	
		for(User u:lu){
			if (u.getEmail().equals(mail)){
				toto = u;
			}
		}
		return toto;
	}
	public boolean checkUserExists(String who){
		TreeSet<User> lu = getUsers();
		String tmp;
		for(User user:lu){
			tmp = user.getFirstName()+" "+user.getLastName();
			if (tmp.equals(who))
				return true;
		}
		return false;
	}
	
	public User getUserByFirstnameLastName(String u){
		TreeSet<User> lu = getUsers();
		String tmp;
		User uu = null;
		for(User user:lu){
			tmp = user.getFirstName()+" "+user.getLastName();
			if (tmp.equals(u))
				return user;
		}
		return uu;		
	}
	
}
