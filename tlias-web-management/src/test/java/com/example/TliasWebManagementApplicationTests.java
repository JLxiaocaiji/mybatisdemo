package com.example;


import com.mysql.cj.util.Base64Decoder;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.YamlJsonParser;
import org.springframework.util.Base64Utils;

import java.net.URLEncoder;
import java.util.*;


//@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    public void testUuid(){
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    /**
     * 生成JWT
     */
    @Test
    public void testGenJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "example")//签名算法
                .setClaims(claims) //自定义内容(载荷)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置有效期为1h
                .compact();
        System.out.println(jwt);
    }

    /**
     * 解析JWT
     */
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("example")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY3MDQ2NDU0N30.yPLRyiusrlrmWeC4-dhInjFuAghPkmiHSRHd_DTKi9E")
                .getBody();
        System.out.println(claims);
    }

}
