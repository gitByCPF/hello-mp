package com.cpf.learn.hellomp.service.impl;

import com.cpf.learn.hellomp.entity.User;
import com.cpf.learn.hellomp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetById() {
        User user = userService.getById(2L);
        assertEquals("Jack", user.getName());
    }

    @Test
    public void testSaveOrUpdate() {
        User user = new User();
        user.setId(1L);
        user.setName("Alice");
        boolean res = userService.saveOrUpdate(user);
        System.out.println("是否成功更新: " + res);
    }

}