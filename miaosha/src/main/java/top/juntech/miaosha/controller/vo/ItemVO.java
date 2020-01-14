package top.juntech.miaosha.controller.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.time.DateTime;


import java.io.Serializable;
import java.math.BigDecimal;


/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/13 21:57
 * @ClassName 类名
 * @Descripe 描述
 */
@Setter
@Getter
@ToString(callSuper = true)
public class ItemVO implements Serializable {
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

    //商品秒杀活动状态 0->没有活动 1->秒杀活动待开始 2->秒杀活动进行中
    private Integer status;

    //秒杀活动价
    private BigDecimal seckillPrice;

    //秒杀id
    private Integer seckillId;

    //秒杀时间
    private String startDate;
}
