package com.baizhi.service;

import com.baizhi.entity.User;
import com.baizhi.entity.UserDto;

import java.util.List;

public interface UserService {
    List<User> findAll(Integer id);

    void saveUser(User user);

    void delete(Integer id);

    User findUser(Integer id);

    void updateUser(User user);
}
