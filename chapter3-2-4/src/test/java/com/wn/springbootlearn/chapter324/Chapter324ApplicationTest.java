package com.wn.springbootlearn.chapter324;

import com.wn.springbootlearn.chapter324.domain.p.User;
import com.wn.springbootlearn.chapter324.domain.p.UserRepository;
import com.wn.springbootlearn.chapter324.domain.s.Message;
import com.wn.springbootlearn.chapter324.domain.s.MessageRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter324ApplicationTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void test() {

//        userRepository.deleteAll();

        userRepository.save(new User("zs", 22, 1));
        userRepository.save(new User("zs2", 22, 1));
        userRepository.save(new User("z3", 22, 1));

        Assert.assertEquals(3, userRepository.count());

        messageRepository.deleteAll();
        messageRepository.save(new Message("info1","information1"));
        messageRepository.save(new Message("info2","information2"));

        Assert.assertEquals(2, messageRepository.count());
    }
}