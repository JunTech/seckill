package top.juntech.miaosha.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.time.DateTime;


import java.io.Serializable;
import java.math.BigDecimal;


/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/14 12:31
 * @ClassName 类名
 * @Descripe 描述
 */
@Setter
@Getter
@ToString(callSuper = true)
public class SeckillModel implements Serializable {

    //id
    private Integer id;

    //秒杀活动名称
    private String seckillName;

    //秒杀活动开始时间
    private String startDate;

    private String endDate;

    //秒杀活动适用商品
    private Integer itemId;

    //秒杀活动价格
    private BigDecimal seckillPrice;

    //秒杀状态
    private Integer status;
}
