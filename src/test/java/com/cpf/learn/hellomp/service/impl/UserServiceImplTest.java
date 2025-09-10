package com.cpf.learn.hellomp.service.impl;

import com.cpf.learn.hellomp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testList(){
        userService.list().forEach(System.out::println);
    }

}