package top.juntech.miaosha.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/14 9:11
 * @ClassName 类名
 * @Descripe 描述
 */
@Setter
@Getter
@ToString(callSuper = true)
public class OrderModel implements Serializable {
    //订单号
    private String id;
    //用户号
    private Integer userId;

    //购买的商品id
    private Integer itemId;

    //购买商品的单价,若seckillId非空，则表示是以秒杀商品价格
    private BigDecimal itemPrice;

    //若seckillId非空，则表示是以秒杀商品价格
    private Integer seckillId;

    //购买数量,若seckillId非空，则表示是以秒杀商品价格
    private Integer amount;

    //购买的金额,若seckillId非空，则表示是以秒杀商品价格
    private BigDecimal orderPrice;


}
