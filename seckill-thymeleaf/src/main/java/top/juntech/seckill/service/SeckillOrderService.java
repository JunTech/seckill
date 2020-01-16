package top.juntech.seckill.service;

import org.springframework.stereotype.Component;
import top.juntech.seckill.bean.SeckillOrder;

import java.util.List;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 12:46
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
public interface SeckillOrderService {
    int deleteByPrimaryKey(Long id);

    int insert(SeckillOrder record);

    int insertSelective(SeckillOrder record);

    SeckillOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillOrder record);

    int updateByPrimaryKey(SeckillOrder record);

    List<SeckillOrder> selectAllSeckillOrder();
}
