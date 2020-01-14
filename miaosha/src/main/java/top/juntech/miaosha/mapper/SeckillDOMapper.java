package top.juntech.miaosha.mapper;

import top.juntech.miaosha.bean.SeckillDO;

public interface SeckillDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SeckillDO record);

    int insertSelective(SeckillDO record);

    SeckillDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SeckillDO record);

    int updateByPrimaryKey(SeckillDO record);

    //根据商品id获取秒杀活动信息
    SeckillDO getSeckillDOByItemId(Integer itemId);
}