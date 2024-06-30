package com.example.tlias.controller;

import com.example.tlias.pojo.Emp;
import com.example.tlias.pojo.Result;
import com.example.tlias.service.EmpService;
import com.example.tlias.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("员工登录", emp);
        Emp e = empService.login(emp);

        // 登录成功，生成令牌，下发令牌
        if( e != null) {
            Map<String, Object> claims = new HashMap();
            claims.put("id", e.getDeptId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }

        return Result.error("用户名或密码错误");


//        return e != null ? Result.success(): Result.error("用户名或密码错误");
    }
}
