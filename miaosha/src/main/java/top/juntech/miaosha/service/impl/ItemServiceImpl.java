package top.juntech.miaosha.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.juntech.miaosha.bean.ItemDO;
import top.juntech.miaosha.bean.ItemStockDO;
import top.juntech.miaosha.error.BussinessException;
import top.juntech.miaosha.error.EmBussinessError;
import top.juntech.miaosha.mapper.ItemDOMapper;
import top.juntech.miaosha.mapper.ItemStockDOMapper;
import top.juntech.miaosha.service.ItemService;
import top.juntech.miaosha.service.SeckillService;
import top.juntech.miaosha.service.model.ItemModel;
import top.juntech.miaosha.service.model.SeckillModel;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/13 21:07
 * @ClassName 类名
 * @Descripe 描述
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemDOMapper itemDOMapper;
    @Resource
    private ItemStockDOMapper itemStockDOMapper;
    @Resource
    private SeckillService seckillService;

    @Override
    @Transactional
    public ItemModel createItem(ItemModel itemModel) throws BussinessException, ParseException {

        ItemDO itemDO =  convertItemDOFromItemModel(itemModel);
        itemDOMapper.insertSelective(itemDO);

        itemModel.setId(itemDO.getId());

        ItemStockDO itemStockDO = convertItemStockDOFromItemModel(itemModel);
        itemStockDOMapper.insertSelective(itemStockDO);

        return this.getItem(itemModel.getId());
    }

    @Override
    public List<ItemModel> listItem() {
        List<ItemDO> itemDOS = itemDOMapper.selectAllItem();
        List<ItemModel> itemModels = new ArrayList<>();
        if(itemDOS.size()==0){
            return null;
        }
        for (ItemDO itemDO : itemDOS){
            ItemStockDO itemStockDO = itemStockDOMapper.selectByItemId(itemDO.getId());
            ItemModel itemModel = this.convertObjectToModel(itemDO,itemStockDO);
            itemModels.add(itemModel);
        }
        return itemModels;
    }

    @Override
    public ItemModel getItem(Integer id) throws BussinessException, ParseException {
        ItemDO itemDO = itemDOMapper.selectByPrimaryKey(id);
        if(itemDO==null){
            return null;
        }
        //获得库存
        ItemStockDO itemStockDO = itemStockDOMapper.selectByItemId(id);
        ItemModel itemModel = convertObjectToModel(itemDO,itemStockDO);

        //获取活动信息
        SeckillModel seckillModel = seckillService.getSeckillDOByItemId(itemModel.getId());
        if(seckillModel!=null && seckillModel.getStatus().intValue()!=3){
            itemModel.setSeckillModel(seckillModel);
        }

        return itemModel;
    }

    @Override
    @Transactional
    public boolean decreaseStock(Integer amount,Integer itemId) {
        int affectRows = itemStockDOMapper.decreaseStock(amount, itemId);
        if (affectRows > 0) {
            //更新库存成功
            return true;
        }
        //更新库存失败
        return false;
    }

    @Override
    public void increaseSales(Integer itemId,Integer amount) throws BussinessException {
        if(itemId==null){
            throw new BussinessException(EmBussinessError.PARAMETER_VALIDATION_ERROR,"itemId为空...");
        }
        itemDOMapper.increaseSales(itemId,amount);
    }

    //销量加一

    private ItemDO convertItemDOFromItemModel(ItemModel itemModel){
        if (itemModel==null){
            return null;
        }

        ItemDO itemDO = new ItemDO();
        BeanUtils.copyProperties(itemModel,itemDO);
        return itemDO;
    }

    private ItemStockDO convertItemStockDOFromItemModel(ItemModel itemModel){
        if (itemModel==null){
            return null;
        }
        ItemStockDO stockDO = new ItemStockDO();
        stockDO.setItemId(itemModel.getId());
        stockDO.setStock(itemModel.getStock());
        return stockDO;
    }

    private ItemModel convertObjectToModel(ItemDO itemDO,ItemStockDO itemStockDO){
        if(itemDO==null){
            return null;
        }

        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(itemDO,itemModel);
        if(itemStockDO!=null){
            itemModel.setStock(itemStockDO.getStock());
        }


        return itemModel;
    }
}
