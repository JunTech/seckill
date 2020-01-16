package top.juntech.seckill.service.impl;

import org.springframework.stereotype.Service;

import top.juntech.seckill.bean.SeckillProd;
import top.juntech.seckill.mapper.SeckillProdMapper;
import top.juntech.seckill.service.SeckillProdService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 13:11
 * @ClassName 类名
 * @Descripe 描述
 */
@Service
public class SeckillProdServiceImpl implements SeckillProdService {

    @Resource
    private SeckillProdMapper seckillProdMapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return seckillProdMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SeckillProd record) {
        return seckillProdMapper.insert(record);
    }

    @Override
    public int insertSelective(SeckillProd record) {
        return seckillProdMapper.insertSelective(record);
    }

    @Override
    public SeckillProd selectByPrimaryKey(Long id) {
        return seckillProdMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SeckillProd record) {
        return seckillProdMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SeckillProd record) {
        return seckillProdMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SeckillProd> selctAllSeckillGoods() {
        return seckillProdMapper.selctAllSeckillGoods();
    }
}
