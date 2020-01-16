package top.juntech.seckill.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.juntech.seckill.bean.Prod;

@Mapper
public interface ProdMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Prod record);

    int insertSelective(Prod record);

    Prod selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Prod record);

    int updateByPrimaryKeyWithBLOBs(Prod record);

    int updateByPrimaryKey(Prod record);
}