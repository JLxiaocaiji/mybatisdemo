package org.example.mybatisdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

// 使用 lombok 中的 get/set 方法需提前引入
/*
@Getter
@Setter
@ToString
@EqualsAndHashCode
*/
@Data   // 等同于这前4个
//@NoArgConstructor   // 无参构造方法
//@AllArgsConstructor // 全参构造方法
public class User {
    // 在实体类定义时最好选择包装类
    private Integer id;
    private String name;
    private Short age;
    private Short gender;
    private String phone;


    public User() {
    }

    public User(Integer id, String name, Short age, Short gender, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                '}';
    }


}
