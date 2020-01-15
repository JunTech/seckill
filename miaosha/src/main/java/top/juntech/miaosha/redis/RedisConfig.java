package top.juntech.miaosha.redis;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 14:22
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
@ConfigurationProperties(prefix = "redis")
@Setter
@Getter
@ToString(callSuper = true)
public class RedisConfig {
    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private int port;

    @Value("${redis.timeout}")
    private int timeout;

    @Value("${redis.poolMaxTotal}")
    private int poolMaxTotal;

    @Value("${redis.poolMaxIdle}")
    private int poolMaxIdle;

    @Value("${redis.poolMaxWait}")
    private int poolMaxWait;//秒
}
