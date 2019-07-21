package com.wn.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void test() {
        Log logger = LogFactory.getLog(this.getClass());

        userMapper.insert("AAA", 22);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "AAA");
        map.put("age", 23);
        userMapper.insertByMap(map);

        userMapper.insertUser(new User("AAA", 24));

        User user =userMapper.queryUserById(6L);
        logger.info("user:" + user);
        List<User> users = userMapper.queryUserByName("AAA");
        logger.info("users:" + users);

        userMapper.update(new User("AAA", 44));

       User user2 = userMapper.queryUserById(6L);
       logger.info("user2:" + user2);
       List<User> users2 = userMapper.queryUserByName("AAA");
       logger.info("users2:" + users2);

       List<User> userList = userMapper.findAll();
       logger.info("allUsers:" + userList);

       userMapper.deleteByName("AAA");
        List<User> users3 = userMapper.queryUserByName("AAA");
        logger.info("users3:" + users3);
    }
}