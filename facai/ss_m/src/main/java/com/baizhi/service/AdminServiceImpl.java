package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Admin loginAdmin(String username, String password) {
        return adminMapper.loginAdmin(username,password);
    }

    @Override
    public void save(Admin admin) {
        adminMapper.save(admin);
    }
}
