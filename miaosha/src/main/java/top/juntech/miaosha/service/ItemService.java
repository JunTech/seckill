package top.juntech.miaosha.service;

import org.springframework.stereotype.Component;
import top.juntech.miaosha.error.BussinessException;
import top.juntech.miaosha.service.model.ItemModel;

import java.text.ParseException;
import java.util.List;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/13 19:07
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
public interface ItemService {

    //创建商品
    ItemModel createItem(ItemModel itemModel) throws BussinessException, ParseException;

    //商品列表
    List<ItemModel> listItem();

    //商品详情
    ItemModel getItem(Integer id) throws BussinessException, ParseException;

    //减库存
    boolean decreaseStock(Integer itemId,Integer amount);

    //加销量
    void increaseSales(Integer itemId,Integer amount) throws BussinessException;

}
