package top.juntech.miaosha.service;

import org.springframework.stereotype.Component;
import top.juntech.miaosha.bean.SeckillDO;
import top.juntech.miaosha.error.BussinessException;
import top.juntech.miaosha.service.model.SeckillModel;

import java.text.ParseException;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/14 12:45
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
public interface SeckillService {

    //根据商品id获取秒杀活动信息
    SeckillModel getSeckillDOByItemId(Integer itemId) throws BussinessException, ParseException;
}
