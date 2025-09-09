package com.cpf.learn.hellomp.wrapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cpf.learn.hellomp.entity.User;
import com.cpf.learn.hellomp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author cui pengfei
 * @since 17
 * Date 2025/9/9
 * Description: 复杂查询语句的构造，使用Wrapper
 */
@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserService userService;

    @Test
    public void testQueryWrapper() {
        // 查询name=Tom的用户
        executeQuery(queryWrapper -> queryWrapper.eq("name", "Tom"));

        // 查询邮箱域名含有baomidou的所有用户
        executeQuery(queryWrapper -> queryWrapper.like("email", "baomidou"));
        // queryWrapper.likeLeft("email", "baomidou.com"); // 是同样的效果

        // 查询所有用户并按照age降序排列
        executeQuery(queryWrapper -> queryWrapper.orderByDesc("age"));

        // 查询年龄介于[20,30]的所有用户
        executeQuery(queryWrapper -> queryWrapper.ge("age", "20").le("age", 30));
        // between也是闭区间，在此处两者等价
        executeQuery(qw -> qw.between("age", 20, 30));
        // 等价Lambda写法
        executeQuery(qw -> qw.lambda().between(User::getAge, 20, 30));

        // 查询年龄<20或>30的用户
        executeQuery(queryWrapper -> queryWrapper.lt("age", 20).or().gt("age", 30));

        // 查询邮箱域名为baomidou且(age<30||age>40)的所有用户
        executeQuery(qw -> qw.lambda().like(User::getEmail, "baomidou.com")
                .and(qwInner -> qwInner.lt(User::getAge, 30).or().gt(User::getAge, 40)));
    }

    @Test
    public void testUpdateWrapper() {
        // 把jack的名字改为Bob
        executeUpdate(uw -> uw.eq("name", "Jack").set("name", "Bob"));

        // 把所有用户的邮箱改成name@baomidou.com
        executeUpdate(uw -> uw.setSql("email = CONCAT(name, '@baomidou.com')"));
    }


    private void executeQuery(Consumer<QueryWrapper<User>> wrapperConsumer) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        wrapperConsumer.accept(queryWrapper);
        List<User> list = userService.list(queryWrapper);
        list.forEach(System.out::println);
    }

    private void executeUpdate(Consumer<UpdateWrapper<User>> wrapperConsumer) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        wrapperConsumer.accept(updateWrapper);
        boolean succeed = userService.update(updateWrapper);
        System.out.println("是否更新成功：" + succeed);
    }
}
