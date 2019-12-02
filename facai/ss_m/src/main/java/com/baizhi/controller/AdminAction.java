package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(scopeName = "prototype")
public class AdminAction {
    @Autowired
    private AdminService adminService;
    private String username;
    private String password;
    private Admin admin;
    private String name;
    private String sex;


    public String loginAdmin(){
        Admin admin = adminService.loginAdmin(username, password);
        if(admin!=null){
            return "ok";
        }else {
            return "no";
        }
    }
    public String save(){
        admin = new Admin();
        this.admin.setUsername(username);
        this.admin.setPassword(password);
        this.admin.setName(name);
        this.admin.setSex(sex);
        adminService.save(this.admin);
        return "save";
    }






    //get and set
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
