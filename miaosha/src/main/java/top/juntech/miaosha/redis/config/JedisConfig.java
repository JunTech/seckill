package top.juntech.miaosha.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/14 17:17
 * @ClassName 类名
 * @Descripe 描述
 */
@Configuration
//@ConfigurationProperties(prefix = "redis")
public class JedisConfig {

    @Value("#{redis.host}")
    private String host;

    @Value("#{redis.port}")
    private int port;

    @Value("#{redis.timeout}")
    private int timeout;

    @Value("#{redis.poolMaxTotal}")
    private int poolMaxTotal;

    @Value("#{redis.poolMaxIdle}")
    private int poolMaxIdle;

    @Value("#{redis.poolMaxWait}")
    private int poolMaxWait;

    @Bean
    public JedisPool redisPoolFactory() throws Exception{
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxWaitMillis(poolMaxWait);
        jedisPoolConfig.setMaxIdle(poolMaxIdle);
        jedisPoolConfig.setMaxTotal(poolMaxTotal);

        jedisPoolConfig.setJmxEnabled(true);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,false);

        return jedisPool;
    }
}
