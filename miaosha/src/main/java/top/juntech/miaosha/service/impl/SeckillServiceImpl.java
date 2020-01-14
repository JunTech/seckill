package top.juntech.miaosha.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.juntech.miaosha.bean.SeckillDO;
import top.juntech.miaosha.error.BussinessException;
import top.juntech.miaosha.error.EmBussinessError;
import top.juntech.miaosha.mapper.SeckillDOMapper;
import top.juntech.miaosha.service.SeckillService;
import top.juntech.miaosha.service.model.SeckillModel;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/14 12:48
 * @ClassName 类名
 * @Descripe 描述
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    @Resource
    private SeckillDOMapper seckillDOMapper;

    @Override
    public SeckillModel getSeckillDOByItemId(Integer itemId) throws BussinessException, ParseException {
        if(itemId==null){
            throw new BussinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,"itemId不能为空");
        }

        SeckillDO seckillDO = seckillDOMapper.getSeckillDOByItemId(itemId);
        SeckillModel seckillModel = this.convertObjectToModel(seckillDO);
        //判断当前时间是够秒杀活动开始或正在进行
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = simpleDateFormat.parse(seckillDO.getStartDate());
        Date endTime = simpleDateFormat.parse(seckillDO.getEndDate());
        int s = now.compareTo(startTime);
        int e = now.compareTo(endTime);

        if (s<0) {
            //秒杀活动还未开始
            seckillModel.setStatus(1);
        } else if (e>0) {
            //秒杀活动已经结束
            seckillModel.setStatus(3);
        }else{
            //秒杀进行中
            seckillModel.setStatus(2);
        }

        return seckillModel;
    }

    public SeckillModel convertObjectToModel(SeckillDO seckillDO) {
        SeckillModel seckillModel = new SeckillModel();
        if (seckillDO == null) {
            return null;
        }
        BeanUtils.copyProperties(seckillDO,seckillModel);
        return seckillModel;
    }
}
