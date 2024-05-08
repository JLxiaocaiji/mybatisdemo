package org.example.mybatisdemo.mapper;

import org.apache.ibatis.annotations.*;
import org.example.mybatisdemo.pojo.Emp;

@Mapper
public interface EmpMapper {

    // 根据ID删除数据
    @Delete("delete * from emp where id = #{id}")
    public void delete(Integer id);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)"
            + "values ( #{username},#{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)"
            + "values ( #{username},#{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert1(Emp emp);

    // 更新员工
    @Update("update emp set username= #{username}, name=#{name}, gender=#{gender}, image=#{image}, entrydate=#{entrydate}, dept_id=#{deptId}, update_time=#{updateTime} where\n" +
            "id = #{id};")
    public void update(Emp emp);

    // 查询员工, 根据 id
    @Select("select * from emp where id=#{id}")
    public Emp getById(Integer id);


}

