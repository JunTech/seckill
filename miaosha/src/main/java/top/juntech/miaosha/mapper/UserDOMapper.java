package top.juntech.miaosha.mapper;

import top.juntech.miaosha.bean.UserDO;


public interface UserDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    public UserDO getUserDOByTelphone(String telphone);
}