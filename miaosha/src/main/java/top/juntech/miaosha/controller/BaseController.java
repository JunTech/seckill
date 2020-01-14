package top.juntech.miaosha.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import top.juntech.miaosha.error.BussinessException;
import top.juntech.miaosha.error.EmBussinessError;
import top.juntech.miaosha.response.CommonReturnType;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/13 9:59
 * @ClassName 类名
 * @Descripe 描述
 */
@RestController
@Slf4j
public class BaseController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Object handlerException(HttpServletRequest request, Exception ex){
        Map<String,Object> map = new HashMap<>();
        if(ex instanceof BussinessException){
            BussinessException bussinessException = (BussinessException)ex;
            map.put("errCode",bussinessException.getErrCode());
            map.put("errMsg",bussinessException.getErrMsg());
        }else {
            map.put("errCode", EmBussinessError.UNKNOW_EXCEPTION.getErrCode());
            map.put("errMsg",EmBussinessError.UNKNOW_EXCEPTION.getErrMsg());
        }
        return CommonReturnType.create(map,"fail");
    }

}

