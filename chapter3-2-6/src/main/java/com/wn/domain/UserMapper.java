package com.wn.domain;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    // 增
    @Insert("insert into user(name, age) values(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Insert("insert into user(name, age) values(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("insert into user(name, age) values(#{name}, #{age})")
    int insertUser(User user);

    // 删
    @Delete("delete from user where name=#{name}")
    int deleteByName(@Param("name") String name);

    // 改
    @Update("update user set age=#{age} where name=#{name}")
    int update(User user);

    // 查
    @Select("select * from user where id=#{id}")
    User queryUserById(Long id);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where name=#{name}")
    List<User> queryUserByName(String name);
}
