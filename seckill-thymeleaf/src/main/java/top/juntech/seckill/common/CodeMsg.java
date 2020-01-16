package top.juntech.seckill.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 11:37
 * @ClassName 类名
 * @Descripe 描述
 */
@Setter
@Getter
@ToString(callSuper = true)
public class CodeMsg {
    private int code;
    private String msg;

    //通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(000000, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    //登录模块 5002XX
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");


    //商品模块 5003XX

    //订单模块 5004XX
    public static CodeMsg ORDER_NOT_EXIST = new CodeMsg(500400, "订单不存在");

    //秒杀模块 5005XX
    public static CodeMsg MIAO_SHA_OVER = new CodeMsg(500500, "商品已经秒杀完毕");
    public static CodeMsg REPEATE_MIAOSHA = new CodeMsg(500501, "不能重复秒杀");
    public static CodeMsg MIAOSHA_FAIL = new CodeMsg(500502, "秒杀失败");

    private CodeMsg(){}

    private CodeMsg(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public CodeMsg fillArgs(Object... args) {
        /**
         * J2SE 1.5提供了“Varargs”机制。借助这一机制，
         * 		可以定义能和多个实参相匹配的形参。从而，可以用一种更简单的方式，来传递个数可变的实参。
         * 	只要在一个形参的“类型”与“参数名”之间加上三个连续的“.”（即“...”，英文里的句中省略号）
         * 	，就可以让它和不确定个实参相匹配
         */
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }


}
