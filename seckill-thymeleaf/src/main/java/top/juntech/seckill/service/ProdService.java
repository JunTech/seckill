package top.juntech.seckill.service;

import org.springframework.stereotype.Component;
import top.juntech.seckill.bean.Prod;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 12:46
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
public interface ProdService {
    int deleteByPrimaryKey(Long id);

    int insert(Prod record);

    int insertSelective(Prod record);

    Prod selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Prod record);

    int updateByPrimaryKeyWithBLOBs(Prod record);

    int updateByPrimaryKey(Prod record);
}
