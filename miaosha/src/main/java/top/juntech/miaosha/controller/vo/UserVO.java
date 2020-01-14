package top.juntech.miaosha.controller.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/13 9:55
 * @ClassName 类名
 * @Descripe 描述
 */
@Setter
@Getter
@ToString(callSuper = true)
public class UserVO implements Serializable {
    private Long id;

    private String name;

    private Integer gender;

    private Integer age;

    private String telphone;

}
