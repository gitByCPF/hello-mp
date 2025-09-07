package com.cpf.learn.hellomp.mapper;

import com.cpf.learn.hellomp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testList(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Transactional
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("Alice");
        user.setAge(19);
        user.setEmail("test6@Alice.com");

        int succeed = userMapper.insert(user);
        System.out.println("插入成功的记录数: " + succeed);
    }

}