package top.juntech.seckill.service.impl;

import org.springframework.stereotype.Service;
import top.juntech.seckill.bean.SeckillOrder;
import top.juntech.seckill.service.SeckillOrderService;

import java.util.List;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 13:07
 * @ClassName 类名
 * @Descripe 描述
 */
@Service
public class SeckillOrderServiceImpl implements SeckillOrderService {
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(SeckillOrder record) {
        return 0;
    }

    @Override
    public int insertSelective(SeckillOrder record) {
        return 0;
    }

    @Override
    public SeckillOrder selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(SeckillOrder record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SeckillOrder record) {
        return 0;
    }

    @Override
    public List<SeckillOrder> selectAllSeckillOrder() {
        return null;
    }
}
