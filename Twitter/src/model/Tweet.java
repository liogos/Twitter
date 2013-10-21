package model;

import java.util.Calendar;
import java.util.Date;

public class Tweet {

	private User user;
	private String text;
	private Date datePublish;
	

	
	public Tweet(User u, String t, Date d){
		this.user=u;
		this.text=t;
		this.datePublish=d;
	}
	
	
	
	public User getUser() {
		return user;
	}



	public String getText() {
		return text;
	}



	public Date getDatePublish() {
		return datePublish;
	}



	public String toString(){
		return this.getUser().getFirstName()+" "+this.getText()+" "+this.getDatePublish();
	}
}
