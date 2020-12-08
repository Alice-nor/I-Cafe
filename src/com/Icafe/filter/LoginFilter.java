package com.Icafe.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Hello Filter");
		HttpServletRequest servletRequest = (HttpServletRequest) request; //將request強制轉型別到HttpServletRequest
		HttpServletResponse servletResponse = (HttpServletResponse) response; //將resonse強制轉型別到HttpServletRespons
		HttpSession session = servletRequest.getSession(); //取得session
		String user_name = (String) session.getAttribute("name");//取得指定session值
		String path = servletRequest.getRequestURI();
		//判斷使用者請求的資源是否可以不登錄就訪問
		
		//paht.indexOf若等於-1則為這個字串不存在，若>-1則字串存在，做filter～
		if (path.indexOf("/login") > -1) {
			chain.doFilter(request, response);//放行，成功通過過濾器
			return;
		} else {
			//判斷HttpSession物件中有沒有使用者登入的屬性資訊
			
			if (user_name != null) {
				chain.doFilter(request, response);//放行，成功通過過濾器
				return;
			}else
				try {
					servletResponse.sendRedirect(servletRequest.getContextPath()+"/login");
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
