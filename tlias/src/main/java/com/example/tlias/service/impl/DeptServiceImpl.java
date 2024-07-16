package com.example.tlias.service.impl;

import com.example.tlias.mapper.DeptMapper;
import com.example.tlias.mapper.EmpMapper;
import com.example.tlias.pojo.Dept;
import com.example.tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// dept service 实现类, 实现 接口 DeptService 的具体方法
@Service
public class DeptServiceImpl implements DeptService {

    // 注入 mapper,service 中不能实现对数据库的各种操作， 需要调用 mapper 中的接口
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional  // spring 事务管理
    @Override
    public void delete(Integer id) {
        // 删除部门
        deptMapper.deleteById(id);
        // 删除该部门下的员工
        empMapper.deleteByDeptId(id);
    }


    public void add( Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }
}