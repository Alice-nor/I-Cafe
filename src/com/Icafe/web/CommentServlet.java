package com.Icafe.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Icafe.dao.CommentDAO;
import com.Icafe.model.Comment;


//@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CommentDAO commentDAO;

    public CommentServlet() {
       commentDAO = new CommentDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
        response.setLocale(Locale.TAIWAN);
        response.getWriter().append("Served at: ").append(request.getContextPath());
        String action = request.getServletPath();
        try {
			switch (action) {
			case "/comment/new": //顯示新增留言表單
				showCommentForm(request, response);
				break;
			case "/comment/insert": //使用者送出時insert表單
				insertComment(request, response);
				break;
			case "/comment/backend-list": //後台後台！這邊是後台！顯示後台的留言列表
				listComment(request, response,"backend");
				break;
			case "/comment/edit": //後台後台！這邊是後台！顯示後台的編輯表單
				showEditForm(request, response);
				break;
			case "/comment/update": //後台後台！這邊是後台！
				updateComment(request, response);
				break;
			case "/comment/delete": //後台後台！這邊是後台！
				deleteComment(request, response);
				break;
			case "/comment/deleteRy": //後台後台！這邊是後台！
				deleteReplyComment(request, response);
				break;
			default: //顯示前台公開之留言列表
				listComment(request, response,"frontend");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
        response.setLocale(Locale.TAIWAN);
        doGet(request, response);
	}
	
	
	//前台顯示留言列表
	private void listComment(HttpServletRequest request, HttpServletResponse response,String type)throws SQLException, IOException, ServletException{
		RequestDispatcher dispatcher;
		List< Comment > listComments = commentDAO.selectAllComments();
		request.setAttribute("listComment", listComments);
		if (type=="frontend") {
			dispatcher = request.getRequestDispatcher("../commentList.jsp");
		}else { //這邊轉到後台
			dispatcher = request.getRequestDispatcher("../backend/comments/comment-list.jsp");
		}

		dispatcher.forward(request, response);
	}
	
	private void insertComment(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String comment = request.getParameter("comment");
		String published_at = request.getParameter("published_at");
		
		Comment Newcomment = new Comment(name, email, comment, published_at);
		commentDAO.insertComment(Newcomment);
		response.sendRedirect("list");
	}

		
	//
	private void showCommentForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("../comment.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException{
		int c_id = Integer.parseInt(request.getParameter("c_id"));
		Comment existingComment = commentDAO.selectComment(c_id);
		request.setAttribute("comment", existingComment);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("../backend/comments/comment-form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void updateComment(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException{
		int c_id = Integer.parseInt(request.getParameter("c_id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String comment = request.getParameter("comment");
		String published_at = request.getParameter("published_at");
		String m_name = request.getParameter("m_name");
		String replyComment = request.getParameter("replyComment");
		String ry_published_at = request.getParameter("ry_published_at");
		
		Comment UpdateComment = new Comment(c_id, name, email, comment, published_at, m_name, replyComment, ry_published_at);
		commentDAO.updateComment(UpdateComment);
		response.sendRedirect("backend-list");//跳轉回到後台頁面
		
	}
	
	//刪除留言（包括顧客留言與管理者回覆）
	private void deleteComment(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException{
		int c_id = Integer.parseInt(request.getParameter("c_id"));//取得網址列參數 ?c_id=x
		commentDAO.deleteComment(c_id);
		response.sendRedirect("backend-list"); //跳轉回到後台頁面
	}
	
	
	//刪除管理者留言
	private void deleteReplyComment(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException{
		int c_id = Integer.parseInt(request.getParameter("c_id"));//取得網址列參數 ?c_id=x
		commentDAO.deleteReplyComment(c_id);
		response.sendRedirect("backend-list"); //跳轉回到後台頁面
	}
	
	
	

}
