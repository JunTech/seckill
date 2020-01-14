package top.juntech.miaosha.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/13 17:29
 * @ClassName 类名
 * @Descripe 商品信息
 */

@Setter
@Getter
@ToString(callSuper = true)
public class ItemModel implements Serializable {
    private Integer id;

    //商品名称
    private String title;

    //商品价格
    private BigDecimal price;

    //商品库存
    private Integer stock;

    //商品描述
    private String description;

    //商品销量
    private Integer sales;

    //秒杀商品图片的url
    private String imgurl;

    //seckillModel不为空，拥有还未结束的秒杀活动
    private SeckillModel seckillModel;
}
