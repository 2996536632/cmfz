package com.baizhi.controller;

import com.baizhi.DTO.UserDTO;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("all")
    public List<UserDTO> all() {
        ArrayList<UserDTO> map = new ArrayList<>();
        List<UserDTO> list = userService.getCountByprovince();
        for (UserDTO userDTO : list) {
            UserDTO dto = new UserDTO(userDTO.getName(), userDTO.getValue());
            map.add(dto);
        }
        return map;
    }

    @RequestMapping("xx")
    public List<Integer> xx() {
        List<Integer> list = new ArrayList();

        for (int i = 0; i < 7; i++) {
            Integer countByCreateDate = userService.getCountByCreateDate(i);
            list.add(countByCreateDate);
        }
        return list;
    }


}
