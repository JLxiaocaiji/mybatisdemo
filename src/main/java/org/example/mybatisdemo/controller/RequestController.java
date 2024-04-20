package org.example.mybatisdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.mybatisdemo.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class RequestController {
    // 原始方式
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request) {
        // 获取请求参数
    String name = request.getParameter("name");
    String ageStr = request.getParameter("age");

    int age = Integer.parseInt(ageStr);
        System.out.println(name+":"+age);
        return "OK";
    }

    // springboot 方式
    @RequestMapping("/simpleParam")
    public String simpleParam(String name, Integer age) {
        System.out.println(name+ ":" + age);
        return "OK";
    }

    // 1. 简单参数
    // springboot 若方法形参和请求参数名不匹配，可使用 @RequestParam 完成映射
    /*
    @RequestParam 的 required 属性默认为 true,
     */
    @RequestMapping("/simpleParam")
    public String simpleParam1(@RequestParam(name="name", required = true)String username, Integer age) {
        System.out.println(username+ ":" +age);
        return "OK";
    }

    // 2.实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        return "Ok";
    }

    // 3.数组集合参数
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    // 3.数组集合参数
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "OK";
    }

    // 4.日期参数
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "OK";
    }

    // 5.JSON 格式
    /*
    JSON数据键名与形参对象属性名相同，定义 POJO 类型形参可接受参数，需使用 @RequestBody 标识
     */
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "OK";
    }

    // 6.路径参数
    /*
    通过 url 传递参数，使用 {...} 来标识该路径参数，使用 @PathVariable 标注
     */
    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id) {
        System.out.println(id);
        return "OK";
    }
    @RequestMapping("/path/{id}/{name}")
    public String pathParam1(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id + ":" + name);
        return "OK";
    }

    /*
    @ResponseBody 方法注解，在 Controller 上
    作用：将方法返回值直接相应，若返回值是 实体对象/集合，会转换为 JSON 格式
    说明：@ RestController = @Controller + @ResponseBody
     */


}
