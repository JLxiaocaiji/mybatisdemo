package com.example.tlias;

import org.dom4j.io.SAXReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TliasApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasApplication.class, args);
    }

    // 声明第三方 bean
    // 当前方法的返回值对象交给 IOC(Inversion of Control) 管理, 成为 IOC 的 bean；
    @Bean
    public SAXReader saxReader() {
        return new SAXReader();
    }
}
