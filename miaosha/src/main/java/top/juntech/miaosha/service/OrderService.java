package top.juntech.miaosha.service;

import org.springframework.stereotype.Component;
import top.juntech.miaosha.error.BussinessException;
import top.juntech.miaosha.service.model.OrderModel;

import java.text.ParseException;
import java.util.List;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/14 9:18
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
public interface OrderService {

    /**
     * @param userId 用户id
     * @param itemId 商品id
     * @param amount 数量
     * @return OrderModel
     */
    OrderModel createOrder(Integer userId,Integer itemId,Integer amount,Integer seckillId) throws BussinessException, ParseException;

    List<OrderModel> getOrderByUserId(Integer userId);

}
