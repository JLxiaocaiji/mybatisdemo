package com.example.tlias.controller;

import com.example.tlias.pojo.Emp;
import com.example.tlias.pojo.PageBean;
import com.example.tlias.pojo.Result;
import com.example.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j // 打印日志
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    /*
    @GetMapping(value="/emps")
    public Result page(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("分页查询，参数 {},{}", page, pageSize);

        // 调用 service 方法分页查询
        PageBean pageBean =  empService.page(page, pageSize);
        return Result.success(pageBean);
    }
    @GetMapping(value="/emps")
    public Result page1(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询，参数 {},{}", page, pageSize);

        // 调用 service 方法分页查询
        PageBean pageBean =  empService.page(page, pageSize);
        return Result.success(pageBean);
    }
    */


    // page 和 page2 冲突，要使其生效，
    @GetMapping(value="/emps")
    public Result page2(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            String name,
            Short gender,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    ) {
        log.info("分页查询，参数 {},{}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);

        // 调用 service 方法分页查询
        PageBean pageBean =  empService.page2(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("ids:{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping("/emps")
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工, emp: {}", emp);
        empService.save(emp);
        return Result.success();
    }
}
