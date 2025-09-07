package com.cpf.learn.hellomp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpf.learn.hellomp.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
