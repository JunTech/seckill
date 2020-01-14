package top.juntech.miaosha.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.juntech.miaosha.bean.ItemStockDO;

@Mapper
public interface ItemStockDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemStockDO record);

    int insertSelective(ItemStockDO record);

    ItemStockDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemStockDO record);

    int updateByPrimaryKey(ItemStockDO record);

    ItemStockDO selectByItemId(Integer itemId);

    int decreaseStock(Integer amount,Integer itemId);
}