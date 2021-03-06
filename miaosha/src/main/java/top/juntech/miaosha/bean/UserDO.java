package top.juntech.miaosha.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString(callSuper = true)
public class UserDO implements Serializable {
    private Integer id;

    private String name;

    private Integer gender;

    private Integer age;

    private String telphone;


}