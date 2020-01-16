package top.juntech.seckill.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import top.juntech.seckill.bean.Prod;
import top.juntech.seckill.bean.SeckillProd;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 17:35
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
public class Seckill_prod_Redis {
    @Autowired
    private RedisTemplate redisTemplate;

    private static final String prefix = ":goodsSum";

    public void miaoshaGoods_redis(Prod prod){
        Long increment = redisTemplate.opsForValue().increment(prod + prefix, -1);
        if(increment>=0){
            System.out.println("抢到iphoneX,成功！还剩下："+increment);
        }else {
            System.out.println("抢到iphoneX,失败！");
        }

    }
}

