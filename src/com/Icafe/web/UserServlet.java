package com.Icafe.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Icafe.dao.UserDAO;
import com.Icafe.model.User;




//@WebServlet("/ManageServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    private HttpSession session;
    
    public void init() {
    	userDAO = new UserDAO();
    }
    
    public UserServlet() {
        userDAO = new UserDAO();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
        response.setLocale(Locale.TAIWAN);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/user/new": //新增按鈕，按下去會到表格
				showNewForm(request, response);
				break;
			case "/user/insert": 
				insertUser(request, response);
				break;
			case "/user/edit": 
				showEditForm(request, response);
				break;
			case "/user/update": 
				updateUser(request, response);
				break;
			case "/user/delete": 
				deleteUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void loginCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		if ((String)session.getAttribute("username") == null ) {
			
		} else {
			//成功登入
		}
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
        response.setLocale(Locale.TAIWAN);
		doGet(request, response);
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException{
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);//設定變數犩listUser供list.jsp帶資料
		RequestDispatcher dispatcher = request.getRequestDispatcher("../backend/users/user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User NewUser = new User(name, email, password);
		userDAO.insertUser(NewUser);
		response.sendRedirect("list");
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("../backend/users/user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException{
		int id = Integer.parseInt(request.getParameter("id"));//取得網址列參數 ?id=x
		User existingUser = userDAO.selectUser(id);//查詢指定id的資料（呼叫userDAO的selectUser方法）
		request.setAttribute("user", existingUser);//設定變數名稱讓form.jsp可以帶出user資料
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("../backend/users/user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException{
		//取得表單欄位的值id（包含隱藏欄位的id）
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//將資料儲存到User資料模型（含id
		User UpdateUser = new User(id, name, email, password);
		userDAO.updateUser(UpdateUser);//呼叫userDAO的insertUser方法執行寫入資料到資料庫
		response.sendRedirect("list");//跳轉回到後台頁面
		
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException{
		int id = Integer.parseInt(request.getParameter("id"));//取得網址列參數 ?id=x
		userDAO.deleteComment(id);//執行userDAO的deleteUser方法刪除資料
		response.sendRedirect("list"); //跳轉回到後台頁面
	}
	
	
}
