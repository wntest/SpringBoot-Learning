package com.wn;

import com.wn.domain.User;
import com.wn.domain.UserMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void findByName() {

        Log logger = LogFactory.getLog(this.getClass());

        int count = userMapper.deleteByName("AAA");
        logger.info("count=" + count);

        userMapper.insert("AAA", 22);

        User user = userMapper.findByName("AAA");

        Assert.assertEquals(22, user.getAge());
    }
}
