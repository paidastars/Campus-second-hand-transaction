package com.zsy.xyapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:G:/idea work/xyapp/src/main/java/com/zsy/xyapp/img/");
    }
}
