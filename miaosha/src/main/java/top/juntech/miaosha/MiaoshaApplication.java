package top.juntech.miaosha;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.juntech.miaosha.mapper")
//@RestController
public class MiaoshaApplication {
//    @Resource
//    private UserDOMapper userDOMapper;

    public static void main(String[] args) {
        SpringApplication.run(MiaoshaApplication.class, args);
    }


//    @RequestMapping("/")
//    @ResponseBody
//    public String home(){
//        UserDO userDO = userDOMapper.selectByPrimaryKey(Long.valueOf(2020011101));
//        if(userDO == null){
//            return "用户不存在！";
//        }
//        return userDO.toString();
//    }


}
