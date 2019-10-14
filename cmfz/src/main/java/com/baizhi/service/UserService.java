package com.baizhi.service;

import com.baizhi.DTO.UserDTO;

import java.util.List;

public interface UserService {
    Integer getCountByCreateDate(Integer day);

    List<UserDTO> getCountByprovince();
}
