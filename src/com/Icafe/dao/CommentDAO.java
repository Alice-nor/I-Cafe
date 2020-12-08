package com.Icafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Icafe.model.Comment;

public class CommentDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/I_cafe_data?serverTime=UTC&useSSL=false&characterEncoding=UTF-8";
	private String jdbcAccount = "root";
	private String jdbcPassword = "";

	private static final String SELECT_ALL_COMMENTS = "select * from comment order by 'published_at' desc;";
	private static final String SELECT_COMMENT_BY_ID = "select * from comment where c_id =?";
	private static final String INSERT_COMMENT_SQL = "INSERT INTO comment (name, email, comment, published_at) VALUES (?, ?, ?, NOW())";
	private static final String UPDATE_COMMENT_SQL = "update comment set name = ?, email = ?, comment = ?, published_at = ?, m_name = ?, replyComment = ?, ry_published_at = NOW() where c_id = ?;";
	private static final String DELETE_COMMENT_SQL = "delete from comment where c_id = ?;";
	private static final String DELETE_REPLYCOMMENT_SQL = "delete m_name, replyComment, ry_published_at from comment where c_id = ?;";

	public CommentDAO() {
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

	public List<Comment> selectAllComments() {
		List<Comment> comments = new ArrayList<>();
		try (Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement(SELECT_ALL_COMMENTS)) {
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				int c_id = rSet.getInt("c_id");
				String type_name = rSet.getString("name");
				String type_email = rSet.getString("email");
				String type_comment = rSet.getString("comment");
				String type_published_at = rSet.getString("published_at");
				String m_name = rSet.getString("m_name");
				String replyComment = rSet.getString("replyComment");
				String ry_published_at = rSet.getString("ry_published_at");
				comments.add(new Comment(c_id, type_name, type_email, type_comment, type_published_at, m_name,
						replyComment, ry_published_at));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comments;
	}

	public Comment selectComment(int c_id) {
		Comment comment = null;
		try (Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement(SELECT_COMMENT_BY_ID)) {
			statement.setInt(1, c_id);
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				String type_name = rSet.getString("name");
				String type_email = rSet.getString("email");
				String type_comment = rSet.getString("comment");
				String type_published_at = rSet.getString("published_at");
				String m_name = rSet.getString("m_name");
				String replyComment = rSet.getString("replyComment");
				String ry_published_at = rSet.getString("ry_published_at");
				comment = new Comment(c_id, type_name, type_email, type_comment, type_published_at, m_name, replyComment,
						ry_published_at);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return comment;
	}

	public void insertComment(Comment comment) throws SQLException {
		System.out.println(INSERT_COMMENT_SQL);
		try (Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement(INSERT_COMMENT_SQL)) {
			statement.setString(1, comment.getName());
			statement.setString(2, comment.getEmail());
			statement.setString(3, comment.getComment());
			System.out.println(statement);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean updateComment(Comment comment) throws SQLException {
		boolean rowupdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_COMMENT_SQL)) {
			
			statement.setString(1, comment.getName());
			statement.setString(2, comment.getEmail());
			statement.setString(3, comment.getComment());
			statement.setString(4, comment.getPublished_at());

			statement.setString(5, comment.getM_name());
			statement.setString(6, comment.getReplyComment());
			statement.setInt(7, comment.getC_id());
			rowupdated = statement.executeUpdate() > 0;
		}
		return rowupdated;
	}

	public boolean deleteComment(int c_id) throws SQLException{
		boolean rowDeleted;//宣告布林值物件
		//執行資料庫連線後，執行DELETE_COMMENT_SQL的SQL語法刪除資料
		try(Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement(DELETE_COMMENT_SQL)) {
			statement.setInt(1, c_id);
			rowDeleted = statement.executeUpdate() > 0;//執行刪除後取得回傳的布林值
		}
		return rowDeleted;//回傳值
	}
	
	public boolean deleteReplyComment(int c_id) throws SQLException{
		boolean rowDeleted;//宣告布林值物件
		//執行資料庫連線後，執行DELETE_COMMENT_SQL的SQL語法刪除資料
		try(Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement(DELETE_REPLYCOMMENT_SQL)) {
			statement.setInt(1, c_id);
			rowDeleted = statement.executeUpdate() > 0;//執行刪除後取得回傳的布林值
		}
		return rowDeleted;//回傳值
	}
	
	
	
}



