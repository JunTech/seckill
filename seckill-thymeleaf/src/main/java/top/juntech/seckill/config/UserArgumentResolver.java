package top.juntech.seckill.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import top.juntech.seckill.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 16:57
 * @ClassName 类名
 * @Descripe 描述
 */
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    /**
     * 接口说明：
     * supportsParameter：用于判定是否需要处理该参数分解，返回true为需要，并会去调用下面的方法resolveArgument。
     * resolveArgument：真正用于处理参数分解的方法，返回的Object就是controller方法上的形参对象。
     */
    @Autowired
    private UserService userService;


    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> clazz = methodParameter.getParameterType();
        return clazz==UserService.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);

        String token = request.getParameter("token");


        return null;
    }
}
