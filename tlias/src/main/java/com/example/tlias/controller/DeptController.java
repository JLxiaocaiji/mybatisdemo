package com.example.tlias.controller;

import com.example.tlias.pojo.Dept;
import com.example.tlias.pojo.Result;
import com.example.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // logger 日志注解
@RestController
public class DeptController {

    @Autowired  // 自动注入 service
    private DeptService deptService;

//    private static Logger log = LoggerFactory.getLogger(DeptController.class); // @Slf4j

//    @RequestMapping("/depts") // 一般这么写
//    @RequestMapping(value="/depts", method = RequestMethod.GET) // get 方法，其他类似
    @GetMapping("/depts")   // get 方法的衍生注解，其他类似
    public Result list() {
        log.info("查询全部部门数据");

        // 调用 service 查询部门数据, deptService 中的 list 方法
        List<Dept> deptList = deptService.list();
        // 返回查询数据
        return Result.success(deptList);
    }

    /**
     * 删除部门
     */
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id)  {
        log.info("根据 id 删除部门: {}", id);
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     * @return
     */
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门: {}", dept);
        // 调用 service
        deptService.add(dept);
        return Result.success();
    }
}

/*
上面的可通过

@RestController
@RequestMapping("/depts")
public class DeptController {

}
提取公共路径

其覆盖的可以省略公共方法
 */