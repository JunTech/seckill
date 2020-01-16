package top.juntech.seckill.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/10 12:33
 * @ClassName 类名
 * @Descripe 描述
 */
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/*");
    }

}
