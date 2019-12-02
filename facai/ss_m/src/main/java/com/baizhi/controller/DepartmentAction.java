package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Department;
import com.baizhi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Scope(scopeName = "prototype")
@Controller
public class DepartmentAction {
    @Autowired
    private DepartmentService departmentService;

    private List<Department> all;
    private Admin admin;
    private Integer id;
    private Department department;
    private String number;
    private String name;
    private Department department1;

    public String findAll() {
        all = departmentService.findAll();
        return "findAll";
    }

    public String find(){
        department = departmentService.find(id);
        return "find";
    }
    public String updateAdmin(){
        System.out.println(departmentService);
        departmentService.updateAdmin(department1);
        all = departmentService.findAll();
        return "updateAdmin";
    }

    public String addDepartment(){
        department = new Department();
        department.setName(name);
        department.setNumber(number);
        departmentService.addDepartment(department);
        all = departmentService.findAll();
        return "addDepartment";
    }

    //get and set

    public List<Department> getAll() {
        return all;
    }

    public void setAll(List<Department> all) {
        this.all = all;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment1() {
        return department1;
    }

    public void setDepartment1(Department department1) {
        this.department1 = department1;
    }

}
