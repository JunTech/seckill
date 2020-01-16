package top.juntech.seckill.service.impl;

import org.springframework.stereotype.Service;
import top.juntech.seckill.bean.Order;
import top.juntech.seckill.mapper.OrderMapper;
import top.juntech.seckill.service.OrderService;
import top.juntech.seckill.vo.OrderDetailVo;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 12:50
 * @ClassName 类名
 * @Descripe 描述
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;


    @Override
    public Integer deleteByPrimaryKey(Long id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insert(Order record) {
        return orderMapper.insert(record);
    }

    @Override
    public Integer insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public Order selectByPrimaryKey(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Integer updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Order> selectStatusOrder(int status) {
        return orderMapper.selectStatusOrder(status);
    }

    @Override
    public OrderDetailVo getOrderDetail(Long id) {
        OrderDetailVo vo = new OrderDetailVo();
        Order order = this.selectByPrimaryKey(id);
        vo.setGetProdAddr(order.getDeliveryAddrId());

        return vo;
    }
}
