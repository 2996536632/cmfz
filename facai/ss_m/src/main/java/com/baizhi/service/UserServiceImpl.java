package com.baizhi.service;

import com.baizhi.entity.User;
import com.baizhi.entity.UserDto;
import com.baizhi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<User> findAll(Integer id) {
        return userMapper.findAll(id);
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.deleteUser(id);
    }

        @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public User findUser(Integer id) {
        return userMapper.findUser(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
