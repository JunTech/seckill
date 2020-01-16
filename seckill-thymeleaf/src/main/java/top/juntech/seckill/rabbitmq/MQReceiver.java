package top.juntech.seckill.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.juntech.seckill.bean.SeckillOrder;
import top.juntech.seckill.redis.RedisService;
import top.juntech.seckill.service.OrderService;
import top.juntech.seckill.service.ProdService;
import top.juntech.seckill.service.SeckillOrderService;


/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 14:49
 * @ClassName 类名
 * @Descripe 描述
 */
@Service
public class MQReceiver {
    private static Logger logger = LoggerFactory.getLogger(MQReceiver.class);

    @Autowired
    RedisService redisService;

    @Autowired
    ProdService prodService;

    @Autowired
    OrderService orderService;

    @Autowired
    SeckillOrderService seckillOrderService;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void recieve(String message){
        logger.info("recieve message:"+message);
    }
    @RabbitListener(queues = MQConfig.TOPIC_QUEUE1)
    public void recieveTopic1(String message){
        logger.info("recieve message:"+message);
    }

    @RabbitListener(queues = MQConfig.TOPIC_QUEUE2)
    public void recieveTopic2(String message){
        logger.info("recieve message:"+message);
    }

    @RabbitListener(queues = MQConfig.HEADER_QUEUE)
    public void receiveHeaderQueue(byte[] message) {
        logger.info(" header  queue message:"+new String(message));
    }
}
