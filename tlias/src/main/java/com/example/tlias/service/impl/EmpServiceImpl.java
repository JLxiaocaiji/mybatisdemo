package com.example.tlias.service.impl;

import com.example.tlias.mapper.EmpMapper;
import com.example.tlias.pojo.Emp;
import com.example.tlias.pojo.PageBean;
import com.example.tlias.service.EmpService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        // 获取总记录数
        Long count = empMapper.count();

        // 获取分页查询列表
        Integer start = (page -1) * pageSize;
        List<Emp> empList = empMapper.page(start, pageSize);

        // 封装 pageBean 对象
        PageBean pageBean = new PageBean(count, empList);
        return pageBean;
    }

     // pageHelper 示例
    @Override
    public PageBean page1(Integer page, Integer pageSize) {
        // 1. 设置分页参数 (页码， 每页展示数目)
        PageHelper.startPage(page, pageSize);

        // 2. 执行查询
        List<Emp> empList = empMapper.page1();
        // 需要将其转化为 Page 类型
        Page<Emp> p = (Page<Emp>) empList;

        // 3. 封装 PageBean 对象
        // 右侧参数分别为 总数 和 结果列表
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }
    @Override
    public PageBean page2(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        // 1. 设置分页参数 (页码， 每页展示数目)
        PageHelper.startPage(page, pageSize);

        // 2. 执行查询
        List<Emp> empList = empMapper.page2(name, gender, begin, end);
        // 需要将其转化为 Page 类型
        Page<Emp> p = (Page<Emp>) empList;

        // 3. 封装 PageBean 对象
        // 右侧参数分别为 总数 和 结果列表
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }


    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }
}
