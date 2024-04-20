package org.example.mybatisdemo.controller;

import org.example.mybatisdemo.pojo.Emp;
import org.example.mybatisdemo.pojo.Result;
import org.example.mybatisdemo.service.EmpService;
import org.example.mybatisdemo.service.impl.EmpServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.example.mybatisdemo.utils.XmlParserUtils;

@RestController
public class EmpController {
    /*
    @RequestMapping("/listEmp")
    public Result list() {
        // 1. 加载解析 emp.xml
//        String file = "D:\\java_project\\mybatisDemo\\src\\main\\resources\\emp.xml";
        // 动态加载
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        // 2. 数据转化
        empList.stream().forEach( emp -> {
            String gender = emp.getGender();
            if ( "1".equals("gender")){
                emp.setGender("男");
            } else if("2".equals("gender")) {
                emp.setGender("女");
            }

            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("2".equals(job)) {
                emp.setJob("就业指导");
            }
        });

        // 响应数据
          return Result.success(empList);
    };
    */

//    private EmpService empService = new EmpServiceA();

    @Autowired  // 运行时，IOC 容器会提供该类型的 bean 对象，并赋值给该变量 - 依赖注入
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list() {
        List<Emp> empList = empService.listEmp();

        // 响应数据
        return Result.success(empList);
    }
}
