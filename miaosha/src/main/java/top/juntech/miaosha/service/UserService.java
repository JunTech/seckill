package top.juntech.miaosha.service;

import org.springframework.stereotype.Component;
import top.juntech.miaosha.error.BussinessException;
import top.juntech.miaosha.service.model.UserModel;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/13 9:18
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
public interface UserService {
    public UserModel getUserByTelphone(String telphone);

    public void register(UserModel userModel);

    UserModel login(String telphone,String password) throws BussinessException;
}
