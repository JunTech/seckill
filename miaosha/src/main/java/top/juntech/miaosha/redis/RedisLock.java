package top.juntech.miaosha.redis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 15:42
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
public class RedisLock {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /*
    * 加锁
    *
    * */
    public boolean tryLock(String key,String value){
        if(stringRedisTemplate.opsForValue().setIfAbsent(key,value)){
            return true;
        }
        String currentValue = stringRedisTemplate.opsForValue().get(key);
        if(StringUtils.isNotEmpty(currentValue) && Long.valueOf(currentValue)<System.currentTimeMillis()){
            String oldValue = stringRedisTemplate.opsForValue().getAndSet(key,value);
            if (StringUtils.isNotEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }

        }
        return false;
    }

    /*
    * 解锁
    * */
    public void unlock(String key,String value){
        String currentValue = stringRedisTemplate.opsForValue().get(key);
        try {
            if(StringUtils.isNotEmpty(currentValue) && currentValue.equals(value)){
                stringRedisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
