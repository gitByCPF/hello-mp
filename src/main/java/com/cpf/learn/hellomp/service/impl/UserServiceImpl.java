package com.cpf.learn.hellomp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpf.learn.hellomp.entity.User;
import com.cpf.learn.hellomp.mapper.UserMapper;
import com.cpf.learn.hellomp.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author cui pengfei
 * @since 17
 * Date 2025/9/8
 * Description: 业务功能实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
