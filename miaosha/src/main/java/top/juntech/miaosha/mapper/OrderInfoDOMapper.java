package top.juntech.miaosha.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.juntech.miaosha.bean.OrderInfoDO;

import java.util.List;

@Mapper
public interface OrderInfoDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrderInfoDO record);

    int insertSelective(OrderInfoDO record);

    OrderInfoDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderInfoDO record);

    int updateByPrimaryKey(OrderInfoDO record);

    List<OrderInfoDO> selectOrderByUserId(Integer userId);
}