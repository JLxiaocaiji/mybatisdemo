package com.example.tlias.service;

import com.example.tlias.pojo.Emp;
import com.example.tlias.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;


public interface EmpService {

    PageBean page(Integer page, Integer pageSize);
    PageBean page1(Integer page, Integer pageSize);

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    PageBean page2(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    void save(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
