package com.example.tlias;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@ServletComponentScan   // 开启了对 servlet 组件的 +
@SpringBootTest
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
}
