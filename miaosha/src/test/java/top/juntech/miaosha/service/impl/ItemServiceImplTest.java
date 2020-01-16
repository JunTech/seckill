package top.juntech.miaosha.service.impl;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import top.juntech.miaosha.error.BussinessException;
import top.juntech.miaosha.service.ItemService;
import top.juntech.miaosha.service.model.ItemModel;
import top.juntech.miaosha.service.model.UserModel;

import java.math.BigDecimal;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/15 17:07
 * @ClassName 类名
 * @Descripe 商品单元测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ItemServiceImplTest {
    @Autowired
    private ItemService itemService;

    private MockMvc mockMvc;
    private WebApplicationContext wac;
    private MockHttpSession session;

    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession();
        UserModel  userModel = new UserModel();
        session.setAttribute("usermodel",userModel);
    }

    @Test
    void createItem() throws BussinessException, ParseException {
        ItemModel itemModel = new ItemModel();
        itemModel.setSeckillModel(null);
        itemModel.setId(1);
        itemModel.setPrice(BigDecimal.valueOf(1));
        itemModel.setTitle("123");
        itemModel.setDescription("123");
        itemModel.setStock(1);
        itemModel.setImgurl("123.jpg");
        itemModel.setSales(13);
        ItemModel item = itemService.createItem(itemModel);
        System.out.println(item.toString());
    }

    @Test
    void listItem() {
    }

    @Test
    void getItem() {
    }

    @Test
    void decreaseStock() {
    }

    @Test
    void increaseSales() {
    }
}