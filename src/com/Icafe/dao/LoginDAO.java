package com.Icafe.dao;

import java.sql.*;

import com.Icafe.model.User;

public class LoginDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/I_cafe_data?serverTime=UTC&useSSL=false&characterEncoding=UTF-8";
	private String jdbcAccount = "root";
	private String jdbcPassword = "";
	
	private static final String SELECT_ADMIN_BY_ID = "select * from admin where email = ? and password = ?";
	
	public LoginDAO() {}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcAccount, jdbcPassword);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	
	public User checkAdmin(String email,String password)throws ClassNotFoundException{
		
		User user = null;
		try (Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement(SELECT_ADMIN_BY_ID)) {
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet rsAdmin = statement.executeQuery();
			
			while (rsAdmin.next()) {
				String name = rsAdmin.getString("name");
				String email2 = rsAdmin.getString("email");
				String password2 = rsAdmin.getString("password");
				user = new User(name,email2,password2);			
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	
	
	
	
	
}
