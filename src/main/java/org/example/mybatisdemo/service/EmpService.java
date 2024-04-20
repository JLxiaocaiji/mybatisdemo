package org.example.mybatisdemo.service;

import org.example.mybatisdemo.pojo.Emp;

import java.util.List;

public interface EmpService {
    // 获取员工列表
    public List<Emp> listEmp();
}
