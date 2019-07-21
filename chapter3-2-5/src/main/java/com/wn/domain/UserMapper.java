package com.wn.domain;

import com.wn.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name}")
    User findByName(String name);

    @Insert("insert into user(name, age) values(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") int age);

    @Delete("delete from user where name=#{name}")
    int deleteByName(@Param("name") String name);
}
