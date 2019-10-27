package com.crud.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.crud.model.UserModel;

public class CRUDikoNiAlex {

	private static Connection conn = null;
	private static Statement stmt = null;


	public static void main(String[] args) throws SQLException {
		try {

			CRUDikoNiAlex crud = new CRUDikoNiAlex();

			UserModel user = new UserModel();
			user.setFirstname("Crud");
			user.setMiddlename("ikoNi");
			user.setLastname("Alex");
			user.setAddress("cubao ibabaw");
			user.setUsername("undextrois");
			user.setPassword("123");
			
			//add
			crud.AddUpdateUser(user);
			
			//view
			user = crud.getUserById(2);
			
			//update
			user.setFirstname("aaaaa");
			crud.AddUpdateUser(user);
		
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt.close();
			conn.close();
		}

	}
	
	public static Connection getConnection() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String databaseName="/test_db";
		String host="localhost";
		String port=":3306";

		//the result of this url ="jdbc:mysql://localhost:3306/test_db";
		StringBuffer url = new StringBuffer("jdbc:mysql://");
		url.append(host)
		.append(port)
		.append(databaseName);

		String username = "root";
		String password = "";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url.toString(), username, password);
		return conn;
	}

	private CRUDikoNiAlex() throws Exception{
		conn = getConnection();
		stmt = conn.createStatement(); 
	}

	private int updateQuery(String query) throws Exception{
		return stmt.executeUpdate(query); 
	}
	
	private UserModel viewQuery(String query) throws SQLException{
		System.out.println(query);
		ResultSet rs= stmt.executeQuery(query);
		UserModel user = null;
		while (rs.next()) {
			user =new UserModel(rs.getInt("userid"),rs.getString("firstname"),rs.getString("middlename"),rs.getString("lastname"),
					rs.getString("address"),rs.getString("username"),rs.getString("password"));
			System.out.println(rs.getString("firstname"));
		}
		return user;
	}
	
	public void AddUpdateUser(UserModel user) throws Exception{
		if(user==null)
			throw new Exception("User object is null willing calling AddUpdateUser method.");
		StringBuffer qry;
		if(user.getUserid()==0){
			qry= new StringBuffer("insert into users (firstname,middlename,lastname,address,username,password)");
			qry.append("values('"+user.getFirstname()+"','"+user.getMiddlename()+"','"+user.getLastname()+"',");
			qry.append("'"+user.getAddress()+"','"+user.getUsername()+"','"+user.getPassword()+"')");
			System.out.println(qry.toString());
			updateQuery(qry.toString());
		}else{
			qry= new StringBuffer("update users set firstname='"+user.getFirstname()+"', middlename='"+user.getMiddlename()+"',lastname='"+user.getLastname()+"',");
			qry.append("address='"+user.getAddress()+"',username='"+user.getUsername()+"',password='"+user.getPassword()+"'");
			qry.append("where userid="+user.getUserid());
			System.out.println(qry.toString());
			updateQuery(qry.toString());
		}
		
	}
	
	public UserModel getUserById(int userid) throws SQLException{
	   return viewQuery("select * from users where userid="+userid);
	}

}