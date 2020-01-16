package top.juntech.seckill.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SeckillProd implements Serializable {
    private Long id;

    private Integer goodsId;

    private BigDecimal maioshaPrice;

    private Integer stockCount;

    private Date startDate;

    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getMaioshaPrice() {
        return maioshaPrice;
    }

    public void setMaioshaPrice(BigDecimal maioshaPrice) {
        this.maioshaPrice = maioshaPrice;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}