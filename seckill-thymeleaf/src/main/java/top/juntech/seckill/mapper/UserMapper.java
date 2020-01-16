package top.juntech.seckill.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.juntech.seckill.bean.User;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}