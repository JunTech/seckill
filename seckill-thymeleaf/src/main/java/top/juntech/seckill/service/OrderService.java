package top.juntech.seckill.service;

import org.springframework.stereotype.Component;
import top.juntech.seckill.bean.Order;
import top.juntech.seckill.common.BaseResponse;
import top.juntech.seckill.vo.OrderDetailVo;

import java.util.List;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 12:46
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
public interface OrderService {
    Integer deleteByPrimaryKey(Long id);

    Integer insert(Order record);

    Integer insertSelective(Order record);

    Order  selectByPrimaryKey(Long id);

    Integer updateByPrimaryKeySelective(Order record);

    Integer updateByPrimaryKey(Order record);

    List<Order> selectStatusOrder(int status);

    OrderDetailVo getOrderDetail(Long id);
}
