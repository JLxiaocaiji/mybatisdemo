package org.example.mybatisdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.mybatisdemo.pojo.User;

import java.util.List;

@Mapper // 在运行时，会自动生成该接口的实现类对象(代理对象)，并将该对象交给IOC容器管理
public interface UserMapper {

    // 查询全部用户信息
    @Select("select * from user")
    public List<User> list();
}
