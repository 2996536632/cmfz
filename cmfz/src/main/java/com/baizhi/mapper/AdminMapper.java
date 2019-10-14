package com.baizhi.mapper;


import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;


public interface AdminMapper {
    Admin findByUserNameAndPassword(@Param("username") String username);
}
