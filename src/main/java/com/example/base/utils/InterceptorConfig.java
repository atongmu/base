package com.example.base.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018-09-15 21:39
 * @Description:
 */
public class InterceptorConfig implements HandlerInterceptor {
    private List<String> url = new ArrayList();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session
        HttpSession session = request.getSession(true);
        if(request.getRequestURI().equals("/admin/login")){
            return true;
        }
        if(session.getAttribute("userInfo") != null){
            session.setAttribute("userInfo", session.getAttribute("userInfo"));
            return true;
        }else {
            response.sendRedirect(request.getContextPath()+"/admin/login");
            return false;
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        // TODO Auto-generated method stub

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub


    }
    /**
     * 定义排除拦截URL
     * @return
     */
    public List<String> getUrl(){
        //登录页
        url.add("/LoginController/login");
        //网站静态资源
        url.add("/static/css/**");
        url.add("/static/js/**");
        url.add("/static/fonts/**");
        url.add("/static/images/**");
        return url;
    }

}
