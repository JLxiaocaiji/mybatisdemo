package com.example.tlias.service.impl;

import com.example.tlias.mapper.DeptMapper;
import com.example.tlias.pojo.Dept;
import com.example.tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// dept service 实现类, 实现 接口 DeptService 的具体方法
@Service
public class DeptServiceImpl implements DeptService {

    // service 中不能实现对数据库的各种操作， 需要调用 mapper 中的接口
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
}