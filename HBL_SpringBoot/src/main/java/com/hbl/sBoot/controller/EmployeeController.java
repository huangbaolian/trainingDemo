package com.hbl.sBoot.controller;

import com.hbl.sBoot.dao.DepartmentDao;
import com.hbl.sBoot.dao.EmployeeDao;
import com.hbl.sBoot.entities.Department;
import com.hbl.sBoot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps",employees);
        //thymeleaf默认拼串
        //classpath:/template/xxx/xxx.html
        return "emp/list";
    }
    //跳转到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有部门。在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    //springmvc自动将请求参数和入参对象的属性进行绑定，要求请求参数的名字和javabean入参的对象属性名一致
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        //redirect:重定向
        //forward:转发
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp",employee);
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
