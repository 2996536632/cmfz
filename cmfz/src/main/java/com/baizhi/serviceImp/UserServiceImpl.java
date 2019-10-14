package com.baizhi.serviceImp;

import com.baizhi.DTO.UserDTO;
import com.baizhi.mapper.UserMapper;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer getCountByCreateDate(Integer day) {
        return userMapper.getCountByCreateDate(day);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<UserDTO> getCountByprovince() {
        return userMapper.getCountByprovince();
    }
}
