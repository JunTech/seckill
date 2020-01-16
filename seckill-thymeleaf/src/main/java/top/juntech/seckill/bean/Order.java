package top.juntech.seckill.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@ToString(callSuper = true)
public class Order implements Serializable {
    private Long id;

    private Long userId;

    private Long goodsId;

    private String deliveryAddrId;

    private String goodsName;

    private Integer goodsCount;

    private BigDecimal goodsPrice;

    private Byte orderChannel;

    private Byte status;

    private Date createDate;

    private Date payDate;


}