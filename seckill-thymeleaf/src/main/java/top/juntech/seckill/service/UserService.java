package top.juntech.seckill.service;

import org.springframework.stereotype.Component;
import top.juntech.seckill.bean.User;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 12:47
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
public interface UserService {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
