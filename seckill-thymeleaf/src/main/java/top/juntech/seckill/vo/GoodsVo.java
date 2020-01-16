package top.juntech.seckill.vo;

import lombok.Data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.juntech.seckill.bean.Prod;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 分装对象
 */

@Setter
@Getter
@ToString(callSuper = true)
public class GoodsVo extends Prod {
	private Double miaoshaPrice;
	private Date startDate;
	private Date endDate;
	private String prod_img;
	private String prod_name;
	private BigDecimal prod_origin_price;
	private Integer stockCount;

}
