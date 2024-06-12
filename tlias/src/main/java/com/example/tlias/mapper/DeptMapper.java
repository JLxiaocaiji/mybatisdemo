package com.example.tlias.mapper;

import com.example.tlias.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门
     */
    @Select("select * from dept")
    List<Dept> list();
}
