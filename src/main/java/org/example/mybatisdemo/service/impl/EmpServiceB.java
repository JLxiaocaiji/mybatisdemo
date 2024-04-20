package org.example.mybatisdemo.service.impl;

import org.example.mybatisdemo.dao.EmpDao;
import org.example.mybatisdemo.dao.impl.EmpDaoA;
import org.example.mybatisdemo.pojo.Emp;
import org.example.mybatisdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

// 可通过 是否 注释 @Component 来切换 EmpServiceA, EmpServiceB, 但不会存在多个
//@Component  // 当前类交给 IOC 容器管理，成为 IOC 容器中的 bean
@Service
public class EmpServiceB implements EmpService {
//    @Autowired
    private EmpDao empDao;

    public List<Emp> listEmp() {
        // 调用 dao, 获取数据
        List<Emp> empList = empDao.listEmp();

        empList.stream().forEach( emp -> {
            String gender = emp.getGender();
            if ( "1".equals("gender")){
                emp.setGender("男士");
            } else if("2".equals("gender")) {
                emp.setGender("女士");
            }

            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("2".equals(job)) {
                emp.setJob("就业指导");
            }
        });

        return empList;
    }
}
