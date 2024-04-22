package org.example.mybatisdemo.dao;

import org.example.mybatisdemo.pojo.Emp;

import java.util.List;

public interface EmpDao {
    // 获取员工列表数据
    public List<Emp> listEmp();
}
