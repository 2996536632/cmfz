package com.baizhi.mapper;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Department;

import java.util.List;

public interface DepartmentMapper {

     List<Department> findAll();

     Department find(Integer id);

     void updateAdmin(Department department);

     void addDepartment(Department department);
}
