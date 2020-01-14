package top.juntech.miaosha.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/13 9:39
 * @ClassName 类名
 * @Descripe 描述
 */
@Setter
@Getter
@ToString(callSuper = true)
public class UserModel implements Serializable {
    private Integer id;

    @NotNull(message = "用户名不能为空")
    private String name;


    private Integer gender;

    private Integer age;

    @NotNull(message = "用户手机号不能为空")
    private String telphone;

    private String encrptPassword;
}
