package com.hkd.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hkd.pojo.Person;
import com.hkd.service.PersonService;

@Controller
public class LoginController {
	
	@Autowired
	PersonService psi;
	
	@RequestMapping("/towelcome2")
	public String login() {
		return "WEB-INF/welcome2";
	}
	
	
	
	
//登录控制
	@RequestMapping("/dologin")
	public String dologin(HttpServletRequest request,HttpServletResponse response) {
		
		//获取工号，密码，身份，免输入参数
			String uid1=request.getParameter("uid");
			int id=Integer.parseInt(uid1);
			String pwd1=request.getParameter("pwd");
			String rem=request.getParameter("rm");
			String status=request.getParameter("status");
			HttpSession session=request.getSession();
			Person person=psi.login(id, pwd1, status);
		
		if(person!=null) {
			//登录成功
			session.setAttribute("person", person);
			session.removeAttribute("login_info");
			if(rem!=null) {
				//设置cookie
				Cookie uid=new Cookie("uid",String.valueOf(uid1));
				Cookie pwd=new Cookie("pwd",pwd1);
	
				//设置存活时间为7天
				uid.setMaxAge(7*24*3600);
				pwd.setMaxAge(7*24*3600);
				
				//发送cookie
				response.addCookie(uid);
				response.addCookie(pwd);
			}
			
			if("1".equals(status)) {
				//商家的欢迎页面
				return "WEB-INF/welcome2";
			}else {
				//用户的欢迎页面
				return "welcome";
			}
			
		}else {
			//登录失败
			session.setAttribute("login_info", "用户名或密码错误");
			return "redirect:login.jsp";
		}
			
	};
	
//注销	
	@RequestMapping("/doinvalidate")
	public String doinvalidate(HttpServletRequest request) {
		
		HttpSession session=request.getSession();
		
		session.invalidate();
		
		return "redirect:login.jsp";
		
	}
	
//注册
	@RequestMapping("doregister")
	public String doregister(Person person) {
		System.out.println(person);
				psi.addPerson(person);

				return "login";
	}
	
	
}
