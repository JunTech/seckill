package top.juntech.seckill.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString(callSuper = true)
public class OrderDetailVo {
    private String prod_name;
    private String prod_img;
    private double seckill_price;
    private Date order_time;
    private int status;
    private String getProdUser;
    private String getProdAddr;
}
