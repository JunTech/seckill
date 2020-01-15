package top.juntech.miaosha.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.juntech.miaosha.service.model.UserModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/15 15:42
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    HttpServletRequest request;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        UserModel userModel = (UserModel) this.request.getSession().getAttribute("LOGIN_USER");
        if(userModel==null){
            //如果session中没有保存登录用户的信息，就说明没有登录，就直接重定向到tologin请求页面，视图名是login
            response.sendRedirect("toLogin");
            flag = false;
        }else{
            flag = true;
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
