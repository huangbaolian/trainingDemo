package com.hbl.sBoot.dao;

import com.hbl.sBoot.entities.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer,Department>();
        departments.put(101,new Department(101,"A1"));
        departments.put(102,new Department(102,"B1"));
        departments.put(103,new Department(103,"C1"));
        departments.put(104,new Department(104,"D1"));
        departments.put(105,new Department(104,"E1"));
    }
    public Collection<Department> getDepartments(){
        return departments.values();
    }
    public Department getDepartment(Integer id){
        return departments.get(id);
    }
}
