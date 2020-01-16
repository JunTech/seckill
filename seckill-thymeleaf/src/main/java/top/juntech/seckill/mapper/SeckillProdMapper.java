package top.juntech.seckill.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.juntech.seckill.bean.SeckillProd;

import java.util.List;

@Mapper
public interface SeckillProdMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeckillProd record);

    int insertSelective(SeckillProd record);

    SeckillProd selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillProd record);

    int updateByPrimaryKey(SeckillProd record);

    List<SeckillProd> selctAllSeckillGoods();
}