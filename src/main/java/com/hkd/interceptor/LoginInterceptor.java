package com.hkd.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 检查session是否有用户信息
        HttpSession session = request.getSession();
        Object person = session.getAttribute("person"); 
        if (person == null) {
            // 说明没有登录，跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false; // 拦截请求
        }
        return true; // 放行
    }
}