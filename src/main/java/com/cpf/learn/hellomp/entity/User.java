package com.cpf.learn.hellomp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author cui pengfei
 * @since 17
 * Date 2025/9/3
 * Description: 数据库表对应的实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("age")
    private Integer age;
    
    @TableField("email")
    private String email;
}
