package com.hkd.interceptor;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class RegisterInterceptor implements HandlerInterceptor {
	
	  public static boolean isValidNumLetterString(String str) {
	        // 必须包含数字
	        boolean hasDigit = Pattern.compile("[0-9]").matcher(str).find();
	        // 必须包含英文
	        boolean hasLetter = Pattern.compile("[A-Za-z]").matcher(str).find();
	        // 长度不少于6
	        boolean isLongEnough = str.length() >= 6;
	        return hasDigit && hasLetter && isLongEnough;
	    }
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//获取session
		HttpSession session =request.getSession();
		//设置编码集
		request.setCharacterEncoding("utf-8");
		//获取用户名，密码，电话
		String name= request.getParameter("uname");
		String password=request.getParameter("password");
		String tel=request.getParameter("tel");

		//用户名不能为空
		Boolean flage1="".equals(name);

		//电话号码为11位
		Boolean flage3="".equals(tel)|tel.length()!=11;

		System.out.println(name+"-"+password+"-"+tel);
		System.out.println(flage1+"-"+this.isValidNumLetterString(password)+"-"+flage3);
		if(!flage1 && this.isValidNumLetterString(password)&& !flage3) {
			session.removeAttribute("register_info1");
			session.removeAttribute("register_info2");
			session.removeAttribute("register_info3");

			return true; 

		}else {

			session.setAttribute("register_info1", "用户名不为空");
			session.setAttribute("register_info2", "密码至少6位，英文和数字");
			session.setAttribute("register_info3", "电话为11位");
			response.sendRedirect(request.getContextPath() +"/register.jsp");
			return false;
		}
		
		
	}

}
