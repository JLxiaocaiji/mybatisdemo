package com.example.tlias.mapper;

import com.example.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from emp")
    public Long count();

    /**
     * 分页查询，返回列表数据
     * @return
     */
    @Select("select * from emp limit #{start}, #{pageSize}")
    public List<Emp> page(Integer start,Integer pageSize);

    /**
     * 员工信息查询
     */
    @Select("select * from emp")
    public List<Emp> page1();

    /**
     * 条件员工信息查询 使用 mybatis 实现
     */
//    @Select("select * from emp")
    public List<Emp> page2(@Param("name") String name, @Param("gender") Short gender, @Param("begin") LocalDate begin,@Param("end") LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    public void delete(List<Integer> ids);
}
