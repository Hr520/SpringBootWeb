package com.ssm.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.entity.User;
import com.ssm.util.Const;
import com.ssm.util.StringUtil;

/**
 * 拦截器
 *
 *
 */
public class SpringBootFileter implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        if (path.matches(Const.NO_INTERCEPTOR_PATH)) {
            return true;
        } else {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(Const.SESSION_USER);
            if (StringUtil.isNotEmpty(user)) {
                return true;
            } else {
                response.sendRedirect(request.getContextPath() + Const.LOGIN);
                return false;
            }
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
