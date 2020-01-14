package top.juntech.miaosha.error;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/13 10:15
 * @ClassName 类名
 * @Descripe 描述
 */
public enum EmBussinessError implements CommonError{
    //通用错误类型20001
    PARAMETER_VALIDATION_ERROR(20001,"参数不合法"),
    //1000开头为用户信息相关错误定义
    USER_NOT_EXIST(10001,"用户不存在"),
    USER_NOT_LOGIN(10002,"用户未登录"),
    //3000开头-未知错误异常
    UNKNOW_EXCEPTION(30001,"未知错误"),
    USERNAME_OR_PASSWORD_NOT_TRUE(40001,"用户名或密码错误"),
    ORDER_NOT_COMPLATE(50001,"交易失败")
    ;
    private int errCode;
    private String errMsg;

    private EmBussinessError(int errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
