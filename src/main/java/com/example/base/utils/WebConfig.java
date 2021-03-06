package com.example.base.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @Auther: Administrator
 * @Date: 2018-09-08 15:44
 * @Description:
 */
@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public WebConfig(){
        super();
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
//        registry.addResourceHandler("/static/easyui/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/easyui/");
//        registry.addResourceHandler("/content/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/easyui/content/");
        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");
        registry.addResourceHandler("/imgupload/**").addResourceLocations("file:G:/imgupload/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorConfig interceptorConfig=new InterceptorConfig();
        //拦截规则：除了login，其他都拦截判断
        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/LoginController/**").excludePathPatterns(interceptorConfig.getUrl());

    }

   

}
