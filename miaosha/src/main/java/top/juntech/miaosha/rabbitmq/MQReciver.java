package top.juntech.miaosha.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.juntech.miaosha.redis.RedisService;
import top.juntech.miaosha.service.ItemService;
import top.juntech.miaosha.service.OrderService;
import top.juntech.miaosha.service.SeckillService;
import top.juntech.miaosha.service.UserService;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/15 9:48
 * @ClassName 类名
 * @Descripe 描述
 */
@Service
public class MQReciver {
    private static Logger logger = LoggerFactory.getLogger(MQReciver.class);

    @Autowired
    RedisService redisService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;

    @Autowired
    SeckillService seckillService;


    @RabbitListener(queues = MQConfig.QUEUE)
    public void receive(String message){
        logger.info("receive msg:"+message);
    }

    @RabbitListener(queues = MQConfig.TOPIC_QUEUE1)
    public void receiveTopicQueue1(String message){
        logger.info("receive msg:"+message);
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
