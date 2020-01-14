package top.juntech.miaosha.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.time.DateTime;


import java.io.Serializable;
import java.math.BigDecimal;


@Setter
@Getter
@ToString(callSuper = true)
public class SeckillDO implements Serializable {
    private Integer id;

    private String seckillName;

    private String startDate;

    private String endDate;

    private Integer itemId;

    private BigDecimal seckillPrice;


}