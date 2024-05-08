package org.example.mybatisdemo.service.impl;

import org.example.mybatisdemo.dao.EmpDao;

import org.example.mybatisdemo.pojo.Emp;
import org.example.mybatisdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component  // 当前类交给 IOC 容器管理，成为 IOC 容器中的 bean
@Service // 为 @Component 的衍生项
public class EmpServiceA implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        // 调用 dao, 获取数据
        List<Emp> empList = empDao.listEmp();

        empList.stream().forEach( emp -> {
            Short gender = emp.getGender();
            if ( "1".equals("gender")){
                emp.setGender(Short.parseShort("男"));
            } else if("2".equals("gender")) {
                emp.setGender(Short.parseShort("女"));
            }

            Short job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob();
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("2".equals(job)) {
                emp.setJob("就业指导");
            }
        });

        return empList;
    }
}
