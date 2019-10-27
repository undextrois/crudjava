package com.crud.model;

public class UserModel {
	
	private int userid;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String middlename;
	private String address;
	
	public UserModel(){
		
	}
	public UserModel(int userid, String username,String password,String firstname,
			String lastname,String middlename,String address){
		setUserid(userid);
		setUsername(username);
		setPassword(password);
		setFirstname(firstname);
		setLastname(lastname);
		setMiddlename(middlename);
		setAddress(address);
	}
	
	public void setUserid(int userid){
		this.userid=userid;
	}
	
	public int getUserid(){
		return this.userid;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}