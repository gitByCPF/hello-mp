package com.cpf.learn.hellomp.mapper;

import com.cpf.learn.hellomp.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cui pengfei
* @description 针对表【user】的数据库操作Mapper
* @createDate 2025-09-10 03:40:38
* @Entity com.cpf.learn.hellomp.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




