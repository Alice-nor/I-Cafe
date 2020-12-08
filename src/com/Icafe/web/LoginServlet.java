
package com.Icafe.web;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Icafe.dao.LoginDAO;
import com.Icafe.model.User;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDAO loginDAO;
    private HttpSession session;
    private RequestDispatcher dispatcher;
    
    public void init() {
    	loginDAO = new LoginDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
        response.setLocale(Locale.TAIWAN);
        response.getWriter().append("Served at: ").append(request.getContextPath());
        
        String action = request.getServletPath();
        switch (action) {
		case "/login": 
			dispatcher = request.getRequestDispatcher("/backend/login.jsp");
			dispatcher.forward(request, response);
			System.out.println("/login");
			//response.sendRedirect("./backend/login.jsp");
			break;
		case "/logout" :
			session.invalidate();//清除記錄
			//dispatcher = request.getRequestDispatcher("/backend/login.jsp");
			response.sendRedirect("./backend/login.jsp");
			//dispatcher.forward(request, response);
			break;
		}
        
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			User user = loginDAO.checkAdmin(email, password);
			if (user != null) {
				//如果帳號密碼符合就跳到user/list
				session = request.getSession();
				session.setAttribute("name", user.getName());
				System.out.println("name="+user.getName());
				response.sendRedirect("user/list");
				
			}else {
				response.sendRedirect("login?error=true");
				System.out.println("輸入錯誤");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
