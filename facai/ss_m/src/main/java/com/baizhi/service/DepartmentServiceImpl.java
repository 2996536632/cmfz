package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Department;
import com.baizhi.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Department> findAll() {
        return departmentMapper.findAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Department find(Integer id) {
        return departmentMapper.find(id);
    }

    @Override
    public void updateAdmin(Department department) {
        departmentMapper.updateAdmin(department);
    }

    @Override
    public void addDepartment(Department department) {
        departmentMapper.addDepartment(department);
    }
}
