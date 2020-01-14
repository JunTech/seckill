package top.juntech.miaosha.controller;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.juntech.miaosha.controller.vo.ItemVO;
import top.juntech.miaosha.error.BussinessException;
import top.juntech.miaosha.response.CommonReturnType;
import top.juntech.miaosha.service.ItemService;
import top.juntech.miaosha.service.model.ItemModel;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/13 21:57
 * @ClassName 类名
 * @Descripe 描述
 */
@RestController
@RequestMapping("/item")
@Slf4j
@CrossOrigin(allowedHeaders = "*",allowCredentials = "true",origins = {"*"})
public class ItemController{
    @Autowired
    private ItemService itemService;


    //创建商品
    @RequestMapping(value = "/create",method = RequestMethod.POST,consumes = {"application/x-www-form-urlencoded"})
    @ResponseBody
    public CommonReturnType createItem(@RequestParam(name = "title")String title,
                                       @RequestParam(name = "description")String description,
                                       @RequestParam(name = "price") BigDecimal price,
                                       @RequestParam(name = "stock")Integer stock,
                                       @RequestParam(name = "imgUrl")String imgUrl) throws BussinessException, ParseException {
        ItemModel itemModel = new ItemModel();
        itemModel.setStock(stock);
        itemModel.setDescription(description);
        itemModel.setImgurl(imgUrl);
        itemModel.setTitle(title);
        itemModel.setPrice(price);

        ItemModel item = itemService.createItem(itemModel);
        ItemVO itemVO = convertItemModelToItemVO(itemModel);
        return CommonReturnType.create(itemVO);
    }

    //获取id为#id的产品
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getItem(@RequestParam(name = "id")Integer id) throws BussinessException, ParseException {
        ItemModel itemModel = itemService.getItem(id);

        ItemVO itemVO = convertItemModelToItemVO(itemModel);

        return CommonReturnType.create(itemVO);

    }

    //商品列表浏览
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType listItem(){
        List<ItemModel> itemModels = itemService.listItem();
        List<ItemVO> itemVOS = new ArrayList<>();
        for (ItemModel itemModel: itemModels){
            ItemVO itemVO = this.convertItemModelToItemVO(itemModel);
            itemVOS.add(itemVO);
        }
        return CommonReturnType.create(itemVOS);
    }





    private ItemVO convertItemModelToItemVO(ItemModel itemModel){
        if (itemModel==null){
            return null;
        }
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(itemModel,itemVO);
        if(itemModel.getSeckillModel()!=null){
            //有正在进行或即将进行的秒杀活动
            itemVO.setStatus(itemModel.getSeckillModel().getStatus());
            itemVO.setSeckillId(itemModel.getSeckillModel().getId());
            itemVO.setStartDate(itemModel.getSeckillModel().getStartDate());
            itemVO.setSeckillPrice(itemModel.getSeckillModel().getSeckillPrice());
        }else{
            itemVO.setStatus(0);
        }
        return itemVO;
    }
}
