package com.baizhi.service;

import com.baizhi.entity.Department;

import java.util.List;

public interface DepartmentService {
     List<Department> findAll();
     Department find(Integer id);
     void updateAdmin(Department department);
     void addDepartment(Department department);
}
