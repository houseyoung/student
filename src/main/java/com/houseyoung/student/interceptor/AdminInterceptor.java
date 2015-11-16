package com.houseyoung.student.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by houseyoung on 15/10/23 22:15.
 * Modify from http://jinnianshilongnian.iteye.com/blog/1670856 & http://www.cnblogs.com/AloneSword/p/3420286.html
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {
    private String loginUrl, forbiddenUrl;
    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
    public void setForbiddenUrl(String forbiddenUrl) {
        this.forbiddenUrl = forbiddenUrl;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //放行登录页
        if(request.getServletPath().startsWith(loginUrl)) {
            return true;
        }

        //登录后放行其他页
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") != null) {
            return true;
        }

        //非法访问时跳转至错误页
        //(使用RequestDispatcher.forward跳转，地址栏地址不变)
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(request.getContextPath() + forbiddenUrl);
        requestDispatcher.forward(request, response);
        return false;
    }
}
