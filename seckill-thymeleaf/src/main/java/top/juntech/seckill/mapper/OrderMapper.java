package top.juntech.seckill.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.juntech.seckill.bean.Order;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectStatusOrder(int status);
}