package org.example.mybatisdemo;

import org.example.mybatisdemo.mapper.UserMapper;
import org.example.mybatisdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

@SpringBootTest // springboot 整合单元测试的注解
class MybatisDemoApplicationTests {

    @Autowired  // 完成依赖注入
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testListUser() {
        List<User> userList = userMapper.list();
        userList.stream().forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void testJdbc() throws Exception{
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接对象
        String url = "jdbc:mysql://localhost:3306/db01";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 获取执行SQL对象Statement,只想sql,返回结果
        String sql = "select * from user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        // 封装结果数据
        List<User> userList = new ArrayList<>();

        while( resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            short age = resultSet.getShort("age");
            short gender = resultSet.getShort("gender");
            String phone = resultSet.getString("phone");

            User user = new User(id, name, age, gender, phone);
            userList.add(user);

        }

        // 5. 释放资源
        statement.close();
        connection.close();

//        userList.stream().forEACH( USER -> {
//            System.out.println(user);
//        })
    }
}
