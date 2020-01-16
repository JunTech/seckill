package top.juntech.seckill.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 11:41
 * @ClassName 类名
 * @Descripe 描述
 */
@Setter
@Getter
@ToString(callSuper = true)
public class BaseResponse<T> {
    private int code;
    private String msg;
    private T result;

    /*
    * 成功时的调用
    * */
    public static <T> BaseResponse<T> success(T result){
        return new BaseResponse<T>(result);
    }

    /*
    * 失败时的调用
    * */
    public static <T> BaseResponse<T> error(CodeMsg msg){
        return new BaseResponse<T>(msg);
    }


    public BaseResponse(T result){
        this.code = 0;
        this.msg = "success";
        this.result = result;
    }

    private BaseResponse(CodeMsg cm) {
        if(cm == null) {
            return;
        }
        this.code = cm.getCode();
        this.msg = cm.getMsg();
    }
}
