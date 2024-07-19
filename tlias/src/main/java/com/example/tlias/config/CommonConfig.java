package com.example.tlias.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    // 声明第三方 bean
    // 当前方法的返回值对象交给 IOC(Inversion of Control) 管理, 成为 IOC 的 bean；
    // 通过 @Bean 注解的 name/value 属性指定 bean 名称，若未指定，默认是方法名
    @Bean
    public SAXReader saxReader() {
        return new SAXReader();
    }
}
