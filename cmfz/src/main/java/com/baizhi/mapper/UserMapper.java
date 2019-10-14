package com.baizhi.mapper;

import com.baizhi.DTO.UserDTO;

import java.util.List;

public interface UserMapper {
    Integer getCountByCreateDate(Integer day);

    List<UserDTO> getCountByprovince();
}
