package com.baizhi.mapper;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    //登录
    public Admin loginAdmin(@Param("username") String username, @Param("password") String password);
    //注册
    public void save(Admin admin);
}
