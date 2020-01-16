package top.juntech.seckill.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.juntech.seckill.bean.User;
import top.juntech.seckill.mapper.UserMapper;
import top.juntech.seckill.service.UserService;

import javax.annotation.Resource;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 13:10
 * @ClassName 类名
 * @Descripe 描述
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Transactional
    public boolean tx() {
        User u1= new User();
        u1.setId(2L);
        u1.setName("2222");
        userMapper.insert(u1);

        User u2= new User();
        u2.setId(1L);
        u2.setName("11111");
        userMapper.insert(u2);

        return true;
    }
}
