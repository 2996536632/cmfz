package com.baizhi.mapper;

import com.baizhi.entity.User;
import com.baizhi.entity.UserDto;

import java.util.List;

public interface UserMapper {

    List<User> findAll(Integer id);

    void saveUser(User user);

    void deleteUser(Integer id);

    User findUser(Integer id);

    void updateUser(User user);

}
