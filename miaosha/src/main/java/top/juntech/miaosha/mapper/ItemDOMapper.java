package top.juntech.miaosha.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.juntech.miaosha.bean.ItemDO;

import java.util.List;

@Mapper
public interface ItemDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemDO record);

    int insertSelective(ItemDO record);

    ItemDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemDO record);

    int updateByPrimaryKey(ItemDO record);

    List<ItemDO> selectAllItem();
    //销量+1操作
    void increaseSales(Integer itemId,Integer amount);
}