package top.juntech.seckill.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.juntech.seckill.bean.SeckillOrder;

import java.util.List;

@Mapper
public interface SeckillOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeckillOrder record);

    int insertSelective(SeckillOrder record);

    SeckillOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillOrder record);

    int updateByPrimaryKey(SeckillOrder record);

    List<SeckillOrder> selectAllSeckillOrder();
}