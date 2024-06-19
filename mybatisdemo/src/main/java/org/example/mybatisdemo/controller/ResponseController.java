package org.example.mybatisdemo.controller;

import org.example.mybatisdemo.pojo.Address;
import org.example.mybatisdemo.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
// 可通过 @RequestMapping("/xxx") 提取公共路径;
public class ResponseController {
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    public Result hello1() {
        System.out.println("hello");
        // Result 方法1
//        return new Result(1, "success", "hello");
        // Result 方法2
        return Result.success("hello");
    }

    @RequestMapping("/getAddr")
    public Address getAddr() {
        Address addr = new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");
        return addr;
    }

    @RequestMapping("/listAddr")
    public List<Address> listAddr() {
        List<Address> list = new ArrayList<>();
        Address addr = new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");

        Address addr1 = new Address();
        addr1.setProvince("广东");
        addr1.setCity("深圳");

        Address addr2 = new Address();
        addr2.setProvince("广东");
        addr2.setCity("深圳");

        list.add(addr);
        list.add(addr2);
        return list;
    }
}
