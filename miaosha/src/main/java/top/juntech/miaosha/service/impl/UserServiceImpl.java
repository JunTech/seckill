package top.juntech.miaosha.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.juntech.miaosha.bean.UserDO;
import top.juntech.miaosha.bean.UserPasswordDO;
import top.juntech.miaosha.error.BussinessException;
import top.juntech.miaosha.error.EmBussinessError;
import top.juntech.miaosha.mapper.UserDOMapper;
import top.juntech.miaosha.mapper.UserPasswordDOMapper;
import top.juntech.miaosha.service.UserService;
import top.juntech.miaosha.service.model.UserModel;

import javax.annotation.Resource;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/13 9:18
 * @ClassName 类名
 * @Descripe 描述
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserDOMapper userDOMapper;
    @Resource
    private UserPasswordDOMapper passwordDOMapper;

    @Override
    public UserModel getUserByTelphone(String telphone){
        logger.info("根据用户id获取用户开始...,入口参数为：telphone={}",telphone);
        UserDO userDO = userDOMapper.getUserDOByTelphone(telphone);
        UserPasswordDO passwordDO = passwordDOMapper.selectBytelphone(telphone);

        UserModel userModel =  convertFromDataObject(userDO,passwordDO);
        logger.info("根据用户id查询用户结束...");
        return userModel;
    }

    @Transactional
    @Override
    public void register(UserModel userModel) {
        if (userModel==null){
            return;
        }
        if (StringUtils.isEmpty(userModel.getName())||userModel.getAge()==null||userModel.getGender()==null||StringUtils.isEmpty(userModel.getTelphone())){
            return;
        }

        //实现model->bean方法
        UserDO userDO = convertFromModel(userModel);
        userDOMapper.insertSelective(userDO);

        UserPasswordDO userPasswordDO = convertPasswordFromModel(userModel);
        passwordDOMapper.insertSelective(userPasswordDO);

    }

    //登录接口

    @Override
    public UserModel login(String telphone, String encrptPassword) throws BussinessException {
        //通过telphone来查找用户
        UserDO userDO = userDOMapper.getUserDOByTelphone(telphone);
        if(userDO==null){
            throw  new BussinessException(EmBussinessError.USER_NOT_EXIST,"该手机号对应的用户不存在...");
        }
        UserPasswordDO userPasswordDO = passwordDOMapper.selectBytelphone(telphone);
        if(userPasswordDO==null){
            throw  new BussinessException(EmBussinessError.USER_NOT_EXIST,"该手机号对应的密码不存在...");
        }
        //将之封装到UserModel
        UserModel userModel = convertFromDataObject(userDO,userPasswordDO);

        //比对用户信息内加密的密码是否和传输进来的密码像匹配
        if(!StringUtils.equals(encrptPassword,userModel.getEncrptPassword())){
            throw new BussinessException(EmBussinessError.USERNAME_OR_PASSWORD_NOT_TRUE);
        }
        return userModel;

    }

    private UserPasswordDO convertPasswordFromModel(UserModel userModel) {
        if (userModel==null){
            return null;
        }
        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setEncrptPassword(userModel.getEncrptPassword());
        userPasswordDO.setTelphone(userModel.getTelphone());
        return userPasswordDO;
    }

    private UserDO convertFromModel(UserModel userModel) {
        if (userModel==null){
            return null;
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userModel,userDO);
        return userDO;
    }

    private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO passwordDO) {
        if(userDO==null){
            logger.info("没有该telphone={}对应的用户信息...",userDO.getTelphone());
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO,userModel);

        if(passwordDO!=null){
            logger.info("通过telphone={}可以找到对应的用户加密后的密码...",userDO.getTelphone());
            userModel.setEncrptPassword(passwordDO.getEncrptPassword());
        }else{
            logger.error("通过telphone={}查找不到对应的用户加密后的密码...",userDO.getTelphone());
        }
        logger.info("获取到的用户信息为：{}",userModel);
        return userModel;
    }
}
