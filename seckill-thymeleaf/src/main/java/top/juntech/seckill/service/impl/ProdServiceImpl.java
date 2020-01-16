package top.juntech.seckill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.juntech.seckill.bean.Prod;
import top.juntech.seckill.mapper.ProdMapper;
import top.juntech.seckill.service.ProdService;

import javax.annotation.Resource;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 12:52
 * @ClassName 类名
 * @Descripe 描述
 */
@Service
public class ProdServiceImpl implements ProdService {

    @Resource
    private ProdMapper prodMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return prodMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Prod record) {
        return prodMapper.insert(record);
    }

    @Override
    public int insertSelective(Prod record) {
        return prodMapper.insertSelective(record);
    }

    @Override
    public Prod selectByPrimaryKey(Long id) {
        return prodMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Prod record) {
        return prodMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Prod record) {
        return prodMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Prod record) {
        return prodMapper.updateByPrimaryKey(record);
    }
}
