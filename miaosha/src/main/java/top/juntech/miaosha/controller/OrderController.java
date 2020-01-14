package top.juntech.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.juntech.miaosha.error.BussinessException;
import top.juntech.miaosha.error.EmBussinessError;
import top.juntech.miaosha.response.CommonReturnType;
import top.juntech.miaosha.service.OrderService;
import top.juntech.miaosha.service.model.OrderModel;
import top.juntech.miaosha.service.model.UserModel;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/14 10:09
 * @ClassName 类名
 * @Descripe 描述
 */
@RestController
@RequestMapping("/order")
@CrossOrigin(allowedHeaders = "*",allowCredentials = "true",origins = {"*"})
public class OrderController{

    @Autowired
    private OrderService orderService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/create",method = RequestMethod.POST,consumes = {"application/x-www-form-urlencoded"})
    @ResponseBody
    public CommonReturnType createOrder(@RequestParam(name = "itemId")Integer itemId,
                                        @RequestParam(name = "amount")Integer amount,
                                        @RequestParam(name = "seckillId",required = false)Integer seckillId) throws BussinessException, ParseException {

        Boolean is_login = (Boolean) this.request.getSession().getAttribute("IS_LOGIN");
        if(is_login==null||!is_login.booleanValue()){
            throw new BussinessException(EmBussinessError.USER_NOT_LOGIN);
        }

        //获取用户登录的信息
        UserModel userModel = (UserModel) this.request.getSession().getAttribute("LOGIN_USER");
        OrderModel orderModel = orderService.createOrder(userModel.getId(),itemId,amount,seckillId);

        return CommonReturnType.create(null);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType orderList(){

        UserModel userModel = (UserModel)this.request.getSession().getAttribute("LOGIN_USER");
        List<OrderModel> ordermodel = orderService.getOrderByUserId(userModel.getId());

        return CommonReturnType.create(ordermodel);

    }
}
