package top.juntech.miaosha.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.juntech.miaosha.bean.OrderInfoDO;
import top.juntech.miaosha.bean.UserDO;
import top.juntech.miaosha.error.BussinessException;
import top.juntech.miaosha.error.EmBussinessError;
import top.juntech.miaosha.mapper.OrderInfoDOMapper;
import top.juntech.miaosha.mapper.UserDOMapper;
import top.juntech.miaosha.service.ItemService;
import top.juntech.miaosha.service.OrderService;
import top.juntech.miaosha.service.model.ItemModel;
import top.juntech.miaosha.service.model.OrderModel;
import top.juntech.miaosha.util.SnakId;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/14 9:20
 * @ClassName 类名
 * @Descripe 描述
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderInfoDOMapper orderInfoDOMapper;

    @Resource
    private ItemService itemService;
    @Resource
    private UserDOMapper userDOMapper;


    /*
    * 创建订单
    *
    * */
    @Override
    @Transactional
    public OrderModel createOrder(Integer userId, Integer itemId, Integer amount,Integer seckillId) throws BussinessException, ParseException {
        //1.校验下单状态，下单商品是否存在用户是否合法，购买数量是否正确
        ItemModel item = itemService.getItem(itemId);
        if(item==null){
            throw new BussinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,"商品信息不存在");
        }

        UserDO userDO = userDOMapper.selectByPrimaryKey(userId);
        if(userDO==null){
            throw new BussinessException(EmBussinessError.USERNAME_OR_PASSWORD_NOT_TRUE,"用户不存在");
        }

        if(amount<=0||amount>99){
            throw new BussinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,"数量操作不符合，大于0小于100");
        }
        //校验活动信息
        if(seckillId!=null){
            //检验对应活动是否存在
            if(seckillId.intValue()!= item.getSeckillModel().getId()){
                throw new BussinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,"活动信息不正确");

            }else {
                //检验活动是否正在进行中
                if (item.getSeckillModel().getStatus().intValue()!=2){
                    throw new BussinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,"活动尚未开始");
                }
            }
        }

        //2.落单减库存或支付减库存
        boolean b = itemService.decreaseStock(amount,itemId);
        System.out.println(b);
        if(b==false){
            throw new BussinessException(EmBussinessError.ORDER_NOT_COMPLATE);
        }
        //封装对象ordermodel
        OrderModel orderModel = new OrderModel();
        orderModel.setAmount(amount);
        orderModel.setItemId(itemId);
        orderModel.setUserId(userId);
        orderModel.setItemPrice(item.getPrice());
        orderModel.setSeckillId(seckillId);
        orderModel.setOrderPrice(item.getPrice().multiply(new BigDecimal(amount)));
        //生成交易流水号
        orderModel.setId(this.generateOrderNo());

        OrderInfoDO orderInfoDO = this.convertFromOrderModel(orderModel);
        //3.订单入库
        orderInfoDOMapper.insert(orderInfoDO);

        //4.销量加1
        itemService.increaseSales(itemId,amount);


        //5.返回前端
        return orderModel;
    }


    //根据用户id查找order信息
    @Override
    public List<OrderModel> getOrderByUserId(Integer userId) {
        List<OrderInfoDO> orderInfoDO = orderInfoDOMapper.selectOrderByUserId(userId);
        List<OrderModel> orderModels = new ArrayList<>();
        for(OrderInfoDO orderDO:orderInfoDO){
            OrderModel orderModel = this.convertToOrderModel(orderDO);
            orderModels.add(orderModel);
        }

        return orderModels;
    }



    //将ordermodel转化为bean类
    public OrderInfoDO convertFromOrderModel(OrderModel orderModel){
        if(orderModel==null){
            return null;
        }
        OrderInfoDO orderInfoDO = new OrderInfoDO();
        BeanUtils.copyProperties(orderModel,orderInfoDO);

        return orderInfoDO;
    }

    //将bean类转化为ordermodel类
    public OrderModel convertToOrderModel(OrderInfoDO orderInfoDO){
        if(orderInfoDO==null){
            return null;
        }
        OrderModel orderModel = new OrderModel();
        BeanUtils.copyProperties(orderInfoDO,orderModel);

        return orderModel;
    }

    //生成订单流水号
    public String generateOrderNo() {
//        StringBuffer stringBuffer = new StringBuffer();
        //时间+自增序列+分库分表
//        LocalDateTime now = LocalDateTime.now();
//        String nowDate = now.format(DateTimeFormatter.ISO_DATE).replace("-", "");
//        stringBuffer.append(nowDate);

        SnakId snakId = new SnakId(1,1,1);
        long id = snakId.nextId();

        return String.valueOf(id);
    }
}
