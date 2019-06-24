package com.wn.springbootlearn.chapter318.web;

import com.wn.springbootlearn.chapter318.vo.User;
import org.apache.juli.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping(value = "/user",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public User create(@RequestBody User user) {
        user.setName("userName: " + user.getName());
        user.setAge(user.getAge() + 100);
        System.out.println(user);
        return user;
    }
}
