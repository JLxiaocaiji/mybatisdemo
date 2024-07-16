package com.example.tlias.mapper;

import com.example.tlias.pojo.Emp;
import org.apache.ibatis.annotations.*;

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
    public void delete(@Param("ids") List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    @Insert("insert into emp( username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values(#{username},#{password},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    // 回显查询
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    // 修改
    public void update(Emp emp);

    /**
     * 查询员工
     * @param emp
     * @return
     */
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUserNameAndPassword(Emp emp);

    /**
     * 根据部门 ID 删除该部门下的所有员工
     * @param deptId
     */
    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId( Integer deptId );
}
