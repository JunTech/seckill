package top.juntech.seckill.service;

import org.springframework.stereotype.Component;
import top.juntech.seckill.bean.SeckillProd;

import java.util.List;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 12:47
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
public interface SeckillProdService {
    int deleteByPrimaryKey(Long id);

    int insert(SeckillProd record);

    int insertSelective(SeckillProd record);

    SeckillProd selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillProd record);

    int updateByPrimaryKey(SeckillProd record);

    List<SeckillProd> selctAllSeckillGoods();
}
