package com.wn.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void test() {

        Log logger = LogFactory.getLog(this.getClass());

        User user = userRepository.findByName("AAA");
        logger.info("第一次查询：" + user.getName());

        User user2 = userRepository.findByName("AAA");
        logger.info("第二次查询：" + user2.getName());
    }
}