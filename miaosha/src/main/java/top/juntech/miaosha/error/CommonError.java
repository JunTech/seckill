package top.juntech.miaosha.error;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/13 10:13
 * @ClassName 类名
 * @Descripe 描述
 */
public interface CommonError {
    public int getErrCode();

    public String getErrMsg();

    public CommonError setErrMsg(String errMsg);
}
