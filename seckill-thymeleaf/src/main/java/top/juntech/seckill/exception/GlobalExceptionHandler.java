package top.juntech.seckill.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.juntech.seckill.common.BaseResponse;
import top.juntech.seckill.common.CodeMsg;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 11:49
 * @ClassName 类名
 * @Descripe 描述
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value=Exception.class)
    //异常拦截
    public BaseResponse<String> exceptionHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
        if(e instanceof GlobalException) {
            GlobalException ex = (GlobalException)e;
            return BaseResponse.error(ex.getCm());
        }else if(e instanceof BindException) {
            BindException ex = (BindException)e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return BaseResponse.error(CodeMsg.BIND_ERROR.fillArgs(msg));
            //将捕捉到的异常信息传递给状态码  显示到前端
        }else {
            return BaseResponse.error(CodeMsg.SERVER_ERROR);
        }
    }
}
