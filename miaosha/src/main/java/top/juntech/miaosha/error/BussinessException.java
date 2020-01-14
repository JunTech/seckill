package top.juntech.miaosha.error;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/13 10:21
 * @ClassName 类名
 * @Descripe 描述
 */
public class BussinessException extends Exception implements CommonError {

    private CommonError commonError;

    public BussinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    public BussinessException(CommonError commonError,String errMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        return this.commonError.setErrMsg(errMsg);
    }
}
