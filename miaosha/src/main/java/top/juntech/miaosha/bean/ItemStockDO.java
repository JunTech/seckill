package top.juntech.miaosha.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString(callSuper = true)
public class ItemStockDO implements Serializable {
    private Integer id;

    private Integer stock;

    private Integer itemId;


}