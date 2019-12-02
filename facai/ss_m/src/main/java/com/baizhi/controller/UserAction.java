package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Department;
import com.baizhi.entity.User;
import com.baizhi.service.DepartmentService;
import com.baizhi.service.UserService;
import com.opensymphony.xwork2.Action;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@Scope(scopeName = "prototype")
@Controller
public class UserAction {
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;

    private Integer id;
    private List<User> all;
    private User user;
    private Integer ids;
    private File upload;
    private String uploadFileName;
    private String xdPath;
    private String depId;
    private User user1;


    public String findAll(){
        all = userService.findAll(id);
        return "findAll";
    }
    public String saveUser() throws IOException {
        ServletContext servletContext = ServletActionContext.getRequest().getSession().getServletContext();
        String realPath = servletContext.getRealPath(xdPath);
        FileUtils.copyFile(upload,new File(realPath+"\\"+uploadFileName));
        user.setSrc(uploadFileName);

        String[] split = depId.split(",");
        user.setdId(Integer.parseInt(split[0]));
        user.setdName(split[1]);


        userService.saveUser(user);

        return "saveUser";

    }

    public String showDep() throws IOException {
        List<Department> list = departmentService.findAll();
        String s = JSONObject.toJSONString(list);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(s);
        return Action.NONE;
    }
    public String deleteUser(){
        userService.delete(ids);
        all = userService.findAll(id);
        System.out.println(id);
        return "deleteUser";
    }
    public String findUser(){
        user = userService.findUser(id);
        return "findUser";
    }
    public String updateUser() throws IOException {
        ServletContext servletContext = ServletActionContext.getRequest().getSession().getServletContext();
        System.out.println(xdPath);
        String realPath = servletContext.getRealPath(xdPath);
        File file = new File(realPath);

        if(upload!=null){
            FileUtils.copyFile(upload,new File(realPath+"\\"+uploadFileName));
            if(!file.exists()){
                file.mkdir();
            }
            System.out.println(user1);
            user1.setSrc(uploadFileName);
        }
        String[] split = depId.split(",");
        user1.setdId(Integer.parseInt(split[0]));
        user1.setdName(split[1]);

        System.out.println(user1);

        userService.updateUser(user1);
       // all = userService.findAll(id);
        return "updateUser";
    }

    //get and set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<User> getAll() {
        return all;
    }

    public void setAll(List<User> all) {
        this.all = all;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getIds() {
        return ids;
    }

    public void setIds(Integer ids) {
        this.ids = ids;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getXdPath() {
        return xdPath;
    }

    public void setXdPath(String xdPath) {
        this.xdPath = xdPath;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }
}
