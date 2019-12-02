package com.baizhi.test;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userServiceImpl = (UserService) applicationContext.getBean("userServiceImpl");
//        User user = new User();
////        user.setSrc("1.jpg");
////        user.setName("张3");
////        user.setAge(22);
////        user.setSalary(2222.0);
////        user.setdName("公安部");
////        user.setdId(1);
////        userServiceImpl.saveUser(user);
        //userServiceImpl.delete(6);
        User user = new User();
        user.setSrc("1.jpg");
       user.setName("张3");
       user.setAge(22);
       user.setSalary(2222.0);
       user.setdName("公安部");
       user.setdId(1);
        userServiceImpl.updateUser(user);
    }
}
