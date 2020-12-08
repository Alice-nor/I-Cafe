package com.Icafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Icafe.model.User;

public class UserDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/I_cafe_data?serverTime=UTC&useSSL=false&characterEncoding=UTF-8";
	private String jdbcAccount = "root";
	private String jdbcPassword = "";

	private static final String SELECT_ALL_USERS = "select * from admin order by 'published_at' desc;";
	private static final String SELECT_USERS_BY_ID = "select * from admin where id =?";
	private static final String INSERT_USERS_SQL = "INSERT INTO admin (name, email, password) VALUES (?, ?, ?)";
	private static final String UPDATE_USERS_SQL = "update admin set name = ?, email = ?, password = ? where id = ?;";
	private static final String DELETE_USERS_SQL = "delete from admin where id = ?;";
	
	
	public UserDAO() {
		super();
	}
	
	
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
	
	
	public List< User > selectAllUsers() {
		List< User > users = new ArrayList<>();
		try (Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS)) {
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				int id = rSet.getInt("id");
				String name = rSet.getString("name");
				String email = rSet.getString("email");
				String password = rSet.getString("password");
				users.add(new User(id, name, email, password));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	public User selectUser(int id) {
		User user = null;
		try (Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement(SELECT_USERS_BY_ID)) {
			statement.setInt(1, id);
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				String name = rSet.getString("name");
				String email = rSet.getString("email");
				String password = rSet.getString("password");
				user = new User(id, name, email, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	
	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		try (Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement(INSERT_USERS_SQL)) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			System.out.println(statement);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public boolean updateUser(User user) throws SQLException {
		boolean rowupdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
			
			statement.setInt(1, user.getId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());

			rowupdated = statement.executeUpdate() > 0;
		}
		return rowupdated;
	}
	
	public boolean deleteComment(int id) throws SQLException{
		boolean rowDeleted;//宣告布林值物件
		//執行資料庫連線後，執行DELETE_COMMENT_SQL的SQL語法刪除資料
		try(Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;//執行刪除後取得回傳的布林值
		}
		return rowDeleted;//回傳值
	}
	
	
	
}

