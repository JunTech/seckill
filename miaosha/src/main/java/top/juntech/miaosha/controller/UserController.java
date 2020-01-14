package top.juntech.miaosha.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;
import top.juntech.miaosha.controller.vo.UserVO;
import top.juntech.miaosha.error.BussinessException;
import top.juntech.miaosha.error.EmBussinessError;
import top.juntech.miaosha.response.CommonReturnType;
import top.juntech.miaosha.service.UserService;
import top.juntech.miaosha.service.model.UserModel;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.Random;


/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/13 9:24
 * @ClassName 类名
 * @Descripe 描述
 */
@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin(allowedHeaders = "*",allowCredentials = "true")
public class UserController extends BaseController{
    public static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;

    //通过用户id获取用户信息的方法
    @RequestMapping("/get")
    public CommonReturnType getUser(@RequestParam(name = "telphone") String telphone) {
        //TODO 调用userservice的根据用户id获取用户的接口
        UserModel userInfo = userService.getUserByTelphone(telphone);
        if (userInfo == null) {
            return null;
        }
        //返回可供ui界面观看的数据
        UserVO userVO = convertFromModel(userInfo);
        //返回通用类型
        return CommonReturnType.create(userVO);
    }
    //用户获取otp短信验证码
    @RequestMapping(value = "/getotp",method = RequestMethod.POST,consumes = {"application/x-www-form-urlencoded"})
    @ResponseBody
    public CommonReturnType getotp(@RequestParam(name = "telphone")String telphone){
        //使用线程安全类
        StringBuffer otpCodesb = new StringBuffer();
        //按照一定规则生成6位验证码
        Random random = new Random();
        for (int i = 0; i <6 ; i++) {
            int num = random.nextInt(10);
            otpCodesb.append(String.valueOf(num));
        }
        String otpCode = otpCodesb.toString();
        //将验证码同用户手机号关联,使用httpsession的方式绑定他的手机号与验证码
        request.getSession().setAttribute(telphone,otpCode);
        logger.info("--------->tel={}",telphone);
        logger.info("--------->optCode={}",otpCode);
        //将otp验证码通过短信发送给用户，省略
        return CommonReturnType.create(null);
    }

    //用户注册接口
    @RequestMapping(value = "/register",method = RequestMethod.POST,consumes = {"application/x-www-form-urlencoded"})
    @ResponseBody
    public CommonReturnType register(@RequestParam(name = "telphone")String telphone,
                                     @RequestParam(name = "otpCode")String otpCode,
                                     @RequestParam(name = "name")String name,
                                     @RequestParam(name = "password")String password,
                                     @RequestParam(name = "age")Integer age,
                                     @RequestParam(name = "gender")Integer gender
                                     ) throws Exception {
        logger.info("注册用户开始...");
        //验证optCode与手机号一致
        String optCodeInSession = (String)this.request.getSession().getAttribute(telphone);
        if(!StringUtils.equals(otpCode,optCodeInSession)){
            throw  new BussinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,"短信验证码不符合");
        }
        //TODO 用户注册流程
        //封装usermodel
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setAge(Integer.valueOf(age));
        userModel.setGender(Integer.valueOf(gender));
        userModel.setTelphone(telphone);
        userModel.setEncrptPassword(this.toEncrptPassword(password));

        //调用userservice注册用户接口
        userService.register(userModel);


        return CommonReturnType.create(null);
    }


    //用户登录接口
    @RequestMapping(value = "/login",method = RequestMethod.POST,consumes = {"application/x-www-form-urlencoded"})
    @ResponseBody
    public CommonReturnType login(@RequestParam(name = "telphone")String telphone,@RequestParam("password")String password) throws Exception {
        //入参校验
        if(StringUtils.isEmpty(telphone)||StringUtils.isEmpty(password)){
            throw new BussinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,"用户名或密码为空");
        }
        //TODO  用户登录服务，用来校验用户登录是否合法
        String encrptPassword = this.toEncrptPassword(password);
        UserModel userModel = userService.login(telphone,encrptPassword);

        //将登录凭证加入到登录成功的session内
        this.request.getSession().setAttribute("IS_LOGIN",true);
        this.request.getSession().setAttribute("LOGIN_USER",userModel);

        return CommonReturnType.create(null);
    }

    //加密密码
    public String toEncrptPassword(String str) throws Exception{
        //确定计算方法
        MessageDigest md = MessageDigest.getInstance("MD5");
        BASE64Encoder base = new BASE64Encoder();
        //加密字符串
        String newstr = base.encode(md.digest(str.getBytes("utf-8")));
        return newstr;
    }

    //转换为前端ui显示的包装类的类型转换
    public UserVO convertFromModel(UserModel userModel) {
        if (userModel == null) {
           return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }


}
