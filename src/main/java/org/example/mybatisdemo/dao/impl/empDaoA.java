package org.example.mybatisdemo.dao.impl;

import org.example.mybatisdemo.dao.EmpDao;
import org.example.mybatisdemo.pojo.Emp;
import org.example.mybatisdemo.utils.XmlParserUtils;

import java.util.List;

public class empDaoA implements EmpDao {

    public List<Emp> listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
