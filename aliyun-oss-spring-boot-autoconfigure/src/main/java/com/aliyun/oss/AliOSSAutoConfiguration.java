package com.aliyun.oss;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AliOSSProperties.class)  // 把这个类直接导入到 ioc 容器
public class AliOSSAutoConfiguration {

    @Bean // 加上这个注解，可以直接 new 一个 aliyunutils 这个类
    public AliOSSUtils aliOSSUtils(AliOSSProperties aliOSSProperties) {
         AliOSSUtils aliOSSUtils = new AliOSSUtils();
         return aliOSSUtils;
    }
}
