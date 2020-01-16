package top.juntech.seckill.rabbitmq;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.juntech.seckill.bean.User;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 14:48
 * @ClassName 类名
 * @Descripe 描述
 */
@Setter
@Getter
@ToString(callSuper = true)
public class MiaoshaMessage {
    private User user;
    private long goodsId;
}
