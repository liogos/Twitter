package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Comparable<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String email;
	private String pwd;
	List<User> followers;
	
	public User(String f, String l, Date d, String e, String p){
		this.firstName=f;
		this.lastName=l;
		this.birthday=d;
		this.email=e;
		this.pwd=p;
		this.followers=new ArrayList<>();
	}

	public void addFollower(User toto){
		this.followers.add(toto);
	}
	public List<User> getFollowers() {
		return followers;
	}
	
	public int getNbFollowers(){
		return followers.size();
	}

	public String getEmail() {
		return email;
	}

	public String getPwd() {
		return pwd;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public String getUser(){
		return this.firstName+" "+this.lastName;
	}

	public Date getBirthday() {
		return birthday;
	}
	
	public String toString(){
		return this.firstName+" "+this.lastName;
	}


	@Override
	public int compareTo(User o) {
		if (firstName.compareTo(o.getFirstName()) != 0){
			return firstName.compareTo(o.getFirstName());
		}
		return lastName.compareTo(o.getLastName());
	}
}
