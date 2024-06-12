package com.example.tlias.controller;

import com.example.tlias.pojo.Dept;
import com.example.tlias.pojo.Result;
import com.example.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j // logger 日志注解
@RestController
public class DeptController {

    @Autowired  // 自动注入 service
    private DeptService deptService;

//    private static Logger log = LoggerFactory.getLogger(DeptController.class);

//    @RequestMapping("/depts") // 一般这么写
//    @RequestMapping(value="/depts", method = RequestMethod.GET) // get 方法，其他类似
    @GetMapping("/depts")   // get 方法的衍生注解，其他类似
    public Result list() {
        log.info("查询全部部门数据");

        // 调用 service 查询部门数据, deptService 中的 list 方法
        List<Dept> deptList = deptService.list();
        return Result.success();
    }
}
