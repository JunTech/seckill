package top.juntech.miaosha.rabbitmq;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.juntech.miaosha.service.model.UserModel;

import java.io.Serializable;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/15 9:27
 * @ClassName 类名
 * @Descripe 描述
 */
@Setter
@Getter
@ToString(callSuper = true)
public class SeckillMessage implements Serializable {
    //存放在session中的user信息
    private UserModel userModel;
    //商品id
    private Integer itemId;
}
