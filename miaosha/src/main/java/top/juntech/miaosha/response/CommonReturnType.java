package top.juntech.miaosha.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/13 10:05
 * @ClassName 类名
 * @Descripe 定义的通用返回类型
 */
@Setter
@Getter
@ToString(callSuper = true)
public class CommonReturnType {

    //表明请求的返回结果“success"或者"fail

    private String status;

    //请求返回的数据信息封装

    private Object data;

    //定义一个通用的创建方法
    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result,String status){
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setData(result);
        commonReturnType.setStatus(status);
        return commonReturnType;
    }
}
