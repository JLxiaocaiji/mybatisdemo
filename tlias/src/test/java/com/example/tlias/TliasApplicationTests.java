package com.example.tlias;

import com.example.tlias.controller.DeptController;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@ServletComponentScan   // 开启了对 servlet 组件的 +
@SpringBootTest
//@Lazy                   // 延迟初始化，直到第一次初始化时
class TliasApplicationTests {

    @Test
    void contextLoads() {
    }

    // 测试： 生成 Jwt
    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "tom");

        // 数字签名方法 分别为 （算法，密钥）
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.ES256, "tlias")
                // .（自定义的数据）
                .setClaims(claims)
                // .截至日期, 设置为 1h
                .setExpiration(new Date(System.currentTimeMillis() + 3600 + 1000))
                // 生成字符串类型
                .compact();

        System.out.println(jwt);
    }

    // 测试： 解析 JWT
    @Test
    public void testParseJwt() {
        Claims claims = Jwts.parser()
                // 生成时指定的密钥是 tlias, 解析时也须为 tlias
                .setSigningKey("itheima")
                // 调用 pass 方法解析 Jwt 令牌
                .parseClaimsJws("")
                // 获取到自定义的内容
                .getBody();

        System.out.println(claims);
    }

    @Autowired
    private ApplicationContext applicationContext;

    // bean 的获取
    @Test
    public void testGetBean() { // 这 3 种输出的都是同一值，指向相同对象，单例模式
        // 根据 bean 名称获取
        DeptController bean1 = (DeptController) applicationContext.getBean("deptController");

        // 根据 bean 类型获取
        DeptController bean2 = applicationContext.getBean(DeptController.class);

        // 根据 bean 的名称及类型获取
        DeptController bean3 = applicationContext.getBean("deptController", DeptController.class);
    }

    // bean 的作用域
    public void testScope() {
        for( int i = 0; i < 10; i++) {
            DeptController deptController = applicationContext.getBean(DeptController.class);
            System.out.println(deptController); // 没有设置 scope,每次都输出同一值，指向相同对象，单例模式, 加了 scope, 则每次输出值不同
        }
    }


    @Autowired
    private SAXReader saxReader;

    // 第三方 bean 管理
    @Test
    public void testThirdBean() throws Exception {
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read(this.getClass().getClassLoader().getResource("1.xml"));

        Element rootElement = document.getRootElement();

        String name = rootElement.element("name").getText();
        String age = rootElement.element("age").getText();

        System.out.println(name + ":" + age);
    }


    // 已经在 config.CommonConfig 中配置第三方 SaxReader bean 了，测试能否得到 saxReader 的 bean
    public void testGetBean2() {
        Object saxReader = applicationContext.getBean("saxReader");
        System.out.println(saxReader);
    }
}
