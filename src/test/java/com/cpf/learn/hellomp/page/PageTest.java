package com.cpf.learn.hellomp.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cpf.learn.hellomp.entity.User;
import com.cpf.learn.hellomp.mapper.UserMapper;
import com.cpf.learn.hellomp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author cui pengfei
 * @since 17
 * Date 2025/9/10
 * Description: 测试分页查询
 */
@SpringBootTest
public class PageTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void testPageService(){
        Page<User> page = new Page<>(2, 3);
        Page<User> res = userService.page(page);
        res.getRecords().forEach(System.out::println);
    }

    @Test
    public void testPageMapper(){
        Page<User> page = new Page<>(2, 3);
        Page<User> res = userMapper.selectPage(page, null);
        res.getRecords().forEach(System.out::println);
    }

    @Test
    public void testCustomPageMapper(){
        Page<User> page = new Page<>(2, 3);
        Page<User> res = userMapper.selectUserPage(page);
        res.getRecords().forEach(System.out::println);
    }


}
