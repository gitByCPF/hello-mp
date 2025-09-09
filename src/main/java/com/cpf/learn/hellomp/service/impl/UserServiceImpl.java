package com.cpf.learn.hellomp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpf.learn.hellomp.entity.User;
import com.cpf.learn.hellomp.service.UserService;
import com.cpf.learn.hellomp.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author cui pengfei
* @description 针对表【user】的数据库操作Service实现
* @createDate 2025-09-10 03:40:38
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




