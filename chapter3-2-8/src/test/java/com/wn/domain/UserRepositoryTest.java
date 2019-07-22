package com.wn.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void before() {
        userRepository.save(new User("AAA", 11));
    }

    @Test
    public void test() {
        Log logger = LogFactory.getLog(this.getClass());

        User user = userRepository.findByName("AAA");
        logger.info("第一次查询：" + user.getAge());

        User user2 = userRepository.findByName("AAA");
        logger.info("第二次查询：" + user.getAge());

        user.setAge(22);
        userRepository.save(user);

        User user3 = userRepository.findByName("AAA");
        logger.info("第三次查询：" + user3.getAge());
    }
}